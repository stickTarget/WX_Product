<html>
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sideber-->
        <#include "../common/nav.ftl">
        <#--主要内容content-->
    <div id="page-content-wrapper">
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>订单id</th>
                            <th>订单总金额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.orderAmount}</td>
                        </tr>
                        </tbody>
                    </table>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
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
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
                                    <input type="text" class="form-control" />
                                </div> <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="#">Link</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
                    <div class="jumbotron">
                        <h1>
                            Hello, world!
                        </h1>
                        <p>
                            This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
                        </p>
                        <p>
                            <a class="btn btn-primary btn-large" href="#">Learn more</a>
                        </p>
                    </div>
                </div>

            <#--订单详情表数据-->
                <div class="col-md-4 column">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>商品id</th>
                            <th>商品名称</th>
                            <th>价格</th>
                            <th>数量</th>
                            <th>总额</th>
                        </tr>
                        </thead>
                        <tbody>
                <#list orderDTO.orderDetailList as orderDetail>
                <tr>
                    <td>${orderDetail.productId}</td>
                    <td>${orderDetail.productName}</td>
                    <td>${orderDetail.productPrice}</td>
                    <td>${orderDetail.productQuantity}</td>
                    <td>${orderDetail.productQuantity * orderDetail.productPrice}</td>
                </tr>
                </#list>

                        </tbody>
                    </table>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Brand</a>
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
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
                                    <input type="text" class="form-control" />
                                </div> <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="#">Link</a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong class="caret"></strong></a>
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
                    <div class="jumbotron">
                        <h1>
                            Hello, world!
                        </h1>
                        <p>
                            This is a template for a simple marketing or informational website. It includes a large callout called the hero unit and three supporting pieces of content. Use it as a starting point to create something more unique.
                        </p>
                        <p>
                            <a class="btn btn-primary btn-large" href="#">Learn more</a>
                        </p>
                    </div>
                </div>

            <#--操作-->
                <div class="col-md-12 column">
            <#if orderDTO.getOrderStatusEnum().mag == "新订单">
                <a type="button" href="/sell/seller/order/finish?orderId=${orderDTO.orderId}" class="btn btn-default btn-primary">完结订单</a>
                <button type="button" href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}" class="btn btn-default btn-danger">取消订单</button>
            </#if>

                </div>
            </div>
    </div>
    </div>
</div>

</body>
</html>