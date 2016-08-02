/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mamian.mySpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 程序入口
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-07-05 11:31
 * @copyright ©2016 马面 All Rights Reserved
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebJspApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebJspApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebJspApplication.class, args);
    }

}
