/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.entity.base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

/**
 * 实体父类
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-23 11:34:16
 * @copyright ©2016 马面 All Rights Reserved
 */
@MappedSuperclass
public abstract class TimeScopeEntity extends UUIDEntity {

    @Getter
    @Setter
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timeCreated;

    @Getter
    @Setter
    @Column(nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date timeLastUpdated;

    @PrePersist
    private void setup() {
        Date date = new Date();
        this.timeCreated = date;
        this.timeLastUpdated = date;
    }

}
