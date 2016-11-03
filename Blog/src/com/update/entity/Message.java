package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.update.framework.model.BaseEntity;


/**
 * 
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO (意见消息)
 */
@Entity
@Table(name="message")
public class Message extends BaseEntity{
	
	private static final long serialVersionUID = -769485623405331513L;
	
	@Column
	private String name;//名称
	@Column
	private String title;//标题
	@Column
	private String mailbox;//邮箱
	@Column
	private String context;//内容
	@Column
	private String time;//时间
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMailbox() {
		return mailbox;
	}
	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
		
}
