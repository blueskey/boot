package com.my.mapper;

import com.my.entity.Poem;
import com.my.entity.PoemWithBLOBs;

public interface PoemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PoemWithBLOBs record);

    int insertSelective(PoemWithBLOBs record);

    PoemWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PoemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PoemWithBLOBs record);

    int updateByPrimaryKey(Poem record);
}