package com.fb.manage.common.utils.myBatisUtils.base;



import com.fb.manage.common.utils.myBatisUtils.exception.DBException;
import com.fb.manage.common.utils.myBatisUtils.query.QueryArgs;

import java.util.List;

/**
 * dao接口  单表增删改查
 * @param <E>
 */

public interface BaseDao<E> {
    /**
     * 插入数据
     * @throws Exception
     */
    public int insert(QueryArgs<E> e) throws DBException;

    /**
     * 删除数据
     * @throws Exception
     */
    public int delete(QueryArgs<E> e) throws DBException;

    /**
     * 修改数据
     * @param e  要修改的内容
     * @throws Exception
     */
    public int update(QueryArgs<E> e) throws DBException;

    /**
     * 根据内容查询数据
     * @return 查询结果集合
     * @throws Exception
     */
    public List<E> select(QueryArgs<E> e) throws DBException;
}
