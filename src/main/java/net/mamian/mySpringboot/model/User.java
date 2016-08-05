/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.mamian.mySpringboot.common.BaseObject;
import net.mamian.mySpringboot.enums.CountryCode;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-4 18:33:30
 * @copyright ©2016 马面 All Rights Reserved
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseObject {

    /**
     * id
     */
    @Getter
    @Setter
    private String id;
    
    /**
     * 国际国家代码与区号
     */
    @Getter
    @Setter
    private CountryCode countryCode;
    
    /**
     * 手机号
     */
    @Getter
    @Setter
    private String mobile;
    
    /**
     * 真实姓名
     */
    @Getter
    @Setter
    private String name;
    
    /**
     * 用户名
     */
    @Getter
    @Setter
    private String loginName;
    
    /**
     * 头像
     */
    @Getter
    @Setter
    private String avatar;

    /**
     * 用户状态: true(启用) | false(禁用)
     */
    @Getter
    @Setter
    private boolean enabled;
    
}