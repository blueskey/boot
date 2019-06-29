<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加</title>
    <link href="/css/public.css" rel="stylesheet">
</head>
<body>
<div class="content">
<form action="/author/add" method="post">
        <div class="form-item">
            <label class="lab-item" >朝代</label>
            <div class="el-input-content cl-2" style="position: relative;" ><input class="el-input-inner " name="dynasty"/></div>
        </div>
        <div class="form-item">
            <label class="lab-item" >朝代</label>
            <div class="el-input-content cl-2" style="position: relative;" ><input class="el-input-inner " name="dynasty"/></div>
        </div>
        <div class="form-item">
            <label class="lab-item">介绍</label>
            <div class="el-textarea-content cl-2" style="position: relative;" ><textarea class="el-textarea-inner" name="introduction"></textarea></div>
        </div>

    <input  class=" el-button el-button--primary" type="submit" value="提交"/>
</div>
</form>
</body>
</html>