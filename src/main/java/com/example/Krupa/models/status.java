
package com.example.Krupa.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class status {
    @Id
    @Column(name = "STATUS_ID")
    @SequenceGenerator(name = "StatusIdSeq", sequenceName = "status_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "StatusIdSeq")
    private Integer STATUS_ID;

    @NotNull
    @Column(name = "STATUS_MESSAGE")
    private String STATUS_MESSAGE;

    @OneToMany(mappedBy="STATUS_ID", fetch=FetchType.EAGER)
    private List<review> reviewList = new ArrayList<review>();

    public Integer getSTATUS_ID() {
        return STATUS_ID;
    }

    public void setSTATUS_ID(Integer STATUS_ID) {
        this.STATUS_ID = STATUS_ID;
    }

    public String getSTATUS_MESSAGE() {
        return STATUS_MESSAGE;
    }

    public void setSTATUS_MESSAGE(String STATUS_MESSAGE) {
        this.STATUS_MESSAGE = STATUS_MESSAGE;
    }
}
