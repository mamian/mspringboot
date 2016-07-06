package net.mamian.mySpringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "T_USER")
public class User {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Getter
    @Setter
    @NotNull
    private String email;

    @Getter
    @Setter
    @NotNull
    private String name;

    public User(long id) {
        this.id = id;
    }

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

}
