package com.my.controller;

import com.my.entity.Author;
import com.my.service.AuthorService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/")
@MapperScan({"com.my.mapper","com.my.mapper"})
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@ResponseBody
	@RequestMapping("add")
	public String add(Author author) {
		Author addAuthor = new Author();
		addAuthor.setName("佚名");
		authorService.addAuthor(author);
		return "ok";
	}
}
