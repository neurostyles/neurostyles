package ru.sstu.se20.DAL.DAO;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import ru.sstu.se20.DAL.Entities.ResultImagesEntity;
import ru.sstu.se20.DAL.Entities.UsersEntity;
import org.hibernate.Query;
import ru.sstu.se20.utils.HibernateUtil;
import java.util.ArrayList;
import org.hibernate.Session;

public abstract class AbstractHibernateDAO <T extends Serializable> implements IOperations<T> {
    private Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz = clazzToSet;
    }


    public final T getById(final int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T result = (T) session.get(clazz, id);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }


    public final List<T> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = String.format("from %s",clazz.getCanonicalName());
        Query SQLQuery = session.createQuery(hql);
        ArrayList<T> result = (ArrayList<T>) SQLQuery.list();
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return result;
    }

    @Override
    public final void create(final T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(entity);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }

    @Override
    public final T update(final T entity) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(entity);
        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return (T) entity;
    }

    @Override
    public void deleteById(final int entityId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        T del = getById(entityId);
        if (del != null)
        {
            session.delete(del);
        }

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
    }
}