package com.springmvc.interceptor;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @ClassName: LogAspect
 * @Description: 日志记录AOP实现
 * 
 */
@Aspect
@Slf4j
public class LogAspect {
	private String requestPath = null; // 请求地址
	private String userName = null; // 用户名
	private Map<?, ?> inputParamMap = null; // 传入参数
	private Map<String, Object> outputParamMap = null; // 存放输出结果
	private long startTimeMillis = 0; // 开始时间
	private long endTimeMillis = 0; // 结束时间

	/**
	 * 方法调用前触发 记录开始时间
	 */
	@Before("execution(* com.springmvc.controller..*.*(..))")
	public void doBeforeInServiceLayer(JoinPoint joinPoint) {
		startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
	}

	/**
	 * 
	 * 方法调用后触发 记录结束时间
	 */
	@After("execution(* com.springmvc.controller..*.*(..))")
	public void doAfterInServiceLayer(JoinPoint joinPoint) {
		endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
		printOptLog();
	}

	/**
	 * 环绕触发
	 */
	@Around("execution(* com.springmvc.controller..*.*(..))")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		/**
		 * 1.获取request信息 2.根据request获取session 3.从session中取出登录用户信息
		 */
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		// 获取输入参数
		inputParamMap = request.getParameterMap();
		// 获取请求地址
		requestPath = request.getRequestURI();
		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		outputParamMap = new HashMap<String, Object>();
		Object result = pjp.proceed();// result的值就是被拦截方法的返回值
		outputParamMap.put("result", result);

		return result;
	}

	/**
	 * 输出日志
	 */
	private void printOptLog() {
		Gson gson = new Gson(); // 需要用到google的gson解析包
		String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
		log.info("请求地址：" + requestPath + "\n请求时间：" + optTime + "\n花费时间：" + (endTimeMillis - startTimeMillis)
				+ "ms" + "\n参数：" + gson.toJson(inputParamMap) + "\n请求结果：" + gson.toJson(outputParamMap));
	}
}
