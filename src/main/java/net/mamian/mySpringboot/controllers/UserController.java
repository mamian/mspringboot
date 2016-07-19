package net.mamian.mySpringboot.controllers;

import net.mamian.mySpringboot.entity.User;
import net.mamian.mySpringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @RequestMapping("/profile")
    public ModelAndView user(String email) {
        ModelAndView model = new ModelAndView();
        
        User user = userService.findByEmail(email);
        if(null == user){
            System.out.println("user is not exist, try to init one");
            user = new User();
        }
        model.addObject("user", user);
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
    @RequestMapping("/create")
    @ResponseBody
    public String create(String email, String name) {
        try {
            User user = new User(email, name);
            userService.save(user);
        } catch (Exception ex) {
            return "Error creating the user: " + ex.toString();
        }
        return "User succesfully created!";
    }

    /**
     * 根据id删除用户
     * 
     * @param id
     * @return 
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(long id) {
        try {
            userService.delete(id);
        } catch (Exception ex) {
            return "Error deleting the user: " + ex.toString();
        }
        return "User succesfully deleted!";
    }

    /**
     * 根据email查询用户
     * 
     * @param email
     * @return 
     */
    @RequestMapping("/email")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        try {
            User user = userService.findByEmail(email);
            if(null == user){
                return "user which email = "+email+" is not exist!";
            }
            userId = String.valueOf(user.getId());
        } catch (Exception ex) {
            return "User not found: " + ex.toString();
        }
        return "The user id is: " + userId;
    }

    /**
     * 修改用户
     * 
     * @param id
     * @param email
     * @param name
     * @return 
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public String updateName(long id, String email, String name) {
        try {
            User user = userService.findOne(id);
            if(null == user){
                return "user which id = "+id+" is not exist!";
            }
            user.setEmail(email);
            user.setName(name);
            userService.save(user);
        } catch (Exception ex) {
            return "Error updating the user: " + ex.toString();
        }
        return "User succesfully updated!";
    }
    //================================================访问数据================================================
}
