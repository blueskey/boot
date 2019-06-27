package com.my.service;

import com.my.domain.AuthorQueryDo;
import com.my.entity.Author;

import java.util.List;

public interface AuthorService {
	/**
	 *　添加作者
	 * @param author
	 */
	void addAuthor(Author author);

	List<Author> listAuthors(AuthorQueryDo queryDo);

	void sendMsg();

}
