package cn.ayeez.interceptor;

import cn.ayeez.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String url = request.getRequestURI();
        if (url.contains("/login")) {
            log.info("登录操作，放行");
            return true;
        }

        String token = request.getHeader("token");
        if (token == null || token.isEmpty()) {
            log.info("未登录，请先登录");
            response.setStatus(401);
            return false;
        }

        try {
            JwtUtils.parseToken(token);
        } catch (Exception e) {
            log.info("token解析失败，请重新登录");
            response.setStatus(401);
            return false;
        }
        log.info("token解析成功，放行");
        return  true;

    }
}
