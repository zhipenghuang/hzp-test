package com.springmvc.mapper;

import java.util.List;

import com.springmvc.model.Localtion;

public interface LocaltionMapper extends BaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Localtion record);

    int insertSelective(Localtion record);

    Localtion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Localtion record);

    int updateByPrimaryKey(Localtion record);
    
    public List<Localtion> findAll(Long id);
}