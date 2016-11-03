package com.update.system.service;

import java.util.List;

import com.update.entity.Admin;

/**
 * 管理者业务逻辑接口
 * @author cw
 *  @date 2016年6月14日 下午4:37:26
 */
public interface AdminService {
	/**
	 * 登录业务
	 */
	public boolean login(String username,String password) throws Exception;

	public List<Admin> findAdminByLoginName(String username) throws Exception;
}
