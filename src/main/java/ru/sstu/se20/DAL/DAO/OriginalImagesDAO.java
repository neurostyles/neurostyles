package ru.sstu.se20.DAL.DAO;

import ru.sstu.se20.DAL.Entities.OriginalImagesEntity;
import org.springframework.stereotype.Repository;

@Repository
public class OriginalImagesDAO extends AbstractHibernateDAO <OriginalImagesEntity> implements IOriginalImagesDAO{

    public OriginalImagesDAO() {
        super();

        setClazz(OriginalImagesEntity.class);
    }
}
