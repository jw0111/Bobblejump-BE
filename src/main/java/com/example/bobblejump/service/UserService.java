package com.example.bobblejump.service;

import com.example.bobblejump.domain.user.Role;
import com.example.bobblejump.domain.user.User;
import com.example.bobblejump.domain.user.UserRepository;
import com.example.bobblejump.response.ResponseException;
import com.example.bobblejump.web.dto.UserLoginDto;
import com.example.bobblejump.web.dto.UserResponseDto;
import com.example.bobblejump.web.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import static com.example.bobblejump.response.ResponseTemplateStatus.*;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long register(UserSaveDto userSaveDto) throws ResponseException {
        try{
            userSaveDto.setUserPwd(bCryptPasswordEncoder.encode(userSaveDto.getUserPwd()));
            userSaveDto.setRole(Role.ROLE_USER);
            return userRepository.save(userSaveDto.toEntity()).getUserId();
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(e.getStatusCode());
        }
    }

    public User login(UserLoginDto userLoginDto) throws ResponseException{
        User user = userRepository.findByUserEmail(userLoginDto.getEmail()).orElseThrow(()-> new ResponseException(NO_USER));
        if(!bCryptPasswordEncoder.matches(userLoginDto.getPassword(), user.getUserPwd())){
            throw new ResponseException(WRONG_PWD);
        }
        return user;
    }

    public UserResponseDto loadUser(Long userId) throws ResponseException {
        User user = userRepository.findById(userId).orElseThrow(() ->new ResponseException(NO_USER));
        return new UserResponseDto(user);
    }

    public void saveScore(Long userId, int score) throws ResponseException {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResponseException(NO_USER));
        user.setScore(score);
        return;
    }
}
