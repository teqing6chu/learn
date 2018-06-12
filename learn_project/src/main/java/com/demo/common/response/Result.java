package com.demo.common.response;

import com.demo.common.error.ServiceErrors;

import java.io.Serializable;

/**
 * 接口返回结果包装类
 * @param <T>
 */
public class Result<T> implements Serializable {

    private static final String SUCCESS_CODE = "000000";
    private T data;
    private boolean success;
    private String code;
    private String message;

    /**
     * 包装成功的返回结果
     * @param data 返回结果类
     * @param <T>
     * @return
     */
    public static <T> Result<T> wrapSuccessResult(T data) {
        Result<T> result = new Result();
        result.data = data;
        result.success = true;
        result.code = SUCCESS_CODE;
        result.message="success";
        return result;
    }

    public static <T> Result<T> wrapSuccessResult(String message, T data) {
        Result<T> result = new Result();
        result.data = data;
        result.success = true;
        result.code = SUCCESS_CODE;
        result.message = message;
        return result;
    }

    public static <T> Result<T> wrapErrorResult(ServiceErrors error) {
        Result<T> result = new Result();
        result.success = false;
        result.code = error.getCode();
        result.message = error.getMessage();
        return result;
    }

    public static <T> Result<T> wrapErrorResult(ServiceErrors error, Object... extendMsg) {
        Result<T> result = new Result();
        result.success = false;
        result.code = error.getCode();
        result.message = String.format(error.getMessage(), extendMsg);
        return result;
    }

    public static <T> Result<T> wrapErrorResult(String code, String message) {
        Result<T> result = new Result();
        result.success = false;
        result.code = code;
        result.message = message;
        return result;
    }

    public T getData() {
        return this.data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Result<T> setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Result<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public Result<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("success=");
        sb.append(this.success);
        sb.append(",");
        sb.append("code=");
        sb.append(this.code);
        sb.append(",");
        sb.append("message=");
        sb.append(this.message);
        sb.append(",");
        sb.append("data=");
        sb.append(this.data);
        sb.append("}");
        return sb.toString();
    }
}
