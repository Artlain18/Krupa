package com.example.Krupa.models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "game_like")
public class gameLike  implements Serializable{


    @EmbeddedId
    routeGameLike id;

    @ManyToOne
    @MapsId("USER_ID")
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    users USER_ID;

    @ManyToOne
    @MapsId("GAME_ID")
    @JoinColumn(name = "GAME_ID", referencedColumnName = "GAME_ID")
    game GAME_ID;

    @Column(name = "IS_GAME_LIKE")
    Boolean IS_GAME_LIKE;

    public gameLike(routeGameLike id) {
        this.id = id;
    }
    public Boolean getIS_GAME_LIKE() {
        return IS_GAME_LIKE;
    }

    public void setIS_GAME_LIKE(Boolean IS_GAME_LIKE) {
        this.IS_GAME_LIKE = IS_GAME_LIKE;
    }

    public gameLike() {
    }
    public gameLike(users USER_ID, game GAME_ID) {
        this.USER_ID = USER_ID;
    }

    public routeGameLike getId() {
        return id;
    }

    public void setId(routeGameLike id) {
        this.id = id;
    }

    public users getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(users USER_ID) {
        this.USER_ID = USER_ID;
    }

    public game getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(game GAME_ID) {
        this.GAME_ID = GAME_ID;
    }
}
