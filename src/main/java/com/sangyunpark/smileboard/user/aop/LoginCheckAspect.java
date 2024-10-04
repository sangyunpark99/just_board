package com.sangyunpark.smileboard.user.aop;

import static com.sangyunpark.smileboard.user.error.UserErrorCode.SESSION_NOT_FOUND;

import com.sangyunpark.smileboard.user.exception.NotFoundSession;
import com.sangyunpark.smileboard.user.utils.SessionUtils;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Slf4j
@Component
@Aspect
public class LoginCheckAspect {

    @Around("@annotation(com.sangyunpark.smileboard.user.aop.LoginCheck) && @annotation(loginCheck)")
    public Object adminLoginCheck(ProceedingJoinPoint proceedingJoinPoint, LoginCheck loginCheck) throws Throwable {
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();

        String id = null;
        int idIndex = 0;

        String userType = loginCheck.type().toString();
        switch (userType) {
            case "DEFAULT" :
                id = SessionUtils.getLoginDefaultId(session);
                break;
            case "ADMIN":
                id = SessionUtils.getLoginAdminId(session);
                break;
        }

        if(id == null) {
            throw new NotFoundSession(SESSION_NOT_FOUND);
        }

        Object[] modifiedArguments = proceedingJoinPoint.getArgs();

        if(proceedingJoinPoint != null) {
            modifiedArguments[idIndex] = id;
        }

        return proceedingJoinPoint.proceed(modifiedArguments);
    }

}