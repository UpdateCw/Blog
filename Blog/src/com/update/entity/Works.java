package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.update.framework.model.BaseEntity;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO 作品
 */
@Entity
@Table(name="works")
public class Works extends BaseEntity{
	private static final long serialVersionUID= -63887316935248513L;
	
	@Column
	private String image;//图片
	@Column
	private String remarks;//备注
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
		
}
