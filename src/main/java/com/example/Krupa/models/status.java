
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
    private int statusID;

    @NotNull
    @Column(name = "STATUS_MESSAGE")
    private String statusMessage;

    @OneToMany(mappedBy="statusID", fetch=FetchType.EAGER)
    private List<status> statusList = new ArrayList<status>();

    public status(int STATUS_ID) {
        this.statusID = STATUS_ID;
    }

    public status() {
    }

    public status(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(Integer STATUS_ID) {
        this.statusID = STATUS_ID;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String STATUS_MESSAGE) {
        this.statusMessage = STATUS_MESSAGE;
    }
}
