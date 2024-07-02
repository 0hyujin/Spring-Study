package com.example.jwt.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String token = jwtTokenProvider.resolveToken(request);

//        if (token != null && !jwtTokenProvider.validateToken(token)) {
//            jwtTokenProvider.setSecurityContext(token);
//        }
        if (token != null) {
            logger.debug("Token detected: {}", token);
            if (jwtTokenProvider.validateToken(token)) {
                logger.debug("Token is valid");
                jwtTokenProvider.setSecurityContext(token);
            } else {
                logger.debug("Token is invalid");
            }
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
