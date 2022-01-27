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
        <span class="title">비밀번호 변경완료</span>
        <span class="message">비밀번호 변경이 완료되었습니다.</span>
        <%--        <c:if test="${not empty error}">--%>
        <span class="error">${error}</span>
        <%--        </c:if>--%>
        <form method="GET" action="/login.do" autocomplete="off">
            <div class="btns">
                <input type="submit" name="btn-next" value="로그인 화면으로" class="btn btn-primary">
            </div>
            <span class="enquiry">전산팀 문의</span>
            <input type="hidden" name=id value="${id}">
        </form>

        <div class="modal modal-enquiry" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">전산팀 문의</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <p>전산팀 문의번호 : 02-1234-5678<br><br>※ 아이디는 직원번호입니다.</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
                    </div>
                </div>
            </div>
        </div>

    </main>

    <script>

        $('.glyphicon-remove').click(() => {
            location.href = '/login.do';
        })

        $('form').submit(function() {

            let error = '';

            if ($('input[name=pw]').val() == '') {
                $('.errorname').text('새 비밀번호를 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

            } else if ($('input[name=pwok]').val() == '') {

                $('.errorssn').text('비밀번호 확인을 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');

            } else {

                return true;
            }
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
            }
        });

    </script>

</body>
</html>
