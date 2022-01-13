package com.my.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.my.domain.AuthorQueryDo;
import com.my.entity.Author;
import com.my.log.MyLog;
import com.my.service.AuthorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author/")

public class AuthorController extends BaseController{

	private static Logger logger = Logger.getLogger(AuthorController.class);

	@Autowired
	private AuthorService authorService;

	@MyLog(module = "作者",operator = "哈哈")
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String toAdd() {

		return "author/add";
	}

	@RequestMapping(value = "list")
//	@Cacheable(value = "user:info", depict = "用户信息缓存", key = "#allAuthorList",
//			firstCache = @FirstCache(expireTime = 2, timeUnit = TimeUnit.SECONDS),
//			secondaryCache = @SecondaryCache(expireTime = 30, preloadTime = 3, forceRefresh = true, timeUnit = TimeUnit.SECONDS))
	public String list(ModelMap modelMap, AuthorQueryDo queryDo) {
		try (Entry entry = SphU.entry("authorList")) {
			logger.info("访问auth/list");
			modelMap.addAttribute("authors", authorService.listAuthors(queryDo));
		} catch (BlockException e) {
			// Handle rejected request.
			e.printStackTrace();
		}

		return "author/list";
	}

	@ResponseBody
	@RequestMapping("add")
	public String add(Author author) {
		logger.info("添加作者");
		authorService.addAuthor(author);
		return "ok";
	}

	@ResponseBody
	@RequestMapping("test")
	public String test() {
		logger.info("test");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "test ok";
	}

	@ResponseBody
	@RequestMapping("test2")
	public String test2() {
		logger.info("test2");
		return "test2 ok";
	}

}
