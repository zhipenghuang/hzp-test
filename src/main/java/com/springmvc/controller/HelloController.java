package com.springmvc.controller;

import java.util.List;
import java.util.Map;

import com.springmvc.model.Localtion;
import com.springmvc.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springmvc.exception.ServiceException;
import com.springmvc.model.ChatBackground;
import com.springmvc.service.MyService;
import com.springmvc.utils.Response;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@Controller
@Api(value = "Test", description = "test the swagger API")
@RequestMapping("/management")
public class HelloController {

	@Autowired
	private MyService myServie;

	@ResponseBody
	@RequestMapping(value = "/world/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "根据id查询图片", httpMethod = "GET", response = ChatBackground.class, notes = "根据id查询图片")
	public Response HelloWorld(@ApiParam(required = true, name = "id", value = "id") @PathVariable Long id,
	                           Map<String, Object> map) throws ServiceException {
		Response response = new Response();
		String string = RedisUtils.getJedis().get("name");
		response.data = string;
		return response;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String getPicPage() throws ServiceException {
		return "secure/HelloWorld";
	}

	@ResponseBody
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public Response getLocation() throws ServiceException {
		Response response = new Response();
		List<Localtion> all = myServie.findAll(0L);
		response.data = all;
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public Response getUser() throws ServiceException {
		Response response = new Response();
		response.data = myServie.getUser("hzp", "18200299031");
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Response test() throws ServiceException {
		Response response = new Response();
		response.data = myServie.getAll(2L);
		return response;
	}
}