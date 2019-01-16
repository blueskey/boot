<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>诗/词人列表</title>
</head>
<body>

<input type="button" value="添加" href="/author/add"/>

<form action="/author/list" method="post">
<div class="plat">
   <table>
       <#if authors??>
           <#list  authors as auth>
               <tr>
               <td>
               ${auth.name!''}
               </td>
               <td>
               ${auth.dynasty!''}
               </td>
               <td>
               ${auth.introduction!''}
               </td>
               </tr>
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