package cn.edu.ncu.jiluan.bbs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "bbs", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private byte gender;
    private Date birthday;
    private String icon;
    private Integer provinceId;
    private Integer cityId;

    private Collection<PostEntity> postsByUserId;
    private Collection<PostLikedEntity> postLikedsByUserId;
    private Collection<ReplyEntity> repliesByUserId;
    private ProvinceEntity provinceByProvinceId;
    private CityEntity cityByCityId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 100)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "gender", nullable = false)
    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "birthday", nullable = false)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "icon", nullable = false, length = 256)
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (gender != that.gender) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (birthday != null ? !birthday.equals(that.birthday) : that.birthday != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (int) gender;
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }

    @Basic

    @Column(name = "province_id")
    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    @Basic

    @Column(name = "city_id")
    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @OneToMany(mappedBy = "userByUserId")
    @JsonManagedReference
    public Collection<PostEntity> getPostsByUserId() {
        return postsByUserId;
    }

    public void setPostsByUserId(Collection<PostEntity> postsByUserId) {
        this.postsByUserId = postsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    @JsonManagedReference
    public Collection<PostLikedEntity> getPostLikedsByUserId() {
        return postLikedsByUserId;
    }

    public void setPostLikedsByUserId(Collection<PostLikedEntity> postLikedsByUserId) {
        this.postLikedsByUserId = postLikedsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    @JsonManagedReference
    public Collection<ReplyEntity> getRepliesByUserId() {
        return repliesByUserId;
    }

    public void setRepliesByUserId(Collection<ReplyEntity> repliesByUserId) {
        this.repliesByUserId = repliesByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "province_id", referencedColumnName = "province_id", insertable = false, updatable = false)
    @JsonBackReference
    public ProvinceEntity getProvinceByProvinceId() {
        return provinceByProvinceId;
    }

    public void setProvinceByProvinceId(ProvinceEntity provinceByProvinceId) {
        this.provinceByProvinceId = provinceByProvinceId;
    }

    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", insertable = false, updatable = false)
    @JsonBackReference
    public CityEntity getCityByCityId() {
        return cityByCityId;
    }

    public void setCityByCityId(CityEntity cityByCityId) {
        this.cityByCityId = cityByCityId;
    }
}
