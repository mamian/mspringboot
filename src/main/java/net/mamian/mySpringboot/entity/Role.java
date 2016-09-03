/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Collection;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.mamian.mySpringboot.entity.base.UUIDEntity;
import net.mamian.mySpringboot.enums.Privilege;

/**
 * 
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 10:43:36
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_ROLE", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"NAME"})
})
public class Role extends UUIDEntity {

    /**
     * Name of this role
     */
    @Getter
    @Setter
    @Column(name = "NAME", nullable = false)
    private String name;
    
    /**
     * 员工组说明
     */
    @Getter
    @Setter
    private String description;

    /**
     * The members having this role granted
     */
    @Getter
    @Setter
    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Collection<Employee> members;

    @Getter
    @Setter
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "RF_PRIVILEGE")
    @Enumerated(EnumType.STRING)
    private Collection<Privilege> privileges;

}
