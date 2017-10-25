package com.lanou.HRD.dao.impl;

import com.lanou.HRD.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/24.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {

    private static SessionFactory sessionFactory;



    @Override
    public List<T> findAll(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery(hql);
        List<T> list = query.list();

        transaction.commit();
        return list;
    }

    @Override
    public List<T> find(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        //执行查询语句
        Query query = session.createQuery(hql);
        //设置参数
        if (params!=null && !params.isEmpty()){
            //遍历参数
            for (String key : params.keySet()) {
                //设置查询语句中的key和value
                query.setParameter(key,params.get(key));
            }
        }
        List<T> list = query.list();

        transaction.commit();
        return list;//返回查询结果
    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        List<T> tList = find(hql,params);
        if (tList.size()>0) {
            return tList.get(0);//返回查询到的第一个对象
        }
        return null;
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        //根据主键id查询某个对象
        T t = (T) session.get(tClass,id);
        transaction.commit();
        return t;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        BaseDaoImpl.sessionFactory = sessionFactory;
    }
}
