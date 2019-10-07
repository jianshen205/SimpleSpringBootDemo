package com.ccgg.SpringBootRestDemo.security;

import com.ccgg.SpringBootRestDemo.http.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-10-01 10:47
 **/
public class SecurityUtils {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendResponse(HttpServletResponse response, int status, String message, Exception exception) throws IOException{
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(new Response(exception == null, status, message)));
        response.setStatus(status);
        writer.flush();
        writer.close();
    }
}
