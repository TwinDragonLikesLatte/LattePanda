<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%
if (session.getAttribute("seq_position").equals("6")) {
	response.sendRedirect("/notice/board.do");
} else if (session.getAttribute("seq_position").equals("5")) {
	response.sendRedirect("/notice/board.do");
}

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>홈</title>
<%@ include file="/WEB-INF/inc/asset.jsp"%>
	<link rel="stylesheet" href="/asset/css/home/dashboard.css">
	<script src="/asset/js/lib/highcharts.js"></script>
</head>
<body>

	<div class="container">
		<%@ include file="/WEB-INF/inc/header.jsp"%>
		<main>
			<%@ include file="/WEB-INF/inc/sub-nav_home.jsp"%>
			<div class="content">

				<!-- 점장화면 -->
				<!-- DashBoard.java에서 보낸 세션값을 이용해 화면에 표시될 차트 구분 -->
				<!-- 지점의 부서번호는 300000 이상이며 부서의 점장 번호는 8 이다. -->
				<c:if test="${ seq_department > 300000 && seq_position == 8}">
					<div class="dashboard_content_container">
						<!-- [점장] 당일 총 판매액 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">당일 총 판매액</div>
							<div class="dashboard_content_font">
								<p>당일 판매액</p>
								<p class="dashboard_total">
									<fmt:formatNumber value="${total}" pattern="#,###,###,###" />
									원
								<p>
							</div>

							<!-- [점장] 월간 총 판매액 차트 -->
							<div class="dashboard_content_chart">
								<p>
									월간 총 판매액<small>단위(원)</small>
								</p>
								<figure class="dashboard_highcharts-figure">
									<div id="dashbaord_container"></div>
								</figure>
							</div>
						</div>

						<!-- [점장] 당일 상품별 총 판매 비율 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">당일 상품별 총 판매 비율</div>
							<!-- [점장] 당일 상품별 총 판매 비율 그래프 -->
							<div class="dashboard_content_graph">
								<figure class="highcharts-figure2">
									<div id="dashboard_graph"></div>
								</figure>
							</div>
						</div>
						<!-- [점장] 공지사항 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">
								<a class="dash_notice_head" href="/notice/board.do">공지사항</a>
							</div>
							<div class="dashboard_notice">
								<table class="table table-bordered daily_sales">
									<c:forEach items="${notice}" var="dto" end="9">
										<tr>
											<td><a class="dash_notice_title"
												href="/notice/view.do?seq=${dto.seq_notice}">${dto.title}</a></td>
											<td><small>${dto.content}</small></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
						<!-- [점장] 근무 스케줄 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">근무 스케줄</div>
							<div class="schedule">
								<table class="table table-bordered w-auto board_schedule">
									<!-- 일단 대시보드 기능, 매장관리 완성 후 테이블 수정 예정 -->
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
									<%-- <c:forEach items="${employeeschedule}" var="dto">
										<tr>
											<td>${dto.name}</td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
											<td></td>
										</tr>
									</c:forEach> --%>
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
												<td></td>
												<td></td>
												<td></td>
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
												<td></td>
												<td></td>
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
												<td></td>
												<td></td>
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
						<!-- [점장] 재고 상황 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">재고 상황</div>
							<div class="dashboard_remain_product">
								<table class="table table-bordered remain_product">
									<tr>
										<td>재고명</td>
										<td>재고 수량</td>
									</tr>
									<c:forEach items="${ stockremain }" var="dto" end="8">
										<tr>
											<td>${dto.name }</td>
											<td><fmt:formatNumber value="${dto.quantity}"
													pattern="#,###,###,###" /></td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>

				</c:if>

				<!-- 지역장화면 -->
				<!-- DashBoard.java에서 보낸 세션값을 이용해 화면에 표시될 차트 구분 -->
				<!-- 지점 이상의 부서번호는 300000 이하이며 부서의 점장 외 직급의 번호는 8 이하이다. -->
				<c:if test="${seq_department < 300000 && seq_position < 8}">
					<div class="dashboard_content_container">
						<!-- [지역장] 지역내 지점별 당일 판매 현황 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">
								지역내 지점별 당일 판매 현황
								<!-- 지점 선택시 GET방식으로 Dashboard.java로 값 이동 기본값 10101-->
								<form method="GET" action="/home/dashboard.do"
									class="dashboard-select">
									<!-- 지역장 번호에 따라 다르게 표시하는 기능은 미구현 -->
									<select name="store" class="dashboard_button">
										<option value="10101" selected>강남대로점</option>
										<option value="10102">대치점</option>
										<option value="10103">선릉점</option>
									</select> <input type="submit" class="btn btn-primary" value="이동하기">
								</form>
							</div>
							<!-- [지역장] 지역내 지점별 당일 판매 현황 그래프 -->
							<div class="dashboard_content_graph">
								<figure class="dashboard_highcharts-figure3">
									<div id="dashboard_graph2"></div>
								</figure>
							</div>
						</div>
						<!-- [지역장] 지점별 당일 총 판매액 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">당일 총 판매액</div>
							<div class="dashboard_content_font_nm">
								<p>당일 판매액</p>
								<p class="areatotal_nm">
									<fmt:formatNumber value="${areatotal}" pattern="#,###,###,###" />
									원
								<p>
							</div>
						</div>
						<!-- [지역장] 전지역 매출 현황 섹션 -->
						<!-- 다른 지점에 대한 매출값이 없어 확인 불가능 데이터 추가시 표시될 것으로 예상-->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">전지역 매출 현황</div>
							<div class="dashboard_content_chart">
								<p>
									월간 총 판매액<small>단위(원)</small>
								</p>
								<figure class="dashboard_highcharts-figure4">
									<div id="dashboard_container2"></div>
								</figure>
							</div>
							
						</div>
						<!-- [지역장] 전지점 상품별 월간 판매량 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">전지점 상품별 월간 판매량</div>
							<div class="area_prod">
								<!-- [지역장] 전지점 상품별 월간 판매량 차트 -->
								<figure class="dashboard_highcharts-figure">
									<div id="dashboard_container3"></div>
								</figure>
							</div>
						</div>
						<!-- [지역장] 공지사항 섹션 -->
						<div class="dashboard_content_gird">
							<div class="dashboard_content_header">
								<a class="dash_notice_head" href="/notice/board.do">공지사항</a>
							</div>
							<div class="dashboard_notice">
								<table class="table table-bordered daily_sales">
									<c:forEach items="${notice}" var="dto" end="9">
										<tr>
											<td><a class="dash_notice_title"
												href="/notice/view.do?seq=${dto.seq_notice}">${dto.title}</a></td>
											<td>${dto.content}</td>
										</tr>
									</c:forEach>
								</table>
							</div>
						</div>
					</div>

				</c:if>
			</div>

		</main>
	</div>

	<script>
	/* 직급 번호가 매니저(9), 사원(6), 대리(5) 인 경우 대시보드 열람 권한이 없어 진입 시도시 공통 페이지인 공지사항으로 이동한다. */
