
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>스태프조회</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/asset/css/lib/bootstrap-datepicker.standalone.css">
    <script src="<%= request.getContextPath() %>/asset/js/lib/bootstrap-datepicker.js"></script>
    <link rel="stylesheet" href="/asset/css/hr/staff/paystub.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_hr.jsp" %>
        <div class="content">
            <section class="list">
                <div class="section-header">
                    <span class="sub-title">급여조회</span>
                    <div>
                        <div class="select-wrap">
                            <select name="year">
                                <option value="2021">2021년</option>
                                <option value="2022">2022년</option>
                            </select>
                        </div>
                        <div class="select-wrap">
                            <select name="month">
                                <option value="1">1월</option>
                                <option value="2">2월</option>
                                <option value="3">3월</option>
                                <option value="4">4월</option>
                                <option value="5">5월</option>
                                <option value="6">6월</option>
                                <option value="7">7월</option>
                                <option value="8">8월</option>
                                <option value="9">9월</option>
                                <option value="10">10월</option>
                                <option value="11">11월</option>
                                <option value="12">12월</option>
                            </select>
                        </div>
                        <input type="button" class="btn btn-primary" value="조회">
                        <input type="button" class="btn btn-default" value="프린트">
                    </div>
                </div>
                <form>
                    <table class="table">
                        <thead>
                        <tr>
                            <th rowspan="2">스태프번호</th>
                            <th rowspan="2">이름</th>
                            <th rowspan="2">총근무시간</th>
                            <th rowspan="2">전체급여</th>
                            <th rowspan="2">실수령액</th>
                            <th colspan="4">급여상세</th>
                            <th colspan="5">공제내역</th>
                        </tr><tr>
                            <th>기본급</th>
                            <th>주휴수당</th>
                            <th>초과수당</th>
                            <th>야간수당</th>
                            <th>근로소득세</th>
                            <th>지방소득세</th>
                            <th>국민연금</th>
                            <th>건강보험</th>
                            <th>고용보험</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${list}" var="dto">
                            <tr>
                                <td>${dto.seqStaff}</td>
                                <td>${dto.name}</td>
                                <td><fmt:formatNumber value="${dto.time / 60}" pattern=".0"/></td>
                                <td><fmt:formatNumber value="${dto.total}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.real}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.basic}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.holiday}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.over}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.night}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.incomeTax}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.localTax}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.gukmin}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.gungang}" pattern="#,###"/></td>
                                <td><fmt:formatNumber value="${dto.goyong}" pattern="#,###"/></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </form>
            </section>
        </div>
    </main>

</div>

<script>

    $('select').on({
        change: function() {
            alert();
        }
    })
    
</script>

</body>
</html>
