package com.sangyunpark.smileboard.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserUpdatePasswordRequest {

    @NotBlank
    private String beforePassword;

    @NotBlank
    private String afterPassword;
}
