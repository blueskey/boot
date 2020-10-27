package com.my.controller;

import com.my.domain.ItemQueryDo;
import com.my.entity.Item;
import com.my.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/")
//@CacheConfig(cacheNames = "mycaffeineCache")
public class ItemController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

	@Autowired
	private ItemService itemService;


	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String toAdd() {

		return "item/add";
	}

	@RequestMapping(value = "list") public String list(ModelMap modelMap, ItemQueryDo queryDo) {
		logger.info("访问item/list");
		modelMap.addAttribute("items", itemService.listItems(queryDo));
		return "author/list";
	}

	@ResponseBody
	@RequestMapping("add")
	public String add(Item item) {
		itemService.addItem(item);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("star")
	public String star() {

		String[][] qu=new String[100][100];

		Item item =itemService.selectByRandom(null);


		return "ok";
	}
}
