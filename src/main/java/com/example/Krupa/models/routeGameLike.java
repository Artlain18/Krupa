package com.example.Krupa.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class routeGameLike implements Serializable {
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "USER_ID")
    Long USER_ID;
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Column(name = "GAME_ID")
    Integer GAME_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        routeGameLike that = (routeGameLike) o;
        return Objects.equals(USER_ID, that.USER_ID) &&
                Objects.equals(GAME_ID, that.GAME_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(USER_ID, GAME_ID);
    }

    public routeGameLike() {
    }
    public routeGameLike(Long USER_ID, Integer GAME_ID) {
        this.USER_ID = USER_ID;
        this.GAME_ID = GAME_ID;
    }

    public Long getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Long USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(Integer GAME_ID) {
        this.GAME_ID = GAME_ID;
    }
}
