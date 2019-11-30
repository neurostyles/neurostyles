package ru.sstu.se20.DAL.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "result_images", schema = "neuralart_db")
public class ResultImagesEntity implements Serializable {
    private int id;
    private byte privateStatus;
    private java.util.Date creationDate;
    private OriginalImagesEntity originalImagesByOriginalImage;
    private ContextImagesEntity contextImagesByContextImage;
    private Collection<ImageEmotionsEntity> imageEmotionsById;
    private UsersEntity usersByUser;
    private byte[] resultImage;

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
    @Column(name = "result_image", columnDefinition = "MEDIUMBLOB")
    public byte[] getResultImage() {
        return resultImage;
    }

    public void setResultImage(byte[] resultImage) {
        this.resultImage = resultImage;
    }

    @Basic
    @Column(name = "private", nullable = false)
    public byte getPrivateStatus() {
        return privateStatus;
    }

    public void setPrivateStatus(byte privateStatus) {
        this.privateStatus = privateStatus;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date", nullable = true)
    public java.util.Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(java.util.Date creationDate) {
        this.creationDate = creationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultImagesEntity that = (ResultImagesEntity) o;
        return id == that.id &&
                privateStatus == that.privateStatus &&
                Objects.equals(creationDate, that.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, privateStatus, creationDate);
    }

    @ManyToOne
    @JoinColumn(name = "original_image", referencedColumnName = "id")
    public OriginalImagesEntity getOriginalImagesByOriginalImage() {
        return originalImagesByOriginalImage;
    }

    public void setOriginalImagesByOriginalImage(OriginalImagesEntity originalImagesByOriginalImage) {
        this.originalImagesByOriginalImage = originalImagesByOriginalImage;
    }

    @ManyToOne
    @JoinColumn(name = "context_image", referencedColumnName = "id")
    public ContextImagesEntity getContextImagesByContextImage() {
        return contextImagesByContextImage;
    }

    public void setContextImagesByContextImage(ContextImagesEntity contextImagesByContextImage) {
        this.contextImagesByContextImage = contextImagesByContextImage;
    }

    @OneToMany(mappedBy = "resultImagesByImage", cascade=CascadeType.ALL)
    public Collection<ImageEmotionsEntity> getImageEmotionsById() {
        return imageEmotionsById;
    }

    public void setImageEmotionsById(Collection<ImageEmotionsEntity> imageEmotionsById) {
        this.imageEmotionsById = imageEmotionsById;
    }

 @ManyToOne
    @JoinColumn(name = "user", referencedColumnName = "id")
    public UsersEntity getUsersByUser() {
        return usersByUser;
    }

    public void setUsersByUser(UsersEntity usersByUser) {
        this.usersByUser = usersByUser;
    }
}
