package com.update.system.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 自定义拦截器，主要验证登陆信息
 * @author cw
 * @date 2016年11月3日
 * @vsersion 1.0
 */
public class ActionLogInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 2306576306965209091L;
	private static final Logger logger = Logger.getLogger(ActionLogInterceptor.class);


	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
			ActionContext actionContext = invocation.getInvocationContext();
			ServletContext context = (ServletContext) actionContext.get(StrutsStatics.SERVLET_CONTEXT);
			ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);

		return invocation.invoke();
	}

	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}


}
