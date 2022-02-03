<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<html>
<head>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<title>공지사항</title>

<style>
/* 내용틀 */
div.content {
	display: flex;
	justify-content: center;
}

div.content>div {
	width: 1140px;
	margin-top: 50px;
}

/* 제목 */
.content > div > div:nth-child(1) {
	font-size: 24px;
	font-color: var(--black_main);
	margin-bottom : 10px;
}

/* 테이블 */
#list tr:nth-child(1) {
	background-color: #504B71;
	color: var(--white);
}

#list tr > th {
	text-align: center;
}

/* 서치바 */
.search {
	padding: 5px;
	border: 1px solid #BEBEBE;
	margin: 0px 0px 15px 0px;
}

.search>form {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 4px 20px;
}

.search > form > table:nth-child(2) {
    display: flex;
    width: 100px;
    margin-left: 56px;
    height:35px;
}

#ordertime{
	height: 34px;
}

.search {
	background-color: #FFFFFF;
}

.search>form input[type=text] {
	width: 400px;
	margin: 0 10px;
}

.searchdate {
	display: flex;
	margin-right: 30px;
	text-align: center;
}

.searchdate>input {
	width: 145px;
}

.searchdate > span {
	margin: 0 10px;
	vertical-align: middle;
}

table > tbody > tr > td {
	background-color: #FFFFFF;
}

table > tbody > tr:hover > td {
	background-color: #e5e5e5;
}

table > tbody > tr > td > a {
	color: var(--black_sub1);
}

table > tbody > tr > td > a:hover {
	color: var(--purple_three);
}

/* 페이징 */
.pagebar .pagination>li>a {
	color: var(--black_main);
}

.pagebar .pagination>.active>a {
	background-color: var(--purple_three);
	color: var(--white);
}

.pagebar {
	position: relative;
	left: 580px;
	top: 50px;
	width: 500px;
}

.pagebar>nav {
	position: absolute;
	left: -220px;
	top: -50px;
}

.btn-box {
	text-align: right;
}
</style>

<%@ include file="/WEB-INF/inc/asset.jsp"%>


</head>
<body>


	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_notice.jsp"%>
			<div class="content">

				<div>

					<div>공지사항</div>
					<div class="search">
						<form method="GET" action="/notice/board.do">

							<div name="calendar" class="searchdate">
								<input class="form-control" type="date" name="startDate" value="regdate">
								<span>-</span>
								<input class="form-control" type="date" name="enddate" value="regdate">
							</div>
							<table>
								<tr>
									<td><select name="columntime" class="form-control" id="ordertime">
											<option value="new">최신순</option>
											<option value="old">오래된순</option>
									</select></td>
								</tr>
							</table>
							<table>
								<tr>
									<td><select name="column" class="form-control">
											<option value="title">제목</option>
											<option value="content">내용</option>
											<option value="name">부서</option>
									</select></td>
									<td><input type="text" name="word" class="form-control"
										required></td>
									<td><input type="submit" value="검색하기"
										class="btn btn-default"></td>

								</tr>
							</table>
						</form>
					</div>

					<c:if test="${map.searchmode == 'y'}">
						<div style="text-align: center; margin: 10px; color: #777;">'${map.word}${map.name}'(으)로
							검색한 ${list.size()}개의 게시물이 있습니다.</div>
					</c:if>

					<table class="table table-bordered list" style="width: 1140px;"
						id="list">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성부서</th>
							<th>등록일</th>
						</tr>
						<c:forEach items="${list}" var="dto">
							<tr>
								<td style="text-align: center;">${dto.seq_notice}</td>
								<!-- 번호 -->
								<td><a
									href="/notice/view.do?seq=${dto.seq_notice}&column=${map.column}&word=${map.word}&page=${nowPage}">${dto.title}</a>
								</td>
								<td style="text-align: center;">${dto.name}</td>
								<!-- 작성부서 -->
								<td style="text-align: center;">${dto.regdate}</td>
								<!-- 등록일 -->
							</tr>
						</c:forEach>
						<c:if test="${list.size() == 0}">
							<tr>
								<td colspan="5">게시물이 없습니다.</td>
							</tr>
						</c:if>
					</table>
					<div class="btn-box">
						<input type="button" value="글쓰기" class="btn btn-primary" id="btn"
							onclick="location.href='/notice/add.do';">
					</div>


					<div class="pagebar">${pagebar}</div>
				</div>
			</div>
		</main>

	</div>

	<script>
		<c:if test="${map.searchmode == 'y'}">
		//검색 상태를 유지
		$('select[name=column]').val('${map.column}');
		$('input[name=word]').val('${map.word}');
		</c:if>
	</script>

</body>
</html>
