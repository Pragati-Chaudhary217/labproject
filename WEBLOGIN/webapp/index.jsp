<!DOCTYPE html>
<html>
<head>
    <title>Distributed Server</title>
</head>
<body>

<h2>Upload Code</h2>
<form action="uploadCode" method="post" enctype="multipart/form-data">
    Username: <input type="text" name="username"><br><br>
    Select Code File: <input type="file" name="codefile"><br><br>
    <input type="submit" value="Upload Code">
</form>

<h2>Upload Data</h2>
<form action="uploadData" method="post" enctype="multipart/form-data">
    Username: <input type="text" name="username"><br><br>
    Select Data File: <input type="file" name="datafile"><br><br>
    <input type="submit" value="Upload Data">
</form>

<h2>Execute Program</h2>
<form action="execute" method="post">
    Username: <input type="text" name="username"><br><br>
    <input type="submit" value="Run Code">
</form>

</body>
</html>