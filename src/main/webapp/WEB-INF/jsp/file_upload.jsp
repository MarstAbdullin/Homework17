<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<div>
    <form enctype="multipart/form-data"  action="/files" method="post">
        <input type="file" id="file" name="file" placeholder="Имя файла..."/>
        <input type="email" name="email" placeholder="Email">
        <input type="submit">
    </form>
    <div class="filename"></div>
</div>
</body>
</html>
