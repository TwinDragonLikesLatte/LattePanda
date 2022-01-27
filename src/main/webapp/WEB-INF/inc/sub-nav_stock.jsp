<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 서브 메뉴 -->
<nav class="nav-sub">
    <div class="menu-title">
        재고관리
    </div>
    <ul>
        <li class="sub-menu"><a href="/stock/list/list.do" class="">재고정보</a>
            <ul>
                <li><a href="/stock/list/list.do">재고정보조회</a></li>
                <li><a href="/stock/list/edit.do">재고정보입력</a></li>
            </ul>
        </li>
        <li class="sub-menu"><a href="/stock/order/list.do" class="">재고발주</a>
            <ul>
                <li><a href="/stock/order/list.do">발주정보조회</a></li>
                <li><a href="/stock/order/edit.do">발주정보입력</a></li>
                <li><a href="/stock/order/print.do">발주확인서발급</a></li>
            </ul>
        </li>
    </ul>
</nav>

<script src="/asset/js/sub-nav.js"></script>
