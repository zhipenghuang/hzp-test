package com.springmvc.mapper;

import com.springmvc.model.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getUser(@Param("name") String name,@Param("phone") String phone);
}