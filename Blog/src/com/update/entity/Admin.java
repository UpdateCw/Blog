package com.update.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.update.framework.model.BaseEntity;


/**
 * @author cw
 *  @date 2016年6月12日 下午3:45:56
 *  管理员信息
 */
@Entity
@Table(name="admin")
public class Admin extends BaseEntity  {
	private static final long serialVersionUID= 654987312501248513L;
	    /**
	     *账号 
	     */
	    @Column
		private String username;//账号
	    
	    /**
	     * 密码
	     */
	    @Column
		private String password;//密码
		
		@Override
		public String toString() {
			return "Admin [id=" + id + ", username=" + username + ", password="
					+ password + "]";
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
