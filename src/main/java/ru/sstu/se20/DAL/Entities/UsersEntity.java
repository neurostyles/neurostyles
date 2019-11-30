package ru.sstu.se20.DAL.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Collection;

@Entity
@Table(name = "users", schema = "neuralart_db")
public class UsersEntity implements Serializable {
    private int id;
    private String cookie;
    private java.util.Date cookieCreationDate;
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
    @Column(name = "cookie", nullable = false, length = 100)
    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "cookieCreationDate", nullable = true)
    public java.util.Date getCookieCreationDate() {
        return cookieCreationDate;
    }

    public void setCookieCreationDate(java.util.Date cookieCreationDate) {
        this.cookieCreationDate = cookieCreationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(cookie, that.cookie) &&
                Objects.equals(cookieCreationDate, that.cookieCreationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cookie, cookieCreationDate);
    }

    @OneToMany(mappedBy = "usersByUser", fetch = FetchType.EAGER)
    public Collection<ResultImagesEntity> getResultImagesById() {
        return resultImagesById;
    }

    public void setResultImagesById(Collection<ResultImagesEntity> resultImagesById) {
        this.resultImagesById = resultImagesById;
    }
}
