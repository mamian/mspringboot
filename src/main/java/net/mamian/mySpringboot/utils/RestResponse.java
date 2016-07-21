/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.utils;

import lombok.Getter;
import lombok.Setter;

/**
 * 业务响应对象
 *
 * @author mamian
 * @param <T>
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-19 19:25:20
 * @copyright ©2016 马面 All Rights Reserved
 */
public class RestResponse<T> {
    
    //返回码
    @Getter
    @Setter
    private int code;
    
    //返回码描述
    @Getter
    @Setter
    private String msg;

    //返回数据
    @Getter
    @Setter
    private T param;
    
    public RestResponse() {
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
        this.param = null;
    }
    
    public RestResponse(T param) {
        this.param = param;
        this.code = ResponseCode.SUCCESS.getCode();
        this.msg = ResponseCode.SUCCESS.getMsg();
    }
    
    public RestResponse(ResponseCode code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.param = null;
    }
    
    public RestResponse(ResponseCode code, T param) {
        this.code = code.getCode();
        this.msg = code.getMsg();
        this.param = param;
    }
    
    public RestResponse <T> success(T data) {
        setCode(ResponseCode.SUCCESS.getCode());
        setMsg(ResponseCode.SUCCESS.getMsg());
        setParam(data);
        return this;
    }
    
    public RestResponse <T> success(T param, String msg) {
        setParam(param);
        setCode(ResponseCode.SUCCESS.getCode());
        setMsg(msg);
        return this;
    }
    
    public RestResponse <T> success() {
        setCode(ResponseCode.SUCCESS.getCode());
        setMsg(msg);
        return this;
    }
    
    public RestResponse <T> error(ResponseCode code) {
        setCode(code.getCode());
        setMsg(code.getMsg());
        return this;
    }
    
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }
}
