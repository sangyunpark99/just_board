package com.sangyunpark.smileboard.user.controller;

import com.sangyunpark.smileboard.user.dto.UserDto;
import com.sangyunpark.smileboard.user.dto.request.UserLoginRequest;
import com.sangyunpark.smileboard.user.dto.request.UserSignupRequest;
import com.sangyunpark.smileboard.user.dto.request.UserUpdatePasswordRequest;
import com.sangyunpark.smileboard.user.dto.request.UserDeleteRequest;
import com.sangyunpark.smileboard.user.dto.response.UserInfoResponse;
import com.sangyunpark.smileboard.user.dto.response.UserLoginResponse;
import com.sangyunpark.smileboard.user.dto.response.UserLogoutResponse;
import com.sangyunpark.smileboard.user.dto.response.UserSignupResponse;
import com.sangyunpark.smileboard.user.dto.response.UserUpdatePasswordResponse;
import com.sangyunpark.smileboard.user.service.UserService;
import com.sangyunpark.smileboard.user.utils.SessionUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserSignupResponse> signup(@Valid  @RequestBody UserSignupRequest request) {

        userService.signup(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(new UserSignupResponse());
    }

    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> login(@Valid @RequestBody UserLoginRequest request, HttpSession session) {

        userService.login(request, session);

        return ResponseEntity.ok(new UserLoginResponse());
    }

    @GetMapping("/info")
    public ResponseEntity<UserInfoResponse> userInfo(HttpSession session) {

        UserDto userDto = userService.getUserInfo(session);
        UserInfoResponse response = UserInfoResponse.fromUserDto(userDto);

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/password")
    public ResponseEntity<UserUpdatePasswordResponse> updatePassword(@Valid @RequestBody UserUpdatePasswordRequest request, HttpSession session) {

        userService.updatePassword(request, session);

        return ResponseEntity.ok(new UserUpdatePasswordResponse());
    }

    @PutMapping("/logout")
    public ResponseEntity<UserLogoutResponse> logout(HttpSession session) {

        SessionUtils.clear(session);

        return ResponseEntity.ok(new UserLogoutResponse());
    }

    @DeleteMapping
    public void delete(@Valid @RequestBody UserDeleteRequest request, HttpSession session) {
        userService.delete(request,session);
    }
}