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
        <%@ include file="/WEB-INF/inc/sub-nav_hr.jsp" %>
        <div class="content">

            컨텐츠 코드 작성<br><br>

            <div>
                버튼예제<br>
                <input type="button" class="btn btn-primary" value="등록하기">
                <input type="button" class="btn btn-danger" value="취소하기">
                <input type="button" class="btn btn-default" value="목록보기">
            </div>

        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
