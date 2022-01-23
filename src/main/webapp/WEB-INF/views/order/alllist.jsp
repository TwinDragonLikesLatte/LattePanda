<%@page import="com.test.main.order.ListDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>주문관리: 진행중</title>
    <style>
    </style>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>


<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_order.jsp" %>
        <div class="content">
        
        <div class="search">
				<form method="GET" action="/order/alllist.do">
				<table style="width:500px;margin:20px auto;">
					<tr>
						<td>
							<select name="column" class="form-control">
								<option value="new">최신순</option>
								<option value="old">오래된순</option>
							</select>
						</td>
						<td>
							<input type="text" name="word" class="form-control" required>
						</td>
						<td>
							<input type="submit" value="검색하기" class="btn btn-default">
						</td>
						
					</tr>
				</table>
				</form>
			</div>	
			
			<%-- <c:forEach items="${listall}" var="dto">
	            <table class="table table-bordered" style="width: 304px; height: 220px">
	            	<tr>
	            		<th>주문번호</th>
	            		<th>메뉴명</th>
	            		<th>총결제가(원)</th>
	            		<th>주문진행상태</th>
	            		<th>주문시간</th>
	            		<th>완료시간</th>
	            		<th>비고</th>
	            	</tr>
	            	<tr>
						<td>${dto.detail}</td>
						<td>${dto.name_kr}</td>
						<td>${dto.total}</td>
						<td>주문진행상태</td>
						<td>${dto.start_order}</td>
						<td>${dto.end_order}</td>
						<td></td>
					</tr>	
	            </table>
      		</c:forEach> --%>
      		<c:if test="${map.searchmode == 'y'}">
			<div style="text-align:center;margin:10px;color:#777;">'${map.word}'(으)로 검색한 ${listall.size()}개의 주문이 있습니다.</div>
			</c:if>
   			<table class="table table-bordered" style="width:1500px">
   				<tr>
   					<th>주문번호</th>
   					<th>메뉴명</th>
   					<th>총결제가</th>
   					<th>주문진행상태</th>
   					<th>주문시간</th>
   					<th>완료시간</th>
   					<th>비고</th>
   				</tr>
      		<c:forEach items="${listall}" var="dto">
      				<tr>
      					<td>${dto.detail}</td>
      					<td>${dto.name_kr}</td>
      					<td>${dto.total}원</td>
      					<td>수정중</td>
      					<td>${dto.start_order}</td>
      					<td>${dto.end_order}</td>
      					<td></td>
      				</tr>
      		</c:forEach>
      		</table>
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
