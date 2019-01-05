package com.my.mapper;

import com.my.entity.Author;

public interface AuthorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Author record);

    int insertSelective(Author record);

    Author selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Author record);

    int updateByPrimaryKeyWithBLOBs(Author record);

    int updateByPrimaryKey(Author record);
}