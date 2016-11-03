package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.update.framework.model.BaseEntity;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO (文章)
 */
@Entity
@Table(name="article")
public class Article extends BaseEntity {
	
        private static final long serialVersionUID = -7694820267005331513L;
        
        @Column
		private String title;//标题
        
        @Column
		private String context;//内容
        
        @Column
		private Type type=new Type();//类型
        
        @Column
		private String label;//标签
        
        @Column
		private String sendTime;//发表时间
		
		
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContext() {
			return context;
		}
		public void setContext(String context) {
			this.context = context;
		}
		public Type getType() {
			return type;
		}
		public void setType(Type type) {
			this.type = type;
		}
		public String getLabel() {
			return label;
		}
		public void setLabel(String label) {
			this.label = label;
		}
		public String getSendTime() {
			return sendTime;
		}
		public void setSendTime(String sendTime) {
			this.sendTime = sendTime;
		}
		
		
		
}
