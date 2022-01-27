<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>주문관리: 진행중</title>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
<style>
#box {
	width: 304px;
	height: 300px;
	border: 1px solid #BEBEBE;
}

.box {
	float: left;
	background-color: var(--white);
}

p {
	color: white;
	font-size: 24px;
	text-align: center;
	position: relative;
	top: 8px;
}

#menudetail {
	position: relative;
	top: 30px;
	left: 15px;
}

#menudetail div:nth-child(1) {
	margin-bottom: 30px;
}

#menudetail div:nth-child(2) {
	margin-bottom: 50px;
	width: 85%;
	float: left;
}

#menudetail div:nth-child(3) {
	margin-bottom: 100px;
}

#price {
	clear: both;
	position: relative;
	left: 222px;
}
</style>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_order.jsp"%>
			<div class="content">

				<div>
					<c:forEach items="${list}" var="dto">
						<div id="box" class="box">
							<div id="boxcontainer">
								<div id="seq" style="background-color: #504B71; height: 50px;">
									<p>${dto.rnum}
									<p>
								</div>

								<div id="menudetail">
									<div>${dto.start_order}</div>
									<div>${dto.name_kr}${dto.seq_size}</div>
									<div>${dto.count}</div>
									<div id="price">${dto.total}원</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>

			</div>
		</main>

	</div>

	<script>
		
	</script>

</body>
</html>
