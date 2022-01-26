<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Latte Panda</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/menu/menu.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_menu.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

            <h1 class="title">메뉴 조회</h1>

            <%-- 상단 필터 --%>
            <form method="GET" action="/menu/basic/list.do" class="form-control" id="menu-filter">
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
                    <div>
                        <span>메뉴명</span>
                        <input type="text" name="search" class="form-control">
                    </div>

                    <input type="submit" class="btn btn-primary" value="검색하기">
                </div>
            </form>

            <div class="add-btn">
                <input type="button" class="btn btn-primary" value="메뉴등록"
                       onclick="location.href='/menu/basic/add.do';">
            </div>


            <%--하단 테이블 --%>
            <div class="menu-table">
            <table class="table table-hover table-bordered">
                <thead>
                    <tr>
                        <th>상위 카테고리</th>
                        <th>하위 카테고리</th>
                        <th>메뉴코드</th>
                        <th>메뉴명</th>
                        <th>메뉴명(영문)</th>
                        <th>Regular</th>
                        <th>Large</th>
                        <th>1-Size</th>
                        <th>수정</th>
                        <th>제품조회</th>
                    </tr>
                </thead>
                <tbody class="table-hover">
                <c:forEach items="${list}" var="dto">
                    <tr>
                        <td>${dto.upperCategory}</td>
                        <td>${dto.categoryName}</td>
                        <td>${dto.seqMenu}</td>
                        <td>${dto.namekr}</td>
                        <td>${dto.nameEn}</td>
                        <td>${dto.regular}</td>
                        <td>${dto.large}</td>
                        <td>${dto.oneSize}</td>
                        <td>
                            <input type="button" class="btn btn-default" value="수정"
                                onclick="location.href='/menu/basic/edit.do';">
                        </td>
                        <td><input type="button" class="btn btn-default detail-btn" value="제품보기"
                                   onclick="location.href='/menu/basic/detail.do?seqmenu=${dto.seqMenu}';"></td>
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

        <c:forEach items="${filter.category}" var="cate">
            $('input[value=${cate}').prop('checked', true);
        </c:forEach>

    </c:if>

    <c:if test="${filter.all == 'on'}">
        $('input:radio').prop('checked', true);
    </c:if>


/*    $('.detail-btn').click(()=>{
        let temp = event.srcElement;
        alert($(temp).attr('name'));

    });*/


</script>

</body>
</html>
