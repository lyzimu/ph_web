<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/5/21
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>医生查询页面</title>
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
</head>
<body>

<c:if test="${not empty user}">
    <%--    <h1>欢迎 ${user.name}</h1>--%>
    <div class="head">
        <h6><a href="/ph/loginOut">退出</a></h6>
        <h2 align="center">社&nbsp;区&nbsp;宠&nbsp;物&nbsp;诊&nbsp;所</h2>
        <a href="">医生管理</a>  <a href="">客户管理</a>
    </div>
    <div id="content" align="center" >
        <div class="sel">
            <form action="${pageContext.request.contextPath}/vetServlet" method="post">

                        <table class="table-hover" style="margin: auto;line-height: 50px;text-align: center;padding: 10px;color: #fd7e14">
                            <tr style="margin: 10px">
                                <th>医生姓名</th>
                                <th>专业特长</th>
                            </tr>
                            <c:forEach var="v" items="${sessionScope.list}">
                                <tr>
                                    <td>
                                            ${v.name}
                                    </td>
                                    <td>
                                        <c:forEach items="${v.specialList}" var="s">
                                            ${s.name}
                                        </c:forEach>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="2">
                                    <a href="${pageContext.request.contextPath}/vetsearch.jsp">返回</a>
                                </td>
                            </tr>
                        </table>
        </div>
    </div>
    <div class="footer"></div>
</c:if>
<c:if test="${empty user}">
    <h1>您还没有登录呢！</h1>
    <h3><span id="sp">3</span>秒后自动跳转到<a href="/ph/index.jsp">登录页面</a></h3>
    <script>
        //setTimeout() 方法用于在指定的毫秒数后调用函数或执行表达式。
        setTimeout(function () {
            //assign()方法加载一个新的文档。
            location.assign("${pageContext.request.contextPath}")
        },3000)
        //setInterval() 方法可按照指定的周期（以毫秒计）来调用函数或计算表达式
        setInterval(function () {
            sp.innerText--
        },1000)
    </script>
</c:if>
</body>
</html>
