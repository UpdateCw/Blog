package com.update.framework.model.queryObject;

import org.springframework.util.StringUtils;

import com.update.entity.Admin;
import com.update.framework.model.QueryObject;

public class AdminQueryObject extends QueryObject<Admin>{
	private String username;
	private String password;

	public AdminQueryObject() {
		super(Admin.class.getName());
	}

	public AdminQueryObject(Boolean pager) {
		super(Admin.class.getName(),pager);
	}
	
	@Override
	protected void customerQuery() {
		 if (StringUtils.hasText(username)) {
	        addWhere(" o.username = ? ",username);
        }
        if (StringUtils.hasText(password)) {
            addWhere("o.password = ? ",password);
        }
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
