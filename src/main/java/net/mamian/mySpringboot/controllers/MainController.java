package net.mamian.mySpringboot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class MainController {
    
    /**
     * 网站首页
     * 
     * @return 
     */
    @RequestMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    
    /**
     * 方法1：跳转到别另一个jsp页面
     * 
     * @return 
     */
    @RequestMapping("/forward1")
    public String forward1() {
        return "user/profile";
    }

    /**
     * 方法2：跳转到别另一个jsp页面
     * 
     * @return 
     */
    @RequestMapping(value = "forward2", method = RequestMethod.GET)
    public ModelAndView forward2() {
        return new ModelAndView("user/profile");
    }
    
}
