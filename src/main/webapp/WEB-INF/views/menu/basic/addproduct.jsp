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

            <h1 class="title">신규 판매제품등록</h1>

            <div id="product-box">
                <%-- 좌측) 메뉴 이름, 이미지 컬럼 --%>
                <div class="product-left">
                    <div><h2>${dto.namekr} <small>${dto.nameEn}</small></h2></div>
                    <img src="/resources/images/${dto.seqMenu}.jpg">
                    <div>
                        <input type="button"
                               class="btn btn-default save-btn"
                               value="저장하기" >
<%--                               onclick="location.href='/menu/basic/detail.do?seqmenu=${dto.seqMenu}';">--%>
                    </div>
                </div>

                <%-- 우측) 메뉴 정보 컬럼 --%>
                <div class="product-right">

                    <%-- 상단 메뉴별 판매 사이즈 탭 --%>
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
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <th>사이즈</th>
                                    <td>${sizeName}</td>
                                </tr>
                                <tr>
                                    <th>등록일자</th>
                                    <td class="regdate">test</td>
                                </tr>
                                <tr>
                                    <th>판매시작일</th>
                                    <td><input type="date" name="sale-start-date" class="form-control sale-start-date"></td>
                                </tr>
                                <tr>
                                    <th>판매종료일</th>
                                    <td><input type="date" name="sale-end-date" class="form-control sale-end-date"></td>
                                </tr>
                                <tr>
                                    <th>메뉴공개등급</th>
                                    <td>판매예정</td>
                                </tr>

                                <tr>
                                    <th>판매가</th>
                                    <td><input type="text" class="form-control selling-price"> 원</td>
                                </tr>
                                <tr>
                                    <th>원가</th>
                                    <td class="cost-price"></td>
                                </tr>
                                <tr>
                                    <th>마진율</th>
                                    <td class="cost-rate">0.0</td>
                                </tr>
                            </table>

                        </div>

                        <%-- 재료 / 변경내역 정보--%>
                        <div class="product-info-extra">
                            <form id="add-recipe-form">
                            <div class="product-ingredient">
                                <div>
                                    <h3>재료정보</h3>
                                    <div class="btns-recipe">
                                        <input type="button" class="btn btn-danger remove" value="-">
                                        <input type="button" class="btn btn-default add" value="+">
                                    </div>
                                </div>

                                <div class="table-box">

                                    <table class="table table-bordered add-recipe">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" name="sel" class="chk-box"></th>
                                            <th>재료명</th>
                                            <th>수량</th>
                                            <th>단위가격(원)</th>
                                            <th>1인분가격(원)</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${rlist}" var="rdto">
                                        <tr>
                                            <td><input type="checkbox" name="sel" class="chk-box"></td>
                                            <td>
                                                <select class="form-control" name="seq-stock">
                                                    <c:forEach items="${stockList}" var="stock">
                                                        <c:if test="${stock.name eq rdto.name}">
                                                            <option value="${stock.seqStock}">${rdto.name}</option>
                                                        </c:if>
                                                    </c:forEach>
                                                </select>
                                            </td>
                                            <td><input type="text" class="form-control quantity" name="quantity" value="${rdto.quantity}"></td>
                                            <td><input type="text" class="form-control unit-cost" name="unit-cost" value="${rdto.unitCost}"disabled></td>
                                            <td><input type="text" class="form-control one-price" name="one-price" value="" disabled></td>
                                        </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>

                            </div>
                            </form>

                            <div class="product-history">
                                <h3>메뉴변경내역</h3>
                                <div class="table-box">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th>등록일</th>
                                            <th>제품코드</th>
                                            <th>메뉴명</th>
                                            <th>판매시작일</th>
                                            <th>판매종료일</th>
                                            <th>상태</th>
                                        </tr>
                                        </thead>
                                        <tbody>
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
                                        </tbody>

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
    $('.size-box h2').each(function(){
        let size = $(this).text();
        if(size == "${sizeName}") {
            $(this).css('color', 'var(--purple_four)');
        }
    })


    /* 재료 카테고리 리스트 사전 저장 (JSTL > JS) */
    const stockList = [
        <c:forEach items="${stockList}" var="stock">
        {
            seqStock : "${stock.seqStock}",
            name : "${stock.name}",
            unitCost : "${stock.unitCost}"
        },
        </c:forEach>
    ]


    /* 등록일자, 오늘 날짜로 자동 기입 */
    $('.regdate').text(new Date().toISOString().substring(0,10));



    /* 재료 레코드 삭제 */
    $('.remove').click(()=>{
        $('.add-recipe tr td:first-child .chk-box').each((index, item)=>{
            if($(item).is(':checked')){
                $(item).parent().parent().remove();
            }
        });
    });


    /* 재료 레코드 추가 */
    $('.add').click(()=>{
        $('.add-recipe tbody').append(
            '<tr>' +
                '<td><input type="checkbox" name="sel" class="chk-box"></td>' +
                '<td>' +
                    '<select class="form-control">' +
                        makeStockList() +
                    '</select>' +
                '</td>' +
                '<td><input type="text" class="form-control quantity"></td>' +
                '<td><input type="text" class="form-control unit-cost" disabled></td>' +
                '<td><input type="text" class="form-control one-price" value="" disabled></td>' +
            '</tr>'
        );
    });

    function makeStockList() {
        let tmp = "";
        stockList.forEach(stock => {
            tmp += '<option value="' + stock.seqStock + '">' + stock.name + '</option>';
        })
        return tmp;
    }


    /* 체크 박스 전체 선택 or 해제 */
    $('thead input').click(()=>{
        if($('thead .chk-box').is(':checked')){
            $('.chk-box').prop('checked', true);
        }
        else $('.chk-box').prop('checked', false);

    });


    /* 재료정보, 재료별 1인분 가격 (수량 * 단위가격) : 첫로딩시 */
    $('.add-recipe tr .one-price').each((index, item)=>{
       let quantity = $(item).parent().parent().children().children('.quantity').val();
       let unitCost = $(item).parent().parent().children().children('.unit-cost').val();
       $(item).val(quantity * unitCost);
    });


    /* '수량' 변경에 따른 > 1인분 가격, 원가, 마진율 갱신 */
    $('.quantity').on("propertychange change keyup paste input", function() {
        let quantity = $(this).val();
        let unitCost = $(this).parent().parent().children().children('.unit-cost').val();

        // 1인분 가격 갱신
        $(this).parent().parent().children().children('.one-price').val(quantity * unitCost);

        // 원가 갱신
        $('.cost-price').text(totalOneCost());

        // 마진율 갱신
        $('.cost-rate').text(costRate());
    });


    /* '판매가' 변경에 따른 > '마진율' 변경 */
    $('.selling-price').on("propertychange change keyup paste input", function() {
        $('.cost-rate').text( 1 - (totalOneCost() / $(this).val()).toFixed(2));
    });


    /* 원가 : 첫로딩시 */
    $('.cost-price').text(totalOneCost());


    /* 원가 계산 메소드 */
    function totalOneCost(){
        let cost = 0;
        $('.add-recipe tr .one-price').each((index, item)=>{
            cost += Number($(item).val());
        });
        return cost;
    }


    /* 마진율 계산 메소드 */
    function costRate() {
        let costPrice = totalOneCost();
        let sellingPrice = $('.selling-price').val();
        return 1 - (costPrice / sellingPrice);
    }



    /* *************** Ajax *************** */
    $('.save-btn').click(()=>{

        let queryString = $('#add-recipe-form').serialize() +
                            '&sale-start-date=' + $('.sale-start-date').val() +
                            '&sale-end-date=' + $('.sale-end-date').val() +
                            '&selling-price=' + $('.selling-price').val() +
                            '&cost-price=' + $('.cost-price').text() +
                            '&cost-rate=' + $('.cost-rate').text() +
                            '&seqmenu=' + "${dto.seqMenu}" +
                            '&seqcategory=' + "${dto.seqCategory}" +
                            '&sizename=' + "${sizeName}";

        $.ajax({
            type : 'POST',
            url : '/menu/basic/addokproduct.do',
            data : queryString,
            success : function(result){
                if(result == 1)
                    location.href='/menu/basic/detail.do?seqmenu=${dto.seqMenu}';
                else {
                    alert('신규 판매제품 등록 실패 😥😥 ');
                    history.back();
                }
            }
        });

    });


</script>

</body>
</html>
