package com.imine.backend.model;

import org.apache.openjpa.persistence.DataCache;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by dev on 2015/6/25.
 */
@Entity
@Table(name = PersonInfo.TABLE_NAME)
@DataCache(enabled = false)
public class PersonInfo implements Serializable {
    public static final String TABLE_NAME = "PERSON_INFO";

    private long personInfoUid;

    private User user;

    private int weight;

    private int sitUp;

    private int pushUp;

    private int squad;

    private Date timestamp;

    @Id
    @Column(name = "PERSON_INFO_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = TABLE_NAME)
    public long getPersonInfoUid() {
        return personInfoUid;
    }

    public void setPersonInfoUid(long personInfoUid) {
        this.personInfoUid = personInfoUid;
    }

    @ManyToOne(targetEntity = User.class, cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Basic
    @Column(name = "WEIGHT", nullable = false)
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "SIT_UP", nullable = false)
    public int getSitUp() {
        return sitUp;
    }

    public void setSitUp(int sitUp) {
        this.sitUp = sitUp;
    }

    @Basic
    @Column(name = "PUSH_UP", nullable = false)
    public int getPushUp() {
        return pushUp;
    }

    public void setPushUp(int pushUp) {
        this.pushUp = pushUp;
    }

    @Basic
    @Column(name = "SQUAD", nullable = false)
    public int getSquad() {
        return squad;
    }

    public void setSquad(int squad) {
        this.squad = squad;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "TIMESTAMP")
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
