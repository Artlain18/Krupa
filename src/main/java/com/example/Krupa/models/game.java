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
    @SequenceGenerator(name = "GameIdSeq", sequenceName = "game_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "GameIdSeq")
    private Integer gameID;

    @NotNull
    @Column(name = "NAME")
    private String NAME;

    @Column(name = "DESCRIBE")
    private String DESCRIBE;

    @Column(name = "BACK")
    private String BACK;

    @Column(name = "LOGO")
    private String LOGO;

    @Column(name = "GAMETRAILER")
    private String GAMETRAILER;
    @Column(name = "TEASER")
    private String TEASER;
    @Column(name = "PUBLISHER")
    private String PUBLISHER;

    public String getTEASER() {
        return TEASER;
    }

    public void setTEASER(String TEASER) {
        this.TEASER = TEASER;
    }

    public String getPUBLISHER() {
        return PUBLISHER;
    }

    public void setPUBLISHER(String PUBLISHER) {
        this.PUBLISHER = PUBLISHER;
    }

    public String getLOGO() {
        return LOGO;
    }

    public void setLOGO(String LOGO) {
        this.LOGO = LOGO;
    }





    @OneToMany(mappedBy="GAME_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();

    @OneToMany(mappedBy = "GAME_ID")
    //@ManyToMany(mappedBy = "GAME_ID")
    Set<gameLike> gameLikes;// = new HashSet<>();



    public String getBACK() {
        return BACK;
    }

    public void setBACK(String BACK) {
        this.BACK = BACK;
    }

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
    public String getDESCRIBE() {
        return DESCRIBE;
    }

    public void setDESCRIBE(String DESCRIBE) {
        this.DESCRIBE = DESCRIBE;
    }

    public String getGAMETRAILER() {
        return GAMETRAILER;
    }

    public void setGAMETRAILER(String GAMETRAILER) {
        this.GAMETRAILER = GAMETRAILER;
    }

    public game() {
    }



    public game(String NAME, String DESCRIBE, String BACK, String LOGO, String GAMETRAILER, String TEASER, String PUBLISHER) {
        this.DESCRIBE = DESCRIBE;
        this.NAME = NAME;
        this.BACK = BACK;
        this.LOGO = LOGO;
        this.GAMETRAILER = GAMETRAILER;
        this.TEASER = TEASER;
        this. PUBLISHER = PUBLISHER;

    }
    public game(String NAME) {
        this.NAME = NAME;
    }
}
