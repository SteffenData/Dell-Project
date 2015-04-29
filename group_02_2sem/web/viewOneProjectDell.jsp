<%-- 
    Document   : viewOneProjectDell.jsp
    Created on : 17-04-2015, 20:16:15
    Author     : Bente
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "javax.servlet.RequestDispatcher" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css.css">
        <title>View one project Dell</title>
        <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css"></style>
    </head>
    <body>
        <div class="topBox"> 
            <a href="dellHome.jsp">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Home</h3>
                </div>
            </a>
            <a href="https://www.google.dk/">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Coming soon</h3>
                </div>
            </a>
            <a href="${pageContext.request.contextPath}/View_Project_Servlet">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">View Projects</h3>
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
        <div class="centerBox"> 
            <div id="overskrift"><strong>View one project</strong></div>
            <h1>
                ${project.projectName}
            </h1>

            <p>
                Partner: <strong>${project.partner.partnerName}</strong>
            </p>

            <p>
                Starting date: <strong>${project.startDate}</strong>
            </p>

            <p>
                Projected costs of the project: <strong>${project.cost}</strong>
            </p>
            <p>Status is: <strong>${project.status}</strong></p>
            <p>
                Description of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="description" readonly="">${project.description}</textarea>

           
            <p>
                Goal of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="goal" readonly="">${project.goal}</textarea><br><br><br> 
            
            <p>
                Description of status: 
            </p>
            <form action="StatusChangeServlet"> 
                <textarea type="text" cols="40" rows="6" name="statusDescription" >${project.statusDescription}</textarea><br><br><br>
                  <input type ="hidden" name="projectId" value="${project.projectId}" >
                <button type="submit" name="statusBox" value="1">Approve</button> <button type="submit" name="statusBox" value="0">Reject</button>
            </form>
                
                <form action="PoeServlet">
                    <input type ="hidden" name="projectId" value="${project.projectId}" >
                    <button type="submit">Download POE</button>
                </form>
                
                
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
        </div>
    </body>
</html>