package com.springmvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginContoller {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpServletResponse respose) {
		return "login";
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mian(HttpServletRequest request, HttpServletResponse response, String username, String password,
			Map<String, Object> map) throws ServletException, IOException {
		if (StringUtils.isBlank(username)) {
			map.put("message", "请输入账号！");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		if (StringUtils.isBlank(password)) {
			map.put("message", "请输入密码！");
			request.getRequestDispatcher("login").forward(request, response);
			return;
		}
		HttpSession session = request.getSession();
		Object loginStatus = session.getAttribute("loginStatus");
		if (username.equals("hzp") && password.equals("172594")) {
			session.setAttribute("loginStatus", "alreadyLogin");
			session.setAttribute("expire", System.currentTimeMillis());
			response.sendRedirect("management/hello");
			return;
		} else {
			map.put("message", "账号或密码错误！");
		}

		request.getRequestDispatcher("login").forward(request, response);
		return;
	}
}
