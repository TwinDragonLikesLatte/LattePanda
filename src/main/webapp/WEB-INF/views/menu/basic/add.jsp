<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <link rel="stylesheet" href="/asset/css/menu/menu.css">
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_menu.jsp" %> <!-- 본인 파트 서브내비로 바꾸세요. -->
        <div class="content">

            <h1 class="title">메뉴등록</h1>

            <%-- 레코드 추가 버튼 --%>
            <div class="plus-btn">
                <span class="glyphicon glyphicon-plus"></span>
            </div>

            <%-- 메뉴등록 폼 --%>
            <form method="POST" action="/menu/basic/addok.do">
                <div class="menu-table menu-add-table">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th><input type="checkbox" name="sel" value="add-sel"></th>
                            <th>상위 카테고리</th>
                            <th>하위 카테고리</th>
                            <th>메뉴코드</th>
                            <th>메뉴명</th>
                            <th>메뉴명(영문)</th>
                            <th>Regular</th>
                            <th>Large</th>
                            <th>1-Size</th>
                        </tr>
                        </thead>

                        <tboady>
                        <tr>
                            <td><input type="checkbox" name="sel" value="add-sel" class="chk-box"></td>

                            <%-- 상위 카테고리 select --%>
                            <td>
                                <select name="upper-category" class="form-control">
                                    <c:forEach items="${category}" var="cate">
                                        <c:if test="${empty cate.upperCategory}">
                                            <option value="upper-category">${cate.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>

                            <%-- 하위 카테고리 select --%>
                            <td>
                                <select name="category" class="form-control">
                                    <c:forEach items="${category}" var="cate">
                                        <c:if test="${not empty cate.upperCategory}">
                                            <option value="${cate.seqCategory}">${cate.categoryName}</option>
                                        </c:if>
                                        <c:if test="${cate.categoryName eq '굿즈'}">
                                            <option value="${cate.seqCategory}">${cate.categoryName}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </td>

                            <%-- 메뉴 코드, kr, en --%>
                            <td><input type="text" name="seq-menu" class="form-control" required></td>
                            <td><input type="text" name="name-kr" class="form-control" required></td>
                            <td><input type="text" name="name-en" class="form-control" required></td>

                            <%-- Regular size --%>
                            <td>
                                <select name="regular" class="form-control">
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>

                            <%-- Large size --%>
                            <td>
                                <select name="large" class="form-control">
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>

                            <%-- 1-size size --%>
                            <td>
                                <select name="1-size" class="form-control">
                                    <option value="Y">Y</option>
                                    <option value="N">N</option>
                                </select>
                            </td>
                        </tr>
                        </tboady>

                    </table>
                </div>

                <%-- 하단 버튼 박스 --%>
                <div class="btns">
                    <input type="button" value="목록으로"
                           class="btn btn-default"
                           onclick="location.href='/menu/basic/list.do';">
                    <input type="button" class="btn btn-danger remove-btn" value="삭제하기">
                    <input type="submit" value="등록하기" class="btn btn-primary">
                </div>
            </form>



        </div>
    </main>

</div>

<script>

    /* + 버튼 누를 경우 행 추가*/
    $('.plus-btn').click(()=>{
        $('.table tbody').append(
            '<tr>' +
            '<td><input type="checkbox" name="sel" value="add-sel" class="chk-box"></td>' +
            '<td>' +
                '<select name="upper-category" class="form-control">' +
                    '<option value="Y">ㅠㅠ</option>' +
                '</select>' +
            '</td>' +
            '<td>' +
                '<select name="upper-category" class="form-control">' +
                    '<option value="Y">ㅠㅠ</option>' +
                '</select>' +
            '</td>' +
            '<td><input type="text" name="seq-menu" class="form-control" required></td>' +
            '<td><input type="text" name="name-kr" class="form-control" required></td>' +
            '<td><input type="text" name="name-en" class="form-control" required></td>' +
            '<td>' +
                '<select name="regular" class="form-control"> ' +
                    '<option value="Y">Y</option>' +
                    '<option value="N">N</option>' +
                '</select>' +
            '</td>' +
            '<td>' +
                '<select name="large" class="form-control"> ' +
                '<option value="Y">Y</option>' +
                '<option value="N">N</option>' +
                '</select>' +
            '</td>' +
            '<td>' +
                '<select name="1-size" class="form-control"> ' +
                '<option value="Y">Y</option>' +
                '<option value="N">N</option>' +
                '</select>' +
            '</td>' +
            '</tr>'

        );
    });


    /* 체크 박스 전체 선택 or 해제 */
    $('thead input').click(()=>{
        if($('thead input').is(':checked')){
            $('.chk-box').prop('checked', true);
        }
        else $('.chk-box').prop('checked', false);

    });


    /* check box 선택 레코드 삭제 */
    //$('.table tbody').children().children().children('.chk-box').prop('checked', true)
    // 자괴감 들어서 못 하겠네ㅠ
    // 삭제하기 버튼 > tbody 의 children을 돌면서 첫번재 자식이 check된 것을 찾아 해당 레코드를 삭제한다.
    $('.remove-btn').click(()=>{
        if($('tbody .chk-box').is(':checked')){
            console.log(event.srcElement);
        }
    });



</script>

</body>
</html>
