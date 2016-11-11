package com.update.system.service.Impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.update.entity.Article;
import com.update.framework.model.Page;
import com.update.framework.model.queryObject.ArticleQueryObject;
import com.update.framework.persistence.IBaseDao;
import com.update.system.service.ArticleService;

/**
 * 文章业务逻辑方法
 * @author cw
 *  @date 2016年6月14日 下午4:40:08
 */
@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService{

	
	@Resource
	private IBaseDao<Article> articleDao;
	
	@Override
	public void addArticle(Article article) throws Exception {
		articleDao.saveOrUpdate(article);
	}

	@Override
	public Page<Article> selectArticleList(ArticleQueryObject articleQueryObject) throws Exception {
		
		return articleDao.findQueryResult(articleQueryObject);
	}  
}
