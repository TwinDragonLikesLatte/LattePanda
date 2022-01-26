<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>재고 조회</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<style>
table{
	width: 1520px;
	display: block;
	text-align: center;
	vertical-align: middle;
	overflow: auto;
	overflow-x:hidden;
}

.table > thead > tr > th {vertical-align: middle; text-align: center; height: 20px;}
.table > tbody > tr > td {vertical-align: middle;}

td > input[type="text"]{
	padding: 0;
	text-align: center;
}

tbody {
    height: 700px;
    display: inline-block;
    width: 1520px;
}


.column1{width: 100px;}/* 번호 */
.column2{width: 180px;}/* 이름 */
.column3{width: 110px;}/* 구분 */
.column4{width: 130px; }/* 단위 */
.column5{width: 800px; }
.column6{width: 180px;}

.column5-sub{width: 200px;}

.bg-purple{background: var(--purple_four); color: var(--white);}

</style>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_stock.jsp" %>
			<div class="content">
			<form method="post" action="/stock/list/editok.do" autocomplete="off">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th class="column1" rowspan="2">번호</th>
							<th class="column2" rowspan="2">이름</th>
							<th class="column3" rowspan="2">구분</th>
							<th class="column4" rowspan="2">단위</th>
							<th class="column5 bg-purple" colspan="4">수량</th>
							<th class="column6" rowspan="2">비고</th>
						</tr>
						<tr>
							<th class="column5-sub bg-purple">장부수량</th>
							<th class="column5-sub bg-purple">실수량</th>
							<th class="column5-sub bg-purple">폐기량</th>
							<th class="column5-sub bg-purple">차이</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td class="column1">${dto.seq_stock}</td>
							<td class="column2">${dto.name}</td>
							<td class="column3">${dto.types}</td>
							<td class="column4">${dto.unit}</td>
							<td class="column5-sub">${dto.pre_quantity}</td>
							<td class="column5-sub"><input type="text" class="form-control" name="quantity" value="${dto.quantity}"></td>
							<td class="column5-sub"><input type="text" class="form-control" name="waste" value="${dto.waste}" ></td>
							<td class="column5-sub"><input type="text" class="form-control" value="${dto.pre_quantity-dto.quantity-dto.waste}" disabled="disabled"></td>
							<td class="column6"><input type="text" class="form-control" name="etc" value="${dto.etc}"></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
	
				<div style="float: right;">
				<input type="submit" class="btn btn-primary" value="등록하기">
				<!-- <input type="button" class="btn btn-default" value="저장하기" onclick="location.href='/stock/list/editok.do';"> -->
				<input type="button" class="btn btn-danger" value="취소하기" onclick="history.back()">
				</div>
				<input type="hidden" value="${dto.seq_store}" name="seq_store">
				</form>
			</div>
		</main>

</div>

<script>

</script>

</body>
</html>
