package com.update.system.service.Impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.update.entity.Type;
import com.update.framework.model.Page;
import com.update.framework.model.queryObject.TypeQueryObject;
import com.update.framework.persistence.IBaseDao;
import com.update.system.service.TypeService;

/**
 * 文章类型业务逻辑方法
 * @author cw
 *  @date 2016年6月14日 下午4:40:08
 */
@Service("typeServiceImpl")
public class TypeServiceImpl implements TypeService{

	
	@Resource
	private IBaseDao<Type> typeDao;

	@Override
	public void addType(Type Type) throws Exception {
		
	}

	@Override
	public Page<Type> selectTypeList() throws Exception {
		TypeQueryObject typeQueryObject=new TypeQueryObject();
		return typeDao.findQueryResult(typeQueryObject);
	}  

}
