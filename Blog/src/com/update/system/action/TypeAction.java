package com.update.system.action;

import java.util.logging.Logger;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Results;

import com.update.entity.Type;
import com.update.framework.action.JsonAction;
import com.update.system.service.LogService;
import com.update.system.service.TypeService;

/**
 * @author cw
 * @date 2016年6月12日 下午2:01:21
 * 文章类型action
 */
@Namespace(value = "/type")
@Results({
		})
public class TypeAction extends JsonAction {
    private Logger logger=Logger.getLogger(this.getClass().getName()); 
	
	private static final long serialVersionUID = 7675610277124547364L;
	
	@Resource
	private TypeService typeService;
	
	@Resource
	private LogService logService;
	
	private Type type;

	
	@Action("selectType")
	public String selectType() throws Exception{
		page=typeService.selectTypeList();
		responseData.setData(page);
		return "json";
	}


	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
}

	
