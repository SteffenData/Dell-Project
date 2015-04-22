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
        <link rel="stylesheet" href="css/viewCss.css">
        <title>View projects Dell</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

        <div class="centerBox" > 

            <table border="4" style="border-color: blue; margin: auto;">
                <thead>
                    <tr>
                        <th>Start date</th>
                        <th>Project name</th>
                        <th>Status</th>
                        <th>Partner name</th>
                        <th>Country</th>
                        <th>See info</th>
                    </tr>
                </thead>          
                <tbody>
                    <tr></tr>
                <form action="View_Single_Project_Servlet" method="post">
                    <c:forEach var="p" items="${projects}">

                        <tr>
                            <td><p class="tableText">${p.startDate} </p></td>
                            <td><p class="tableText">${p.projectName}</p></td>
                            <td><p class="tableText">${p.status}</p></td>
                            <td><p class="tableText">${p.partner.partnerName}</p></td>
                            <td><p class="tableText">${p.partner.country}</p></td>
                            <td>
                                <button type="submit" name="projectId" value="${p.projectId}">
                                    Press here to see project details
                                    
                                    
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </form>

                </tbody>
            </table>

        </div>
    </body>
</html>