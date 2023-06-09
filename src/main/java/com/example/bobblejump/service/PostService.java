package com.example.bobblejump.service;

import com.example.bobblejump.domain.hearts.HeartsRepository;
import com.example.bobblejump.domain.post.Post;
import com.example.bobblejump.domain.post.PostRepository;
import com.example.bobblejump.domain.user.User;
import com.example.bobblejump.domain.user.UserRepository;
import com.example.bobblejump.response.ResponseException;
import com.example.bobblejump.web.dto.PostDetailResponseDto;
import com.example.bobblejump.web.dto.PostResponseDto;
import com.example.bobblejump.web.dto.PostSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

import static com.example.bobblejump.response.ResponseTemplateStatus.*;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final HeartsRepository heartsRepository;

    public Long savePost(PostSaveDto postSaveDto, Long userId) throws ResponseException {
        try{
            User user = userRepository.findById(userId).orElseThrow(()-> new ResponseException(NO_USER));
            postSaveDto.setUser(user);
            return postRepository.save(postSaveDto.toEntity()).getPostId();

        } catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    public List<PostResponseDto> loadPosts() throws ResponseException {
        try{
            List<Post> entity = postRepository.findAll(Sort.by(Sort.Direction.DESC, "postId"));
            List<PostResponseDto> postResDtos = new ArrayList<>();
            for (int i = 0; i < entity.size(); i++){
                PostResponseDto postResponseDto = new PostResponseDto(entity.get(i));
                postResDtos.add(postResponseDto);
            }
            return postResDtos;
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    public PostDetailResponseDto loadPostDetail(Long postId, Long userId) throws ResponseException {
        try{
            Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseException(NO_POST));
            User user = userRepository.findById(userId).orElseThrow(() -> new ResponseException(NO_USER));
            PostDetailResponseDto responseDto = new PostDetailResponseDto(post, user);
            responseDto.setHeartCnt(heartsRepository.countByPost_PostId(postId));
            responseDto.setHearted(heartsRepository.existsByPost_PostIdAndUser_UserId(postId, userId));
            return responseDto;
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    public String deletePost(Long postId) throws ResponseException {
        try {
            Post post = postRepository.findById(postId).orElseThrow(() -> new ResponseException(NO_POST));
            postRepository.deleteById(postId);
            return "게시글 삭제에 성공했습니다.";
        }catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }
}
