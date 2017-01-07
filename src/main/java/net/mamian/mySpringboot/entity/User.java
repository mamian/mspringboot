/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.mamian.mySpringboot.entity.base.TimeScopeEntity;
import net.mamian.mySpringboot.enums.CountryCode;
import net.mamian.mySpringboot.utils.SecurityUtils;

/**
 * 用户
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:36
 * @copyright ©2016 马面 All Rights Reserved
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_USER",
       indexes = {@Index(columnList="mobile")})
public class User extends TimeScopeEntity {
    
    /**
     * 国际国家代码与区号
     */
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
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
    @NotNull
    private String loginName;
    
    /**
     * 密码的密文
     */
    @Getter
    @Setter
    @Column(nullable = false, length = 40)
    protected String passphrase;

    /**
     * 加密盐值
     */
    @Getter
    @Setter
    @Column(nullable = false, length = 120)
    protected String salt;
    
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
    
    
    
    /**
     * 设置password对应的盐值和密文
     * 
     * @param loginName
     * @param password 
     */
    public void password(final String loginName, final String password) {
        salt = SecurityUtils.getSalt(loginName);
        passphrase = SecurityUtils.getPassphrase(salt, password);
    }

}
