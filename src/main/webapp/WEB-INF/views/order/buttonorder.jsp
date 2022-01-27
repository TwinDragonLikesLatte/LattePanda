<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>title</title>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_order.jsp"%>
			<!-- 본인 파트 서브내비로 바꾸세요. -->
			<div class="content">






			</div>
		</main>

	</div>

	<script>
		<c:if test="${resultorder == 1}">
		//성공
		//alert('성공');
		location.href = '/order/alllist.do';
		</c:if>

		/* <c:if test="${resultorder == 0}">
		 //실패
		 alert('주문실패 다시시도하세요.');
		 history.back();
		 </c:if>

		 <c:if test="${resultdetail == 1}">
		 //성공
		 //alert('성공');
		 location.href = '/order/alllist.do';
		 </c:if>

		 <c:if test="${resultdetail == 0}">
		 //실패
		 alert('주문실패 다시시도하세요.');
		 history.back();
		 </c:if>  */
	</script>

</body>
</html>
