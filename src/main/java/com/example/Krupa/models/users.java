package com.example.Krupa.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
//@IdClass(gameLike.class)
@Table(name = "users")
public class users implements Serializable{
    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "UserIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSeq")
    private Integer userID;

    @NotNull
    @Column(name = "NAME")
    private String NAME;

    @NotNull
    @Column(name = "PASSWORD")
    private String PASSWORD;

    @NotNull
    @Column(name = "IS_ADMIN")
    private boolean IS_ADMIN;

    @OneToMany(mappedBy="USER_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();

    @OneToMany(mappedBy = "USER_ID")
    //@ManyToMany(mappedBy = "USER_ID")
    //private List<gameLike> gameLikes = new ArrayList<gameLike>();
    private Set<gameLike>  gameLikes;// = new HashSet<>();

    @OneToMany(mappedBy = "USER_ID")
    Set<reviewLike> reviewLikes;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer USER_ID) {
        this.userID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public boolean isIS_ADMIN() {
        return IS_ADMIN;
    }

    public void setIS_ADMIN(boolean IS_ADMIN) {
        this.IS_ADMIN = IS_ADMIN;
    }

    public users() {
    }
    public users(String NAME, String PASSWORD, boolean IS_ADMIN) {
        this.NAME = NAME;
        this.PASSWORD = PASSWORD;
        this.IS_ADMIN = IS_ADMIN;
    }
}
