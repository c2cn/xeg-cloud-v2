package com.xeg.cores.base.http;


import java.text.MessageFormat;

import com.xeg.cores.base.exception.IResponseEnum;
import com.xeg.cores.base.exception.enums.ThrowCommonException;

/**
 * @author ArchieDing
 * @since 2020/09/01
 */
public class JsonResultUtils {

    /**
     * 返回成功，传入返回体具体出參‘
     * 想给Im使用
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T t, String code, String type) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode(code);
        result.setMessage(type);
        result.setData(t);
        return result;
    }


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
     * 返回成功，传入返回体具体出參
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T t, int timeout) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode("200");
        result.setMessage("success");
        result.setData(t);
        SocketSync sync = new SocketSync();
        sync.setTimeout(timeout);
        result.setSync(sync);
        return result;
    }

    /**
     * 返回成功，传入返回体具体出參
     *
     * @param t
     * @param topics
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T t, String... topics) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode("200");
        result.setMessage("success");
        result.setData(t);
        SocketSync sync = new SocketSync();
        sync.setTimeout(60000);
        sync.setTopics(topics);
        result.setSync(sync);
        return result;
    }

    /**
     * 返回成功，传入返回体SocketSync
     *
     * @param sync
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(SocketSync sync) {
        JsonResult<T> result = new JsonResult<T>();
        result.setCode("200");
        result.setMessage("success");
        result.setSync(sync);
        return result;
    }

    /**
     * 返回成功，传入返回体SocketSync
     *
     * @param sync
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
        return success(null);
    }
    
    /**
    * @Title: error  
    * @Description: 2021年11月4日 上午11:31:07 自定义 VALID_ERROR 默认错误信息
    * @param @param <T>
    * @param @param message
    * @param @return    参数  
    * @return JsonResult<T>    返回类型  
    * @throws
     */
    public static <T> JsonResult<T> error(String message) {
        return error(ThrowCommonException.VALID_ERROR.getCode(), message);
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

    public static JsonResult error(IResponseEnum responseEnum) {
        JsonResult result = new JsonResult<>();
        result.setCode(responseEnum.getCode());
        result.setMessage(responseEnum.getMessage());
        return result;
    }

    public static JsonResult error(IResponseEnum responseEnum, String... args) {
        JsonResult result = new JsonResult<>();
        result.setCode(responseEnum.getCode());
        result.setMessage(MessageFormat.format(responseEnum.getMessage(), args));
        return result;
    }
}
