/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.common;

/**
 * 业务响应码
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-19 19:27:34
 * @copyright ©2016 马面 All Rights Reserved
 */
public enum ResponseCode {

    SUCCESS("成功", 0000),
    ERROR_UNKNOW("未知错误", 100),
    
    //客户端错误====================================================================================================================
    ERROR_PARAM_INVALID("无效的参数", 4000),
    
    ERROR_USER_NO_PERMISSION("无操作权限", 4001),
    ERROR_USER_INVALID_PASSWORD("无效的用户密码", 4002),
    ERROR_USER_NO_EXIST("用户不存在", 4003),
    ERROR_LOGINNAME_EXIST("用户名已存在", 4004),
    //====================================================================================================================
    
    ;

    final private String msg;
    
    final private int code;
    
    ResponseCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
 
    public int getCode() {
        return code;
    }
    
}
