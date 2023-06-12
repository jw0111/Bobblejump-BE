package com.example.bobblejump.web;

import com.example.bobblejump.response.ResponseException;
import com.example.bobblejump.response.ResponseTemplate;
import com.example.bobblejump.service.PostService;
import com.example.bobblejump.web.dto.PostDetailResponseDto;
import com.example.bobblejump.web.dto.PostResponseDto;
import com.example.bobblejump.web.dto.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
@CrossOrigin(originPatterns = "http://localhost:8080")
public class PostController {
    private final PostService postService;

    @PostMapping("/upload/{userId}")
    public ResponseTemplate<Long> savePost(@RequestBody PostSaveDto postSaveDto, @PathVariable Long userId) throws ResponseException {
        return new ResponseTemplate<>(postService.savePost(postSaveDto,userId));
    }

    @GetMapping("/loadAll")
    public ResponseTemplate<List<PostResponseDto>> loadPosts() throws ResponseException{
        return new ResponseTemplate<>(postService.loadPosts());
    }

    @GetMapping("/load/{userId}/{postId}")
    public ResponseTemplate<PostDetailResponseDto> loadPostDetail(@PathVariable Long userId, @PathVariable Long postId) throws ResponseException{
        return new ResponseTemplate<>(postService.loadPostDetail(userId, postId));
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseTemplate<String> deletePost(@PathVariable Long postId) throws ResponseException{
        return new ResponseTemplate<>(postService.deletePost(postId));
    }
}
