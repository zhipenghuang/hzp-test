package com.springmvc.mapper;

import com.springmvc.model.Test;

import java.util.List;

public interface TestMapper extends BaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

	List<Test> getAll(Long id);
}