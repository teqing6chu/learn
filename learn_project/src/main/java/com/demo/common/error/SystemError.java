package com.demo.common.error;

/**
 * 常见系统错误类
 */
public enum SystemError implements ServiceErrors{
    UNKNOWN("10001", "未知的严重错误类型。"),
    SIGN_FILED("10002", "invalid sign"),
    SERVER_BUSY("10003", "服务器繁忙，请稍后！");

    private final String code;
    private final String message;

    SystemError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
