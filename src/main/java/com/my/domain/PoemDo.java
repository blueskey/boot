package com.my.domain;

public class PoemDo {
	private Long id;

	private String title;

	private String author;

	private String dynasty;

	private String content;

	private String annotation;

	private String appreciate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDynasty() {
		return dynasty;
	}

	public void setDynasty(String dynasty) {
		this.dynasty = dynasty;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getAppreciate() {
		return appreciate;
	}

	public void setAppreciate(String appreciate) {
		this.appreciate = appreciate;
	}
}
