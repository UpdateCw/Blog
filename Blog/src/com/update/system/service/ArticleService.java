package com.update.system.service;

import com.update.entity.Article;


/**
 * 日志业务逻辑接口
 * @author cw
 *  @date 2016年6月14日 下午4:37:26
 */
public interface ArticleService {

	void addArticle(Article article) throws Exception;
}