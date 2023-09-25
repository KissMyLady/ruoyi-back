package com.ruoyi.common.core.domain;

import com.alibaba.fastjson2.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

import java.io.Serializable;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/25 22:23
 * @Description:
 */
public class ResultVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 默认成功信息
     */
    public static final String DEF_SUCCESS_MSG = "操作成功！";

    /**
     * 默认失败信息
     */
    public static final String DEF_ERROR_MSG = "操作失败！";

    /**
     * 成功状态
     */
    @JsonProperty("success")
    private boolean success;

    /**
     * 消息
     */
    @JsonProperty("msg")
    private String msg;

    /**
     * 状态码
     */
    @JsonProperty("code")
    private Integer code;

    /**
     * 时间戳
     */
    @JsonProperty("timestamp")
    private Long timestamp;

    /**
     * 数据对象
     */
    @JsonProperty("data")
    private T data;

    //计数
    @JsonProperty("length")
    private Integer length;

    public T getData() {
        return data;
    }

    public ResultVo<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String toJsonStr() {
        return JSONObject.toJSONString(this);
    }

    public ResultVo() {
        this.success = true;
        this.msg = DEF_SUCCESS_MSG;
        this.code = HttpStatus.OK.value();
        this.timestamp = System.currentTimeMillis();
    }

    // ================================== 静态方法 ===================================

    //成功1
    @JsonIgnore
    public static ResultVo<Object> success() {
        return new ResultVo<>();
    }


    //成功2
    @JsonIgnore
    public static ResultVo<Object> success(String msg) {
        ResultVo<Object> ret = new ResultVo<>();
        ret.setMsg(msg);
        return ret;
    }


    //成功3
    @JsonIgnore
    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> ret = new ResultVo<>();
        ret.setData(data);
        return ret;
    }

    //成功3.5
    @JsonIgnore
    public static <T> ResultVo<T> success(T data, String msg) {
        ResultVo<T> ret = new ResultVo<>();
        ret.setData(data);
        ret.setMsg(msg);
        return ret;
    }

    @JsonIgnore
    public static <T> ResultVo<T> success(T data, Integer length) {
        ResultVo<T> ret = new ResultVo<>();
        ret.setData(data);
        ret.setLength(length);
        return ret;
    }

    //成功5
    @JsonIgnore
    public static <T> ResultVo<T> success(Integer code, String msg, T data) {
        ResultVo<T> ret = new ResultVo<>();
        ret.setCode(code);
        ret.setMsg(msg);
        ret.setData(data);
        return ret;
    }

    //错误1
    @JsonIgnore
    public static ResultVo<Object> error() {
        return ResultVo.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value()
                , DEF_ERROR_MSG, null);
    }

    //错误2
    @JsonIgnore
    public static ResultVo<Object> error(String msg) {
        return ResultVo.error(
                HttpStatus.INTERNAL_SERVER_ERROR.value()
                , msg, null);
    }

    //错误3
    @JsonIgnore
    public static ResultVo<Object> error(Integer code, String msg) {
        return ResultVo.error(code, msg, null);
    }

    //错误4
    @JsonIgnore
    public static <T> ResultVo<T> error(Integer code, String msg, T data) {
        ResultVo<T> ret = new ResultVo<>();
        ret.setMsg(msg);
        ret.setCode(code);
        ret.setData(data);
        ret.setSuccess(false);
        return ret;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", timestamp=" + timestamp +
                ", data=" + data +
                ", length=" + length +
                '}';
    }
}
