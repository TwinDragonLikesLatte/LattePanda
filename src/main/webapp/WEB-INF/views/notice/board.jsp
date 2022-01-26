<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<html>
<head>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
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
    		width : 710px;
    		border : 2px solid #BEBEBE;
    		position: relative;
    		left : 200px;
    		top : 35px;
    		margin: 0px;
    	}
    	
    	.pagebar {
    		position : relative;
    		left: 580px;
    		top : 50px;
    		width : 500px;
    	}
    	
 /*    	html > .content > .btns > .btn-primary { /* 안됨.. */
    		width: 100px;
    		positon: relative;
    		left: 800px !important;
    		margin: 0px;
    		backgorund-color: gold;
    		
    	} */
    	
    	
    	button, html input[type="button"] {
    		color : black;
    	}
    	
    	.searchdate {
    		float : left;
    		margin-right: 30px;
    	}
    	
    	.searchdate > input { height: 34px; width: 140px; }
    	
    	.form-control {
    		margin-right : 20px;
    	}
    	
    	
   	.pagebar .pagination > .active > a {
    	background-color: var(--purple_three);
    	color: var(--white);
    }
    
    .pagebar .pagination > li > a {
    	color: var(--black_main);
    }
    
    </style>

    <%@ include file="/WEB-INF/inc/asset.jsp" %>
 

</head>
<body>
  
    </script>
<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_notice.jsp" %>
        <div class="content">
        
        
        <div class="search">
				<form method="GET" action="/notice/board.do">
				
				<div name ="calendar" class="searchdate" >
					<input type="date" name="startDate" value="regdate"> - 
					<input type="date" name="enddate" value="regdate">
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
			<div style="text-align:center;margin:10px;color:#777;">'${map.word}${map.name}'(으)로 검색한 ${list.size()}개의 게시물이 있습니다.</div>
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
 
				<input type="button" value="글쓰기"
					class="btn btn-primary" id="btn"
					onclick="location.href='/notice/add.do';">


           	<div class="pagebar">${pagebar}</div>
           
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
