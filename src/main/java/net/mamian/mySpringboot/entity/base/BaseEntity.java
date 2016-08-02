/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.entity.base;

import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 实体父类
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-23 11:34:16
 * @copyright ©2016 马面 All Rights Reserved
 */
public abstract class BaseEntity implements Serializable {

    static final long serialVersionUID = 20160723L;
    
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE, false);
    }

}
