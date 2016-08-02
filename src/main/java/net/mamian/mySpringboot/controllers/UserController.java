/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.controllers;

import lombok.extern.slf4j.Slf4j;
import net.mamian.mySpringboot.entity.User;
import net.mamian.mySpringboot.service.UserService;
import net.mamian.mySpringboot.common.ResponseCode;
import net.mamian.mySpringboot.common.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用户api接口层
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:45
 * @copyright ©2016 马面 All Rights Reserved
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    //================================================访问jsp页面================================================
    /**
     * 获取用户详情页
     * 
     * @param loginName
     * @return 
     */
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView user(String loginName) {
        ModelAndView model = new ModelAndView();
        
        User user = userService.findByLoginName(loginName);
        model.addObject("user", null == user ? new User() : user);
        model.setViewName("user/profile");
        
        return model;
    }
    //================================================访问jsp页面================================================

    
    //================================================访问数据================================================
    /**
     * 创建用户
     * 
     * @param email
     * @param name
     * @return 
     */
    @RequestMapping(value="/create", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse create(String email, String name) {
        RestResponse result = new RestResponse();
        try {
            User user = userService.save(new User());
            log.debug("User succesfully created!");
            return result.success(user);
        } catch (Exception ex) {
            log.debug("Error creating the user: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }

    /**
     * 根据id删除用户
     * 
     * @param id
     * @return 
     */
    @RequestMapping(value="/delete", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse delete(String id) {
        RestResponse result = new RestResponse();
        try {
            userService.delete(id);
            log.debug("User succesfully deleted!");
            return result.success();
        } catch (Exception ex) {
            log.debug("Error deleting the user: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }

    /**
     * 根据email查询用户
     * 
     * @param email
     * @return 
     */
    @RequestMapping(value="/email", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse getByEmail(@RequestParam(value="email", defaultValue="1") String email) {
        RestResponse result = new RestResponse();
        try {
            User user = userService.getByEmail(email);
            if(null == user){
                log.debug("user which email = "+email+" is not exist!");
                return result.error(ResponseCode.ERROR_USER_NO_EXIST);
            }
            return result.success(user);
        } catch (Exception ex) {
            log.debug("Error deleting the user: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }

    /**
     * 修改用户
     * 
     * @param id
     * @param email
     * @param name
     * @return 
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse updateName(String id, String email, String name) {
        RestResponse result = new RestResponse();
        try {
            User user = userService.findOne(id);
            if(null == user){
                log.debug("user which id = "+id+" is not exist!");
                return result.error(ResponseCode.ERROR_USER_NO_EXIST);
            }
            user = userService.save(user);
            log.debug("User succesfully updated!");
            return result.success(user);
        } catch (Exception ex) {
            log.debug("Error updating the user: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }
    //================================================访问数据================================================
    
    /**
     * 用户注册
     * 
     * @param loginName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse register(@RequestHeader("token") String token,
                                 @RequestParam(value="loginName") String loginName,
                                 @RequestParam(value="password") String password) {
        RestResponse result = new RestResponse();
        
        User user = userService.findByLoginName(loginName);

        if (user != null) {
            log.error("loginName {} already existed.", loginName);
            return result.error(ResponseCode.ERROR_LOGINNAME_EXIST);
        }
        
        user = userService.create(loginName, password);
        
        return result.success(user);
    }
    
    /**
     * 用户登录
     * 
     * @param loginName 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value="loginName") String loginName,
                              @RequestParam(value="password") String password) {
        ModelAndView model = new ModelAndView();

        if (!userService.checkPassword(loginName, password)) {
            model.setViewName("login");
            return model;
        }
        model.addObject("user", userService.findByLoginName(loginName));
        model.setViewName("user/profile");
        return model;
    }

}
