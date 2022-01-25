<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_template.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

		
		




        </div>
    </main>

</div>

<script>
<c:if test="${result == 1}">
//성공
location.href = '/order/allist.do';
</c:if>

<c:if test="${result == 0}">
//실패
alert('failed');
history.back();
</c:if>
</script>

</body>
</html>
