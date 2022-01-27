<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 상단 메뉴 -->
<header class="top-menu">
    <a class="logo" href="/home.do">
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
                    <li><a href="">
                        <div></div>직원관리
                    </a></li>
                    <li><a href="">
                        <div></div>스태프관리
                    </a></li>
                    <li><a href="">
                        <div></div>스케줄관리
                    </a></li>
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
                <a href="">메뉴관리</a>
                <ul class="nav-box">
                    <li><a href="">
                        <div></div>메뉴정보
                    </a></li>
                    <li><a href="">
                        <div></div>판매제품관리
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
                <a href="/store/netprofit.do">매장관리</a>
                <ul class="nav-box">
                    <li><a href="/store/netprofit.do">
                        <div></div>지점별 매출 상세
                    </a></li>
                    <li><a href="/store/goal.do">
                        <div></div>지점별 목표설정
                    </a></li>
                    <li><a href="/store/rossrate.do">
                        <div></div>지점별 로스율
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
        <span>강남대로점</span>
        <span><strong>이주빈</strong>님</span>
        <div class="thumb"><img src="/resources/images/img.jpeg"></div>
    </div>
</header>

<script src="/asset/js/header.js"></script>

