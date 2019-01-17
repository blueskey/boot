<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>添加</title>
</head>
<body>
<form action="/poem/add" method="post">
    <div class="plat">
        <label>题目</label>
        <input  class="form-inline"name="title"/>
        <label>作者</label>
        <select name="author">
            <option value="">请选择</option>
            <#if authors??>
                <#list  authors as auth>
                    <option value="${auth.id!''}">${auth.name!''}</option>
                </#list>
            </#if>
        </select>
        <label>内容</label>
        <textarea class="form-inline" name="content"></textarea>
        <label>注释</label>
        <textarea class="form-inline" name="annotation"></textarea>
        <label>赏析</label>
        <textarea class="form-inline" name="appreciate"></textarea>


    </div>
    <input  class="button" type="submit" value="提交"/>
</form>
</body>
<style>
    .plat {
        display: block;

    }
</style>
</html>