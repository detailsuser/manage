package com.fb.manage.common.utils.myBatisUtils.base;


import com.fb.manage.common.utils.myBatisUtils.exception.DBException;
import com.fb.manage.common.utils.myBatisUtils.query.QueryArgs;

import java.util.List;

/**
 * dao实现  单表查询
 * @param <E>  pojo泛型
 */
public abstract class BaseDaoImpl<E> implements BaseDao<E> {
    protected abstract BaseDao<E> getDao();

    public int insert(QueryArgs<E> e) throws DBException { return getDao().insert(e); }

    public int delete(QueryArgs<E> e) throws DBException { return getDao().delete(e); }

    public int update(QueryArgs<E> e) throws DBException { return getDao().update(e); }

    public List<E> select(QueryArgs<E> e) throws DBException { return getDao().select(e); }
}
