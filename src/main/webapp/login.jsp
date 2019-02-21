<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/25
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ssm博客系统</title>
    <!-- 引入easyui样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/gray/easyui.css">
    <!-- 引入easyui图标样式文件 -->
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/jquery-easyui-1.5/themes/icon.css">
    <!-- 引入jquery js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.min.js"></script>
    <!-- 引入easyui的js文件 -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <!-- 引文easyui支持中文js -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js"></script>
    <!-- 引入uploadify css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/uploadify/uploadify.css">
    <script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
    <!-- 引入kindeditor css js文件 -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/js/kindeditor-4.1.10/themes/default/default.css" />
    <script src="<%=request.getContextPath() %>/js/kindeditor-4.1.10/kindeditor-all.js"></script>
    <!-- jQuery -->
    <script type="text/javascript" src="<%=request.getContextPath() %>/loginjs/js/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script type="text/javascript"  src="<%=request.getContextPath() %>/loginjs/js/bootstrap.min.js"></script>
    <link type="text/css" rel="stylesheet" href="<%=request.getContextPath() %>/js/bootstrap/bootstrap3/css/bootstrap.css">
    <!-- Placeholder -->
    <script type="text/javascript"  src="<%=request.getContextPath() %>/loginjs/js/jquery.placeholder.min.js"></script>
    <!-- Waypoints -->
    <script type="text/javascript"  src="<%=request.getContextPath() %>/loginjs/js/jquery.waypoints.min.js"></script>
    <!-- Main JS -->
    <script type="text/javascript"  src="<%=request.getContextPath() %>/loginjs/js/main.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/loginjs/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/loginjs/css/animate.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/loginjs/css/style.css">
    <!-- Modernizr JS -->
    <script src="<%=request.getContextPath() %>/loginjs/js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="<%=request.getContextPath() %>/loginjs/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/loginjs/css/form-elements.css">
    <style>
        body {
            background-image: url("<%=request.getContextPath() %>/zzpic15723.jpg");
            background-position: center 0;
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
            -webkit-background-size: cover;
            -o-background-size: cover;
            -moz-background-size: cover;
            -ms-background-size: cover;
        }
        .input-group{
            border:1px #ccc solid;
            border-spacing:1px;
            border-radius:4px;
        }
        #loginForm{
            background-color: rgba(0, 0, 0, 0.4);
            height: 50%;
            margin-top:80px;
            text-align:center
        }
        .form-group{
            width: 250px;
            margin-left: 50px;
            margin-top: 30px;

        }

    </style>
</head>
<body >

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-push-8">
            <!-- Start Sign In Form -->
            <form  id="loginForm" >
                <h2><font color="#fffff0"><b>博客登录</b></font></h2>
                <div class="form-group">
                    <label for="username" class="sr-only">账号</label>
                    <input type="text" class="form-control" id="username" placeholder="请输入账号">
                </div>
                <div class="form-group">
                    <label for="password" class="sr-only">密码</label>
                    <input type="password" class="form-control" id="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <input type="button" class="btn btn-block btn-primary" onclick="login()" value="登录" />
                </div>
            </form>
            <!-- END Sign In Form -->
        </div>
    </div>
    <div class="row" style="padding-top: 160px; clear: both;">
        <div class="col-md-12 text-center"><p><small><font color="#f0f8ff">&copy; Copyright © 2016-2017 SSM个人博客系统  版权所有.</font></small></p></div>
    </div>
</div>

</body>
<script type="text/javascript">
    function login(){
        $.ajax({
            url:"blogger/login",
            type:'post',
            data:{
                username:$("#username").val(),
                password:$('#password').val()
            },
            success:function(data){
                if(data=="登录成功"){
                    alert(data)
                }else{
                    alert(data)
                }
                if(data=="登录成功"){
                    location.href="<%=request.getContextPath() %>/admin/main.jsp";
                }
            }
        })
    }
</script>
</html>
