package com.sangyunpark.smileboard.user.dto.response;

import com.sangyunpark.smileboard.user.dto.UserDto;
import com.sangyunpark.smileboard.user.dto.UserStatus;
import com.sangyunpark.smileboard.user.dto.UserType;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private String userId;

    private String nickName;

    private UserType type;

    private UserStatus status;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static UserInfoResponse fromUserDto(UserDto userDto) {

        return UserInfoResponse.builder()
                .userId(userDto.getUserId())
                .type(userDto.getType())
                .status(userDto.getStatus())
                .nickName(userDto.getNickName())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .build();
    }
}
