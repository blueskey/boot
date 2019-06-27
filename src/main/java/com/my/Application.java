package com.my;

import com.my.domain.AuthorQueryDo;
import com.my.service.AuthorService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@MapperScan({"com.my.mapper","com.my.mapper"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	private AuthorService authorService;

	@ResponseBody
	@RequestMapping("/")
	public String hello() {
		authorService.listAuthors(new AuthorQueryDo());
		return "hello";
	}
}
