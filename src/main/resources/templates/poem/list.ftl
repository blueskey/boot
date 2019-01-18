<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>诗/词列表</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>

<a type="button"  href="/poem/add" methods="get">添加</a>

<form action="/poem/list" method="post">
<div class="plat">
   <div></div>
       <#if poems??>
           <#list  poems as poem>
               <p class="p-0">
               <em>${poem.title!''}</em>
               <em>${poem.author!''}</em>
               <a href="/poem/detail?id=${poem.id!''}">${poem.content!''}</a>
               </p>


           </#list>
       </#if>

   </table>

</div>
</form>
</body>
<style>
    .plat {
        display: block;

    }
</style>
</html>