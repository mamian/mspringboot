/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot.controllers;

import java.io.IOException;
import net.mamian.mySpringboot.rpc.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户api接口层
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:45
 * @copyright ©2016 马面 All Rights Reserved
 */
@Controller
public class HomeController {
    
    @RequestMapping(value="/dubbo", method = RequestMethod.GET)
    @ResponseBody
    public String test() throws IOException{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"dubbo-comsumer.xml"});
        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");
        return demoService.sayHello("马面");
    }
    
}
