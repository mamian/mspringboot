package net.mamian.mySpringboot.controllers;

import lombok.extern.slf4j.Slf4j;
import net.mamian.mySpringboot.entity.User;
import net.mamian.mySpringboot.service.UserService;
import net.mamian.mySpringboot.utils.ResponseCode;
import net.mamian.mySpringboot.utils.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * @param email
     * @return 
     */
    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView user(String email) {
        ModelAndView model = new ModelAndView();
        
        User user = userService.findByEmail(email);
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
            User user = userService.save(new User(email, name));
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
    public RestResponse delete(long id) {
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
    public RestResponse getByEmail(String email) {
        RestResponse result = new RestResponse();
        try {
            User user = userService.findByEmail(email);
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
    public RestResponse updateName(long id, String email, String name) {
        RestResponse result = new RestResponse();
        try {
            User user = userService.findOne(id);
            if(null == user){
                log.debug("user which id = "+id+" is not exist!");
                return result.error(ResponseCode.ERROR_USER_NO_EXIST);
            }
            user.setEmail(email);
            user.setName(name);
            user = userService.save(user);
            log.debug("User succesfully updated!");
            return result.success(user);
        } catch (Exception ex) {
            log.debug("Error updating the user: {}", ex.toString());
            return result.error(ResponseCode.ERROR_UNKNOW);
        }
    }
    //================================================访问数据================================================
}
