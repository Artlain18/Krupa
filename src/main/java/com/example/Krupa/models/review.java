package com.example.Krupa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class review {
    @Id
    @Column(name = "REVIEW_ID")
    @SequenceGenerator(name = "ReviewIdSeq", sequenceName = "review_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ReviewIdSeq")
    private Integer REVIEW_ID;

    @NotNull
    @Column(name="MESSAGE")
    private String MESSAGE;

    @NotNull
    @Column(name = "NAME")
    private String NAME;



    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="USER_ID")
    private users USER_ID;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="GAME_ID")
    private game GAME_ID;

    @NotNull
    @Column(name = "SCORE")
    private Double SCORE;

    @ManyToOne(optional=false, cascade=CascadeType.ALL)
    @JoinColumn(name="STATUS_ID")
    private users STATUS_ID;


    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }

    public game getGAME_ID() {
        return GAME_ID;
    }

    public void setGAME_ID(game GAME_ID) {
        this.GAME_ID = GAME_ID;
    }

    public Double getSCORE() {
        return SCORE;
    }

    public void setSCORE(Double SCORE) {
        this.SCORE = SCORE;
    }

    public users getSTATUS_ID() {
        return STATUS_ID;
    }

    public void setSTATUS_ID(users STATUS_ID) {
        this.STATUS_ID = STATUS_ID;
    }

    public Integer getREVIEW_ID() {
        return REVIEW_ID;
    }

    public void setREVIEW_ID(Integer REVIEW_ID) {
        this.REVIEW_ID = REVIEW_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public users getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(users USER_ID) {
        this.USER_ID = USER_ID;
    }

    public review() {
    }

    public review(String MESSAGE, String NAME) {
        this.MESSAGE = MESSAGE;
        this.NAME = NAME;
    }
}