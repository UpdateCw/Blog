package com.update.system.service;

import javax.servlet.http.HttpSession;

import com.update.entity.Log;


/**
 * 日志业务逻辑接口
 * @author cw
 *  @date 2016年6月14日 下午4:37:26
 */
public interface LogService {

	void addLog(HttpSession session, Log log, String updatecontent)
			throws Exception;
}
