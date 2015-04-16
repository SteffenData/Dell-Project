<html>
    <head>
        <link rel="stylesheet" href="css/skabelonCSS.css">
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style type="text/css"></style>
    </head>
    <body>
        <form action="Index_Servlet" method="get">
        <div id="login">
        <strong>Username:</strong><br>
                <input type="text" name="username" placeholder="Type in your username">
                <br>
                <strong>Password:</strong><br>
                <input type="text" name="password" placeholder="Type in your password">
                <br>
                <br>
                <br>
                <button type ="submit"><strong>Login</strong></button><br>
                <p style="color:red">${message}</p>
        </div>
        </form>

</body>
</html>
