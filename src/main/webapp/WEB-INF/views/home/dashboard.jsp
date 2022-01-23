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
<!-- 점장화면 -->
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
					
					<div class="content_font"><p>당일 판매액</p><p class="total">${total} 원<p></div>
					<!-- 당일 판매액이니 현재 DAO 에 있는 sql 쿼리 내 DATE 관련 줄을 CURRENT_DATE로 바꾸면 되지 않을까 -->
					
					<div class="content_chart"><p>월간 총 판매액<small>단위(원)</small></p>
						<figure class="highcharts-figure">
						    <div id="container"></div>
						</figure>
					</div>
				</div>
				<div class="content_gird">
					<div class="content_header">당일 상품별 총 판매량</div>
					<div class="content_graph">
						<figure class="highcharts-figure2">
    					<div id="graph"></div>
						</figure>
					</div>
				</div>
				<div class="content_gird">
					<div class="content_header">공지사항</div>
					<table class="table table-bordered daily_sales">
						<c:forEach items="${notice}" var="dto" end="9">
							<tr>
								<td>${dto.title}</td>
								<td>${dto.content}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div class="content_gird">
					<div class="content_header">근무 스케줄</div>
					<div class="schedule">

					</div>
				</div>
				<div class="content_gird">
					<div class="content_header">재고 상황</div>
					<table class="table table-bordered remain_product">
						<tr>
							<td>재고명</td>
							<td>재고 수량</td>
						</tr>
						<c:forEach items="${ stockremain }" var="dto" end="9">
							<tr>
								<td>${dto.name }</td>
								<td>${dto.quantity }</td>
							</tr>
						</c:forEach>
					</table>
				</div>      
				<div class="content_gird"></div>   	
            </div>
            
            </c:if>
<!-- 지역장화면 -->
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
	 		<c:forEach items="${list}" var="dto">
	            '${dto.start_order}',
	        </c:forEach>
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
	        data: [
	        	<c:forEach items="${list}" var="dto">
	        	${dto.montotal}, 
	        	</c:forEach>
	        	]
	    }]
	});
	
	Highcharts.chart('graph', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie'
	    },
	    title: {
	        text: ''
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    accessibility: {
	        point: {
	            valueSuffix: '%'
	        }
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            dataLabels: {
	                enabled: false
	            },
	            showInLegend: true
	        }
	    },
	    series: [{
	        name: '판매량',
	        colorByPoint: true,
	        data: [
	        	
	        	<c:forEach items="${prod}" var="dto">
				{
					name: '${dto.name_kr}',
			        y: ${dto.sum}
			    },
        		</c:forEach>
	            //sliced: true,
	            //selected: true
	            
	        ]/* , {
	            name: 'Internet Explorer',
	            y: 11.84
	        }, {
	            name: 'Firefox',
	            y: 10.85
	        }, {
	            name: 'Edge',
	            y: 4.67
	        }, {
	            name: 'Safari',
	            y: 4.18
	        }, {
	            name: 'Other',
	            y: 7.05
	        }] */
	    }]
	});
</script>

</body>
</html>
