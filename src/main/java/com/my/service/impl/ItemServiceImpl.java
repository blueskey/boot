package com.my.service.impl;

import com.my.domain.ItemQueryDo;
import com.my.entity.Item;
import com.my.mapper.ItemsMapper;
import com.my.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

	@Resource
	private ItemsMapper itemsMapper;

	@Override public void addItem(Item item) {
		itemsMapper.insert(item);
	}

	@Override public List<Item> listItems(ItemQueryDo queryDo) {

		return itemsMapper.listItems(queryDo);
	}

	@Override public Item selectById(String id) {
		if(StringUtils.isEmpty(id)) {
			return null;
		}
		return itemsMapper.selectByPrimaryKey(Long.parseLong(id));
	}

	@Override
	public Item selectByRandom(List<Long> excludeIds) {
		return itemsMapper.selectByRandom(excludeIds);
	}
}
