package com.springmvc.service;

import java.util.List;

import com.springmvc.model.ChatBackground;
import com.springmvc.model.Localtion;
import com.springmvc.model.Test;
import com.springmvc.model.User;
import com.springmvc.utils.PageDto;

public interface MyService {

	PageDto getAllPic(PageDto pageDto);

	ChatBackground selectByPrimaryKey(Long id);

	List<Localtion> findAll(Long id);

	User getUser(String name, String phone);

	Test getTest(Long id);

	List<Test> getAll(Long id);
}
