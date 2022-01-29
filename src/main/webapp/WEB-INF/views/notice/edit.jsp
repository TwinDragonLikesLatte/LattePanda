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

		<form method="POST" action="/notice/editok.do">
			<table class="table table-bordered add">
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" class="form-control" required value="${dto.title}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="content" class="form-control" required>${dto.content}</textarea></td>
				</tr>
			</table>
			
			<div class="btns">
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/notice/view.do?seq=${dto.seq_notice}';">
				<input type="submit" value="수정하기"
					class="btn btn-primary">										
			</div>
			
			<input type="hidden" name="seq" value="${dto.seq_notice}">
			</form>





        </div>
    </main>

</div>

<script>
	<c:if test="${result == 1}">
	//성공
	location.href = '/code/board/list.do';
	</c:if>
	
	<c:if test="${result == 0}">
	//실패
	alert('failed');
	history.back();
	</c:if>
</script>

</body>
</html>
