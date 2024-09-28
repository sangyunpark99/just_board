package com.sangyunpark.smileboard.user.service;

import static com.sangyunpark.smileboard.user.exception.errorCode.ErrorCode.*;
import static com.sangyunpark.smileboard.user.exception.errorCode.ErrorCode.DUPLICATED_ID;
import static com.sangyunpark.smileboard.user.utils.EncryptUtils.encrypt;

import com.sangyunpark.smileboard.user.domain.User;
import com.sangyunpark.smileboard.user.dto.UserDto;
import com.sangyunpark.smileboard.user.dto.UserType;
import com.sangyunpark.smileboard.user.dto.request.UserLoginRequest;
import com.sangyunpark.smileboard.user.dto.request.UserSignupRequest;
import com.sangyunpark.smileboard.user.dto.request.UserUpdatePasswordRequest;
import com.sangyunpark.smileboard.user.dto.request.UserDeleteRequest;
import com.sangyunpark.smileboard.user.exception.DuplicatedIdException;
import com.sangyunpark.smileboard.user.exception.NotFoundSession;
import com.sangyunpark.smileboard.user.exception.UserNotFoundException;
import com.sangyunpark.smileboard.user.repository.UserRepository;
import com.sangyunpark.smileboard.user.utils.EncryptUtils;
import com.sangyunpark.smileboard.user.utils.SessionUtils;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signup(final UserSignupRequest request) {

        if (isDuplicated(request.getUserId())) {
            throw new DuplicatedIdException(DUPLICATED_ID);
        }

        User user = request.toEntity();

        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public void login(final UserLoginRequest request, final HttpSession session) {

        String encryptPassword = EncryptUtils.encrypt(request.getPassword());

        User user = userRepository.findByUserIdAndPassword(request.getUserId(), encryptPassword)
                .orElseThrow(() -> new UserNotFoundException(
                        USER_NOT_FOUND));

        if(user.getType() == UserType.DEFAULT) {
            SessionUtils.setLoginDefaultId(session, request.getUserId());
        }else {
            SessionUtils.setLoginAdminId(session, request.getUserId());
        }
    }

    @Transactional(readOnly = true)
    public boolean isDuplicated(final String id) {
        return userRepository.countByUserId(id) == 1;
    }

    @Transactional(readOnly = true)
    public UserDto getUserInfo(final HttpSession session) {

        String id = SessionUtils.getLoginDefaultId(session) == null ? SessionUtils.getLoginAdminId(session) : SessionUtils.getLoginDefaultId(session);

        if(id == null) {
            throw new NotFoundSession(SESSION_NOT_FOUND);
        }

        User user = userRepository.findByUserId(id).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        return UserDto.fromEntity(user);
    }

    @Transactional(readOnly = true)
    public void updatePassword(final UserUpdatePasswordRequest request, final HttpSession session) {

        String encryptBeforePassword = EncryptUtils.encrypt(request.getBeforePassword());

        String id = SessionUtils.getLoginDefaultId(session);
        if(id == null) SessionUtils.getLoginAdminId(session);

        User user = userRepository.findByUserIdAndPassword(id, encryptBeforePassword).orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        user.updatePassword(encrypt(request.getAfterPassword()));
    }

    @Transactional
    public void delete(final UserDeleteRequest request, final HttpSession session) {

        String id = request.getId();
        String encryptPassword = EncryptUtils.encrypt(request.getPassword());

        userRepository.findByUserIdAndPassword(request.getId(), encryptPassword)
                .orElseThrow(() -> new UserNotFoundException(USER_NOT_FOUND));

        userRepository.deleteByUserIdAndPassword(id, encryptPassword);

        SessionUtils.clear(session);
    }
}