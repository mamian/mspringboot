/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.mamian.mySpringboot.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.mamian.mySpringboot.SessionBean;
import net.mamian.mySpringboot.entity.Employee;
import net.mamian.mySpringboot.enums.SessionType;
import net.mamian.mySpringboot.model.User;

/**
 * 
 *
 * @author mamian
 * @mail mamianskyma@aliyun.com
 * @date 2016-8-8 15:35:56
 * @copyright ©2016 马面 All Rights Reserved
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */
public class ContextUtils {

    /**
     * 获取当前登录的用户
     *
     * @param request
     * @return 没有有效用户则返回null
     */
    public static User getUser(final HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        } else {
            return getSessionBean(SessionType.USER, session).getUser();
        }
    }
    
    public static void setUser(final HttpServletRequest request, User user) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            getSessionBean(SessionType.USER, session).setUser(user);
        } 
    }

    /**
     * 获取当前登录的用户
     *
     * @param request
     * @return 没有有效用户则返回null
     */
    public static Employee getEmployee(final HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            return null;
        } else {
            return getSessionBean(SessionType.ADMIN, session).getEmployee();
        }
    }
    
    public static void setEmployee(final HttpServletRequest request, Employee employee) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            getSessionBean(SessionType.USER, session).setEmployee(employee);
        } 
    }
    
    /**
     * 
     * @param type
     * @param request
     * @return 
     */
    public static SessionBean getSessionBean(final SessionType type, final HttpServletRequest request) {
        return getSessionBean(type, request.getSession());
    }

    public static SessionBean getSessionBean(final SessionType type, final HttpSession session) {
        if (session.getAttribute(type.getMsg()) == null) {
            SessionBean sb = new SessionBean();
            session.setAttribute(type.getMsg(), sb);
            return sb;
        } else {
            return (SessionBean) session.getAttribute(type.getMsg());
        }
    }

    public static void storeInSession(final HttpServletRequest request,
                                      final String name,
                                      final Object value) {
        request.getSession().setAttribute(name, value);
    }

    /**
     * 从Session中获取给定名字和类型的对象
     *
     * @param <T>
     * @param request
     * @param name
     * @param clazz
     * @param keep true则在获取后继续保留改该对象，false删除之
     * @return 没有条目则返回null
     */
    public static <T> T getFromSession(final HttpServletRequest request,
                                       final String name,
                                       final Class<T> clazz,
                                       final boolean keep) {
        T result = null;
        HttpSession session = request.getSession();
        if (session.getAttribute(name) != null) {
            result = (T) session.getAttribute(name);
            if (!keep) {
                session.removeAttribute(name);
            }
        }
        return result;
    }
    
}