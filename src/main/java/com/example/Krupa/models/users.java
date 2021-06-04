package com.example.Krupa.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.awt.*;
import java.io.Serializable;
import java.util.*;
import java.util.List;

@Entity
//@IdClass(gameLike.class)
@Table(name = "users")
public class users implements UserDetails, Serializable{
    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(name = "UserIdSeq", sequenceName = "users_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UserIdSeq")
    private Long userID;

    @NotNull
    @Column(name = "NAME")
    private String NAME;

    @NotNull
    @Column(name = "PASSWORD")
    private String PASSWORD;

    @NotNull
    @Column(name = "IS_ADMIN")
    private boolean IS_ADMIN;

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name= "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    @OneToMany(mappedBy="USER_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();

    @OneToMany(mappedBy = "USER_ID")
    //@ManyToMany(mappedBy = "USER_ID")
    //private List<gameLike> gameLikes = new ArrayList<gameLike>();
    private Set<gameLike>  gameLikes;// = new HashSet<>();

    @OneToMany(mappedBy = "USER_ID")
    Set<reviewLike> reviewLikes;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long USER_ID) {
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getPassword() {
        return PASSWORD;
    }

    @Override
    public String getUsername() {
        return NAME;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isIS_ADMIN();
    }
}
