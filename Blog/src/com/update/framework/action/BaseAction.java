package com.update.framework.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.update.framework.model.Page;

/**
 * 基础控制类
 * 
 * @author cw
 *  @date 2016-6-4 上午10:52:33 
 */
public  class BaseAction extends ActionSupport{
	/**
	 * 分页对象
	 */
	@SuppressWarnings("rawtypes")
	protected Page  page;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5913452285354146468L;
	/**
	 * http请求对象
	 */
	protected HttpServletRequest getRequest(){
		return ServletActionContext.getRequest();
	}
	/**
	 * http响应对象
	 */
	protected HttpServletResponse getResponse(){
		return ServletActionContext.getResponse();
	}
	
	/**
	 * session会话跟踪对象
	 */
	protected HttpSession getSession(){
		return ServletActionContext.getRequest().getSession();
	}
	
	/**
	 * context全局上下文对象
	 */
	protected ActionContext getContext(){
		return ServletActionContext.getContext();
	}
	
	/**
	 * 获取项目下文件路径
	 * @param abstractPath 相对路径
	 * @return 绝对路径
	 */
	protected String getWebRealPath(String abstractPath){
		return getSession().getServletContext().getRealPath(abstractPath);
	}
	
	
	/**
	 * Request 设置键值对
	 * @param key 键
	 * @param value 值
	 */
	protected void setRequestAttrValue(String key,Object value){
		getRequest().setAttribute(key, value);
	}
	
	/**
	 * Request 通过键得到值 
	 * @param key 键
	 * @return obj
	 */
	protected Object getRequestAttrValue(String key){
		return getRequest().getAttribute(key);
	}
	
	/**
	 * Request 通过键得到值 
	 * @param key 键
	 * @return obj
	 */
	protected Object getRequestParamValue(String key){
		return getRequest().getParameter(key);
	}
	
	/**
	 * Session 设置键值对
	 * @param key 键
	 * @param value 值
	 */
	protected void setSessionValue(String key,Object value){
		getSession().setAttribute(key, value);
	}
	
	/**
	 * 移除session键值对
	 * @param key 键
	 * @param value 值
	 */
	protected void removeSessionValue(String key){
		getSession().removeAttribute(key);
	}
	
	/**
	 * Session 通过键得到值 
	 * @param key 键
	 * @return obj
	 */
	protected Object getSessionValue(String key){
		return getSession().getAttribute(key);
	}
	
	/**
	 * Context 设置键值对
	 * @param key 键
	 * @param value 值
	 */
	protected void setContextValue(String key,Object value){
		getContext().put(key, value);
	}
	/**
	 * Context 通过键得到值
	 * @param key
	 * @return obj
	 */
	protected Object getContextValue(String key){
		return getContext().get(key);
	}
	/**
	 * @return the page
	 */
	@SuppressWarnings("rawtypes")
	public Page getPage() {
		return page;
	}
	/**
	 * @param page the page to set
	 */
	@SuppressWarnings("rawtypes")
	public void setPage(Page page) {
		this.page = page;
	}
	
	/**
	 * 父页面跳转到指定地址
	 * @param href 要父页面跳转的页面地址
	 */
	protected void responseToParentHref(String href){
		responseScript("window.parent.location.href='"+href+"'");
	}
	
	/**
	 * 父页面发送弹窗消息
	 * @param msg 弹窗消息
	 */
	protected void responseToAlert(String msg){
		responseScript("window.parent.alert('"+msg+"');");
	}
	/**
	 * 返回script响应数据
	 * @param msg
	 */
	protected void responseScript(String msg){
		StringBuilder rep = new StringBuilder("<script>" +msg
				+"</script>");
		try {
			getResponse().setCharacterEncoding("UTF-8");
			getResponse().getWriter().println(rep.toString());
			getResponse().flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
}
