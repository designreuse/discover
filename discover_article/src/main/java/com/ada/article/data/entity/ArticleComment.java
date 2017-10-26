package com.ada.article.data.entity;

import com.ada.data.entity.AbstractEntity;
import com.ada.user.data.entity.UserInfo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 文章评论
 * 
 * @author 年高
 *
 */
@Entity
@Table(name = "article_comment")
public class ArticleComment extends AbstractEntity {



	private String contents;


	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Article article;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private UserInfo user;


	public Article getArticle() {
		return article;
	}


	public String getContents() {
		return contents;
	}



	public String getTitle() {
		return title;
	}

	public UserInfo getUser() {
		return user;
	}


	public void setArticle(Article article) {
		this.article = article;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public void setUser(UserInfo user) {
		this.user = user;
	}

}
