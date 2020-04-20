package com.my.controller;

import com.my.domain.AuthorQueryDo;
import com.my.entity.Author;
import com.my.log.MyLog;
import com.my.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/author/")
public class AuthorController extends BaseController{

	@Autowired
	private AuthorService authorService;

	@MyLog(module = "作者",operator = "哈哈")
	@RequestMapping(value = "add",method = RequestMethod.GET)
	public String toAdd() {

		return "author/add";
	}

	@RequestMapping(value = "list") public String list(ModelMap modelMap, AuthorQueryDo queryDo) {
		modelMap.addAttribute("authors", authorService.listAuthors(queryDo));
		return "author/list";
	}

	@ResponseBody
	@RequestMapping("add")
	public String add(Author author) {
		authorService.addAuthor(author);
		return "ok";
	}
}
