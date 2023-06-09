package com.example.bobblejump.web;

import com.example.bobblejump.response.ResponseException;
import com.example.bobblejump.response.ResponseTemplate;
import com.example.bobblejump.service.HeartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("hearts")
public class HeartsController {
    private final HeartsService heartsService;

    @PostMapping("/like/{userId}/{postId}")
    public ResponseTemplate<Long> like(@PathVariable Long userId, @PathVariable Long postId) throws ResponseException {
        return new ResponseTemplate<>(heartsService.saveHeart(userId, postId));
    }

    @DeleteMapping("/like/{userId}/{postId}")
    public ResponseTemplate<String> unlike(@PathVariable Long userId, @PathVariable Long postId) throws ResponseException{
        return new ResponseTemplate<>(heartsService.deleteHeart(userId, postId));
    }
}
