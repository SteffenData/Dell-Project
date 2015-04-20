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
            <a href="create_project.jsp">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">Create Project</h3>
                </div>
            </a> 
            <a href="https://www.google.dk/">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">#4</h3>
                </div>
            </a> 
            <a href="https://www.google.dk/">
                <div class="menuButtons">
                    <h3 class="menu" style="color: black">#5</h3>
                </div>
            </a>
        </div>
        <div class="centerBox" > 
            <div id="overskrift"><strong>View one project</strong></div>
            <h1>
                ${projectName}
            </h1>

            <p>
                Starting date: <strong>${startDate}</strong>
            </p>

            <p>
                Status is: <strong>${status}</strong> 
            </p>

            <p>
                projected costs of the project: <strong>${cost}</strong>
            </p>

            <p>
                Description of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="description" readonly="" style="text-align: left">${description}</textarea>

            <p>
                Goal of the project: 
            </p>
            <textarea type="text" cols="40" rows="6" name="goal" readonly="" style="text-align: left">${goal}</textarea>
        </div>
    </body>
</html>