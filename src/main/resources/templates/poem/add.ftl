<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加</title>
    <link href="/css/public.css" rel="stylesheet">
</head>
<body>
<div class="content">
<form action="/poem/add" method="post">
    <div class="plat">
        <div class="form-item">
            <label class="lab-item" >题目</label>
            <div class="el-input-content cl-2" style="position: relative;" ><input class="el-input-inner " name="title"/></div>
        </div>
        <div class="form-item">
            <label class="lab-item" >作者</label>
            <div class="el-input-content cl-2" style="position: relative;" >
                <select name="author" class="el-select-inner cl-2">
                    <option value="">请选择</option>
                    <#if authors??>
                        <#list  authors as auth>
                            <option value="${auth.id!''}">${auth.name!''}</option>
                        </#list>
                    </#if>
                </select></div>
        </div>

        <div class="form-item">
            <label class="lab-item" >内容</label>
            <div class="el-input-content cl-2" style="position: relative;" ><input class="el-input-inner " name="content"/></div>
        </div>
        <div class="form-item">
            <label class="lab-item">注释</label>
            <div class="el-textarea-content cl-2" style="position: relative;" ><textarea class="el-textarea-inner" name="content"></textarea></div>
        </div>

        <div class="form-item">
            <label class="lab-item">赏析</label>
            <div class="el-textarea-content cl-2" style="position: relative;" ><textarea class="el-textarea-inner" name="appreciate"></textarea></div>
        </div>

    </div>
    <input  class=" el-button el-button--primary" type="submit" value="提交"/>
</form>
</div>
</body>
</html>