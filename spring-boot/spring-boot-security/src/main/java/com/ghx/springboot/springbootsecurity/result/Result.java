package com.ghx.springboot.springbootsecurity.result;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

@JsonPropertyOrder({"code", "message"})
public class Result<T> implements Serializable {
    private static final Logger log = LoggerFactory.getLogger(Result.class);
    private static final long serialVersionUID = 3055500232134711804L;
    private Integer code;
    private String message;
    private T data;

    private Result() {
    }

    private Result(CodeMsg codeMsg, T data) {
        this.data = data;
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }

    public static <T> Result<T> of(CodeMsg codeMsg, T data) {
        return new Result(codeMsg, data);
    }

    public static <T> Result<T> of(CodeMsg codeMsg) {
        return new Result(codeMsg, null);
    }

    public static <T> Result<T> ok() {
        return of(CodeMsgEnum.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data) {
        return of(CodeMsgEnum.SUCCESS, data);
    }

    public static <T> Result<T> error(T data) {
        return of(CodeMsgEnum.FAILED, data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg) {
        return of(codeMsg);
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean success() {
        return CodeMsgEnum.SUCCESS.getCode().equals(this.getCode());
    }
}
