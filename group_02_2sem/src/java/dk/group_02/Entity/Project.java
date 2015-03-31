/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.awt.Image;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class Project {
    private String startDate;
    private LocalDate localdate;
    private String projectId;
    private String projectName;
    private double cost;
    private String status;
    private String description;
    private Partner partner;
//  private Image files;
    private String goal;

//    public Project(Date startDate, String projectId, String projectName, double cost, String status, String description, Partner partner, Image files, String goal) {
//        this.projectId = projectId;
//        this.projectName = projectName;
//        this.cost = cost;
//        this.status = status;
//        this.description = description;
//        this.partner = partner;
//        this.files = files;
//        this.goal = goal;
//        this.startDate = startDate;
//    }

    public Project(String id, String projectName, double cost, String status, String description, Partner partner, String goal) {
        this.startDate = "" + localdate.now();
        this.projectId = id;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.partner = partner;
        this.goal = goal;
    }

    public String getStartDate() {
        return startDate;
    }

//    public void setStartDate(String startDate) {
//        this.startDate = startDate;
//    }

    public String getProjectId() {
        return projectId;
    }

//    public void setId(String projectId) {
//        this.projectId = projectId;
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
    
}
