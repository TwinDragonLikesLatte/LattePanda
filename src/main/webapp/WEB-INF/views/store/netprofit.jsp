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
	<link rel="stylesheet" href="/asset/css/store/store.css">
	<script src="/asset/js/lib/highcharts.js"></script>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_store.jsp"%>
			<div class="content">
				<div class="netprofit_content_container">
					<div class="netprofit_content_grid">
						<div class="netprofit_content_header">전 매장 순수익별 순위</div>
						<div class="netprofit_select">
							<table class="table table-bordered storeprofit">
								<tr>
									<td>매장명</td>
									<td>순이익</td>
								</tr>
								<c:forEach items="${ storeprofit }" var="dto">
									<tr>
										<td>${dto.name}</td>
										<td><fmt:formatNumber value="${dto.netprofit}"
												pattern="#,###,###,###" />
											<form method="GET" action="/store/netprofit/net.do"
												class="store-select">
												<button type="submit" name="store"
													class="btn btn-primary store_button"
													value="${dto.seq_store}">선택</button>
											</form></td>
									</tr>
								</c:forEach>
								<tr>
									<td>홍대대학로점</td>
									<td>2,350,700
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>명동점</td>
									<td>2,306,200
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>신당점</td>
									<td>2,154,530
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>종로2가점</td>
									<td>2,135,980
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>동묘앞점</td>
									<td>2,113,700
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>강남점</td>
									<td>2,083,200
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>을지로입구역점</td>
									<td>2,045,800
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>혜화역점</td>
									<td>1,994,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>약수역점</td>
									<td>1,984,500
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>시청역점</td>
									<td>1,960,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>세종로점</td>
									<td>1,950,500
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
									<td>1,913,400
										<button type="submit" name="store"
											class="btn btn-primary store_button">선택</button>
									</td>
								</tr>
								<tr>
									<td>서울스퀘어점</td>
									<td>1,583,040
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
						<p class="netprofit_total">
								총 매출액
								<c:forEach items="${profitvalues}" var="dto">
									<fmt:formatNumber value="${dto.sales}" pattern="#,###,###,###" />
								</c:forEach>
							</p>
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
	        </c:forEach>,
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
		            name: '원재료',
		            y: ${dto.cost_of_sales},
	        	}, 
	        	{
		            name: '인건비',
		            y: ${dto.sale_fee},
	        	},
	        	{
		            name: '임차료',
		            y: ${dto.rent_fee},
	        	},
	        	{
		            name: '세금',
		            y: ${dto.tax},
	        	},
	        	{
		            name: '순수익',
		            y: ${dto.netprofit},
	        	},
	        	{
		            name: '보험',
		            y: ${dto.insurance},
	        	}
	        	</c:forEach>
	        ]
	    }]
	});
	</script>

</body>
</html>
