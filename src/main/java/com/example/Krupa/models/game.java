package com.example.Krupa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@IdClass(gameLike.class)
@Table(name = "game")
public class game implements Serializable{
    @Id
    @Column(name = "GAME_ID")
    @OrderBy("NAME")
    @SequenceGenerator(name = "GameIdSeq", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GameIdSeq")
    private Integer gameID;

    @NotNull
    @Column(name = "NAME")
    private String NAME;

    @OneToMany(mappedBy="GAME_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();

    @OneToMany(mappedBy = "GAME_ID")
    //@ManyToMany(mappedBy = "GAME_ID")
    Set<gameLike> gameLikes;// = new HashSet<>();





    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer GAME_ID) {
        this.gameID = GAME_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public game() {
    }

    public game(String NAME) {
        this.NAME = NAME;
    }
}
