<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%
if (request.getAttribute("seq_position").equals("8")) {
	response.sendRedirect("/notice/board.do");
} else if (request.getAttribute("seq_position").equals("9")) {
	response.sendRedirect("/notice/board.do");
} else if (request.getAttribute("seq_position").equals("6")) {
	response.sendRedirect("/notice/board.do");
} else if (request.getAttribute("seq_position").equals("5")) {
	response.sendRedirect("/notice/board.do");
}
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>title</title>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_store.jsp"%>
			<!-- 본인 파트 서브내비로 바꾸세요. -->
			<div class="content">
				<div class="netprofit_content_container">
					<div class="netprofit_content_grid">
						<div class="netprofit_content_header">전 매장 영업이익별 순위</div>
						<div class="netprofit_select">
							<table class="table table-bordered storeprofit">
								<tr class="active">
									<td>매장명</td>
									<td>영업이익</td>
								</tr>
								<c:forEach items="${ storeprofit }" var="dto">
									<tr>
										<td>${dto.name}</td>
										<td><fmt:formatNumber value="${dto.operatingprofit}"
												pattern="#,###,###,###" />
											<form method="GET" action="/store/netprofit/operating.do"
												class="store-select">
												<button type="submit" name="store"
													class="btn btn-primary store_button"
													value="${dto.seq_store}">선택</button>
											</form></td>
									</tr>
								</c:forEach>
								<tr>
									<td>홍대대학로점</td>
									<td>6,350,700
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>명동점</td>
									<td>6,306,200
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>신당점</td>
									<td>6,154,530
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>종로2가점</td>
									<td>5,835,980
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>동묘앞점</td>
									<td>5,513,700
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>강남점</td>
									<td>5,483,200
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>을지로입구역점</td>
									<td>5,245,800
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>혜화역점</td>
									<td>4,994,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>약수역점</td>
									<td>4,984,500
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>시청역점</td>
									<td>4,960,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>세종로점</td>
									<td>4,950,500
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>신설동역점</td>
									<td>4,530,200
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>왕십리역점</td>
									<td>4,413,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>서울스퀘어점</td>
									<td>3,583,040
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>

							</table>
						</div>
					</div>
					<div class="netprofit_content_grid">
						<div class="netprofit_content_header">선택 매장 지출 비율</div>
						<div class="netprofit_content_graph">
							<figure class="netprofit_highcharts-figure">
								<div id="netprofit_container"></div>

							</figure>
						</div>
					</div>
				</div>

			</div>
		</main>

	</div>

	<script>
	Highcharts.chart('netprofit_container', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie',
	        backgroundColor: '#f5f5f5',
	    },
	    title: {
	    	<c:forEach items="${profitvalues}" var="dto">
	        text: '${dto.name}'
	        </c:forEach>
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
	        name: '항목',
	        colorByPoint: true,
	        data: [
	        	<c:forEach items="${profitvalues}" var="dto">
	        	{
		            name: '영업이익',
		            y: ${dto.operatingprofit},
	        	}, 
	        	{
		            name: '매출액',
		            y: ${dto.sales},
	        	},
	        	{
		            name: '매출원가',
		            y: ${dto.cost_of_sales},
	        	},
	        	{
		            name: '관리비',
		            y: ${dto.administration_cost},
	        	},
	        	{
		            name: '판매액',
		            y: ${dto.sale_fee},
	        	}
	        	</c:forEach>
	        ]
	    }]
	});
	</script>

</body>
</html>
