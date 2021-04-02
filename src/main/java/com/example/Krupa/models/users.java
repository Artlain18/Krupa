package com.example.Krupa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class users {
    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "UserIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSeq")
    private Integer USER_ID;


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

    public Integer getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(Integer USER_ID) {
        this.USER_ID = USER_ID;
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


}
