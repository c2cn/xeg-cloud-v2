package com.xeg.cores.base.http;

import com.xeg.cores.base.exception.IResponseEnum;
import com.xeg.cores.base.exception.ServiceException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.text.MessageFormat;

import static cn.hutool.http.HttpStatus.*;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
@ApiModel(value = "响应结构")
public class JsonResult<T> {
    /**
     * 状态码
     */
    @ApiModelProperty(value = "返回状态码；200:成功")
    private String code;
    /**
     * 消息
     */
    @ApiModelProperty(value = "描述信息")
    private String message;

    /**
     * 服务器时间戳
     */
    @ApiModelProperty(value = "服务器时间")
    private Long timestamp = System.currentTimeMillis();

    /**
     * 参数信息
     */
    @ApiModelProperty(value = "返回参数信息")
    private T data;

    /**
     * Socket同步返回对象
     */
    @ApiModelProperty(value = "Socket同步返回对象")
    private SocketSync sync;

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T t) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode("200");
        result.setMessage("success");
        result.setData(t);
        return result;
    }


    /**
     * 必须返回200,否则抛出异常
     */
    public void assertOK() {
        if (!code.equals(HTTP_OK)) {
            throw new ServiceException(code, message);
        }
    }

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T t, SocketSync sync) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode("200");
        result.setMessage("success");
        result.setData(t);
        result.setSync(sync);
        return result;
    }

    /**
     * 提供给部分不需要出參的接口
     *
     * @return
     */
    public static JsonResult success() {
        return success("请求成功", null);
    }

    /**
     * 自定义错误信息
     *
     * @param code
     * @param message
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> error(String code, String message) {
        JsonResult<T> result = new JsonResult<>();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * 请求失败，返回错误码及错误信息
     *
     * @param code    错误码
     * @param message 错误信息
     * @return
     */
    public static <T> JsonResult<T> error(String code, String message, T data) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code);
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static JsonResult error(IResponseEnum responseEnum, Object... objects) {
        JsonResult result = new JsonResult<>();
        result.setCode(responseEnum.getCode());
        result.setMessage(MessageFormat.format(responseEnum.getMessage(), objects));
        return result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SocketSync getSync() {
        return sync;
    }

    public void setSync(SocketSync sync) {
        this.sync = sync;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @ApiModelProperty(value = "成功标识；true：成功；false:失败")
    public boolean isSuccess() {
        return "200".equals(this.code);
    }
}
