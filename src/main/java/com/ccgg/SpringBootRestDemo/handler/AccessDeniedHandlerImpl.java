package com.ccgg.SpringBootRestDemo.handler;

import com.ccgg.SpringBootRestDemo.security.SecurityUtils;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 10:56
 **/

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {


    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, org.springframework.security.access.AccessDeniedException e) throws IOException, ServletException {
        SecurityUtils.sendResponse(httpServletResponse, HttpServletResponse.SC_UNAUTHORIZED, "Not authorized resources", e);

    }
}
