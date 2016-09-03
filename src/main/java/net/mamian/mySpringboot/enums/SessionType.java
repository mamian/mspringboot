/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.enums;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 15:36:46
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public enum SessionType implements BaseEnum {

    ADMIN("AdminSessionBean"),
    USER("SessionBean");

    private final String msg;
    
    SessionType(String msg) {
        this.msg = msg;
    }
        
    @Override
    public String getMsg() {
        return msg;
    }
    
}