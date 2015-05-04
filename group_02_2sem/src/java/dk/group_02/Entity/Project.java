/**
 *
 * @author steffen/Bente/Mikkel/Kasper/Pelle
 */

package dk.group_02.Entity;

import java.io.File;

public class Project {
    private int projectId;
    private String startDate;
    private String projectName;
    private Double cost;
    private String status;
    private String description;
    private File upload;
    private String goal;
    private Partner partner;
    private String statusDescription;

    public Project(int projectId, String startDate, String projectName, Double cost,String status, String description, String goal,Partner partner) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.projectName = projectName;
        this.cost = cost;
        this.status = status;
        this.description = description;
        this.upload = null;
        this.goal = goal;
        this.partner = partner;
        this.statusDescription = "";
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
    public String getStartDate() {
        return startDate;
    }

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

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    @Override
    public String toString() {
        return "Project{" + "projectId=" + projectId + ", startDate=" + startDate + ", projectName=" + projectName + ", cost=" + cost + ", status=" + status + ", description=" + description + ", upload=" + upload + ", goal=" + goal + ", partner=" + partner + ", retard=" + statusDescription + '}';
    }
}