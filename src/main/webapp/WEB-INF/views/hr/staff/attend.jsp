<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/hr/staff/attend.css">
</head>
<body>

    <main>
        <span class="glyphicon glyphicon-remove"></span>
        <img class="logo-h" src="/resources/images/lattepanda_h.png" alt="라떼판다 로고">
        <section class="attend">
            <div class="section-header">
                <span class="sub-title">스태프 근태입력</span>
                <c:if test="${not empty staff}">
                <input type="button" class="btn btn-default" value="비밀번호 변경">
                </c:if>
            </div>
            <form method="GET" action="/hr/staff/attend.do" autocomplete="off">
                <table class="table">
                    <tbody>
                        <tr>
                            <th>스태프번호</th>
                            <td colspan="3">
                                <div>
                                    <input class="" type="text" name="seq_staff" maxlength="9" required value="${staff.seqStaff}">
                                    <input class="btn btn-default" type="submit" value="확인">
                                </div>
                            </td>
                            <th>재직구분</th>
                            <td colspan="3"><span>${staff.status}</span></td>
                        </tr>
                        <tr>
                            <th>이름</th>
                            <td colspan="3"><span>${staff.name}</span></td>
                            <th>입사일</th>
                            <td colspan="3"><span>${staff.join}</span></td>
                        </tr>
                        <tr>
                            <th>연락처</th>
                            <td colspan="3"><span>${staff.tel}</span></td>
                            <th>소속</th>
                            <td colspan="3"><span>${staff.store}</span></td>
                        </tr>
                        <tr>
                            <th>월 근무시간</th>
                            <td colspan="3">
                                <span>
                                    <c:if test="${not empty time_cnt}">
                                    <fmt:formatNumber value="${time_cnt.month_minute / 60}" pattern=".0"/>
                                    시간
                                    </c:if>
                                </span>
                            </td>
                            <th>주 근무시간</th>
                            <td colspan="3">
                                <span>
                                    <c:if test="${not empty time_cnt}">
                                    <fmt:formatNumber value="${time_cnt.week_minute / 60}" pattern=".0"/>
                                    시간
                                    </c:if>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <th>월 근무일수</th>
                            <td colspan="3">
                                <span>
                                    <c:if test="${not empty time_cnt}">
                                    ${time_cnt.month_cnt}
                                    일
                                    </c:if>
                                </span>
                            </td>
                            <th>주 근무일수</th>
                            <td colspan="3">
                                <span>
                                    <c:if test="${not empty time_cnt}">
                                    ${time_cnt.week_cnt}
                                    일
                                    </c:if>
                                </span>
                            </td>
                        </tr>
                        <tr>
                            <td class="gap" colspan="8"></td>
                        </tr>
                        <tr>
                            <th>구분</th>
                            <th data-day="1">일</th>
                            <th data-day="2">월</th>
                            <th data-day="3">화</th>
                            <th data-day="4">수</th>
                            <th data-day="5">목</th>
                            <th data-day="6">금</th>
                            <th data-day="7">토</th>
                        </tr>
                        <tr>
                            <td>출근</td>
                            <td class="work-start" data-day="1"></td>
                            <td class="work-start" data-day="2"></td>
                            <td class="work-start" data-day="3"></td>
                            <td class="work-start" data-day="4"></td>
                            <td class="work-start" data-day="5"></td>
                            <td class="work-start" data-day="6"></td>
                            <td class="work-start" data-day="7"></td>
                        </tr>
                        <tr>
                            <td>휴게시작</td>
                            <td class="rest-start" data-day="1"></td>
                            <td class="rest-start" data-day="2"></td>
                            <td class="rest-start" data-day="3"></td>
                            <td class="rest-start" data-day="4"></td>
                            <td class="rest-start" data-day="5"></td>
                            <td class="rest-start" data-day="6"></td>
                            <td class="rest-start" data-day="7"></td>
                        </tr>
                        <tr>
                            <td>휴게종료</td>
                            <td class="rest-end" data-day="1"></td>
                            <td class="rest-end" data-day="2"></td>
                            <td class="rest-end" data-day="3"></td>
                            <td class="rest-end" data-day="4"></td>
                            <td class="rest-end" data-day="5"></td>
                            <td class="rest-end" data-day="6"></td>
                            <td class="rest-end" data-day="7"></td>
                        </tr>
                        <tr>
                            <td>퇴근</td>
                            <td class="work-end" data-day="1"></td>
                            <td class="work-end" data-day="2"></td>
                            <td class="work-end" data-day="3"></td>
                            <td class="work-end" data-day="4"></td>
                            <td class="work-end" data-day="5"></td>
                            <td class="work-end" data-day="6"></td>
                            <td class="work-end" data-day="7"></td>
                        </tr>
                        <tr>
                            <td>급여</td>
                            <td class="pay" data-day="1"></td>
                            <td class="pay" data-day="2"></td>
                            <td class="pay" data-day="3"></td>
                            <td class="pay" data-day="4"></td>
                            <td class="pay" data-day="5"></td>
                            <td class="pay" data-day="6"></td>
                            <td class="pay" data-day="7"></td>
                        </tr>
                    </tbody>
                </table>
                <div class="btns">
                    <input type="button" class="btn btn-default work-start" name="work_start" value="출근" disabled>
                    <input type="button" class="btn btn-default rest-start" name="rest_start" value="휴게시작" disabled>
                    <input type="button" class="btn btn-default rest-end" name="rest_end" value="휴게종료" disabled>
                    <input type="button" class="btn btn-default work-end" name="work_end" value="퇴근" disabled>
                </div>
            </form>
            <div class="modal modal-pw" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">비밀번호 입력</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form class="send-attend" method="POST" action="/hr/staff/attend.do">
                                <div>
                                    <input type="password" name="pw" placeholder="비밀번호">
                                    <input class="btn btn-default" type="submit" value="확인">
                                    <input type="hidden" name="seq_staff" value="">
                                    <input type="hidden" name="selected" value="">
                                </div>
                                <div>
                                    <span class="error-pw"></span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal modal-error" tabindex="-1" role="dialog">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title">로그인 실패</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <p>비밀번호를 확인하세요.</p>
                            <span class="error-pw"></span>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </main>

    <script>

        $(() => {
            $('input[name=seq_staff]').focus();

            const seq_staff = new URL(location.href).searchParams.get('seq_staff');

            if (seq_staff != null && seq_staff != '') {
                const day = new Date().getDay() + 1;
                $('th[data-day='+day+']').addClass('sel');

                <c:forEach items="${week}" var="day">
                $('.work-start[data-day=${day.day}]').text('${day.workStart}');
                $('.rest-start[data-day=${day.day}]').text('${day.restStart}');
                $('.rest-end[data-day=${day.day}]').text('${day.restEnd}');
                $('.work-end[data-day=${day.day}]').text('${day.workEnd}');
                $('.pay[data-day=${day.day}]').text('${day.pay}');
                </c:forEach>

                if ($('.work-start[data-day=' + day +']').text() == '') {
                    $('.btn.work-start').prop('disabled', false)
                        .removeClass('btn-default')
                        .addClass('btn-primary');

                } else if ($('.rest-start[data-day=' + day +']').text() == '') {
                    $('.btn.rest-start').prop('disabled', false)
                        .removeClass('btn-default')
                        .addClass('btn-primary');
                    $('.btn.work-end').prop('disabled', false);

                } else if ($('.rest-end[data-day=' + day +']').text() == '') {
                    $('.btn.rest-end').prop('disabled', false)
                        .removeClass('btn-default')
                        .addClass('btn-primary');
                } else if ($('.work-end[data-day=' + day +']').text() == '') {
                    $('.btn.work-end').prop('disabled', false)
                        .removeClass('btn-default')
                        .addClass('btn-primary');
                }
            }

            if (new URL(location.href).searchParams.get("error") == 'y') {
                $('.modal-error').modal().css('display', 'flex');
            }
        });

        $('.btns').children().on({
            click: function() {

                $('.modal-pw').modal().css('display', 'flex');
                $('.send-attend').find('input[name=seq_staff]')
                    .val(new URL(location.href).searchParams.get("seq_staff"));
                $('.send-attend').find('input[name=selected]').val($(this).attr('name'));
            }
        });

        $('.send-attend').submit(() => {
            if ($('input[name=pw]').val() == '') {
                $('.error-pw').text('비밀번호를 입력해주세요.')
                    .prepend('<span class="glyphicon glyphicon-exclamation-sign">')
                    .css('display', 'inline');
                $('.error-pwok').css('display', 'none');
                return false;
            }

            return true;
        })

        $('.glyphicon-remove').click(() => {
            location.href = '/home/dashboard.do';
        });

        function getTimeString(minute) {
            return Math.floor(minute / 60) + "시간" + (minute % 60) + "분";
        }

    </script>

</body>
</html>
