package com.sangyunpark.smileboard.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserLoginRequest {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;
}
