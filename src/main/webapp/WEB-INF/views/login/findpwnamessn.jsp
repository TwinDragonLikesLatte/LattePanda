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
        <span class="message">이름과 주민번호 뒷자리를 입력해주세요.</span>
        <%--        <c:if test="${not empty error}">--%>
        <span class="error">${error}</span>
        <%--        </c:if>--%>
        <form method="POST" action="/findpassword.do" autocomplete="off">
            <input type="text" name="name" placeholder="이름">
            <span class="errorname"></span>
            <input type="password" name="ssn" placeholder="주민번호 뒷자리" maxlength="7">
            <span class="errorssn"></span>
            <div class="btns">
                <input type="button" name="btn-prev" value="이전으로" class="btn btn-default">
                <input type="submit" name="btn-next" value="다음으로" class="btn btn-primary">
            </div>
            <span class="enquiry">전산팀 문의</span>
            <input type="hidden" name=id value="${id}">
        </form>
    </main>


    <div class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">
                        <c:if test="${lock == 'y'}">
                            계정 잠금
                        </c:if>
                    </h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <c:if test="${lock == 'y'}">
                        <p>로그인에 5회 이상 실패하여 계정이 잠겼습니다.<br><br>전산팀으로 문의하세요. (02-1234-5678)</p>
                    </c:if>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
                </div>
            </div>
        </div>
    </div>

    <script>

        $(function() {
            $('input[name=name]').focus();
        });

        $('.glyphicon-remove').click(() => {
            location.href = '/login.do';
        })

        $('form').submit(function() {

            if ($('input[name=name]').val() == '') {
                $('.errorname').text('이름을 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

                return false;

            } else {
                $('.errorname').css('display', 'none');
            }

            if ($('input[name=ssn]').val() == '') {

                $('.errorssn').text('주민번호 뒷자리를 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

                return false;

            } else {
                $('.errorssn').css('display', 'none');
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
