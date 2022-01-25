<%@page import="com.test.main.order.ListDAO"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>주문관리: 진행중</title>
    <style>
    
  /*   .table #table {
    	width:1500px; 
    	height: 500px;
       	overflow:scroll;
    } */
    
    .search {
    	width: 500px;
    	position: relative;
    	top: 40px;
    	
    }
    
    
    
    .btnorder {
    	width: 200px;
    	/* background-color : gold; */
    	position: relative;
    	
    	left: 1300px;
    	top: -12px;
    }
    
    #id {
    	margin-right: 5px;
    }
    
    .pagebar {
    	position: relative;
    	left: 550px;
    	/* background-color : gold; */
    	width: 500px;
    
    }
    
    .pagebar .pagination > .active > a {
    	background-color: var(--purple_three);
    	color: var(--white);
    }
    
    .pagebar .pagination > li > a {
    	color: var(--black_main);
    }
    
    
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
							<input type="text" id="text" name="word" class="form-control" required>
						</td>
						<td>
							<input type="submit" value="검색하기" class="btn btn-default">
						</td>
				</form>
					</tr>
				</table>
			</div>	


			<div class="btnorder">
				<form method="GET" action="/order/buttonorder.do">
							<input type="button" value="아메리카노" name="ame" class="btn btn-default">
							<input type="button" value="라떼" name="latte" class="btn btn-default">
				</form>
			</div>

<%--       		<c:if test="${map.searchmode == 'y'}">
			<div style="text-align:center;margin:10px;color:#777;">'${map.word}'(으)로 검색한 ${listall.size()}개의 주문이 있습니다.</div>
			</c:if> --%>
			<div>
   			<table class="table table-bordered"  id="table" >
   				<tr style="background-color : #504B71; color : var(--white);" >
   					<th style="text-align: center;">주문번호</th>
   					<th style="text-align: center;">메뉴명</th>
   					<th style="text-align: center;">총결제가</th>
   					<th style="text-align: center;">주문시간</th>
   					<th style="text-align: center;">완료시간</th>
   					<th style="text-align: center;">수량</th>
   					<th style="text-align: center;">환불여부</th>
   				</tr>
      		<c:forEach items="${listall}" var="dto">
      				<tr>
      					<td style="width: 100px; text-align: center;">${dto.detail}</td>
      					<td style="width: 300px;">${dto.name_kr}</td>
      					<td style="width: 300px; text-align: right;">${dto.total}원</td>
      					<td style="text-align: center;">${dto.start_order}</td>
      					<td style="text-align: center;">${dto.end_order}</td>
      					<td style="width: 100px; text-align: right;">${dto.count}</td>
      					<td style="text-align: center;">${ dto.refund}</td>
      				</tr>
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
