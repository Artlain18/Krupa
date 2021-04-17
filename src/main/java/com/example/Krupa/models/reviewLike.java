package com.example.Krupa.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "review_like")
public class reviewLike implements Serializable {
    @EmbeddedId
    routeReviewLike id;

    @ManyToOne
    @MapsId("USER_ID")
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    users USER_ID;

    @ManyToOne
    @MapsId("REVIEW_ID")
    @JoinColumn(name = "REVIEW_ID", referencedColumnName = "REVIEW_ID")
    review REVIEW_ID;

    @Column(name = "IS_REVIEW_LIKE")
    Boolean IS_REVIEW_LIKE;

    public reviewLike() {
    }
    public reviewLike(users USER_ID, review REVIEW_ID) {
        this.USER_ID = USER_ID;
    }
    public routeReviewLike getId() {
        return id;
    }

    public void setId(routeReviewLike id) {
        this.id = id;
    }

    public users getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(users USER_ID) {
        this.USER_ID = USER_ID;
    }

    public review getREVIEW_ID() {
        return REVIEW_ID;
    }

    public void setREVIEW_ID(review REVIEW_ID) {
        this.REVIEW_ID = REVIEW_ID;
    }

    public Boolean getIS_REVIEW_LIKE() {
        return IS_REVIEW_LIKE;
    }

    public void setIS_REVIEW_LIKE(Boolean IS_REVIEW_LIKE) {
        this.IS_REVIEW_LIKE = IS_REVIEW_LIKE;
    }
}
