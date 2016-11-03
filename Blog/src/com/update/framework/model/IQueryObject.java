package com.update.framework.model;

/**
 * 分页查询条件对象接口
 * @author Nico
 */
public interface IQueryObject {
    /**
     * 是否分页
     * @return
     */
    public boolean getPager();

    /**
     * 分页每页显示多少条数据
     * @return
     */
    public int getPageSize();

    /**
     * 分页当前页数
     * @return
     */
    public int getCurrentPageNo();

    /**
     * 获取查询的条件语句<br/>
     * 该方法具体由实现类的builderWhere()以及addQuery(String, Object)完成
     * @return
     */
    public String getHql();

    /**
     * 获取生成总行数的hql语句<br/>
     * @return
     */
    public String getCountHql();
}
