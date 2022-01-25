<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>홈</title>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>

		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_home.jsp"%>
			<div class="content">
				<!-- 점장화면 -->
				<c:if test="${empty id}">

					<!-- <div>
                버튼예제<br>
                <input type="submit" class="btn btn-primary" value="등록하기">
                <input type="button" class="btn btn-danger" value="취소하기">
                <input type="button" class="btn btn-default" value="목록보기">
            </div> -->
					<div class="content_container">
						<div class="content_gird">
							<div class="content_header">당일 총 판매액</div>

							<div class="content_font">
								<p>당일 판매액</p>
								<p class="total">${total}원
								<p>
							</div>
							<!-- 당일 판매액이니 현재 DAO 에 있는 sql 쿼리 내 DATE 관련 줄을 CURRENT_DATE로 바꾸면 되지 않을까 -->

							<div class="content_chart">
								<p>
									월간 총 판매액<small>단위(원)</small>
								</p>
								<figure class="highcharts-figure">
									<div id="container"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">당일 상품별 총 판매 비율</div>
							<div class="content_graph">
								<figure class="highcharts-figure2">
									<div id="graph"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">
								<a class="dash_notice_title" href="/notice/board.do">공지사항</a>
							</div>
							<div class="dashboard_notice">
								<table class="table table-bordered daily_sales">
									<c:forEach items="${notice}" var="dto" end="9">
										<tr>
											<td><a class="dash_notice_title"
												href="/notice/board.do?${dto.seq_notice}">${dto.title}</a></td>
											<td><small>${dto.content}</small></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">근무 스케줄</div>
							<div class="schedule">
								<table class="table table-bordered w-auto board_schedule">
									<!-- 어떻게 해야 만들 수 있을까... -->
									<tr>
										<td></td>
										<td>7</td>
										<td>8</td>
										<td>9</td>
										<td>10</td>
										<td>11</td>
										<td>12</td>
										<td>13</td>
										<td>14</td>
										<td>15</td>
										<td>16</td>
										<td>17</td>
										<td>18</td>
										<td>19</td>
										<td>20</td>
										<td>21</td>
										<td>22</td>
										<td>23</td>
									</tr>
									<c:forEach items="${staffschedule}" var="dto">
									<tr>
										<td>${dto.name}</td>
										<c:if test="${dto.hourfrom eq '7'}">
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td><%-- ${dto.hourfrom } --%></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										</c:if>
										<c:if test="${ dto.hourfrom eq '12'}">
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										</c:if>
										<c:if test="${ dto.hourfrom eq '18' }">
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										<td bgcolor="#FF7D7D"></td>
										</c:if>
										
									</tr>
									</c:forEach>
								</table>

							</div>

						</div>
						<div class="content_gird">
							<div class="content_header">재고 상황</div>
							<div class="dashboard_remain_product">
								<table class="table table-bordered remain_product">
									<tr>
										<td>재고명</td>
										<td>재고 수량</td>
									</tr>
									<c:forEach items="${ stockremain }" var="dto" end="8">
										<tr>
											<td>${dto.name }</td>
											<td>${dto.quantity }</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>

				</c:if>
				<!-- 지역장화면 -->
				<c:if test="${not empty id}">

					<div class="content_container">
						<div class="content_gird">
							<div class="content_header">
								지역내 지점별 월간 판매 현황
								<form method="POST" action="/home/dashboard.do"
									class="dashboard-select">
									<select name="store">
										<option value="10101">강남대로점</option>
										<option value="10102">대치점</option>
										<option value="10103">선릉점</option>
									</select> <input type="submit" class="btn btn-primary" value="등록하기">
								</form>
							</div>
							<div class="content_graph">
								<figure class="highcharts-figure3">
									<div id="graph2"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">당일 총 판매액</div>
							<div class="content_font">
								<p>당일 판매액</p>
								<p class="areatotal">${areatotal}원
								<p>
							</div>
							<div class="content_chart">
								<p>
									월간 총 판매액<small>단위(만원)</small>
								</p>
								<figure class="highcharts-figure">
									<div id="container2"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">전지역 매출 현황</div>
							<div class="content_graph">
								<figure class="highcharts-figure4">
									<div id="graph3"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">전지점 상품별 일일 판매량</div>
							<div class="area_prod">
								<figure class="highcharts-figure">
									<div id="container3"></div>
								</figure>
							</div>
						</div>
						<div class="content_gird">
							<div class="content_header">공지사항</div>
							<table class="table table-bordered daily_sales">
								<c:forEach items="${notice}" var="dto" end="9">
									<tr>
										<td><a href="/notice/board.do?${dto.seq_notice}">${dto.title}</a></td>
										<td>${dto.content}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="content_gird"></div>
					</div>

				</c:if>
			</div>
		</main>
	</div>

	<script>
	Highcharts.setOptions({
	    colors: ['#62569F', '#4E387E', '#614051', '#5E5A80', '#6A287E', '#7D1B7E', '#A74AC7',
	'#B048B5', '#6C2DC7', '#842DCE', '#8D38C9', '#7A5DC7', '#7F38EC', '#8E35EF', '#893BFF', '#8467D7', '#A23BEC', '#B041FF', '#C45AEC', '#9172EC']
	});
	<c:if test="${empty id}">
		Highcharts.chart('container', {
		    chart: {
		        type: 'column',
		        backgroundColor: '#f5f5f5',
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
		        type: 'pie',
		        backgroundColor: '#f5f5f5',
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
		       ]
		    }]
		});
		
	</c:if>
	
	
	
	/* 지역장 */
	<c:if test="${not empty id}">
	Highcharts.chart('graph2', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie',
	        backgroundColor: '#f5f5f5'
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
	        	
	        	<c:forEach items="${areaprod}" var="dto">
				{
					name: '${dto.name}',
			        y: ${dto.sum}
			    },
        		</c:forEach>
	            //sliced: true,
	            //selected: true
	            
	        ]
	    }]
	});
	
	
	Highcharts.chart('container2', {
	    chart: {
	        type: 'column',
	        backgroundColor: '#f5f5f5'
	    },
	    title: {
	        text: ''
	    },

	    xAxis: {
	        categories: [
	 		<c:forEach items="${areamontotal}" var="dto">
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
	        	<c:forEach items="${areamontotal}" var="dto">
	        	${dto.montotal}, 
	        	</c:forEach>
	        	]
	    }]
	});
	
	Highcharts.chart('container3', {
	    chart: {
	        type: 'column',
	        backgroundColor: '#f5f5f5'
	    },
	    title: {
	        text: ''
	    },
	    subtitle: {
	        text: ''
	    },
	    xAxis: {
	        type: 'category',
	        labels: {
	            rotation: -45,
	            style: {
	                fontSize: '13px',
	                fontFamily: 'Verdana, sans-serif'
	            }
	        }
	    },
	    yAxis: {
	        min: 0,
	        title: {
	            text: ''
	        }
	    },
	    legend: {
	        enabled: false
	    },
	    tooltip: {
	        pointFormat: ''
	    },
	    series: [{
	        name: '',
	        data: [
	        	<c:forEach items="${areamonsellprod}" var="dto">
					['${dto.name}',${dto.sum}],
        		</c:forEach>
	        ],
	        dataLabels: {
	            enabled: false,
	            rotation: -90,
	            color: '#FFFFFF',
	            align: 'right',
	            format: '{point.y:.1f}', // one decimal
	            y: 10, // 10 pixels down from the top
	            style: {
	                fontSize: '13px',
	                fontFamily: 'Verdana, sans-serif'
	            }
	        }
	    }]
	});
	
	Highcharts.chart('graph3', {
	    chart: {
	        plotBackgroundColor: null,
	        plotBorderWidth: null,
	        plotShadow: false,
	        type: 'pie',
	        backgroundColor: '#f5f5f5'
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
	        	
	        	<c:forEach items="${areaalltotal}" var="dto">
				{
					name: '${dto.seq_store}',
			        y: ${dto.total}
			    },
        		</c:forEach>
	            //sliced: true,
	            //selected: true
	            
	        ]
	    }]
	});
	
	</c:if>
</script>

</body>
</html>
