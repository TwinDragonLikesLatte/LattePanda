<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 상단 메뉴 -->
<header class="top-menu">
    <a class="logo" href="/index.jsp">
        <img src="/resources/images/lattepanda_h.png" alt="라떼로고">
    </a>
    <nav class="nav-main">
        <ul>
            <li class="main-menu">
                <a href="/home/dashboard.do">홈</a>
            </li>
            <li class="main-menu">
                <a href="/hr/employee/list.do">인사관리</a>
                <ul class="nav-box">
                    <li><a href="/hr/employee/list.do">
                        <div></div>직원관리
                    </a></li>
                    <c:if test="${fn:indexOf(seq_department, '22') == '0' || fn:indexOf(seq_department, '3') == '0'}">
                    <li><a href="/hr/staff/list.do?seq_department=${seq_department}">
                        <div></div>스태프관리
                    </a></li>
                    <li><a href="">
                        <div></div>스케줄관리
                    </a></li>
                    </c:if>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/stock/list/list.do">재고관리</a>
                <ul class="nav-box">
                    <li><a href="/stock/list/list.do">
                        <div></div>재고 조회
                    </a></li>
                    <li><a href="/stock/order/list.do">
                        <div></div>재고 발주
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/menu/basic/list.do">메뉴관리</a>
                <ul class="nav-box">
                    <li><a href="/menu/basic/list.do">
                        <div></div>메뉴정보
                    </a></li>
                    <li><a href="/menu/product/list.do">
                        <div></div>판매제품조회
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/order/now.do">주문관리</a>
                <ul class="nav-box">
                    <li><a href="/order/now.do">
                        <div></div>진행중 주문
                    </a></li>
                    <li><a href="/order/alllist.do">
                        <div></div>전체 주문
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="">매출관리</a>
                <ul class="nav-box">
                    <li><a href="">
                        <div></div>지점별 매출관리
                    </a></li>
                    <li><a href="">
                        <div></div>지역별 매출관리
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/store/netprofit/net.do">매장관리</a>
                <ul class="nav-box">
                    <li><a href="/store/netprofit/net.do">
                        <div></div>지점별 매출 상세
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/customer/complain/board.do">고객관리</a>
                <ul class="nav-box">
                    <li><a href="/customer/complain/board.do">
                        <div></div>불편 및 건의사항
                    </a></li>
                    <li><a href="/customer/survey/question.do">
                        <div></div>만족도 조사
                    </a></li>
                </ul>
            </li>
            <li class="main-menu">
                <a href="/notice/board.do">공지사항</a>
            </li>
        </ul>
    </nav>

    <!-- 프로필 -->
    <div class="profile">
        <span>${department}</span>
        <span><strong>${name}</strong>님</span>
        <div class="thumb"><img src="/resources/images/img.jpeg"></div>
        <div class="header-btns">
            <div></div>
            <input class="btn btn-default" type="button" value="강남대로점장 손윤희" data-seq_employee="20160006">
            <input class="btn btn-default" type="button" value="강남대로 매니저 백지연" data-seq_employee="20200010">
            <input class="btn btn-default" type="button" value="강남지역장 이민연" data-seq_employee="20120001">
            <input class="btn btn-default" type="button" value="연구기획과장 장민진" data-seq_employee="20140003">
            <input class="btn btn-default" type="button" value="인사과장 권상성" data-seq_employee="20140002">
            <input class="btn btn-danger" type="button" value="로그아웃" data-seq_employee="logout">
        </div>
    </div>
</header>

<script src="/asset/js/header.js"></script>
<script>

    $('.thumb').on({
        click: function() {
            $('.header-btns').css('display', 'flex');
        }
    });

    $('.header-btns').children('.btn').on({
       click: function() {
           // alert($(this).data('seq_employee'));
           location.href = '/loginbtn.do?seq_employee=' + $(this).data('seq_employee');
       }
    });

</script>
