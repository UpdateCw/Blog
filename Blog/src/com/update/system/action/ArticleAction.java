package com.update.system.action;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.update.entity.Article;
import com.update.framework.action.BaseAction;
import com.update.framework.common.CustomException;
import com.update.system.service.LogService;

/**
 * @author cw
 * @date 2016年6月12日 下午2:01:21
 * 文章action
 */
@Namespace(value = "/user")
@Results({
		@Result(name="input",location="/pages/login.jsp",type="redirect"),
		@Result(name="isMain",location="/pages/index.jsp",type="redirect")
		})
public class ArticleAction extends BaseAction {
    private Logger logger=Logger.getLogger(this.getClass().getName()); 
	
	private static final long serialVersionUID = 7675610277124547364L;
	
	@Resource
	private LogService logService;
	
	private Article article;

	/**
	 * 添加文章信息
	 */
	@Action("saveOrUpdate")
	public String saveOrUpdate(){
		if(article==null){
			throw new CustomException("没有文章信息");
		}
		if(article.getId()==null){
			
		}
		return null;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
}

	
