<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항</title>
 	<style>
		.content {
			display: flex;
			flex-direction: column;
			align-items: center;
		}

 		.content table {
 			width: 1000px;
			margin-top: 80px;
			background-color: #FFFFFF;
			border-collapse: collapse;
 		}

 		.content table > tbody tr:nth-child(1) {
 			background-color : #504B71;
			color: var(--white);
 		}

		.content table > tbody > tr > th {
			/*border: none;*/
			text-align: center;
		}

		.content table > tbody > tr > th:nth-child(1) { width: 100px; }
		.content table > tbody > tr > th:nth-child(2) { width: 170px; }
		.content table > tbody > tr > th:nth-child(4) { width: 220px; }
		.content table > tbody > tr > th:nth-child(3) {
			padding-left: 20px;
			text-align: left;
		}

		.content table > tbody > tr:nth-child(2) > td {
			height: 300px;
			padding: 45px;
			vertical-align: top;
		}

		.btns {
			width: 1000px;
			text-align: right;
			vertical-align: top;
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
					<th>${dto.seq_notice}</th>
					<th>${dto.name}</th>
					<th>${dto.title}</th>
					<th>${dto.regdate}</th>
				</tr>	
				<tr>
				 	<td colspan="4">${dto.content}</td>
				</tr>
			</table>
			
			<div class="btns">
			
				<input type="button" value="수정하기"
					class="btn btn-primary"
					onclick="location.href='/notice/edit.do?seq=${dto.seq_notice}';">
				<input type="button" value="삭제하기"
					class="btn btn-primary"
					onclick="location.href='/notice/del.do?seq=${dto.seq_notice}';">
				<input type="button" value="돌아가기"
					class="btn btn-default"
					onclick="location.href='/notice/board.do?column=${column}&word=${word}&page=${page}';">

			</div>
			
			
			
			
        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
