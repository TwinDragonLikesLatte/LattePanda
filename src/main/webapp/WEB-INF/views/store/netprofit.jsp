<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>title</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_store.jsp" %>
        <div class="content">
        	<div class="netprofit_content_container">
        		<div class="netprofit_content_grid">
            		<div class="netprofit_content_header">전 매장 순수익별 순위</div>
            		<div class="netprofit_select">
            			<table class="table table-bordered select">
            				<tr>
            					<td>매장명</td>
            					<td>순이익
            					<form method="POST" action="/home/dashboard.do">
            						<input type="button" class="btn btn-primary" value="10101">
            					</form>
            					</td>
            				</tr>
            			</table>
            		</div>
            	</div>
            	<div class="netprofit_content_grid">
            		<div class="netprofit_content_header">선택 매장 지출 비율</div>
            	</div>
            </div>

<!--             <div>
                버튼예제<br>
                <input type="button" class="btn btn-primary" value="등록하기">
                <input type="button" class="btn btn-danger" value="취소하기">
                <input type="button" class="btn btn-default" value="목록보기">
            </div> -->
        </div>
    </main>

</div>

<script>

</script>

</body>
</html>
