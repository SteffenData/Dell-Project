<%-- 
    Document   : view
    Created on : 09-04-2015, 09:45:26
    Author     : steffen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css.css">
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css"></style>
    </head>
    <body>
        <div id="1">
            <div class="topBox"> 

                <a href="view_project.jsp">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">View project</h3>
                    </div>
                </a>

                <a href="create_project.jsp">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
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
                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Coming soon</h3>
                    </div>
                </a>
            </div>
        </div>
        <div class="centerBox" > 

            <table border="4" style="border-color: blue; margin: auto;">
                <thead>
                    <tr>
                        <th>Start date</th>
                        <th>Project name</th>
                        <th>Status</th>
                        <th>Partner name</th>
                        <th>Country</th>
                    </tr>
                </thead>          
                <tbody>
                    <c:forEach var="p" items="${project}">
                        <tr>
                            <td>${p.startDate}</td>
                            <td>${p.projectName}</td>
                            <td>${p.status}</td>
                            <td>${p.partner}</td>
                            <td>${p.country}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>
    </body>
</html>