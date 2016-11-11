package com.update.system.action;

import java.util.Date;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.update.entity.Article;
import com.update.framework.action.BaseAction;
import com.update.framework.common.CustomException;
import com.update.framework.model.queryObject.ArticleQueryObject;
import com.update.system.service.ArticleService;
import com.update.system.service.LogService;

/**
 * @author cw
 * @date 2016年6月12日 下午2:01:21
 * 文章action
 */
@Namespace(value = "/article")
@Results({
		@Result(name="article",location="/pages/article.jsp"),
		})
public class ArticleAction extends BaseAction {
    private Logger logger=Logger.getLogger(this.getClass().getName()); 
	
	private static final long serialVersionUID = 7675610277124547364L;
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private LogService logService;
	
	private  ArticleQueryObject articleQueryObject;
	
	private Article article;

	
	@Action("selectArticle")
	public String selectArticle() throws Exception{
		String pageNo=getRequest().getParameter("pageNo");
		int pn=1;
		if(pageNo!=null&&!"".equals(pageNo)){
			pn=Integer.parseInt(pageNo);
		}
		
		if(articleQueryObject==null){
			articleQueryObject=new ArticleQueryObject();
		}
		
		articleQueryObject.setCurrentPageNo(pn);
		page=articleService.selectArticleList(articleQueryObject);
		return "article";
	}
	
	/**
	 * 添加文章信息
	 * @throws Exception 
	 */
	@Action("saveOrUpdate")
	public String saveOrUpdate() throws Exception{
		if(article==null){
			throw new CustomException("文章信息不存在");
		}
		if(articleQueryObject==null){
			articleQueryObject=new ArticleQueryObject();
		}
		article.setCreateDate(new Date());
		article.setUpdateDate(new Date());
		articleService.addArticle(article);
		page=articleService.selectArticleList(articleQueryObject);
		logger.info("Operation：acticle add success!");
		return "article";
	}

	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}

	
