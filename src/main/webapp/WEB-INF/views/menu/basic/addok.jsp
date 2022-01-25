<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/menu.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_menu.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

        </div>
    </main>

</div>

<script>
    /* 메뉴등록 성공 */
    <c:if test="${result == 1}">
        location.href ='/menu/basic/list.do';
    </c:if>

    /* 메뉴등록 실패 */
    <c:if test="${result == 0}">
        alert('메뉴등록 실패 😥😥');
        history.back();
    </c:if>

</script>

</body>
</html>
