package com.example.voteRestApi.controller;

import com.example.voteRestApi.model.Vote;
import com.example.voteRestApi.repository.VoteRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import java.nio.file.StandardOpenOption; // 추가

@RestController
@RequestMapping("/votes")
public class VoteController {
    private final VoteRepository voteRepository;
    private final String uploadDir = "uploads/"; // 서버 내 이미지 저장 경로

    public VoteController(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;

        // 업로드 디렉토리 생성
        try {
            Files.createDirectories(Paths.get(uploadDir));
        } catch (IOException e) {
            throw new RuntimeException("Failed to create upload directory", e);
        }
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
        return voteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PostMapping
//    public ResponseEntity<Vote> createVote(@RequestBody Vote vote) {
//        Vote savedVote = voteRepository.save(vote);
//        return ResponseEntity.ok(savedVote);
//    }

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Vote> createVote(
            @RequestPart("vote") Vote vote,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        if (vote.getId() != null) {
            vote.setId(null);
        }
        if (image != null && !image.isEmpty()) {
            String fileName = UUID.randomUUID() + "_" + StringUtils.cleanPath(image.getOriginalFilename());
            Path filePath = Paths.get(uploadDir + fileName);
            Files.write(filePath, image.getBytes(), StandardOpenOption.CREATE); // 수정된 부분
            vote.setImageUrl(filePath.toString());
        }
        Vote savedVote = voteRepository.save(vote);
        return ResponseEntity.ok(savedVote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable Long id, @RequestBody Vote vote) {
        return voteRepository.findById(id)
                .map(existingVote -> {
                    existingVote.setTitle(vote.getTitle());
                    existingVote.setDescription(vote.getDescription());
                    Vote updatedVote = voteRepository.save(existingVote);
                    return ResponseEntity.ok(updatedVote);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        if (voteRepository.existsById(id)) {
            voteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}