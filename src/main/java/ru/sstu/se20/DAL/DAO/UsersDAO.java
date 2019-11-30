package ru.sstu.se20.DAL.DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import ru.sstu.se20.DAL.Entities.ResultImagesEntity;
import ru.sstu.se20.DAL.Entities.UsersEntity;
import org.springframework.stereotype.Repository;
import ru.sstu.se20.utils.HibernateUtil;

@Repository
public class UsersDAO extends AbstractHibernateDAO <UsersEntity> implements IUsersDAO {

    public UsersDAO() {
        super();

        setClazz(UsersEntity.class);
    }


    public final UsersEntity getByCookie(final String cookie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query= session.createQuery("from UsersEntity where cookie=:cookie");
        query.setParameter("cookie", cookie);
        UsersEntity usersEntity = (UsersEntity) query.uniqueResult();

        session.getTransaction().commit();
        if (session.isOpen()) {
            session.close();
        }
        return usersEntity;
    }

    @Override
    public final void deleteById(final int entityId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        UsersEntity del = getById(entityId);
        if (del != null) {
            session.delete(del);

            for (ResultImagesEntity resultImage : del.getResultImagesById()) {
                resultImage.setUsersByUser(null);
            }
            
            session.getTransaction().commit();
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
