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

                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
                    </div>
                </a>

                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
                    </div>
                </a>
                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
                    </div>
                </a> 
                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
                    </div>
                </a> 
                <a href="https://www.google.dk/">
                    <div class="menuButtons">
                        <h3 class="menu" style="color: black">Create project</h3>
                    </div>
                </a>
            </div>
        </div>
        <div class="centerBox"> 
            <div id="overskrift"><strong>New Project</strong></div>
          
            <div id="kasse">
                <p>Type in the required information (fields marked with "*") and click Submit</p>
                <br>
                <form action="Create_Project_Servlet" method="post">

                    <strong>Name of the Project: *</strong><br>
                    <input type="text" name="projectName" required="">
                    <br>
                    <strong>Budget: *</strong><br>
                    <input type="text" name="cost">
                    <br>
                    <br>
                    <strong>Describe the Project: *</strong><br>
                    <textarea type="text" cols="40" rows="6" name="description" required="">                    </textarea>
                    <br>
                    <br>
                    <strong>Goal of the Project: *</strong><br>
                    <textarea type="text" cols="40" rows="6" name="goal" required="">                    </textarea>
                    <br>
                    
                    <p><strong>Attach file:</strong></p>
                    <input type="file" name="upload"><br>
                    <br>
                        
                    <div id="msgDiv" style="display:inline-block">    
                        <button type="submit" style="float: left;"><strong>Submit</strong></button>   
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