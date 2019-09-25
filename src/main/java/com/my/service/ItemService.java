package com.my.service;

import com.my.domain.ItemQueryDo;
import com.my.entity.Item;

import java.util.List;

public interface ItemService {
	void addItem(Item item);

	List<Item> listItems(ItemQueryDo queryDo);

	Item selectById(String id);

	Item selectByRandom(List<Long> excludeIds);

}
