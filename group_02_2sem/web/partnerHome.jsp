<%-- 
Author : Mikkel/Kasper/Bente
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- PAGE IMPORT OG OBJECT IMPORT --%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/css.css">
        <title>Partner homepage</title>
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
            <br><br>
            <h1>Welcome Partner<%--<%=c.getPartnername()%>--%></h1><br>
            <p>With this software you can:</p>
            <ul>
                <li>Complete an application form with your project idea, and submit for evaluation</li>
                <li>Keep track of your ongoing campaigns</li>
                <li>View individual project details</li>
            </ul>
        </div>
    </body>
    </body>
</html>
