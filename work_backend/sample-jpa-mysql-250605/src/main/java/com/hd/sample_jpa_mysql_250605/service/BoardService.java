package com.hd.sample_jpa_mysql_250605.service;

import com.hd.sample_jpa_mysql_250605.dto.BoardResDto;
import com.hd.sample_jpa_mysql_250605.dto.BoardWriteDto;
import com.hd.sample_jpa_mysql_250605.dto.PageResDto;
import com.hd.sample_jpa_mysql_250605.entity.Board;
import com.hd.sample_jpa_mysql_250605.entity.Member;
import com.hd.sample_jpa_mysql_250605.repository.BoardRepository;
import com.hd.sample_jpa_mysql_250605.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    // 게시글 등록 : 반환값 Boolean
    public boolean addBoard(BoardWriteDto boardWriteDto) {
        try {
            Board board = convertDtoToEntity(boardWriteDto);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 등록 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 전체 조회 : 반환값 List<Board>
    public List<BoardResDto> getBoardList() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardResDto> boardResDtoList = new ArrayList<>();
        for (Board board : boardList) {
            BoardResDto boardResDto = convertEntityToDto(board);
            boardResDtoList.add(boardResDto);
        }
        return boardResDtoList;
    }

    // 게시글 단건 조회 : 입력은 게시글 ID, 반환값 Board
    public BoardResDto getBoardById(Long boardId) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(()-> new RuntimeException("해당 게시글이 없습니다."));
        BoardResDto boardResDto = convertEntityToDto(board);
        return boardResDto;
    }

    // 게시글 수정 : 반환값 Boolean
    public boolean updateBoard(Long boardId, BoardWriteDto boardWriteDto) {
        try {
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(()-> new RuntimeException("해당 게시글이 없습니다."));
            Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                    .orElseThrow(()-> new RuntimeException("해당 회원이 존재하지 않습니다."));

            board.setTitle(boardWriteDto.getTitle());
            board.setContent(boardWriteDto.getContent());
            board.setImage(boardWriteDto.getImg());
            board.setMember(member);
            boardRepository.save(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 수정 실패 : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 삭제 : 반환값 Boolean
    public boolean deleteBoard(Long boardId) {
        try {
            Board board = boardRepository.findById(boardId)
                    .orElseThrow(()-> new RuntimeException("해당 게시글이 존재하지 않습니다."));
            boardRepository.delete(board);
            return true;
        } catch (Exception e) {
            log.error("게시글 삭제에 실패 했습니다. : {}", e.getMessage());
            return false;
        }
    }

    // 게시글 검색 : 반환값 List<Board>
    public List<BoardResDto> searchBoardByTitle(String keyword) {
        List<Board> boards = boardRepository.findByTitleContaining(keyword);
        List<BoardResDto> boardResDtoList = new ArrayList<>();
        for (Board board : boards) {
            BoardResDto boardResDto = convertEntityToDto(board);
            boardResDtoList.add(boardResDto);
        }
        return boardResDtoList;
    }

    // 게시글 페이징 처리
    public PageResDto<BoardResDto> getBoardPageList(Integer page, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Board> boardPage = boardRepository.findAll(pageRequest);
        Page<BoardResDto>  boardResDtoPage = boardPage.map(board -> convertEntityToDto(board));
        return new PageResDto<>(boardResDtoPage);
    }

    // Entity -> DTO
    private BoardResDto convertEntityToDto(Board board) {
        BoardResDto boardResDto = new BoardResDto();
        boardResDto.setBoardId(board.getId());
        boardResDto.setTitle(board.getTitle());
        boardResDto.setContent(board.getContent());
        boardResDto.setImg(board.getImage());
        boardResDto.setCreateTime(board.getCreateTime());
        boardResDto.setEmail(board.getMember().getEmail());  // 연관관계 매핑으로 정보를 가져 옴
        return boardResDto;
    }

    // DTO -> Entity
    private Board convertDtoToEntity(BoardWriteDto boardWriteDto) {
        Member member = memberRepository.findByEmail(boardWriteDto.getEmail())
                .orElseThrow(() -> new RuntimeException("해당 회원이 존재하지 않습니다."));
        Board board = new Board();
        board.setTitle(boardWriteDto.getTitle());
        board.setContent(boardWriteDto.getContent());
        board.setImage(boardWriteDto.getImg());
        board.setMember(member);
        return board;
    }
}