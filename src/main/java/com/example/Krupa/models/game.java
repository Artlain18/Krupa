package com.example.Krupa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "game")
public class game {
    @Id
    @Column(name = "GAME_ID")
    @SequenceGenerator(name = "GameIdSeq", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GameIdSeq")
    private Integer GAME_ID;

    @NotNull
    @Column(name = "NAME")
    private String NAME;

    @OneToMany(mappedBy="GAME_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();





    public Integer getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(Integer GAME_ID) {
        this.GAME_ID = GAME_ID;
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
