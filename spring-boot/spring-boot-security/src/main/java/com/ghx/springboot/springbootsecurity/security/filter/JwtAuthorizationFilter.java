package com.ghx.springboot.springbootsecurity.security.filter;

import com.ghx.springboot.springbootsecurity.security.userdeatil.JWTUser;
import com.ghx.springboot.springbootsecurity.security.utils.JWTTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证过滤器
 *
 * @author 高宏旭
 * @date 2021/9/16 0016 9:59
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(JWTTokenUtil.TOKEN_HEADER);

        if (StringUtils.isEmpty(token) || !token.startsWith(JWTTokenUtil.TOKEN_PREFIX)) {
            // 交给 Spring Security 处理，如果没有任何权限信息，就会报错
            chain.doFilter(request, response);
            return;
        }

        // 解析 Token
        SecurityContextHolder.getContext().setAuthentication(createAuthentication(token));
        super.doFilterInternal(request, response, chain);
    }

    /**
     * 做权限的判断和是否登录
     *
     * @param token
     * @return
     */
    private Authentication createAuthentication(String token) {
        // 去掉前缀
        token = token.replaceFirst(JWTTokenUtil.TOKEN_PREFIX, "");
        // 解析成功，说明登录成功
        JWTUser jwtUser = JWTTokenUtil.parseTokenToJwtUser(token);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(jwtUser, null, jwtUser.getAuthorities());
        return authenticationToken;
    }
}
