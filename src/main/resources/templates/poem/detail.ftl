<!DOCTYPE html>
<html lang="en">
<head>
    <#--<meta charset="UTF-8">-->
    <title>${poem.title!''}</title>
</head>
<body>

<a type="button"  href="/poem/list" methods="get">返回</a>
    <div class="plat">
        <h3>  ${poem.title!''}</h3>
        <h5 class="right-float"> ${poem.dynasty!''} ● ${poem.author!''}</h5>
        <p>   ${poem.content!''}</p>
    </div>
</body>
<style>
    .plat {
        display: block;
        text-align: center;
        width: 60%;


    }
    .right-float {
        text-align: right;

    }
</style>
</html>