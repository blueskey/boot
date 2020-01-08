package com.my.mapper;

import com.my.domain.PoemDo;
import com.my.domain.PoemQueryDo;
import com.my.entity.Poem;
import com.my.entity.PoemWithBLOBs;

import java.util.List;

public interface PoemMapper{
    int deleteByPrimaryKey(Long id);

    int insert(PoemWithBLOBs record);

    int insertSelective(PoemWithBLOBs record);

    PoemWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PoemWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PoemWithBLOBs record);

    int updateByPrimaryKey(Poem record);

    List<PoemDo> listPoems(PoemQueryDo queryDo);
}