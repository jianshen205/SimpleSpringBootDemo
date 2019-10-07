package com.ccgg.SpringBootRestDemo.handler;

import com.ccgg.SpringBootRestDemo.security.SecurityUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 11:23
 **/

@Component
public class AuthenticationFailureHandlerImpl extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        SecurityUtils.sendResponse(response, HttpServletResponse.SC_UNAUTHORIZED, "Login failed", exception);

    }
}