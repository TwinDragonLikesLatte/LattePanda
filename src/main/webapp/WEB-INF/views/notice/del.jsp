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
        <%@ include file="/WEB-INF/inc/sub-nav_notice.jsp" %>
        <div class="content">

  			<div class="panel panel-default">
				<div class="panel-heading">삭제하기</div>
				<div class="panel-body">
				
					<input type="button" value="돌아가기" class="btn btn-default" onclick="history.back();">
					<input type="button" value="삭제하기" class="btn btn-primary" onclick="location.href='/notice/delok.do?seq=${seq}';">
					
				</div>
			</div>

        </div>
    </main>

</div>

<script>

</script>

</body>
</html>