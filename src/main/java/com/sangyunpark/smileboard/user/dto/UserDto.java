package com.sangyunpark.smileboard.user.dto;

import com.sangyunpark.smileboard.user.domain.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {

    private String userId;

    private String password;

    private String nickName;

    private UserType type;

    private UserStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .password(user.getPassword())
                .nickName(user.getNickName())
                .type(user.getType())
                .status(user.getStatus())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }
}
