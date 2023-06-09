package com.example.bobblejump.service;

import com.example.bobblejump.domain.hearts.Hearts;
import com.example.bobblejump.domain.hearts.HeartsRepository;
import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.post.PostRepository;
import com.example.bobblejump.domain.user.User;
import com.example.bobblejump.domain.user.UserRepository;
import com.example.bobblejump.response.ResponseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static com.example.bobblejump.response.ResponseTemplateStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class HeartsService {
    private final HeartsRepository heartsRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Long saveHeart(Long userId, Long postId) throws ResponseException {
        try {
            User user = userRepository.findById(userId).orElseThrow(()-> new ResponseException(NO_USER));
            Post post = postRepository.findById(postId).orElseThrow(()-> new ResponseException(NO_POST));
            Hearts entity = new Hearts(user, post);
            return heartsRepository.save(entity).getHeartsId();
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    public String deleteHeart(Long userId, Long postId) throws ResponseException{
        try{
            User user = userRepository.findById(userId).orElseThrow(()-> new ResponseException(NO_USER));
            Post post = postRepository.findById(postId).orElseThrow(()-> new ResponseException(NO_POST));
            Long heartsId = heartsRepository.findByPost_PostIdAndUser_UserId(postId, userId).orElseThrow(() -> new ResponseException(BAD_REQUEST)).getHeartsId();
            heartsRepository.deleteById(heartsId);
            return "좋아요 취소 성공";
        }catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }
}
