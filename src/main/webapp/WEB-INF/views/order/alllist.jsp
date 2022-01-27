<%@page import="com.test.main.order.ListDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>주문관리: 진행중</title>

<style>

/* 서치바 */
.search {
	width: 500px;
	position: relative;
	top: 40px;
}

.search>form {
	display: flex;
	align-items: center;
	justify-content: space-between;
	padding: 0;
}

/* 검색창 */
.search>form input[type=text] {
	width: 240px;
	margin: 0 15px;
}

.search>form input[type=submit] {
	width: 100px;
	margin: 0;
}

.form-control {
	margin-right: 30px;
}

/* 주문버튼 */
.btnorder {
	width: 100px;
	position: relative;
	left: 1430px;
	top: -12px;
}

/* 페이지바 */
.pagebar {
	position: relative;
	left: 550px;
	width: 500px;
}

.pagebar .pagination>.active>a {
	background-color: var(--purple_three);
	color: var(--white);
}

.pagebar .pagination>li>a {
	color: var(--black_main);
}
</style>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
</head>
<body>


	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_order.jsp"%>
			<div class="content">

				<div class="search">
					<form method="GET" action="/order/alllist.do">

						<table style="width: 500px; margin: 20px auto;">
							<tr>
								<td><select name="column" class="form-control">
										<option value="seq_order">주문번호</option>
										<option value="name_kr">메뉴명</option>
								</select></td>
								<td><input type="text" id="text" name="word"
									class="form-control" required></td>
								<td><input type="submit" value="검색하기"
									class="btn btn-default"></td>
								</form>
							</tr>
						</table>
				</div>



				<div class="btnorder">
					<form id="americano" method="POST" action="/order/buttonorder.do">
						<input type="text" name="txtame" value='10101' hidden> <input
							type="text" name="txtamedetail" value='P013' hidden> <input
							type="submit" value="아메리카노" name="ame" class="btn btn-default">
					</form>
				</div>

				<div>
					<table class="table table-bordered" id="table">
						<tr style="background-color: #504B71; color: var(--white);">
							<th style="text-align: center;">주문번호</th>
							<th style="text-align: center;">메뉴명</th>
							<th style="text-align: center;">사이즈</th>
							<th style="text-align: center;">총결제가</th>
							<th style="text-align: center;">주문시간</th>
							<th style="text-align: center;">완료시간</th>
							<th style="text-align: center;">수량</th>
							<th style="text-align: center;">환불여부</th>
							<th style="text-align: center;">비고</th>
						</tr>
						<c:forEach items="${listall}" var="dto">
							<c:if test="${ dto.end_order == null }">
								<tr style="background-color: #C6DDC7;">
									<td style="width: 200px; text-align: center;">${dto.seq_order}</td>
									<td style="width: 200px;">${dto.name_kr}</td>
									<td style="width: 100px; text-align: center;">${dto.seq_size}</td>
									<td style="width: 150px; text-align: right;">${dto.total}원</td>
									<td style="width: 250px; text-align: center;">${dto.start_order}</td>
									<td style="width: 250px; text-align: center;">${dto.end_order}진행중</td>
									<td style="width: 100px; text-align: right;">${dto.count}</td>
									<td style="width: 100px; text-align: center;">${dto.refund}</td>
									<td style="text-align: center;"></td>
								</tr>
							</c:if>

							<c:if test="${ dto.end_order != null }">
								<tr>
									<td style="width: 200px; text-align: center;">${dto.seq_order}</td>
									<td style="width: 200px;">${dto.name_kr}</td>
									<td style="width: 100px; text-align: center;">${dto.seq_size}</td>
									<td style="width: 150px; text-align: right;">${dto.total}원</td>
									<td style="width: 250px; text-align: center;">${dto.start_order}</td>
									<td style="width: 250px; text-align: center;">${dto.end_order}</td>
									<td style="width: 100px; text-align: right;">${dto.count}</td>
									<td style="width: 100px; text-align: center;">${dto.refund}</td>
									<td style="text-align: center;"></td>
								</tr>
							</c:if>


						</c:forEach>
					</table>
				</div>
				<div class="pagebar">${pagebar}</div>
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
