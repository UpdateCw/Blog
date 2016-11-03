package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.update.framework.model.BaseEntity;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO (类型)
 */
@Entity
@Table(name="type")
public class Type extends BaseEntity{
	private static final long serialVersionUID= 685495623401248513L;
	
	@Column
	private String name;//类型名称
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
		
}
