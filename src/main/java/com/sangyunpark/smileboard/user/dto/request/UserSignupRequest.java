package com.sangyunpark.smileboard.user.dto.request;

import static com.sangyunpark.smileboard.user.dto.UserStatus.*;
import static com.sangyunpark.smileboard.user.utils.EncryptUtils.encrypt;

import com.sangyunpark.smileboard.user.domain.User;
import com.sangyunpark.smileboard.user.dto.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserSignupRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String nickName;

    @NotNull
    private UserType type;

    public UserSignupRequest(final String userId, final String password, final String nickName, final UserType type) {
        this.userId = userId;
        this.password = password;
        this.nickName = nickName;
        this.type = type;
    }

    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .password(encrypt(this.password))
                .type(this.type)
                .status(IN_USE)
                .nickName(this.nickName)
                .build();
    }

    public String getUserId() {
        return userId;
    }
}
