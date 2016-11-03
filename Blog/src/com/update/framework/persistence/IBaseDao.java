package com.update.framework.persistence;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.update.framework.model.BaseEntity;
import com.update.framework.model.Page;
import com.update.framework.model.QueryObject;

/**
 * @author cw
 * @date 2016年11月1日
 * @vsersion 1.0
 * DOTO 持久层基础类接口
 */
public interface IBaseDao<T  extends BaseEntity> {

    /**
     * 保存实体
     * @param t
     */
    public void save(T t) throws Exception;

    /**
     * 更新实体
     * @param t
     */
    public void update(T t) throws Exception;

    public void saveOrUpdate(T t) throws Exception;

    /**
     * 通过ID 查找对象
     * @param entityClass 对象类型
     * @param id
     * @return 代理对象(延迟加载)
     */
    public T load(Class<T> entityClass, Serializable id) throws Exception;

    /**
     * 查询单个实体
     * @param entityClass 实体类的权限定名名字 ，id对应查询实体的id
     */
    public T get(Class<T> entityClass, Serializable id) throws Exception;

    /**
     * 删除实体
     * @param entityClass 实体类的权限定名名字 ，id对应删除实体的id
     */
    public void delete(Class<T> entityClass, Serializable id) throws Exception;

    /**
     * 查询所有实体
     * @param entityClass 实体类的权限定名
     */
    public List<T> getAll(Class<T> entityClass) throws Exception;

    /**
     * 根据查询对象获取结果，查询对象可以支持分页或者非分页查询
     * @param baseQuery 查询对象
     */
    public Page<T> findQueryResult(final QueryObject<T> baseQuery) throws Exception;

    /**
     * 批量删除对象
     * @param collections
     */
    public void deleteAll(Collection<T> collections) throws Exception;

    /**
     * 执行sql并返回结果
     * @param sql
     * @param params
     * @return
     * @throws Exception
     */
    @SuppressWarnings("rawtypes")
	public List executeSql(String sql, Object[] params) throws Exception;

    /**
     * this function was deprecated, please use findQueryResult function as prefreed
     * @param hql
     * @param objects
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<T> findByHql(String hql, Object... objects) throws Exception;

    /**
     * this function was deprecated, please use findQueryResult function as prefreed
     * @param entityClass
     * @param where
     * @param values
     * @return
     * @throws Exception
     */
    @Deprecated
    public List<T> findByWhere(Class<T> entityClass, String where, Object... values) throws Exception;



}
