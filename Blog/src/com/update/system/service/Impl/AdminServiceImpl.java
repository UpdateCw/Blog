package com.update.system.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.update.entity.Admin;
import com.update.framework.model.queryObject.AdminQueryObject;
import com.update.framework.persistence.IBaseDao;
import com.update.system.service.AdminService;

/**
 * 管理者业务逻辑方法
 * @author cw
 *  @date 2016年6月14日 下午4:40:08
 */
@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService{

	
	@Resource
	private IBaseDao<Admin> adminDao;

	/**
	 * 实现登录
	 * @param password 
	 */
	public boolean login(String username, String password) {
		Admin admin=null;
		if(admin.getPassword().equals(password)){
			return true;
		}
		return false;
	}
	
	/**
	 * 根据登录名查询用户
	 */
	public List<Admin> findAdminByLoginName(String username) throws Exception  {
		AdminQueryObject adminQueryObject=new AdminQueryObject();
		adminQueryObject.setUsername(username);
     	return this.adminDao.findQueryResult(adminQueryObject).getData();
	}

	
}
