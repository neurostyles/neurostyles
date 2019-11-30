package ru.sstu.se20.DAL.DAO;

import ru.sstu.se20.DAL.Entities.ResultImagesEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ResultImagesDAO extends AbstractHibernateDAO <ResultImagesEntity> implements IResultImagesDAO{

    public ResultImagesDAO() {
        super();

        setClazz(ResultImagesEntity.class);
    }
}
