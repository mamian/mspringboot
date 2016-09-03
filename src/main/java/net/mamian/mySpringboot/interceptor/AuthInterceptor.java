/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.interceptor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.mamian.mySpringboot.annotations.EmployeeLoginRequired;
import net.mamian.mySpringboot.annotations.FreeAccess;
import net.mamian.mySpringboot.annotations.LoginRequired;
import net.mamian.mySpringboot.annotations.PrivilegeRequired;
import net.mamian.mySpringboot.constant.AdminConstant;
import net.mamian.mySpringboot.entity.Employee;
import net.mamian.mySpringboot.enums.Privilege;
import net.mamian.mySpringboot.model.User;
import net.mamian.mySpringboot.utils.ContextUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-10 14:05:54
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            //方法
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            //类
            Object target = handlerMethod.getBean();
            
            //类上有FreeAccess注解
            if(target.getClass().isAnnotationPresent(FreeAccess.class)){
                return true;
            }

            //类上或方法上有LoginRequired注解
            boolean loginRequired = target.getClass().isAnnotationPresent(LoginRequired.class)
                    || null != handlerMethod.getMethodAnnotation(LoginRequired.class);
            if (loginRequired && !checkLogin(request)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            }

            //类上或方法上有EmployeeLoginRequired注解
            boolean employeeLoginRequired = target.getClass().isAnnotationPresent(EmployeeLoginRequired.class)
                    || null != handlerMethod.getMethodAnnotation(EmployeeLoginRequired.class);
            Employee employee = null;
            if (employeeLoginRequired) {
                employee = ContextUtils.getEmployee(request);
                if(employee == null){
                    response.setStatus(HttpStatus.PROXY_AUTHENTICATION_REQUIRED.value());
                    return false;
                }
            }



            Set<Privilege> priv = new HashSet<>();

            //类上有PrivilegeRequired注解
            PrivilegeRequired pr = target.getClass().getAnnotation(PrivilegeRequired.class);
            if (pr != null && pr.value() != null && pr.value().length > 0) {
                priv.addAll(Arrays.asList(pr.value()));
            }

            //方法上有PrivilegeRequired注解
            pr = handlerMethod.getMethodAnnotation(PrivilegeRequired.class);
            if (pr != null && pr.value() != null && pr.value().length > 0) {
                priv.addAll(Arrays.asList(pr.value()));
            }

            Privilege[] privileges = priv.toArray(new Privilege[priv.size()]);
            if (privileges.length > 0 && !checkPrivileges(employee, privileges)) {
                request.setAttribute("insufficientPrivilege", privileges[0].getMsg());
                response.setStatus(HttpStatus.FORBIDDEN.value());
                return false;
            }
        }
        return true;
    }
    
    private boolean checkLogin(HttpServletRequest request) {
        User user = ContextUtils.getUser(request);
        log.debug("check login user {}", user == null ? "not availiable" : user.getId());
        return user != null;
    }
    
    /**
     * 检测员工是否有权限
     */
    private boolean checkPrivileges(Employee employee, Privilege... privileges) {
        if (privileges == null || privileges.length == 0) {
            return true;
        }
        boolean result = false;
        if (employee != null) {
            if (AdminConstant.ADMIN_LOGIN_NAME.equalsIgnoreCase(employee.getLoginName())) {
                return true;
            }
            Set<Privilege> granted = employee.getPrivileges();
            for (Privilege privilege : privileges) {
                if (granted.contains(privilege)) {
                    return true;
                }
            }
        }
        return result;
    }
    
}