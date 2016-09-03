/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot;

import lombok.Getter;
import lombok.Setter;
import net.mamian.mySpringboot.common.BaseObject;
import net.mamian.mySpringboot.entity.Employee;
import net.mamian.mySpringboot.model.User;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 15:34:27
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public class SessionBean extends BaseObject {

    private static final long serialVersionUID = 20140327L;
    
    /**
     * 当前登陆的用户
     */
    @Getter
    @Setter
    private User user;

    @Getter
    @Setter
    private Employee employee;
    
    public String getUserId() {
        return user.getId();
    }
    
}