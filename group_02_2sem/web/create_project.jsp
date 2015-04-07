<!DOCTYPE html>
<html>
    <head>
        <link href="css/create_project.css" rel="stylesheet" type="text/css"/>
        <title>Dell</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <img src="http://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Dell_Logo.svg/2000px-Dell_Logo.svg.png"
             alt="image"><br><br>
        <div id="overskrift"><strong>New Project</strong></div>
        <br>
        <div id="kasse">
            <p>Type in the required information and click Submit</p>
            <br>
            <form action="SERVLETNAVN" method="post">

                <strong>Name of the Project:</strong><br>
                <input type="text" name="projectName">
                <br>
                <strong>Budget:</strong><br>
                <input type="text" name="cost">
                <br>
                <br>
                <strong>Describe the Project:</strong><br>
                <textarea cols="40" rows="6" name="description">
                </textarea>
                <br>
                <br>
                <strong>Goal of the Project:</strong><br>
                <textarea cols="40" rows="6" name="goal">
                </textarea>
                <br>
                <p><strong>Attach file:</strong></p>
                <input type="file" name="upload"/><br>
                <br>
                <button type="submit" formaction="SERVLETNAVN"><strong>Submit</strong></button>
            </form>
        </div>
    </body>
</html>
