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
					<td>${dto.seq_notice}</td>
				</tr>
				<tr>
					<th>부서</th>
					<td>${dto.name}</td>
				</tr>	
					<th>제목</th>
					<td>a${dto.title}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${dto.regdate}</td>
				</tr>						
				<tr>
					<th>내용</th>
				 	<td style="height:300px;vertical-align:middle;">${dto.content}</td>
				</tr>
			</table>
			
			<div class="btns">
			
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/notice/board.do?column=${column}&word=${word}&page=${page}';">
				
				<input type="button" value="수정하기"
					class="btn btn-primary"
					onclick="location.href='/notice/edit.do?seq=${dto.seq_notice}';">
				<input type="button" value="삭제하기"
					class="btn btn-primary"
					onclick="location.href='/notice/del.do?seq=${dto.seq_notice}';">
			</div>
			
			
			
			
        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
