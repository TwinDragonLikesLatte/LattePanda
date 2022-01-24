<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>공지사항</title>
    
    <style>
    	
    	#list {
    		position: relative;
    		left : 200px;
    		top : 50px;
    		
    	}
    	
    	#list tr:nth-child(1) {
    		text-align : center;
    		color : var(--white);
    	}
    	
    	.search {
    		padding: 5px;
    		width : 800px;
    		border : 2px solid #BEBEBE;
    		position: relative;
    		left : 250px;
    		top : 35px;
    		margin: 0px;
    	}
    	
    	.pagebar {
    		position : relative;
    		left: 580px;
    		top : 50px;
    		width : 500px;
    	}
    	
    	#btnwrite { /* 안됨.. */
    		width: 100px;
    		positon: relative;
    		left: 800px;
    		margin: 0px;
    		
    	}
    	
    	.searchdate {
    		float : left;
    		margin-right: 40px;
    	}
    	
    	.searchdate > input { height: 30px; widht: 140px; }
    	
    	.form-control {
    		margin-right : 20px;
    	}
    </style>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>

</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_notice.jsp" %>
        <div class="content">
        
        
        <div class="search">
				<form method="GET" action="/notice/board.do">
				
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

           <table class="table table-bordered list" style="width: 1140px;" id="list">
           		<tr bgcolor="#504B71">
           			<th>번호</th>
           			<th>제목</th>
           			<th>작성부서</th>
           			<th>등록일</th>
           		</tr>
           		<c:forEach items="${list}" var="dto">
           		<tr>
					<td>${dto.seq_notice}</td> 			<!-- 번호 -->
					<td>
						<a href="/notice/view.do?seq=${dto.seq_notice}&column=${map.column}&word=${map.word}&page=${nowPage}">${dto.title}</a>
					</td>
					<td>${dto.name}</td>	<!-- 작성부서 -->
					<td>${dto.regdate}</td>			<!-- 등록일 -->
				</tr>	
           		</c:forEach>
           		<c:if test="${list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
				</c:if>
           </table>
           <div class="btns" id="btnwrite">
			
				<input type="button" value="글쓰기"
					class="btn btn-primary"
					onclick="location.href='/notice/add.do';">
           <div class="pagebar">${pagebar}</div>
           
           </div>
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
