<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>주문관리: 진행중</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
	<style>
		table {
			float: left;
			margin: 0;			
		}
	</style>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_order.jsp" %>
        <div class="content">

           	<c:forEach items="${list}" var="dto">
	            <table class="table table-bordered" style="width: 304px; height: 220px">
	            	<tr>
	            		<th>주문번호</th>
	            	</tr>
	            	<tr>
						<td>${dto.start_order}</td>
					</tr>
					<tr>
						<td>
						${dto.name_kr} ${dto.seq_size} ${dto.count}<br>
						${dto.name_kr} ${dto.seq_size} <!--?????  -->
						</td>
					</tr>	
					<tr>
						<td>총 주문 금액 ${dto.total}원</td>
					</tr>	
	            </table>
      		</c:forEach>
            <div class="pagebar">${pagebar}</div>
            

        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
