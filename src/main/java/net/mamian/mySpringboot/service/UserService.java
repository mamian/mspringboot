/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.service;

import net.mamian.mySpringboot.common.PagedResult;
import net.mamian.mySpringboot.entity.User;
import org.springframework.data.domain.PageRequest;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-18 20:02:06
 * @copyright ©2016 马面 All Rights Reserved
 */
public interface UserService {
    
    public User findByMobile(String mobile);
    
    public User save(User user);
    
    public void delete(String id);
    
    public User findOne(String id);
    
    /**
     * 创建用户
     * 
     * @param loginName
     * @param password
     * @return 
     */
    public User create(String loginName, String password);
    
    /**
     * 查找用户
     * 
     * @param loginName
     * @return 
     */
    public User findByLoginName(String loginName);
    
    /**
     * 验证密码
     * 
     * @param loginName
     * @param password
     * @return
     */
    public boolean checkPassword(String loginName, String password);
    
    public PagedResult<User> list(boolean enable, PageRequest pageRequest);
    
}