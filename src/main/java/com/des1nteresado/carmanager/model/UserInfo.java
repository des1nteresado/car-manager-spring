package com.des1nteresado.carmanager.model;

import javax.persistence.*;

@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    private int id;
    @Column(name = "drive_lic")
    private int driveLicence;
    @Column(name = "drive_year")
    private int driveYear;

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

    public int getDriveYear() {
        return driveYear;
    }

    public void setDriveYear(int driveYear) {
        this.driveYear = driveYear;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", driveLicence=" + driveLicence +
                ", driveYear=" + driveYear +
                '}';
    }
}
