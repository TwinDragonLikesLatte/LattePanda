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
    <link rel="stylesheet" href="/asset/css/login.css">
</head>
<body>

    <main>
        <img class="logo-h" src="/resources/images/lattepanda_v.png" alt="라떼판다 로고">
<%--        <c:if test="${not empty error}">--%>
            <span class="error">${error}</span>
<%--        </c:if>--%>
        <form method="POST" action="/login.do" autocomplete="off">
            <div class="login-box">
                <div>
                    <div>
                        <input type="text" name="id" placeholder="아이디">
                        <span class="glyphicon glyphicon-remove"></span>
                    </div>
                    <div>
                        <input type="password" name="pw" placeholder="비밀번호">
                        <span class="glyphicon glyphicon-remove"></span>
                    </div>
                </div>
                <input type="submit" value="로그인" class="btn btn-primary">
            </div>
            <div class="option-box">
                <label>
                    <input type="checkbox" name="save_id">
                    <span class="glyphicon glyphicon-ok-circle" aria-hidden="true"></span>
                    <span>아이디 저장</span>
                </label>
                <a href="/findpassword.do">비밀번호 찾기</a>
                <span class="enquiry">전산팀 문의</span>
            </div>
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

        $('form').submit(function() {

            let error = '';

            if ($('input[name=pw]').val() == '')
                error = '비밀번호를 입력해주세요.';

            if ($('input[name=id]').val() == '')
                error = '아이디를 입력해주세요.';

            if (error == '') {
                return true;
            } else {
                $('.error').text(error);
                return false;
            }
        });

        $(function() {
            if (getCookie('id') != null) {
                $('input[name=id]').val(getCookie('id'));
                $('input[name=save_id]').prop('checked', true);
                $('.glyphicon-ok-circle').addClass('glyphicon-ok-sign').removeClass('glyphicon-ok-circle');
            }
        });

        $('.login-box').children('div').children('div').on({
            input: function() {
                if($(this).children('input').val() != '') {
                    $(this).children('.glyphicon-remove').css('display', 'inline');
                } else {
                    $(this).children('.glyphicon-remove').css('display', 'none');
                }
            },
            mouseover: function() {
                if($(this).children('input').val() != '') {
                    $(this).children('.glyphicon-remove').css('display', 'inline');
                } else {
                    $(this).children('.glyphicon-remove').css('display', 'none');
                }
            },
            mouseout: function() {
                $(this).children('.glyphicon-remove').css('display', 'none');
            },
        });

        $('.login-box').find('.glyphicon-remove').on({
            click: function() {
                $(this).siblings('input').val('');
                $(this).siblings('input').focus();
                $(this).css('display', 'none');
            }
        })

        $('.option-box').find('input').on({
            click: function() {
                $(this).siblings('.glyphicon').toggleClass('glyphicon-ok-circle');
                $(this).siblings('.glyphicon').toggleClass('glyphicon-ok-sign');
            }
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
