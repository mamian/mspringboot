/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.service;

import javax.transaction.Transactional;
import net.mamian.mySpringboot.dao.UserDAO;
import net.mamian.mySpringboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-7-18 20:02:06
 * @copyright ©2016 马面 All Rights Reserved
 */
@Component
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;
    
    public User findByEmail(String email){
        return userDAO.findByEmail(email);
    }
    
    public User save(User user){
        return userDAO.save(user);
    }
    
    public void delete(long id){
        userDAO.delete(id);
    }
    
    public User findOne(long id){
        return userDAO.findOne(id);
    }
    
}