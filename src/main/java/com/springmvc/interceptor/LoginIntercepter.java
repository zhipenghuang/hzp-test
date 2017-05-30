package com.springmvc.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.utils.RequestUtils;

public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = RequestUtils.getURI(request);
        System.out.println("进入拦截器验证登录,请求地址：" + url);
        HttpSession session = request.getSession();
        if ("/login".matches(url)) {
            return true;
        }
        Object status = session.getAttribute("loginStatus");// 登陆状态的判定是是否存在session
        if (status == null) {// 未登录
            response.sendRedirect(request.getContextPath() + "/login");// 跳到登录页面
            return false;
        }
        long expire = (long) session.getAttribute("expire");
        if ((System.currentTimeMillis() - expire) > 10 * 1000) {
            response.sendRedirect(request.getContextPath() + "/login");// 跳到登录页面
            response.getWriter().write("{\"sessionTimeout\": true}");
            return false;
        }
        return true;
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        try {
            String requestType = request.getHeader("X-Requested-With");
            if ("XMLHttpRequest".equals(requestType)) {
                response.setCharacterEncoding("UTF-8");
                response.setContentType("text/json");
                response.setDateHeader("Expires", 0);
                response.getWriter().write("{\"sessionTimeout\": true}");
            } else {
                response.sendRedirect(request.getContextPath() + "login");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
