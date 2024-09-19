package com.sangyunpark.smileboard.user.dto.request;

import com.sangyunpark.smileboard.user.domain.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDto {

    @NotBlank
    private String userId;

    @NotBlank
    private String password;

    @NotBlank
    private String nickName;

    @NotNull
    private Boolean isAdmin;

    @NotBlank
    private String status;

    public static UserDto fromEntity(User user){
        return UserDto.builder()
                .userId(user.getUserId())
                .isAdmin(user.getIsAdmin())
                .nickName(user.getNickName())
                .password(user.getPassword())
                .status(user.getStatus().toString())
                .build();
    }
}
