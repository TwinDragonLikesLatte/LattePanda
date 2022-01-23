<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항</title>
 	<style>
 		.content table {
 			width: 1000px;
 		}
 	
 	
 	</style>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>
<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>
    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_notice.jsp" %>
        <div class="content">
            <table class="table table-bordered">
				<tr>
					<th>글번호</th>
					<th>부서</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
				<tr>
					<td>${dto.seq_notice}</td>
					<td>${dto.name}</td>
					<td>a${dto.title}</td>
					<td>${dto.regdate}</td>
				</tr>
				<tr>
				 	<td style="height:300px;vertical-align:middle;" colspan="4">내용입니다. ${dto.content}</td>
				</tr>
			</table>
        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
