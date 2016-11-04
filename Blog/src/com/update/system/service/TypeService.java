package com.update.system.service;

import com.update.entity.Type;
import com.update.framework.model.Page;


/**
 * 文章类型业务逻辑接口
 * @author cw
 *  @date 2016年6月14日 下午4:37:26
 */
public interface TypeService {

	void addType(Type Type) throws Exception;
	
	Page<Type> selectTypeList() throws Exception;
}
