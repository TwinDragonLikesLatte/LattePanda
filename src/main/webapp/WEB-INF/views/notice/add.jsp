<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>글쓰기</title>
<style>
</style>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_notice.jsp"%>
			<div class="content">

				<form method="POST" action="/notice/addok.do">
					<table class="table" style="width: 900px;">
						<tr>
							<th>제목</th>
							<td><input type="text" name="subject" class="form-control"
								required></td>
						</tr>
						<tr>
							<td colspan="2"><textarea name="content"
									class="form-control" required style="height: 600px;"></textarea></td>
						</tr>
					</table>

					<div class="btns">
						<input type="button" value="돌아가기" class="btn btn-default"
							onclick="location.href='/notice/board.do';"> <input
							type="submit" value="글쓰기" class="btn btn-primary">
					</div>
				</form>

			</div>
		</main>

	</div>

	<script>
		
	</script>

</body>
</html>
