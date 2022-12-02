package cn.violin.home.common.Interceptor;

import cn.violin.home.common.annotation.PassToken;

import cn.violin.home.common.utils.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional;

import static cn.violin.home.common.utils.CommonConstant.*;

/**
 * Interceptor トーケンの検証
 * work flow
 * 1.method check
 * 2.PassToken annotation check
 * 3.UserLoginToken annotation check
 *  3.1 token is null, throw exception
 *  3.2 to query token from redis and compare
 *
 *
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private JedisUtils redis;

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws IOException {

        // メソッド以外は通る
        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();
        // passTokenアノテーションの検証
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        String authorization = req.getHeader("Authorization");
        String tenantId = req.getHeader("tenantId");

        if (StringUtils.hasLength(authorization) && (authorization.split(":").length == 2) && StringUtils.hasLength(tenantId)) {
            String token = authorization.split(":")[1];
            Optional<String> tokenNullable = redis.get(tenantId);
            if (tokenNullable.isPresent() && tokenNullable.get().equals(token)) {
                return true;
            }
            resp.setStatus(HttpStatus.UNAUTHORIZED.value());
            resp.getWriter().write(ERROR_INFO_1);
            log.info(ERROR_INFO_1);
            return false;
        }
        resp.setStatus(HttpStatus.UNAUTHORIZED.value());
        if (!StringUtils.hasLength(authorization)) {
            resp.getWriter().write(ERROR_INFO_2);
            log.info(ERROR_INFO_2);
        } else if (!StringUtils.hasLength(tenantId)) {
            log.info(ERROR_INFO_3);
            resp.getWriter().write(ERROR_INFO_3);
        }
        return false;
    }
}
