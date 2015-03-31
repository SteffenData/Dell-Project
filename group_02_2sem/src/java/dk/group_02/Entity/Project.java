/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.group_02.Entity;

import java.awt.Image;
import java.util.Date;

/**
 *
 * @author steffen
 */
public class Project {
    private Date startDate;
    private String id;
    private String projectName;
    private double cost;
    private String status;
    private String description;
    private Partner partner;
    private Image files;
    private String goal;

    public Project(Date startDate, String id, String projectName, double cost, String status, String description, Partner partner, Image files, String goal) {
        this.id = id;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.partner = partner;
        this.files = files;
        this.goal = goal;
        this.startDate = startDate;
    }

    public Project(Date startDate, String id, String projectName, double cost, String status, String description, Partner partner, String goal) {
        this.startDate = startDate;
        this.id = id;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.partner = partner;
        this.goal = goal;
    }
    
}
