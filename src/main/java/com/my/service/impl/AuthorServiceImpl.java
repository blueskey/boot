package com.my.service.impl;

import com.my.domain.AuthorQueryDo;
import com.my.entity.Author;
import com.my.mapper.AuthorMapper;
import com.my.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Resource
	private AuthorMapper authorMapper;

	@Override public void addAuthor(Author author) {
		authorMapper.insert(author);
	}

	@Override public List<Author> listAuthors(AuthorQueryDo queryDo) {
		return authorMapper.listAuthors();
	}
}
