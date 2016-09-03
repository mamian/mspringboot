/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.mamian.mySpringboot.enums.Privilege;

/**
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-19 19:25:20
 * @copyright ©2016 马面 All Rights Reserved
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface PrivilegeRequired {
    /**
     * The name/code of the privileges required
     * 
     * @return 
     */
    public Privilege[] value();
}

