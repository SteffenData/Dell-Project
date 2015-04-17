<html>
    <head>
        <link rel="stylesheet" href="css/css.css">
        <title>TODO supply a title</title>
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
        <div class="centerBox"> 
            <div id="overskrift"><strong>New Project</strong></div>
          
            <div id="kasse">
                <p>Type in the required information (fields marked with *) and click Submit</p>
                <br>
                <form action="Create_Project_Servlet" method="post">
                    
                    <strong>Name of the Project: *</strong><br>
                    <input type="text" name="projectName" required="" autofocus>
                    <br><br>
                    <strong>Budget: *</strong><br>
                    <p>Use the format . to separate numbers</p>
                    <input type="number" name="cost" step="any"  min="-9999999" max="9999999">
                    <br>
                    <br>
                    <strong>Describe the Project: *</strong><br>
                    <textarea type="text" cols="40" rows="6" name="description" required=""></textarea>
                    <br>
                    <br>
                    <strong>Goal of the Project: *</strong><br>
                    <textarea type="text" cols="40" rows="6" name="goal" required=""></textarea>
                    <br>
                    
                    <p><strong>Attach file:</strong></p>
                    <input type="file" name="upload"><br>
                    <br>
                        
                    <div id="msgDiv" style="display:inline-block">    
                        <button type="submit" style="float: left;" onclick="break"><strong>Submit</strong></button>   
                        <p style="color: red; float: left;">${MSG_NO}</p>
                        <p style="color: green; float: left; ">${MSG_YES}</p>
                    </div>
             
                    
                </form>
                            
               
            </div>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
            <br><br><br><br><br><br><br><br><br><br>
          </div>

    </body>
</html>
