package com.update.system.service.Impl;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.update.entity.Admin;
import com.update.entity.Log;
import com.update.framework.persistence.IBaseDao;
import com.update.system.service.LogService;

/**
 * 日志业务逻辑方法
 * @author cw
 *  @date 2016年6月14日 下午4:40:08
 */
@Service("logServiceImpl")
public class LogServiceImpl implements LogService{

	
	@Resource
	private IBaseDao<Log> logDao;
	
	@Resource  
	private  HttpServletRequest request;  


	 /**
	   * 得到客户端ip
	   * @return
	   */
	  public final String getClientIp() {
 	      String ip =request.getHeader("x-forwarded-for");
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getHeader("Proxy-Client-IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getHeader("WL-Proxy-Client-IP");
	      }
	      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	          ip = request.getRemoteAddr();
	      }
	      return ip;
	  }
	
	
	/**
	 * 日志增加
	 */
	@Override
	public void addLog( HttpSession session,Log log,String updatecontent) throws Exception {
		Admin admin=(Admin) session.getAttribute("admin");
		if(admin!=null){
			log.setName(admin.getUsername());
			log.setLoginIp(getClientIp());
			log.setContent(updatecontent);
			log.setCreateDate(new Date());
			log.setUpdateDate(new Date());
			logDao.save(log);
		}
	}
	
}
