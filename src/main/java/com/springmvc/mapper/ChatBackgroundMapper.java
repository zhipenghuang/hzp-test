package com.springmvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.springmvc.model.ChatBackground;

public interface ChatBackgroundMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ChatBackground record);

    int insertSelective(ChatBackground record);

    ChatBackground selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ChatBackground record);

    int updateByPrimaryKey(ChatBackground record);

    @Select("select * from chat_background")
	List<ChatBackground> getAllPicture();
}