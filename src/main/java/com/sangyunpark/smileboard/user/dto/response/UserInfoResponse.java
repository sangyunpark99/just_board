package com.sangyunpark.smileboard.user.dto.response;

import com.sangyunpark.smileboard.user.dto.request.UserDto;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserInfoResponse {

    private String userId;
    private String nickName;
    private Boolean isAdmin;
    private String status;

    public static UserInfoResponse fromUserDto(UserDto userDto) {
        return UserInfoResponse.builder()
                .userId(userDto.getUserId())
                .nickName(userDto.getNickName())
                .isAdmin(userDto.getIsAdmin())
                .status(userDto.getStatus().toString())
                .build();
    }
}
