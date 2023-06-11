package com.example.bobblejump.web;

import com.example.bobblejump.response.ResponseException;
import com.example.bobblejump.response.ResponseTemplate;
import com.example.bobblejump.service.UserService;
import com.example.bobblejump.web.dto.UserLoginDto;
import com.example.bobblejump.web.dto.UserResponseDto;
import com.example.bobblejump.web.dto.UserSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
@CrossOrigin(originPatterns = "http://localhost:8080")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseTemplate<Long> register(@RequestBody UserSaveDto userSaveDto) throws ResponseException {
        return new ResponseTemplate<>(userService.register(userSaveDto));
    }

    @PostMapping("/login")
    public ResponseTemplate<Long> login(@RequestBody UserLoginDto userLoginDto) throws ResponseException {
        return new ResponseTemplate<>(userService.login(userLoginDto).getUserId());
    }

    @GetMapping("/load/{userId}")
    public ResponseTemplate<UserResponseDto> loadUser(@PathVariable Long userId) throws ResponseException {
        UserResponseDto result = userService.loadUser(userId);
        return new ResponseTemplate<>(result);
    }
}


