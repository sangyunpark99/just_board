package com.sangyunpark.smileboard.user.repository;

import com.sangyunpark.smileboard.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    Boolean existsByUserId(String id);

    Optional<User> findUserByUserIdAndPassword(String id, String password);

    Optional<User> findUserByUserId(String id);
}
