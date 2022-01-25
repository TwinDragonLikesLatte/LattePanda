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
        <span class="title">비밀번호 변경</span>
        <span class="message">새로운 비밀번호를 입력해주세요.</span>
        <%--        <c:if test="${not empty error}">--%>
        <span class="error">${error}</span>
        <%--        </c:if>--%>
        <form method="POST" action="/changepassword.do" autocomplete="off">
            <input type="password" name="pw" placeholder="새 비밀번호" maxlength="16">
            <span class="error-pw"></span>
            <input type="password" name="pwok" placeholder="새 비밀번호 확인" maxlength="16">
            <span class="error-pwok"></span>
            <div class="btns">
                <input type="submit" name="btn-next" value="비밀번호 변경" class="btn btn-primary">
            </div>
            <span class="enquiry">전산팀 문의</span>
            <input type="hidden" name=id value="${id}">
        </form>
    </main>

    <script>

        $(function() {
            $('input[name=pw]').focus();
        });

        $('.glyphicon-remove').click(() => {
            location.href = '/login.do';
        })

        $('form').submit(function() {

            if ($('input[name=pw]').val() == '') {
                $('.error-pw').text('비밀번호를 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');
                $('.error-pwok').css('display', 'none');

                return false;

            } else if ($('input[name=pw]').val().length < 8) {
                $('.error-pw').text('비밀번호는 8자 이상이어야 합니다.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');
                $('.error-pwok').css('display', 'none');

                return false;

            } else {
                $('.errorpw').css('display', 'none');
            }

            if ($('input[name=pwok]').val() == '') {

                $('.error-pwok').text('비밀번호 확인을 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

                return false;

            } else if ($('input[name=pwok]').val() != $('input[name=pw]').val()) {

                $('.error-pwok').text('비밀번호가 일치하지 않습니다.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

                return false;

            } else {
                $('.error-pwok').css('display', 'none');
            }

            return true;
        });

        $('input[name=btn-prev]').click(() => {
            history.back();
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
