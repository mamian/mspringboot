/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.entity.base;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 * 主键
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-23 11:34:16
 * @copyright ©2016 马面 All Rights Reserved
 */
@MappedSuperclass
public abstract class UUIDEntity extends BaseEntity {
    
    @Getter
    @Setter
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private String id;
    
}
