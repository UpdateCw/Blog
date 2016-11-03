package com.update.framework.model;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO 服务端数据响应对象
 */
public class ResponseData {
    public static final int ERROR = 0;
    public static final int SUCCESS = 1;
    /**
     * 状态码
     */
    private int code = SUCCESS;
    /**
     * 返回客户端的数据
     */
    private Object data;
    /**
     * 返回客户端的消息
     */
    private String msg = "";

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
