package com.duoduo.security.core.response;



/**
 * <pre>
 * 
 * 自定义响应结构
 * </pre>
 * 
 * @author ekko
 */
public class Result<T> {

    public final static Integer CODE_SUCCESS = 0;
    public final static Integer CODE_FAIL = 1;
    public final static String MSG_SUCCESS = "操作成功";
    public final static String MSG_FAIL = "操作失败";

    /**
     * 响应业务状态",example = "0 成功"
     */
    private Integer code;

    /**
     * 响应消息",example = "操作成功
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private T data;

    public static <T> Result<T> build(Integer code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> ok() {
        return new Result<T>(CODE_SUCCESS, MSG_SUCCESS, null);
    }

    public static <T> Result<T> fail() {
        return new Result<T>(CODE_FAIL, MSG_FAIL, null);
    }
    public static <T> Result<T> fail(T data) {
        return new Result<T>(CODE_FAIL, MSG_FAIL, data);
    }

    public Result() {

    }

    public static <T> Result<T> build(Integer code, String msg) {
        return new Result<T>(code, msg, null);
    }

    public static <T> Result<T> getResult(T t) {
        Result<T> result = new Result<>(t);
        return result;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(T data) {
        this.code = 0;
        this.msg = MSG_SUCCESS;
        this.data = data;
    }

}
