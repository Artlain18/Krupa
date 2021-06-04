package com.example.Krupa.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class routeReviewLike implements Serializable {
    @Column(name = "USER_ID")
    Long USER_ID;
    @Column(name = "REVIEW_ID")
    Integer REVIEW_ID;

    public routeReviewLike(Long USER_ID, Integer REVIEW_ID) {
        this.USER_ID = USER_ID;
        this.REVIEW_ID = REVIEW_ID;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        routeReviewLike that = (routeReviewLike) o;
        return Objects.equals(USER_ID, that.USER_ID) &&
                Objects.equals(REVIEW_ID, that.REVIEW_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, REVIEW_ID);
    }

    public Long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Long USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getREVIEW_ID() {
        return REVIEW_ID;
    }

    public void setREVIEW_ID(Integer REVIEW_ID) {
        this.REVIEW_ID = REVIEW_ID;
    }

    public routeReviewLike() {
    }
}

