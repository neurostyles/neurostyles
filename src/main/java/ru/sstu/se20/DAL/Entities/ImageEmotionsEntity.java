package ru.sstu.se20.DAL.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "image_emotions", schema = "neuralart_db")
public class ImageEmotionsEntity implements Serializable {
    private int id;
    private int artisticCount;
    private int beautifulCount;
    private int funnyCount;
    private int scaryCount;
    private int sadCount;
    private int uglyCount;
    private ResultImagesEntity resultImagesByImage;

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
    @Column(name = "artistic_count", nullable = false)
    public int getArtisticCount() {
        return artisticCount;
    }

    public void setArtisticCount(int artisticCount) {
        this.artisticCount = artisticCount;
    }

    @Basic
    @Column(name = "beautiful_count", nullable = false)
    public int getBeautifulCount() {
        return beautifulCount;
    }

    public void setBeautifulCount(int beautifulCount) {
        this.beautifulCount = beautifulCount;
    }

    @Basic
    @Column(name = "funny_count", nullable = false)
    public int getFunnyCount() {
        return funnyCount;
    }

    public void setFunnyCount(int funnyCount) {
        this.funnyCount = funnyCount;
    }

    @Basic
    @Column(name = "scary_count", nullable = false)
    public int getScaryCount() {
        return scaryCount;
    }

    public void setScaryCount(int scaryCount) {
        this.scaryCount = scaryCount;
    }

    @Basic
    @Column(name = "sad_count", nullable = false)
    public int getSadCount() {
        return sadCount;
    }

    public void setSadCount(int sadCount) {
        this.sadCount = sadCount;
    }

    @Basic
    @Column(name = "ugly_count", nullable = false)
    public int getUglyCount() {
        return uglyCount;
    }

    public void setUglyCount(int uglyCount) {
        this.uglyCount = uglyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEmotionsEntity that = (ImageEmotionsEntity) o;
        return id == that.id &&
                artisticCount == that.artisticCount &&
                beautifulCount == that.beautifulCount &&
                funnyCount == that.funnyCount &&
                scaryCount == that.scaryCount &&
                sadCount == that.sadCount &&
                uglyCount == that.uglyCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artisticCount, beautifulCount, funnyCount, scaryCount, sadCount, uglyCount);
    }

    @ManyToOne
    @JoinColumn(name = "image", referencedColumnName = "id", nullable = false)
    public ResultImagesEntity getResultImagesByImage() {
        return resultImagesByImage;
    }

    public void setResultImagesByImage(ResultImagesEntity resultImagesByImage) {
        this.resultImagesByImage = resultImagesByImage;
    }
}
