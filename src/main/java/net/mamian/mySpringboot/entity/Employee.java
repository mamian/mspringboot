/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import net.mamian.mySpringboot.enums.Privilege;
import net.mamian.mySpringboot.entity.base.TimeScopeEntity;
import net.mamian.mySpringboot.utils.SecurityUtils;

/**
 * 后台员工
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 10:43:36
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "T_EMPLOYEE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"loginName"}),
    @UniqueConstraint(columnNames = {"employeeId"}),
    @UniqueConstraint(columnNames = {"mobile"})
})
public class Employee extends TimeScopeEntity {

    @Column(nullable = false, length = 60)
    private String loginName;

    @Column(nullable = false, length = 60)
    private String employeeId;
    
    @Column(length = 20)
    private String name;
    
    @Column(name = "mobile", nullable = false)
    private String mobile;
    
    @ManyToMany
    @JoinTable(name = "RF_EMP_ROLE",
            joinColumns = @JoinColumn(name = "EMP_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    @JsonManagedReference
    private Collection<Role> roles;
    
    /**
     * passphrase value
     */
    @Column(nullable = false, length = 40)
    protected String passphrase;

    /**
     * salt value in hex
     */
    @Column(nullable = false, length = 120)
    protected String salt;

    /**
     * The timestamp that last successfully login
     */
    @Temporal(TemporalType.TIMESTAMP)
    protected Date lastLoginDate;

    /**
     * The time that this guy registered, the value is immutable
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    protected Date registerDate;
    
    /**
     * 设置password对应的盐值和密文
     * 
     * @param mobile
     * @param password 
     */
    public void password(final String mobile, final String password) {
        this.salt = SecurityUtils.getSalt(mobile);
        this.passphrase = SecurityUtils.getPassphrase(salt, password);
    }
    
    public Set<Privilege> getPrivileges(){
        Set<Privilege> result = new HashSet<>();
        for(Role role : this.roles){
            result.addAll(role.getPrivileges());
        }
        return result;
    }
}
