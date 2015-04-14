<%-- 
    Document   : index
    Created on : 09-04-2015, 14:10:03
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
        
      <form action="Index_Servlet" method="get" > 
        
          <div style="width: 600px; height: 200px; margin: auto; margin-top: 200px; background-color: green;">
              <button type="submit" name="dellView" value="dellView" style="width: 300px; height: 200px; float: left;"> <h1>View as Dell</h1> </button>
            
              <button type="submit" name="partnerView" value="partnerView" style="width: 300px; height: 200px; float: right;"> <h1>View as a partner</h1> </button>
          </div>
        </form> 
        
        
    </body>
</html>
