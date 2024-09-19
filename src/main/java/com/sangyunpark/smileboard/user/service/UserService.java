package com.sangyunpark.smileboard.user.service;

import com.sangyunpark.smileboard.user.dto.request.UserDto;

public interface UserService {

    void signup(UserDto userDto);

    UserDto login(String id, String password);

    void updatePassword(String id,String password, String newPassword);

    Boolean isDuplicatedId(String id);

    UserDto getUserInfo(String userId, String password);

    void deleteUser(String id, String password);

    void logout(String id);
}
