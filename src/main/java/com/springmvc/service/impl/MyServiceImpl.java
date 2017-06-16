package com.springmvc.service.impl;

import java.util.List;

import com.springmvc.mapper.UserMapper;
import com.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.mapper.ChatBackgroundMapper;
import com.springmvc.mapper.LocaltionMapper;
import com.springmvc.model.ChatBackground;
import com.springmvc.model.Localtion;
import com.springmvc.service.MyService;
import com.springmvc.utils.PageDto;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private ChatBackgroundMapper chatBackgroundMapper;
	@Autowired
	private LocaltionMapper localtionMapper;
	@Autowired
	private UserMapper userMapper;


	public PageDto getAllPic(PageDto pageDto) {
		Integer pageSize = pageDto.getPageSize();
		Integer pageIndex = pageDto.getPageIndex();
		if (pageIndex == null || pageIndex <= 0) {
			pageIndex = 1;
		}
		if (pageSize == null || pageSize <= 0) {
			pageSize = 10;
		}
		PageHelper.startPage(pageIndex, pageSize);
		List<ChatBackground> allPicture = chatBackgroundMapper.getAllPicture();
		PageInfo<ChatBackground> pageInfo = new PageInfo<ChatBackground>(allPicture);
		pageDto.setDataCount(Integer.parseInt(pageInfo.getTotal() + ""));
		pageDto.setData(allPicture);
		return pageDto;
	}

	public ChatBackground selectByPrimaryKey(Long id) {
		return chatBackgroundMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Localtion> findAll(Long id) {
		List<Localtion> findAll = localtionMapper.findAll(id);
		return findAll;
	}

	@Override
	public User getUser(String name, String phone) {
		User user = userMapper.getUser(name, phone);

		return user;
	}

}
