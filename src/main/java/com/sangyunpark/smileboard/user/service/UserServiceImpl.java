package com.sangyunpark.smileboard.user.service;

import com.sangyunpark.smileboard.user.domain.User;
import com.sangyunpark.smileboard.user.dto.request.UserDto;
import com.sangyunpark.smileboard.user.exception.DuplicateIdException;
import com.sangyunpark.smileboard.user.exception.NotExistedUser;
import com.sangyunpark.smileboard.user.repository.UserRepository;
import com.sangyunpark.smileboard.user.type.UserStatus;
import com.sangyunpark.smileboard.user.util.EncryptUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public void signup(UserDto userDto) {
        if (isDuplicatedId(userDto.getUserId())) {
            throw new DuplicateIdException();
        }

        User user = User.builder()
                .userId(userDto.getUserId())
                .password(EncryptUtil.encoder(userDto.getPassword()))
                .status(UserStatus.NORMAL)
                .nickName(userDto.getNickName())
                .isAdmin(userDto.getIsAdmin())
                .build();

       userRepository.save(user);
    }

    @Override
    @Transactional
    public UserDto login(String id, String password) {
        String encryptPassword = EncryptUtil.encoder(password);
        User user = userRepository.findUserByUserIdAndPassword(id, encryptPassword).orElseThrow(() -> new NotExistedUser());
        return UserDto.fromEntity(user);
    }

    @Override
    @Transactional
    public void updatePassword(String id, String password, String newPassword) {
        String encryptPassword = EncryptUtil.encoder(password);
        String encryptNewPassword = EncryptUtil.encoder(newPassword);
        User user = userRepository.findUserByUserIdAndPassword(id, encryptPassword).orElseThrow(() -> new NotExistedUser());
        user.updatePassword(encryptNewPassword);
    }

    @Override
    @Transactional(readOnly = true)
    public Boolean isDuplicatedId(String id) {
        return userRepository.existsByUserId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto getUserInfo(String userId, String password) {
        User user = userRepository.findUserByUserIdAndPassword(userId, EncryptUtil.encoder(password)).orElseThrow(() -> new NotExistedUser());
        return UserDto.fromEntity(user);
    }

    @Override
    public void deleteUser(String id, String password) {
        User user = userRepository.findUserByUserIdAndPassword(id, EncryptUtil.encoder(password)).orElseThrow(() -> new NotExistedUser());
        userRepository.delete(user);
    }

    @Override
    public void logout(String id) {

    }
}
