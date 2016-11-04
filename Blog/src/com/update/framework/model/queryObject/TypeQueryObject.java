package com.update.framework.model.queryObject;

import org.springframework.util.StringUtils;

import com.update.entity.Type;
import com.update.framework.model.QueryObject;

public class TypeQueryObject extends QueryObject<Type>{
	private String name;

	public TypeQueryObject() {
		super(Type.class.getName());
	}

	public TypeQueryObject(Boolean pager) {
		super(Type.class.getName(),pager);
	}
	
	@Override
	protected void customerQuery() {
		 if (StringUtils.hasText(name)) {
	        addWhere(" o.name = ? ",name);
        }
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
