package com.update.framework.dao;

import com.update.entity.Admin;

/**
 * 管理员操作接口
 * @author cw
 *  @date 2016年6月14日 下午4:16:10
 */
public interface AdminDao {
	
	  /**
	   * 登录
	   *  @date 2016年6月14日 下午4:16:57
	   */
		public Admin login(String username);
}
