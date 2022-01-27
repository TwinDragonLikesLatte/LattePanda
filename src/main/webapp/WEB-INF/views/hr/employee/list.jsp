<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <html>

        <head>
            <title>직원조회</title>
            <%@ include file="/WEB-INF/inc/asset.jsp" %>
                <link rel="stylesheet" href="/asset/css/hr/employee/list.css">
        </head>

        <body>

            <div class="container">
                <%@ include file="/WEB-INF/inc/header.jsp" %>

                    <main>
                        <%@ include file="/WEB-INF/inc/sub-nav_hr.jsp" %>
                            <div class="content">

                                <section class="search">
                                    <div class="section-header">
                                        <span class="sub-title">검색 조건</span>
                                        <input type="button" class="btn btn-default" value="검색">
                                    </div>
                                    <form>
                                        <table class="table">
                                            <tr>
                                                <th>직원번호</th>
                                                <td><input class="form-control" type="text" name=""></td>
                                                <th>직책</th>
                                                <td><input class="form-control" type="text" name=""></td>
                                            </tr>
                                            <tr>
                                                <th>이름</th>
                                                <td><input class="form-control" type="text" name=""></td>
                                                <th>부서</th>
                                                <td><input class="form-control" type="text" name=""></td>
                                            </tr>
                                            <tr>
                                                <th>연락처</th>
                                                <td><input class="form-control" type="text" name=""></td>
                                                <th>입사일</th>
                                                <td colspan="3">
                                                    <dif class="flex-box">
                                                        <div class="input-group date" data-provide="datepicker">
                                                            <input type="text" class="form-control">
                                                            <div class="input-group-addon">
                                                                <span class="glyphicon glyphicon-calendar"></span>
                                                            </div>
                                                        </div>
                                                        <span>~</span>
                                                        <div class="input-group date" data-provide="datepicker">
                                                            <input type="text" class="form-control">
                                                            <div class="input-group-addon">
                                                                <span class="glyphicon glyphicon-calendar"></span>
                                                            </div>
                                                        </div>
                                                    </dif>
                                                </td>
                                            </tr>
                                        </table>
                                    </form>
                                </section>
                                <section class="list">
                                    <div class="section-header">
                                        <span class="sub-title">직원 목록</span>
                                        <input type="button" class="btn btn-default" value="목록 내보내기">
                                    </div>
                                    <form>
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th><input type="checkbox"></th>
                                                    <th>직원번호</th>
                                                    <th>이름</th>
                                                    <th>연락처</th>
                                                    <th>이메일</th>
                                                    <th>부서</th>
                                                    <th>직책</th>
                                                    <th>입사일</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${list}" var="dto">
                                                    <tr>
                                                        <td><input type="checkbox"></td>
                                                        <td>${dto.seqEmployee}</td>
                                                        <td>${dto.name}</td>
                                                        <td>${dto.tel}</td>
                                                        <td>${dto.mail}</td>
                                                        <td>${dto.department}</td>
                                                        <td>${dto.position}</td>
                                                        <td>${dto.join}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </form>
                                </section>
                                <%@ include file="/WEB-INF/inc/org-chart.jsp" %>
                            </div>
                    </main>

            </div>

            <script>

                $(function () {
                    let seq_department = new URL(location.href).searchParams.get('seq_department');
                    if (seq_department != '') {
                        $('span[data-seq_department=' + seq_department + ']').parent().addClass("sel");
                    }
                    $('.sel').parents().siblings('.glyphicon-folder-close')
                        .addClass('glyphicon-folder-open')
                        .removeClass('glyphicon-folder-close');
                });

                $('span[data-seq_department]').on({
                    click: function (event) {
                        location.href = location.pathname + '?seq_department=' + $(this).data('seq_department');
                        event.stopPropagation()
                    }
                });


            </script>

        </body>

        </html>