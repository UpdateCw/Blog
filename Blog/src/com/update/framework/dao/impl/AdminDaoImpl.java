package com.update.framework.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.update.entity.Admin;
import com.update.framework.dao.AdminDao;

/**
 * 管理员数据访问
 * @author cw
 *  @date 2016年6月14日 下午4:20:04
 */
@Repository("adminDaoImpl")
public class AdminDaoImpl implements AdminDao {

	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 管理员登录
	 * @param password 
	 */
	@SuppressWarnings("unchecked")
	public Admin login(String username) {
		String hql="from admin as a where a.username=:username";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("username", username);
		List<Admin> list = query.list();  
		if(list.size()>0){
			return list.get(0);
		}else{
			return null; 
		}
	}

	/**
	 *根据名称查询admin
	 */
	public List<Admin> findAdminByLoginName(String username) {
		Query query=sessionFactory.getCurrentSession().getNamedQuery(username);
		System.out.println(query);
		return null;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
