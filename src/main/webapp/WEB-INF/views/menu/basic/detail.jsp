<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/menu/detail.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_menu.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

            <h1 class="title">상세 조회</h1>

            <div id="product-box">
                <%-- 좌측) 메뉴 이름, 이미지 컬럼 --%>
                <div class="product-left">
                    <div><h2>${dto.namekr} <small>${dto.nameEn}</small></h2></div>
                    <img src="/resources/images/${dto.seqMenu}.jpg">
                    <div><input type="button" class="btn btn-default" value="신규 판매제품등록"></div>
                </div>

                <%-- 우측) 메뉴 정보 컬럼 --%>
                <div class="product-right">
                    <div class="size-box">
                        <c:forEach items="${slist}" var="size">
                            <h2>${size}</h2>
                        </c:forEach>
                    </div>

                    <%-- 제품 정보 컨테이너 --%>
                    <div class="product-info">
                        <%-- 기본정보 --%>
                        <div class="product-info-basic">
                            <h3>기본정보</h3>
                            <table class="table">
                                <tr>
                                    <th>상위 카테고리</th>
                                    <td>${dto.upperCategory}</td>
                                </tr>
                                <tr>
                                    <th>하위 카테고리</th>
                                    <td>${dto.categoryName}</td>
                                </tr>
                                <tr>
                                    <th>메뉴명</th>
                                    <td>${dto.namekr}</td>
                                </tr>
                                <tr>
                                    <th>메뉴코드</th>
                                    <td>${dto.seqMenu}</td>
                                </tr>
                                <tr>
                                    <th>제품코드</th>
                                    <td>${dto.seqProduct}</td>
                                </tr>
                                <tr>
                                    <th>사이즈</th>
                                    <td>${dto.sizeName}</td>
                                </tr>
                                <tr>
                                    <th>등록일자</th>
                                    <td>${dto.regDate}</td>
                                </tr>
                                <tr>
                                    <th>판매시작일</th>
                                    <td>${dto.startDate}</td>
                                </tr>
                                <tr>
                                    <th>판매종료일</th>
                                    <td>${dto.endDate}</td>
                                </tr>
                                <tr>
                                    <th>메뉴공개등급</th>
                                    <td>${dto.openLevel}</td>
                                </tr>

                                <tr>
                                    <th>판매가</th>
                                    <td>${dto.costPrice} 원</td>
                                </tr>
                                <tr>
                                    <th>원가</th>
                                    <td>${dto.sellingPrice} 원</td>
                                </tr>
                                <tr>
                                    <th>마진율</th>
                                    <td>${dto.costRate * 100}%</td>
                                </tr>
                            </table>

                        </div>

                        <%-- 재료 / 변경내역 정보--%>
                        <div class="product-info-extra">
                            <div class="product-ingredient">
                                <h3>재료정보</h3>
                                <div class="table-box">
                                <table class="table table-bordered">
                                    <tr>
                                        <th>재료명</th>
                                        <th>수량</th>
                                        <th>단위가격(원)</th>
                                        <th>1인분가격(원)</th>
                                    </tr>
                                    <c:forEach items="${rlist}" var="rdto">
                                    <tr>
                                        <td>${rdto.name}(${rdto.unit})</td>
                                        <td>${rdto.quantity}</td>
                                        <td>${rdto.unitCost}</td>
                                        <td>${rdto.onePrice}</td>
                                    </tr>
                                    </c:forEach>
                                </table>
                                </div>
                            </div>

                            <div class="product-history">
                                <h3>메뉴변경내역</h3>
                                <div class="table-box">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>등록일</th>
                                            <th>제품코드</th>
                                            <th>메뉴명</th>
                                            <th>판매시작일</th>
                                            <th>판매종료일</th>
                                            <th>상태</th>
                                        </tr>

                                        <c:forEach items="${hlist}" var="hdto">
                                        <tr>
                                            <td>${hdto.regDate}</td>
                                            <td>${hdto.seqProduct}</td>
                                            <td>${hdto.namekr}</td>
                                            <td>${hdto.startDate}</td>
                                            <td>${hdto.endDate}</td>
                                            <td>${hdto.openLevel}</td>
                                        </tr>
                                        </c:forEach>

                                    </table>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </main>

</div>

<script>

    /* Default 사이즈 color 적용 */
    $('.size-box h2').each((index, h2)=> {
        let size = $(h2).text();
        if(size == "${dto.sizeName}") {
            $(h2).css('color', 'var(--purple_four)');
        }
    })


</script>

</body>
</html>
