/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.dao;

import java.util.List;
import javax.transaction.Transactional;
import net.mamian.mySpringboot.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * 用户表访问层
 * 
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:41
 * @copyright ©2016 马面 All Rights Reserved
 */
@Transactional
public interface UserRepository extends CrudRepository<User, String> {

    /**
     * 获取用户
     * 
     * @param loginName
     * @return 
     */
    public User findByLoginName(String loginName);
    
    /**
     * 获取用户
     * 
     * @param mobile
     * @return 
     */
    @Query("select u from User u where u.mobile = :mobile")
    public User findByMobile(String mobile);
    
    /**
     * 查找用户
     * 
     * @param enabled
     * @param pageable
     * @return 
     */
    @Query("select u from User u where u.enabled = :enabled")
    public List<User> list(@Param("enabled") boolean enabled,
                           Pageable pageable);
    
    /**
     * 查找用户
     * 
     * @param enabled
     * @return 
     */
    @Query("select count(u) from User u where u.enabled = :enabled")
    public long count(@Param("enabled") boolean enabled);

}
