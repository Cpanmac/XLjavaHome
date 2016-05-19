package com.xl.database.mysql;

import java.util.List;

public interface BaseDao<T> {
    /**
     * ����ʵ��
     *
     * @param entity
     */
    void save(T entity);

    /**
     * ɾ��ʵ��
     *
     * @param id
     */
    void delete(Long id);

    /**
     * ����ʵ��
     *
     * @param entity
     */
    void update(T entity);

    /**
     * ��ѯʵ��,���idΪnull,�򷵻�null,���������쳣
     *
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * ��ѯʵ��
     *
     * @param ids
     * @return
     */
    List<T> getByIds(Long[] ids);

    /**
     * ��ѯ����
     *
     * @return
     */
    List<T> findAll();
}
