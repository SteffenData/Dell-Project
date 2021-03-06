<%-- 
    Author     : Mikkel/Bente/Steffen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css.css">
        <link rel="stylesheet" href="css/viewCss.css">
        <title>View one project Partner</title>
        <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css"></style>
    </head>
    <body>
        <div class="topBox"> 
            <a href="partnerHome.jsp">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Home</h3>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/View_Project_Servlet">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">View Projects</h3>
                </div>
            </a>
            <a href="createProject.jsp">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Create Project</h3>
                </div>
            </a> 
            <a href="https://www.google.dk/">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Coming soon</h3>
                </div>
            </a> 
            <a href="https://www.google.dk/">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Coming soon</h3>
                </div>
            </a>
        </div>
        <div class="centerBox" > 
            <div id="overskrift"><strong>View one project</strong></div>
            <h1>
                ${project.projectName}
            </h1>
            <p>
                Starting date: <strong>${project.startDate}</strong>
            </p>
            <p>
                Status is: <strong>${project.status}</strong> 
            </p>
            <p>
                projected costs of the project: <strong>${project.cost}</strong>
            </p>
            <p>
                Description of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="description" readonly="" style="text-align: left">${project.description}</textarea>
            <p>
                Goal of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="goal" readonly="" style="text-align: left">${project.goal}</textarea>
            <p>
                Description of status: 
            </p>
            <textarea type="text" cols="40" rows="6" name="goal" readonly="" style="text-align: left">${project.statusDescription}</textarea>
            <br><br><br><br><br><br><br>
            <form action="PoeServlet" method="POST" enctype="multipart/form-data">
                <input type ="hidden" name="projectId" value="${project.projectId}" >
                <p>Upload POE</p>
                <input type="file" name="poe"> 
                <button type="submit">Upload</button>
                <br>
                 <p style="color: red; float: left;">${MSG_NO}</p>
                 <p style="color: green; float: left; ">${MSG_YES}</p>
            </form>
                
        </div>
    </body>
</html>