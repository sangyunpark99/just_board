package com.sangyunpark.smileboard.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserInfoRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
