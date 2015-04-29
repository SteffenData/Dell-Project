<%-- 
    Document   : dellHome
    Created on : 16-04-2015, 09:17:58
    Author     : Mikkel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/css.css">
        <title>Dell homepage</title>
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
            <br><br>
            <h1>Welcome to Dell Campaign Management</h1><br>
            <p>With this software you can:</p>
            <ul>
                <li>Get an overview of ongoing campaigns</li>
                <li>View and approve individual projects</li>
                <li>See budget details</li>
            </ul>
        </div>
    </body>
</html>
