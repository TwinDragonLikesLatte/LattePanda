<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Latte Panda</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/menu.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_menu.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

            <h1 class="title">판매제품조회</h1>

            <%-- 상단 필터 --%>
            <form method="GET" action="/menu/product/list.do" class="form-control product-filter-box">
                <h2>분류 보기</h2>

                <div>
                    <span>전체보기</span>
                    <input type="radio" name="all" checked><span>전체 메뉴 보기</span>
                </div>

                <div>
                    <span>카테고리</span>
                    <input type="checkbox" name="category" value="커피"><span>커피</span>
                    <input type="checkbox" name="category" value="블렌디드"><span>블렌디드</span>
                    <input type="checkbox" name="category" value="티"><span>티</span>
                    <input type="checkbox" name="category" value="에이드"><span>에이드</span>
                    <input type="checkbox" name="category" value="병음료"><span>병음료</span>
                    <input type="checkbox" name="category" value="아이스크림"><span>아이스크림</span>
                    <input type="checkbox" name="category" value="케익"><span>케익</span>
                    <input type="checkbox" name="category" value="굿즈"><span>굿즈</span>
                </div>

                <div>
                    <span>메뉴공개등급</span>
                    <input type="checkbox" name="open-level" value="판매예정"><span>판매예정</span>
                    <input type="checkbox" name="open-level" value="판매중"><span>판매중</span>
                    <input type="checkbox" name="open-level" value="단종"><span>단종</span>
                </div>

                <div>
                    <span>판매기간</span>
                    <input type="date" name="start-date"><span>-</span>
                    <input type="date" name="end-date">
                </div>

                <div>
                    <div>
                        <span>메뉴명</span>
                        <input type="text" name="search">
                    </div>

                    <input type="submit" class="btn btn-primary" value="검색하기">
                </div>
            </form>


            <%--하단 테이블 --%>
            <div class="menu-table product-table">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>카테고리</th>
                        <th>제품코드</th>
                        <th>메뉴명</th>
                        <th>사이즈</th>
                        <th>원가</th>
                        <th>판매가(원)</th>
                        <th>마진율(%)</th>
                        <th>등록일</th>
                        <th>판매시작일</th>
                        <th>판매종료일</th>
                        <th>메뉴공개등급</th>
                    </tr>
                    </thead>
                    <tbody class="table-hover">
                    <c:forEach items="${list}" var="dto">
                        <tr>
                            <td>${dto.upperCategory}</td>
                            <td>${dto.categoryName}</td>
                            <td>${dto.namekr}</td>
                            <td>${dto.sizeName}</td>
                            <td>${dto.costPrice}</td>
                            <td>${dto.sellingPrice}</td>
                            <td>${dto.costRate}</td>
                            <td>${dto.regDate}</td>
                            <td>${dto.startDate}</td>
                            <td>${dto.endDate}</td>
                            <td>${dto.openLevel}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>
    </main>

</div>

<script>

    /* 전체조회 선택시 > checkbox && 검색값 해제 */
    $('input:radio').click(function(){
        $('input:checkbox').prop('checked', false);
        $('input:text').val('');
        $('input[type="date"]').val("");
    });

    /* checkbox 선택시 > 전체조회 해제 */
    $('input:checkbox').click(function(){
        $('input:radio').prop('checked', false);
    });

    /* text값 존재시 > 전체조회 해제 */
    $('input:text').on("propertychange change keyup paste input", function() {
        $('input:radio').prop('checked', false);
    });

    /* 필터 검색시 > 상태 유지 */
    <c:if test="${filter.filterMode == 'y'}">
        $('input:text').val('${filter.search}');
        $('input:radio').prop('checked', false);
        $('input[name="start-date"]').val('${filter.startDate}');
        $('input[name="end-date"]').val('${filter.endDate}');

        <c:forEach items="${filter.category}" var="cate">
        $('input[value=${cate}').prop('checked', true);
        </c:forEach>

        <c:forEach items="${filter.openLevel}" var="lv">
        $('input[value=${lv}').prop('checked', true);
        </c:forEach>

    </c:if>

    <c:if test="${filter.all == 'on'}">
    $('input:radio').prop('checked', true);
    </c:if>


</script>

</body>
</html>
