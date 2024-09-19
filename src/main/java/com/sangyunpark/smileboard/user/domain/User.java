package com.sangyunpark.smileboard.user.domain;

import com.sangyunpark.smileboard.global.BaseEntity;
import com.sangyunpark.smileboard.user.type.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String userId;

    private String password;

    private String nickName;

    private Boolean isAdmin;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    public void updatePassword(String newPassword){
        this.password = newPassword;
    }
}
