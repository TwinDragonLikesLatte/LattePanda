
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>고객관리</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_customer.jsp" %>
        <div class="content">
        
       	<div class="search">
			<form method="GET" action="/customer/complain/board.do">
			
			<div class="searchdate" >
				<input type="date" name="startdate"> - 
				<input type="date" name="enddate">
			</div>
			<table>
				<tr>
					<td>
						<select name="column" class="form-control">
							<option value="title">제목</option>
							<option value="content">내용</option>
							<option value="name">부서</option>
						</select>
					</td>
					<td>
						<input type="text" name="word" class="form-control" required>
					</td>
					<td>
						<input type="submit" value="검색하기" class="btn btn-default">
					</td>
					
				</tr>
			</table>
			</form>
		</div>	
			
			
        <c:if test="${map.searchmode == 'y'}">
			<div style="text-align:center;margin:10px;color:#777;">'${map.word}'(으)로 검색한 ${list.size()}개의 게시물이 있습니다.</div>
		</c:if>
        
        

          <table class="table table-bordered list">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>이름</th>
					<th>날짜</th>
				</tr>
				<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.seq_complain}</td>
					<td>
						<a href="/customer/complain/board.do?seq=${dto.seq_complain}">${dto.title}</a>
					</td>
					<td>${dto.name}</td> 
					<td>${dto.regdate}</td>
				</tr>
				</c:forEach>
				<c:if test="${list.size() == 0}">
					<tr>
						<td colspan="5">게시물이 없습니다.</td>
					</tr>
				</c:if>
			</table>
			<div class="btns">
				<input type="button" value="글쓰기"
					class="btn btn-primary"
					onclick="location.href='/customer/complain/add.do';">
			</div>  
            
            <div class="pagebar">${pagebar}</div> <!-- 페이지바 안나옴 -->
            
        </div>
    </main>

</div>

<script>
	<c:if test="${map.searchmode == 'y'}">
	//검색 상태를 유지
	$('select[name=column]').val('${map.column}');
	$('input[name=word]').val('${map.word}');
	</c:if>
</script>

</body>
</html>