/* 	<c:if test="${ seq_position == 6 || seq_position == 5 || seq_position == 9}">
		alert("권한이 없습니다.");
		location.href = '/notice/board.do';
	</c:if> */
	
	/* HighCharts 컬럼 색상 나열 */
	Highcharts.setOptions({
	    colors: ['#62569F', '#4E387E', '#614051', '#5E5A80', '#6A287E', '#7D1B7E', '#A74AC7',
	'#B048B5', '#6C2DC7', '#842DCE', '#8D38C9', '#7A5DC7', '#7F38EC', '#8E35EF', '#893BFF', '#8467D7', '#A23BEC', '#B041FF', '#C45AEC', '#9172EC']
	});
	
	/* 지점의 부서번호는 300000 이상이며 부서의 점장 번호는 8 이다.  */
	<c:if test="${ seq_department > 300000 && seq_position == 8}">
	
	/* [점장] 월간 총판매액 차트 */
		Highcharts.chart('dashbaord_container', {
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
		        name: '월 매출(년월)',
		        data: [
		        	<c:forEach items="${list}" var="dto">
		        	${dto.montotal}, 
		        	</c:forEach>
		        	]
		    }]
		});
		
		<!-- [점장] 당일 상품별 총 판매 비율 그래프 -->
		Highcharts.chart('dashboard_graph', {
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
	
		<!-- 지점 이상의 부서번호는 300000 이하이며 부서의 점장 외 직급의 번호는 8 이하이다. -->
		<c:if test="${ seq_department < 300000 && seq_position < 8}">
		
	<!-- [지역장] 지역내 지점별 당일 판매 현황 그래프 -->
	Highcharts.chart('dashboard_graph2', {
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
	
	<!-- [지역장] 지점별 월간 총 판매액 차트 -->
	Highcharts.chart('dashboard_container2', {
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
	             '❚ ${dto.start_order}',
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
	        name: '월 매출 (년월)',
	        data: [
	        	<c:forEach items="${areamontotal}" var="dto">
	        	${dto.montotal}, 
	        	</c:forEach>
	        	]
	    }]
	});

	
	<!-- [지역장] 전지점 상품별 월간 판매량 차트 -->
	Highcharts.chart('dashboard_container3', {
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
	
	</c:if>
	
</script>

</body>
</html>
