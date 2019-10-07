package com.ccgg.SpringBootRestDemo.http;

/**
 * @program:
 * @description:
 * @author: Jina
 * @date:2019-09-30 11:38
 **/
public class Response {
    private boolean success;
    private int code;
    private String message;

    public Response(boolean success, String message) {
        super();
        this.code = success? 200: 400;
        this.success = success;
        this.message = message;
    }

    public Response(boolean success) {
        super();
        this.code = success? 200: 400;
        this.success = success;
        this.message = "success";
    }
    public Response(){
        super();
    }

    public Response(boolean success, int code, String message) {
        super();
        this.code = code;
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
