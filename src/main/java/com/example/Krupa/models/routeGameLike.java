package com.example.Krupa.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class routeGameLike implements Serializable {
    @Column(name = "USER_ID")
    Integer USER_ID;
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
    public routeGameLike(Integer USER_ID, Integer GAME_ID) {
        this.USER_ID = USER_ID;
        this.GAME_ID = GAME_ID;
    }

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
    }

    public Integer getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(Integer GAME_ID) {
        this.GAME_ID = GAME_ID;
    }
}
