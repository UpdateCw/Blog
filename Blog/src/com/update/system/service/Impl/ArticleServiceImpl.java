package com.update.system.service.Impl;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import com.update.entity.Article;
import com.update.entity.Log;
import com.update.framework.persistence.IBaseDao;
import com.update.system.service.ArticleService;

/**
 * 文章业务逻辑方法
 * @author cw
 *  @date 2016年6月14日 下午4:40:08
 */
@Service("logServiceImpl")
public class ArticleServiceImpl implements ArticleService{

	
	@Resource
	private IBaseDao<Log> logDao;
	
	@Resource  
	private  HttpServletRequest request;

	@Override
	public void addArticle(Article article) throws Exception {
		// TODO Auto-generated method stub
		
	}  
}
