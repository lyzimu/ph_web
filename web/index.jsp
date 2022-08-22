<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/21
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录页面</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
  </head>
  <body>
  <div class="head">
    <h2 align="center">社&nbsp;区&nbsp;宠&nbsp;物&nbsp;诊&nbsp;所</h2>
  </div>
  <div id="content" class="container-fluid"  align="center"  >
    <!--设置盒子的宽度占5个栅格-->
    <div class="col-4 card p-4" style="background-color: rgba(255,255,255,0.25);">
      <!-- 用户登录内容 -->
      <div class="bg-warning mb-2 p-1" align="center">
        <h4 class="text-white">用户登录</h4>
      </div>
      <!--表单组件-->
      <form role="form" class="form-horizontal" action="${pageContext.request.contextPath}/loginServlet" method="post">
        <!-- 用户名输入框 -->
        <div class="form-inline mb-3">
          <label class="col-sm-3 control-label">姓&nbsp;&nbsp名</label>
          <div class="col-sm-9 ">
            <input type="text" name="name" class="form-control" placeholder="username">
          </div>
        </div>
        <!-- 密码输入框 -->
        <div class="form-inline mb-3">
          <label class="col-sm-3 control-label">密&nbsp;&nbsp;码</label>
          <div class="col-sm-9">
            <input type="password" name="pwd" class="form-control" placeholder="password">
          </div>
        </div>
        <!-- 验证码输入框 -->
        <div class="form-inline mb-3">
          <label class="col-sm-3 control-label">验证码</label>
          <div class="col-sm-9">
            <input type="password" name="code1" class="form-control" placeholder="identifying">
          </div>
        </div>
        <!-- 验证码可刷新图片 -->
        <div class="form-inline mb-3">
          <label class="col-sm-3 control-label">刷新</label>
          <div class="col-sm-9">
            <img id="imgCode" src="${pageContext.request.contextPath}/randomCode" alt="" width="200" height="30">
          </div>
        </div>
        <!--按钮组件-->
       <div class="form-inline row ml-5">
         <button type="submit" class="btn btn-warning w-40 col-4 col-lg-offset-2 mr-4 text-white">登录</button>
         <button type="reset" class="btn btn-warning w-40 col-4 col-lg-offset-2 text-white">重置</button>
       </div>
      </form>
    </div>
  </div>
  <div style="color:red">${msg}</div>
  <div class="footer"></div>
  </body>
</html>
<script>
  imgCode.onclick=function(){
    var t = new Date().getTime();
    imgCode.src='${pageContext.request.contextPath}/randomCode?' + t
  }
</script>
