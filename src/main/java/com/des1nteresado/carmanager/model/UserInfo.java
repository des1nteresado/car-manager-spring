package com.des1nteresado.carmanager.model;

import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name = "user_dtp_info")
public class UserInfo {
    @Id
    private int id;
    @Column(name = "drive_lic")
    private int driveLicence;
    private String description;
    @Column(name = "dtp_date")
    private String dtpDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDtpDate() {
        return dtpDate;
    }

    public void setDtpDate(String dtpDate) {
        this.dtpDate = dtpDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriveLicence() {
        return driveLicence;
    }

    public void setDriveLicence(int driveLicence) {
        this.driveLicence = driveLicence;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", driveLicence=" + driveLicence +
                ", description='" + description + '\'' +
                ", dtpDate='" + dtpDate + '\'' +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
