package com.sangyunpark.smileboard.user.aop;

import com.sangyunpark.smileboard.user.dto.UserType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LoginCheck { // custom 어노테이션

    UserType type();
}