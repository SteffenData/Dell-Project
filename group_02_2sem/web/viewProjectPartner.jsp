<%-- 
    Document   : view
    Created on : 09-04-2015, 09:45:26
    Author     : steffen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import = "javax.servlet.RequestDispatcher" %>



<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css.css">
        <link rel="stylesheet" href="css/viewCss.css">
        <title>View projects Partner</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                    <tr></tr>
                    <c:forEach var="p" items="${projects}">
                        <tr>
                            <td><p class="tableText">${p.startDate}</p></td>
                            <td><p class="tableText">${p.projectName}</p></td>
                            <td><p class="tableText">${p.status}</p></td>
                            <td><p class="tableText">${p.partner.partnerName}</p></td>
                            <td><p class="tableText">${p.partner.country}</p></td>
                            <td>
                                <form action="View_Single_Project_Servlet" method="post">
                                    <input type="hidden" name="choice" value="${p.startDate}">
                                    <input type="hidden" name="choice1" value="${p.projectName}">
                                    <input type="hidden" name="choice2" value="${p.cost}">
                                    <input type="hidden" name="choice3" value="${p.status}">
                                    <input type="hidden" name="choice4" value="${p.description}">
                                    <input type="hidden" name="choice5" value="${p.goal}">
                                    
                                    <button type="submit">
                                        <p>
                                            Press here to see project details
                                        </p>
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        </div>
    </body>
</html>