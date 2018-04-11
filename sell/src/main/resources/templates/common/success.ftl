<html>
<head>
    <meta charset="utf-8">
    <title>错误提示</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
            <div class="alert alert-dismissable alert-success">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4>
                    成功！
                </h4> <strong>${msg}</strong> <a href="${url}" class="alert-link">3秒后自动跳转</a>
            </div>
        </div>
    </div>
</div>
<script>
    setTimeout('location.href="${url}}"',3000)
</script>
</body>
</html>