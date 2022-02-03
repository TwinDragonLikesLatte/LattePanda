<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script>
	<c:if test="${result == 1}">
	//성공
	location.href = '/stock/order/list.do';
	</c:if>
	
	<c:if test="${result == 0}">
	//실패
	alert('failed');
	history.back();
	</c:if>
	
	</script>
</body>
</html>