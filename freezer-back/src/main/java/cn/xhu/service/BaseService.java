package cn.xhu.service;

import java.util.List;

/**
 * @author:zx
 * @create time:2021/1/31
 * @desciption:封装通用的接口
 */
public interface BaseService<T> {

    /**
     * 根据ID查询其所有数据
     *
     * @param id
     * @return
     */
    T findById(Long id);

    /**
     * 创建用户
     *
     * @param t
     */
    void insert(T t);

    /**
     * 根据用户ID删除用户信息
     *
     * @param id
     */
    void delete(Long id);

    /**
     * 更新用户信息
     *
     * @param t
     */
    void update(T t);

    /**
     * 查询所有
     *
     * @return
     */
    List<T> findAll();

    /**
     * 根据特定条件查询
     * @param t
     * @return
     */
    List<T> findByCondition(T t);

}
