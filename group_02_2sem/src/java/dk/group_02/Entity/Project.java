/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 *
 * @author steffen
 */
public class Project {
    private String startDate;
    private String projectName;
    private Double cost;
    private String status;
    private String description;
    private File upload;
    private String goal;
    private Partner partner;

    

  /**** Til senere brug når fil er lavet færdigt, ***/
//    public Project(String startDate, String projectName, Double cost,String status, String description, File upload, String goal) {
//        this.startDate = startDate;
//        this.projectName = projectName;
//        this.cost = cost;
//        this.status = status;
//        this.description = description;
//        this.upload = upload;
//        this.goal = goal;
//    }
    public Project(String startDate, String projectName, Double cost,String status, String description, String goal,Partner partner) {
        this.startDate = startDate;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.upload = null;
        this.goal = goal;
        this.partner = partner;
    }

    public String getStartDate() {
        return startDate;
    }
//    public String getPROJECT_ID() {
//        return PROJECT_ID;
//    }

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

    public void setCost(Double cost) {
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
    

    public Partner getPartner() {
        return partner;
    }
}
