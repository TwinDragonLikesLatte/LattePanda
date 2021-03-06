<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!-- 서브 메뉴 -->
<nav class="nav-sub">
    <div class="menu-title">
        인사관리
    </div>
    <ul>
        <li class="sub-menu"><a href="/hr/employee/list.do" class="">직원관리</a>
            <ul>
                <li><a href="/hr/employee/list.do">직원조회</a></li>
                <c:if test="${seq_department == '2' || seq_department == '22'}">
                <li><a href="/hr/employee/add.do">신규등록</a></li>
                <li><a href="/hr/employee/contract.do">근로계약</a></li>
                <li><a href="/hr/employee/appointment.do">인사발령</a></li>
                <li><a href="/hr/employee/resign.do">퇴사처리</a></li>
                </c:if>
            </ul>
        </li>

        <script>
            console.log(${fn:indexOf(seq_department, '3')});
        </script>
        <c:if test="${fn:indexOf(seq_department, '22') == '0' || fn:indexOf(seq_department, '3') == '0'}">
        <li class="sub-menu"><a href="/hr/staff/list.do?seq_department=${seq_department}">스태프관리</a>
            <ul>
                <li><a href="/hr/staff/list.do?seq_department=${seq_department}">스태프조회</a></li>
                <c:if test="${seq_position != '9'}">
                <li><a href="/hr/staff/add.do">신규등록</a></li>
                </c:if>
                <li><a href="/hr/staff/contract.do">근로계약</a></li>
                <li><a href="/hr/staff/edu.do">안전보건교육</a></li>
                <li><a href="/hr/staff/attend.do">근태입력</a></li>
                <li><a href="/hr/staff/paystub.do">급여관리</a></li>
                <c:if test="${seq_position != '9'}">
                <li><a href="/hr/staff/resign.do">퇴사처리</a></li>
                </c:if>
            </ul>
        </li>
        <li class="sub-menu"><a href="/hr/schedule/view.do">스케쥴관리</a>
            <ul>
                <li><a href="/hr/schedule/view.do">스케쥴조회</a></li>
            </ul>
        </li>
        </c:if>
    </ul>
</nav>

<script src="/asset/js/sub-nav.js"></script>
