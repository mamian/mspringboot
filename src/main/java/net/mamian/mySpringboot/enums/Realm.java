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
 * @date 2016-8-8 10:43:36
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public enum Realm implements BaseEnum {
    /**
     * 基本类型
     */
    USER("用戶"),
    EMPLOYEE("员工"),
    ROLE("角色"),
    USERGROUP("用户组"),
    
    ;
    
    private final String msg;

    private Realm(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
