package com.update.framework.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO 分页查询条件对象的接口实现
 */
public abstract class QueryObject<T extends Serializable> implements IQueryObject {

	private boolean flag = false;
	/**
	 * 结果是否需要分页
	 */
	private boolean pager = true;
	/**
	 * 分页的条件当前页
	 */
	private int currentPageNo = 1;
	/**
	 * 分页条件的每页显示条数
	 */
	private int pageSize = 3;
	/**
	 * 封装查询结果集的sql
	 */
	private StringBuilder hql;
	/**
	 * 封装统计总条数的sql
	 */
	private StringBuilder countHql;
	/**
	 * 封装查询参数条件
	 */
	private List<Object> params;

	public QueryObject(String className) {
		countHql = new StringBuilder("SELECT COUNT(o) FROM " + className + " o");
		hql = new StringBuilder("SELECT o FROM " + className + " o");
		params = new ArrayList<Object>();
	}

	/**
	 * @param className 查询的类名称
	 * @param pager 结果是否需要分页
	 */
	public QueryObject(String className, Boolean pager) {
		this(className);
		if (pager != null) {
			this.pager = pager;
		}
	}

	protected abstract void customerQuery();

    protected void appendToHql(String append) {
        hql.append(append);
    };

	/**
	 * 1.处理hql的拼接
	 * @param where
	 * @param objects
	 */
	protected void addWhere(String where, Object... objects) {
		if (params.size() == 0) {
			countHql.append(" WHERE ").append(where);
			hql.append(" WHERE ").append(where);
		} else {
			countHql.append(" AND ").append(where);
			hql.append(" AND ").append(where);
		}
		params.addAll(Arrays.asList(objects));
	}

	private void builderWhere() {
		if (!flag) {
			flag = true;
			addWhere(" o.isDelete = ? ", false);
			customerQuery();
		}
	}

	public String getCountHql() {
		builderWhere();
		return countHql.toString();
	}

	public String getHql() {
		builderWhere();
		return hql.toString();
	}

	public List<Object> getParams() {
		builderWhere();
		return params;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public boolean getPager() {
		return pager;
	}

	public void setPager(boolean pager) {
        this.pager = pager;
    }

    /**
	 * 生成?替代符号
	 * @param size
	 * @return
	 */
	public static final String generateParamTags(int size) {
		String s = "";
		for (int i = 0; i < size; i++) {
			s += "?,";
		}
		return s.substring(0, s.length() - 1);
	}
}
