<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (session.getAttribute("id") != null) {
        response.sendRedirect("/home/dashboard.do");
    }
%>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/findpassword.css">
</head>
<body>

    <main>
        <span class="glyphicon glyphicon-remove"></span>
        <img class="logo-h" src="/resources/images/lattepanda_h.png" alt="라떼판다 로고">
        <span class="title">비밀번호 찾기</span>
        <span class="message">아이디를 입력해주세요.</span>
        <%--        <c:if test="${not empty errorid}">--%>
        <span class="error">${error}</span>
        <%--        </c:if>--%>
        <form method="POST" action="/findpassword.do" autocomplete="off">
            <input type="text" name="id" placeholder="아이디">
            <span class="errorid"></span>
            <div class="btns">
                <input type="button" name="btn-prev" value="이전으로" class="btn btn-default">
                <input type="submit" name="btn-next" value="다음으로" class="btn btn-primary">
            </div>
            <span class="enquiry">전산팀 문의</span>
        </form>
    </main>

    <script>

        $(function() {
           $('input[name=id]').focus();
        });

        $('.glyphicon-remove').click(() => {
            location.href = '/login.do';
        })

        $('form').submit(function() {

            let error = '';

            if ($('input[name=id]').val() == '') {
                $('.errorid').text('아이디를 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

                return false;

            } else {

                return true;
            }
        });

        $('input[name=btn-prev]').click(() => {
            location.href = "/login.do";
        });

        <c:if test="${lock == 'y'}">
        $('.modal').modal().css('display', 'flex');
        </c:if>

        $('.enquiry').on({
            click: function() {
                $('.modal').modal().css('display', 'flex');
                $('.modal').find('.modal-title').text('전산팀 문의');
                $('.modal').find('.modal-body').append('<p>전산팀 문의번호 : 02-1234-5678<br><br>※ 아이디는 직원번호입니다.</p>');
            }
        });

    </script>

</body>
</html>
