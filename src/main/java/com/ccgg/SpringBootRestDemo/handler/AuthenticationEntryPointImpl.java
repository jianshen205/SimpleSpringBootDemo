package com.ccgg.SpringBootRestDemo.handler;

import com.ccgg.SpringBootRestDemo.security.SecurityUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 11:03
 **/

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        SecurityUtils.sendResponse(httpServletResponse, HttpServletResponse.SC_FORBIDDEN, "Authentication failed", e);

    }
}
