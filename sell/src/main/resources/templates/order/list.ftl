<html>
    <#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
<#--边栏sideber-->
        <#include "../common/nav.ftl">

<#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse"
                                    data-target="#bs-example-navbar-collapse-1"><span
                                    class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                                    class="icon-bar"></span><span class="icon-bar"></span></button>
                            <a class="navbar-brand" href="#">Brand</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="active">
                                    <a href="#">Link</a>
                                </li>
                                <li>
                                    <a href="#">Link</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
                                            class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#">Action</a>
                                        </li>
                                        <li>
                                            <a href="#">Another action</a>
                                        </li>
                                        <li>
                                            <a href="#">Something else here</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="#">Separated link</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="#">One more separated link</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                            <form class="navbar-form navbar-left" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control"/>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="#">Link</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
                                            class="caret"></strong></a>
                                    <ul class="dropdown-menu">
                                        <li>
                                            <a href="#">Action</a>
                                        </li>
                                        <li>
                                            <a href="#">Another action</a>
                                        </li>
                                        <li>
                                            <a href="#">Something else here</a>
                                        </li>
                                        <li class="divider">
                                        </li>
                                        <li>
                                            <a href="#">Separated link</a>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>

                    </nav>
                    <table class="table table-condensed table-striped table-hover">
                        <thead>
                        <tr>
                            <th>
                                订单id
                            </th>
                            <th>
                                姓名
                            </th>
                            <th>
                                手机号
                            </th>
                            <th>
                                地址
                            </th>
                            <th>
                                金额
                            </th>
                            <th>
                                订单状态
                            </th>
                            <th>
                                支付状态
                            </th>
                            <th>
                                创建时间
                            </th>
                            <th colspan="2">
                                操作
                            </th>
                        </tr>
                        </thead>
                        <tbody>
                    <#list orderDTOPage.content as orderDTO>

                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.buyerName}</td>
                        <td>${orderDTO.buyerPhone}</td>
                        <td>${orderDTO.buyerAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.orderStatus}</td>
                        <td>${orderDTO.payStatus}</td>
                        <td>${orderDTO.createTime}</td>
                        <td><a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a></td>
                        <td>
                                <#if orderDTO.getOrderStatusEnum().message =="新订单">
                                    <a href="/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                                </#if>
                        </td>
                    </tr>
                    </#list>
                        </tbody>
                    </table>
                    <div class="jumbotron">
                        <h1>
                            Hello, world!
                        </h1>
                        <p>
                            This is a template for a simple marketing or informational website. It includes a large
                            callout called the hero unit and three supporting pieces of content. Use it as a starting
                            point to create something more unique.
                        </p>
                        <p>
                            <a class="btn btn-primary btn-large" href="#">Learn more</a>
                        </p>
                    </div>
                </div>
            </div>
            <div class="row clearfix">
            <#-- 分页 start-->
                <div class="col-md-12 column">
                    <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="">上一页</a></li>
                    <#else>
                        <li><a href="/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>

                    <li>
                    <#list 1..orderDTOPage.getTotalPages() as index>
                        <#if currentPage == index>
                           <li class="disabled"><a href="#">${index}</a></li>
                        <#else>
                            <li><a href="/seller/order/list?page=${index}&size=${size}">${index}</a></li>
                        </#if>
                    </#list>
                    <#if currentPage gte ${orderDTOPage.getTotalPages()}>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                    </ul>
                </div>
            <#--分页 end-->
            </div>
        </div>
    </div>
</div>
<#--弹框-->
<div class="modal fade" id="MyModel" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="myModalLabel">
                    提醒
                </h4>
            </div>
            <div class="modal-body">
                你有新的订单
            </div>
            <div class="modal-footer">
                <button onclick="javascript:document.getElementById('notice').pause()" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button onclick="location.reload()" type="button" class="btn btn-primary">查看新的订单</button>
            </div>
        </div>
    </div>
</div>
<#--播放音乐-->
<audio id="notice" loop="loop">
    <source src="/sell/mp3/song.mp3" type="audio/mpeg">
</audio>

<script src="https://cdn.bootcss.com/jquery/1.2.6/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
    var websocket = null;
    if ('webSocket' in window) {
            websocket = new WebSocket("ws://sell.natapp4.cc/sell/webSocket");
    }else{
        alert('该浏览器不支持websocket');
    }

    websocket.onopen =function (ev){
        console.log('建立连接');
    }

    websocket.onclose =function (ev){
        console.log('连接关闭');
    }

    websocket.onmessage = function (ev) {
        console.log('收到消息'+ev.data);
        //弹框提醒，播放音乐
        $('#MyModel').modal('show');
        document.getElementById('notice').play();
    }

    websocket.onerror = function (ev) {
        alert('websocket通信发生错误')
    }

    window.onbeforeunload = function (ev) {
        websocket.close();
    }
</script>

</body>
</html>


