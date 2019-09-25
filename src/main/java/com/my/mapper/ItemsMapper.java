package com.my.mapper;

import com.my.domain.ItemQueryDo;
import com.my.entity.Item;

import java.util.List;

public interface ItemsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> listItems(ItemQueryDo  queryDo);

    Item selectByRandom(List<Long> excludeIds);
}