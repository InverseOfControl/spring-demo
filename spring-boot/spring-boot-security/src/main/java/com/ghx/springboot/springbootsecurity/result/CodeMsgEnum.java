package com.ghx.springboot.springbootsecurity.result;

public enum CodeMsgEnum implements CodeMsg {
    UNAUTHORIZED(-1, "无权限"),
    SUCCESS(1, "成功"),
    FAILED(0, "失败"),

    USER_NOT_LOGIN(1000, "用户未登录，请先登录"),
    USER_TOKEN_EXPIRED(1001, "会话过期，请先登录"),
    USER_PWD_ERROR(1001, "用户名或密码错误，请重新输入"),
    USER_UN_KNOWN_ERROR(1009, "未知异常，请联系管理员");

    private Integer code;
    private String message;

    private CodeMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
