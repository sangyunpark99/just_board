package com.sangyunpark.smileboard.user.dto.request;

import static com.sangyunpark.smileboard.user.utils.EncryptUtils.encrypt;

import com.sangyunpark.smileboard.user.domain.User;
import com.sangyunpark.smileboard.user.dto.UserStatus;
import com.sangyunpark.smileboard.user.dto.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UserSignupRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String nickName;

    @NotNull
    private UserType type;

    @NotNull
    private UserStatus status;

    public User toEntity() {
        return User.builder()
                .userId(this.userId)
                .password(encrypt(this.password))
                .type(this.type)
                .status(this.status)
                .nickName(this.nickName)
                .build();
    }
}
