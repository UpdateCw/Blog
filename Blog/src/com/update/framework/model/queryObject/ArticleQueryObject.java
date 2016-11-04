package com.update.framework.model.queryObject;

import org.springframework.util.StringUtils;

import com.update.entity.Article;
import com.update.framework.model.QueryObject;

public class ArticleQueryObject extends QueryObject<Article>{
	private String title;
	private String label;

	public ArticleQueryObject() {
		super(Article.class.getName());
	}

	public ArticleQueryObject(Boolean pager) {
		super(Article.class.getName(),pager);
	}
	
	@Override
	protected void customerQuery() {
		 if (StringUtils.hasText(title)) {
	        addWhere(" o.title = ? ",title);
        }
        if (StringUtils.hasText(label)) {
            addWhere("o.label = ? ",label);
        }
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
