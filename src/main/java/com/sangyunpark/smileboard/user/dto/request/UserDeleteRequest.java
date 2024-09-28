package com.sangyunpark.smileboard.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserDeleteRequest {

    @NotBlank
    private String id;

    @NotBlank
    private String password;
}
