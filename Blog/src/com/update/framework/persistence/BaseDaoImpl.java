package com.update.framework.persistence;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.update.framework.model.BaseEntity;
import com.update.framework.model.Page;
import com.update.framework.model.QueryObject;


/**
 * @author cw
 * @date 2016年10月31日
 * @vsersion 1.0
 * DOTO 持久层基础实现类
 */
@Repository("baseDao")
public class BaseDaoImpl<T extends BaseEntity> extends HibernateDaoSupport implements IBaseDao<T> {

	/**
	 * 注入sessionFactory
	 * @param sessionFactory
	 */
	@Resource
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	public void save(T t) throws Exception {
		getHibernateTemplate().save(t);
	}

	public void update(T t) throws Exception {
		getHibernateTemplate().update(t);
	}

	@Override
	public void saveOrUpdate(T t) throws Exception {
		getHibernateTemplate().saveOrUpdate(t);
	}

	public void delete(Class<T> entityClass, Serializable id) throws Exception {
		T t = get(entityClass, id);
		if (t != null)
			getHibernateTemplate().delete(t);
	}

	@Override
	public T load(Class<T> entityClass, Serializable id) throws Exception {
		return getHibernateTemplate().load(entityClass, id);
	}

	public T get(Class<T> entityClass, Serializable id) throws Exception {
		return getHibernateTemplate().get(entityClass, id);
	}

	public List<T> getAll(Class<T> entityClass) throws Exception {
		return getHibernateTemplate().loadAll(entityClass);
	}

	@Override
	public void deleteAll(Collection<T> collections) throws Exception {
		getHibernateTemplate().deleteAll(collections);
	}

	public Page<T> findQueryResult(final QueryObject<T> baseQuery) throws Exception {
		int currentPage = baseQuery.getCurrentPageNo();
		int pageSize = baseQuery.getPageSize();

		if (baseQuery.getPager()) {
			// 需要分页
			Long count = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Long>() {
				public Long doInHibernate(Session session) throws HibernateException, SQLException {
					Query query = session.createQuery(baseQuery.getCountHql());
					builderParam(query, baseQuery.getParams());
					return (Long) query.uniqueResult();
				}
			});

			int totalCount = count.intValue();
			final Page<T> pageResult = new Page<T>(currentPage, pageSize, totalCount);

			if (count.intValue() == 0) {
				return pageResult;
			}

			List<T> rows = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<T>>() {
				@SuppressWarnings("unchecked")
				public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
					String hql = baseQuery.getHql();
					Query query = session.createQuery(hql);
					builderParam(query, baseQuery.getParams());
					int first = (pageResult.getCurrentPageNo() - 1) * pageResult.getPageSize();
					int max = pageResult.getPageSize();
					query.setFirstResult(first).setMaxResults(max);
					return (List<T>) query.list();
				}
			});
			pageResult.setData(rows);
			return pageResult;
		} else {
			// 不需要分页
			List<T> rows = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<T>>() {
				@SuppressWarnings("unchecked")
				public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
					String hql = baseQuery.getHql();
					Query query = session.createQuery(hql);
					builderParam(query, baseQuery.getParams());
					return (List<T>) query.list();
				}
			});
			final Page<T> pageResult = new Page<T>(currentPage, pageSize, rows.size());
			pageResult.setData(rows);
			return pageResult;
		}
	}

	/**
	 * 添加查询条件
	 * @param query
	 * @param paramList
	 */
	private final void builderParam(Query query, List<Object> paramList) {
		int index = 0;
		for (Object object : paramList) {
			query.setParameter(index++, object);
		}
	}

	/**
	 * 添加查询条件
	 * @param query
	 * @param paramList
	 */
	private final void builderParam(Query query, Object[] paramList) {
		int index = 0;
		for (Object object : paramList) {
			query.setParameter(index++, object);
		}
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	public List<T> findByHql(String hql, Object... objects) throws Exception {
		for (Object object : objects) {
			logger.debug("==" + object);
		}
		logger.debug(hql);
		logger.debug(objects.toString());
		return (List<T>) getHibernateTemplate().find(hql, objects);
	}

	@SuppressWarnings("unchecked")
	@Deprecated
	public List<T> findByWhere(Class<T> entityClass, String where, Object... values) throws Exception {
		StringBuilder hql = new StringBuilder();
		hql.append("from ");
		hql.append(entityClass.getName());
		hql.append(" o WHERE 1=1 ");
		if (where != null && !"".equals(where.trim())) {
			hql.append(where);
		}
		return (List<T>) getHibernateTemplate().find(hql.toString(), values);
	}



	@SuppressWarnings("rawtypes")
	@Override
	public List executeSql(final String sql, final Object[] params) throws Exception {
		return (List) getHibernateTemplate().execute(new HibernateCallback<Object>() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Query query = session.createSQLQuery(sql);
				builderParam(query, params);
				List results = query.list();

				return results;
			}
		});
	}

}
