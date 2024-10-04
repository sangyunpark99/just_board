package com.sangyunpark.smileboard.user.repository;

import com.sangyunpark.smileboard.user.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserIdAndPassword(String id, String password);

    Optional<User> findByUserId(String id);

    Long countByUserId(String id);

    Optional<User> findById(Long id);

    void deleteByUserIdAndPassword(String id, String password);
}
