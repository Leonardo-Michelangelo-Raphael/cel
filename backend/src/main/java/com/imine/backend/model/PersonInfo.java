package com.imine.backend.model;

import org.apache.openjpa.persistence.DataCache;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by dev on 2015/6/25.
 */
@javax.persistence.Entity
@Table(name = PersonInfo.TABLE_NAME)
@DataCache(enabled = false)
public class PersonInfo implements Entity {
    public static final String TABLE_NAME = "PERSON_INFO";

    @Id
    @Column(name = "PERSON_INFO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = TABLE_NAME)
    private long personInfoUid;

    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User user;

    @Basic
    @Column(name = "WEIGHT", nullable = false)
    private int weight;

    @Basic
    @Column(name = "SIT_UP", nullable = false)
    private int sitUp;

    @Basic
    @Column(name = "PUSH_UP", nullable = false)
    private int pushUp;

    @Basic
    @Column(name = "SQUAD", nullable = false)
    private int squad;

    @Temporal(TemporalType.DATE)
    @Column(name = "TIMESTAMP")
    private Date timestamp;


    public long getPersonInfoUid() {
        return personInfoUid;
    }

    public void setPersonInfoUid(long personInfoUid) {
        this.personInfoUid = personInfoUid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }


    public int getSitUp() {
        return sitUp;
    }

    public void setSitUp(int sitUp) {
        this.sitUp = sitUp;
    }


    public int getPushUp() {
        return pushUp;
    }

    public void setPushUp(int pushUp) {
        this.pushUp = pushUp;
    }


    public int getSquad() {
        return squad;
    }

    public void setSquad(int squad) {
        this.squad = squad;
    }


    public Date getTimestamp() {
        if (this.timestamp != null)
            return new Date(this.timestamp.getTime());
        else
            return null;
    }

    public void setTimestamp(Date timestamp) {
        if (timestamp != null)
            this.timestamp = new Date(timestamp.getTime());
        else
            this.timestamp = null;
    }
}
