package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.update.framework.model.BaseEntity;

/**
 * 日志信息
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO (这里用一句话描述)
 */
@Entity
@Table(name="Log")
public class Log  extends BaseEntity {
	
	/**
	 * 登录者
	 */
	@Column
	private String name;
	
	/**
	 * 登录IP
	 */
	@Column
	private String loginIp;
	
	/**
	 * 内容
	 */
	@Column
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
