package com.update.framework.model.queryObject;

import org.springframework.util.StringUtils;

import com.update.entity.Article;
import com.update.framework.model.QueryObject;

public class ArticleQueryObject extends QueryObject<Article>{
	private String title;
	private String label;
	private String type;

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
        if (StringUtils.hasText(type)) {
            addWhere("o.type.name = ? ",type);
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
