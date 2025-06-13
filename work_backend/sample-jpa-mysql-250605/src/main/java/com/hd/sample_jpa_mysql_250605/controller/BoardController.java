package com.hd.sample_jpa_mysql_250605.controller;

import com.hd.sample_jpa_mysql_250605.dto.BoardResDto;
import com.hd.sample_jpa_mysql_250605.dto.BoardWriteDto;
import com.hd.sample_jpa_mysql_250605.dto.PageResDto;
import com.hd.sample_jpa_mysql_250605.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j // Log 메시지 출력을 위한 어노테이션
@RestController  // Rest API (GET, POST, PUT, DELETE)
@RequiredArgsConstructor  // 생성자를 통한 의존성 주입을 받기위해서 생성자를 자동 생성
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;  // 의존성 주입
    // 게시글 등록 : 입력(BoardWriteDto), 반환(boolean)
    @PostMapping("/new")
    public ResponseEntity<Boolean> newBoard(@RequestBody BoardWriteDto boardWriteDto) {
        return ResponseEntity.ok(boardService.addBoard(boardWriteDto));
    }
    // 게시글 수정 : 입력(id, BoardWriteDto), 반환(boolean)
    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> modifyBoard(@PathVariable Long id, @RequestBody BoardWriteDto boardWriteDto) {
        return ResponseEntity.ok(boardService.updateBoard(id, boardWriteDto));
    }

    // 게시글 삭제 : 입력(id), 반환(boolean)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.deleteBoard(id));
    }
    // 게시글 검색 : 입력(제목에 포함된 문자열), 반환(List<BoardResDto)
    @GetMapping("/search")
    public ResponseEntity<List<BoardResDto>> searchBoard(@RequestParam String keyword) {
        return ResponseEntity.ok(boardService.searchBoardByTitle(keyword));
    }
    // 게시글 전체 조회 : 입력(없음), 반환(List<BoardResDto)
    @GetMapping("/list")
    public ResponseEntity<List<BoardResDto>> getBoardList() {
        return ResponseEntity.ok(boardService.getBoardList());
    }
    // 게시글 단건 조회 : 입력(id), 반환(BoardResDto)
    @GetMapping("/detail/{id}")
    public ResponseEntity<BoardResDto> getBoardDetail(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoardById(id));
    }

    // 게시글 페이징 : : 입력(페이지 번호, 페이지 사이즈), 반환(PageResDto)
    @GetMapping("/list/page")
    public ResponseEntity<PageResDto<BoardResDto>> getBoardListPage(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(boardService.getBoardPageList(page, size));
    }
}