package com.sangyunpark.smileboard.user.controller;

import com.sangyunpark.smileboard.user.dto.request.UserDto;
import com.sangyunpark.smileboard.user.dto.request.UserInfoRequest;
import com.sangyunpark.smileboard.user.dto.request.UserLoginRequest;
import com.sangyunpark.smileboard.user.dto.request.UserUpdatePasswordRequest;
import com.sangyunpark.smileboard.user.dto.request.UserWithdrawRequest;
import com.sangyunpark.smileboard.user.dto.response.UserInfoResponse;
import com.sangyunpark.smileboard.user.service.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody @Valid UserDto userDto) {
        userService.signup(userDto);
        return ResponseEntity.ok("회원 가입을 성공 했습니다.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserLoginRequest userLoginRequest) {
        userService.login(userLoginRequest.getId(), userLoginRequest.getPassword());
        return ResponseEntity.ok("로그인을 완료 했습니다.");
    }

    @PostMapping("/info")
    public ResponseEntity<UserInfoResponse> info(@RequestBody @Valid UserInfoRequest request) {
        UserDto userDto = userService.getUserInfo(request.getId(), request.getPassword());
        return ResponseEntity.ok(UserInfoResponse.fromUserDto(userDto));
    }

    @PutMapping("/logout")
    public ResponseEntity<String> logout(@RequestParam String userId) {
        userService.logout(userId);
        return ResponseEntity.ok("로그아웃을 완료했습니다.");
    }

    @DeleteMapping
    public ResponseEntity<String> userWithdraw(@RequestBody @Valid UserWithdrawRequest request) {
        userService.deleteUser(request.getId(), request.getPassword());
        return ResponseEntity.ok("계정이 삭제 되었습니다.");
    }

    @PatchMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestBody @Valid UserUpdatePasswordRequest request) {
        userService.updatePassword(request.getId(), request.getPassword(), request.getNewPassword());
        return ResponseEntity.ok("비밀번호 업데이트를 완료 했습니다.");
    }
}
