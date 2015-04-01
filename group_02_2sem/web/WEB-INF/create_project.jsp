<%-- 
    Document   : index
    Created on : 31-03-2015, 10:32:16
    Author     : steffen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="create_project" method="get">
            
            Projectname   <input type="text" name="projectname">
            </br>
            Cost <input type="text" name="cost"> 
            </br>
            Description <input type="text" name="description"
            </br>                   
            <button type="submit"> Next </button>
 
        </form>
        
    </body>
</html>
