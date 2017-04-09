/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.annotations;

import java.lang.annotation.*;

/**
 * 接口访问限制
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2017-4-8 21:36:20
 * @copyright ©2017 马面 All Rights Reserved
 */
@Documented
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface RequestLimit {

    /**
     * 允许访问的次数，默认值MAX_VALUE
     */
    int count() default Integer.MAX_VALUE;

    /**
     * 时间段，单位为毫秒，默认值一分钟
     */
    long time() default 60000;

}
