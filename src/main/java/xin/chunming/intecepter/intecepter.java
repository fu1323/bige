package xin.chunming.intecepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import xin.chunming.utils.JwtUtil;
import xin.chunming.utils.ThreadLocalUtil;

import java.util.Map;

@Component
public class intecepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("Authorization");
        if (authorization != null) {
            Map<String, Object> stringObjectMap = JwtUtil.parseToken(authorization);
            ThreadLocalUtil.set(stringObjectMap);
            return true;
        }else {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        ThreadLocalUtil.remove();
    }
}
