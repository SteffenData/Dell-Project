/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class Project {
    private String startDate;
    private final String PROJECT_ID;
    private String projectName;
    private double cost;
    private String status;
    private String description;
    private Partner partner;
    private File upload;
    private String goal;



    public Project(String startDate, String id, String projectName, double cost,String status, String description, Partner partner, File upload, String goal) {
        this.startDate = startDate;
        this.PROJECT_ID = id;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.partner = partner;
        this.upload = upload;
        this.goal = goal;
    }
    public Project(String startDate, String id, String projectName, double cost,String status, String description, Partner partner, String goal) {
        this.startDate = startDate;
        this.PROJECT_ID = id;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.partner = partner;
        this.upload = null;
        this.goal = goal;
    }

    public String getStartDate() {
        return startDate;
    }

//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }

    public String getPROJECT_ID() {
        return PROJECT_ID;
    }

//    public void setId(String PROJECT_ID) {
//        this.PROJECT_ID = PROJECT_ID;
//    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Partner getPartner() {
        return partner;
    }

    public void setPartner(Partner partner) {
        this.partner = partner;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public File getUpload() {
        return upload;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }
    
}
