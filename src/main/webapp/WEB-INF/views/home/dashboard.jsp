<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_home.jsp" %>
        <div class="content"> 

            <c:if test="${empty id}">

            <!-- <div>
                버튼예제<br>
                <input type="button" class="btn btn-primary" value="등록하기">
                <input type="button" class="btn btn-danger" value="취소하기">
                <input type="button" class="btn btn-default" value="목록보기">
            </div> -->
            <div class="content_container">
				<div class="content_gird">
					<div class="content_header">당일 총 판매액</div>
					
					<div class="content_font"><p>당일 판매액</p><p>${total}<p></div>
					<!-- 당일 판매액이니 현재 DAO 에 있는 sql 쿼리 내 DATE 관련 줄을 CURRENT_DATE로 바꾸면 되지 않을까 -->
					
					<div class="content_chart"><p>월간 총 판매액<small>단위(만원)</small></p>
						<figure class="highcharts-figure">
						    <div id="container"></div>
						</figure>
					</div>
				</div>
				<div class="content_gird">
					<div class="content_header">당일 상품별 총 판매량</div>
					<div class="content_graph"></div>
				</div>
				<div class="content_gird">
					<div class="content_header">공지사항</div>
					<table class="daily_sales">
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
					</table>
				</div>
				<div class="content_gird">
					<div class="content_header">근무 스케줄</div>
					<div class="schedule"></div>
				</div>
				<div class="content_gird">
					<div class="content_header">재고 상황</div>
					<table class="remain_product">
						<tr>
							<td>번호</td>
							<td>재고명</td>
							<td>재고 수량</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>      
				<div class="content_gird"></div>   	
            </div>
            
            </c:if>
            
            <c:if test="${not empty id}">

            <!-- <div>
                버튼예제<br>
                <input type="button" class="btn btn-primary" value="등록하기">
                <input type="button" class="btn btn-danger" value="취소하기">
                <input type="button" class="btn btn-default" value="목록보기">
            </div> -->
            <div class="content_container">
				<div class="content_gird">
					<div class="content_header">당일 총 판매액</div>
					<div class="content_font"><p>당일 판매액</p><p>????<p></div>
					<div class="content_chart"><p>월간 총 판매액<small>단위(만원)</small></p></div>
				</div>
				<div class="content_gird">
					<div class="content_header">당일 상품별 총 판매량</div>
					<div class="content_graph"></div>
				</div>
				<div class="content_gird">
					<div class="content_header">공지사항</div>
					<table class="daily_sales">
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
						<tr>
							<td>공지사항</td>
						</tr>
					</table>
				</div>
				<div class="content_gird">
					<div class="content_header">근무 스케줄</div>
					<div class="schedule"></div>
				</div>
				<div class="content_gird">
					<div class="content_header">재고 상황</div>
					<table class="remain_product">
						<tr>
							<td>번호</td>
							<td>재고명</td>
							<td>재고 수량</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>      
				<div class="content_gird"></div>   	
            </div>
            
            </c:if>
        </div>
    </main>

</div>

<script>
	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: ''
	    },

	    xAxis: {
	        categories: [
	            'Jan',
	            'Feb',
	            'Mar',
	            'Apr',
	            'May',
	            'Jun',
	            'Jul',
	            'Aug',
	            'Sep',
	            'Oct',
	            'Nov',
	            'Dec'
	        ],
	        
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: ''
	        }
	    },
	    series: [{
	        name: '월 매출',
	        data: [49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4]
	    }]
	});
</script>

</body>
</html>
