package ru.sstu.se20.DAL.DAO;

import ru.sstu.se20.DAL.Entities.ImageEmotionsEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ImageEmotionsDAO extends AbstractHibernateDAO <ImageEmotionsEntity> implements IImageEmotionsDAO{

    public ImageEmotionsDAO() {
        super();

        setClazz(ImageEmotionsEntity.class);
    }
}
