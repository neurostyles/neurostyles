package ru.sstu.se20.DAL.Entities;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.io.*;

@Entity
@Table(name = "original_images", schema = "neuralart_db")
public class OriginalImagesEntity implements Serializable {
    private int id;
    private byte[] image;
    private Collection<ResultImagesEntity> resultImagesById;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "image", columnDefinition = "MEDIUMBLOB")
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginalImagesEntity that = (OriginalImagesEntity) o;
        return id == that.id &&
                Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @OneToMany(mappedBy = "originalImagesByOriginalImage", cascade=CascadeType.ALL)
    public Collection<ResultImagesEntity> getResultImagesById() {
        return resultImagesById;
    }

    public void setResultImagesById(Collection<ResultImagesEntity> resultImagesById) {
        this.resultImagesById = resultImagesById;
    }
}
