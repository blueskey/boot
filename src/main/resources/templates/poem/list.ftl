<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>诗/词列表</title>
</head>
<body>

<a type="button"  href="/poem/add" methods="get">添加</a>

<form action="/poem/list" method="post">
<div class="plat">
   <table>
       <#if poems??>
           <#list  poems as poem>
               <tr>
               <td>
               ${poem.title!''}
               </td>
               <td>
               ${poem.author!''}
               </td>
               <td>
               ${poem.content!''}
               </td>
               <td>
              <a href="/poem/detail?id=${poem.id!''}">详情</a>
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