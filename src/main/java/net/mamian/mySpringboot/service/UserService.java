/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.service;

import java.util.List;
import javax.transaction.Transactional;
import net.mamian.mySpringboot.common.PagedResult;
import net.mamian.mySpringboot.dao.UserDAO;
import net.mamian.mySpringboot.dao.UserRepository;
import net.mamian.mySpringboot.entity.User;
import net.mamian.mySpringboot.enums.CountryCode;
import net.mamian.mySpringboot.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    @Autowired
    private UserRepository userRepository;
    
    public User getByEmail(String email){
        return userDAO.findByEmail(email);
    }
    
    public User save(User user){
        return userRepository.save(user);
    }
    
    public void delete(String id){
        userRepository.delete(id);
    }
    
    public User findOne(String id){
        return userRepository.findOne(id);
    }
    
    /**
     * 创建用户
     * 
     * @param loginName
     * @param password
     * @return 
     */
    public User create(String loginName, String password){
        String salt = SecurityUtils.getSalt(loginName);
        String passphrase = SecurityUtils.getPassphrase(salt, password);
        
        User user = new User(CountryCode.CN,
                             null,
                             null,
                             loginName,
                             passphrase,
                             salt,
                             null,
                             true);
        return userRepository.save(user);
    }
    
    /**
     * 查找用户
     * 
     * @param loginName
     * @return 
     */
    public User findByLoginName(String loginName){
        return userRepository.findByLoginName(loginName);
    }
    
    /**
     * 验证密码
     * 
     * @param loginName
     * @param password
     * @return
     */
    public boolean checkPassword(String loginName, String password) {
        User user = userRepository.findByLoginName(loginName);
        if(null == user){
            return false;
        }
        String passphrase = SecurityUtils.getPassphrase(user.getSalt(), password);
        return user.getPassphrase().equals(passphrase);
    }
    
    public PagedResult<User> list(boolean enable, PageRequest pageRequest){
        long count = userRepository.count(enable);
        List<User> result = userRepository.list(enable, pageRequest);
        return new PagedResult(result, count);
    }
    
}