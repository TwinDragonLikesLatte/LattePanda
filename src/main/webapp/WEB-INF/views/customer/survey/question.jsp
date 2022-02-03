<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>고객관리: 만족도조사</title>
    <%@ include file="/WEB-INF/inc/asset.jsp" %>
    <style>
        #modal.modal-overlay {
            width: 100%;
            height: 100%;
            position: absolute;
            left: 0;
            top: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            background: rgba(255, 255, 255, 0.25);
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
            backdrop-filter: blur(1.5px);
            -webkit-backdrop-filter: blur(1.5px);
            border-radius: 10px;
            border: 1px solid rgba(255, 255, 255, 0.18);
        }
        #modal .modal-window {
            background: rgba( 53, 30, 114, 0.70 );
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 350px;
            height: 300px;
            position: relative;
            top: -100px;
            padding: 10px;
        }
        #modal .title {
            padding-left: 10px;
            display: inline;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        #modal .title > div {
            display: inline-block;
            width : 100%;
        	text-align : center;
        	font-size : 24px;
        	
        }
        #modal .close-area {
            display: inline;
            float: right;
            padding-right: 10px;
            cursor: pointer;
            text-shadow: 1px 1px 2px gray;
            color: white;
        }
        
        #modal .content {
            margin-top: 20px;
            padding: 0px 10px;
            text-shadow: 1px 1px 2px gray;
            color: white;
            
        }
        
        
        #content {
        	width: 100%;
        }
        
        #content > p {
        	text-align : center;
        	font-size : 16px;
        	position: relative;
        	top : 20px;
        }
       
       form {
       		position : relative;
       		left : 30px;
       		top : 50px;
       }
       
       #count {
       		width : 200px;
       		height : 30px;
       		margin-right : 10px;
       		color : var(--black_main);
       }
        
    </style>
</head>
<body>

<div class="container">
    <%@ include file="/WEB-INF/inc/header.jsp" %>

    <main>
        <%@ include file="/WEB-INF/inc/sub-nav_customer.jsp" %>
        <div class="content">

		<!-- 비회원화면 -->
		<div id="container">
        <iframe src="https://forms.gle/DJLvGShJcRjmwfGE9" width="1540" height="820" frameborder="0"
	> </iframe>
    </div>
    <div id="modal" class="modal-overlay">
        <div class="modal-window">
            <div class="title">
            	<br>
                <div>LattePanda 만족도 조사</div>
            </div>
            <div class="close-area">X</div>
            <div class="content" id="content">
                <p>저희 매장을 이용해주셔서 감사합니다.</p>
                <p>주문번호를 입력해주세요</p>
                <p>단, 주문번호당 1회의 참여만 가능합니다.</p>
                
                
                <form method="POST" action="/customer/survey/questionok.do">
               	<input type="text" id = "count" name="count" placeholder="주문번호입력란">
                <input type="button" class ="btn btn-primary" id="btncheck" value="확인">
                <span id="result"></span>
            	</form>
            	
            </div>
        </div>
    </div>
           
    </main>

</div>

	<script>
		
	$("#btncheck").click(function() {
	    var order = $("#count").val();
	    if(order == ""){
	        //alert("주문번호를 입력해주세요");
	        $("#count").css('color', 'tomato');
	        $("#count").val('주문번호를 입력해주세요');
	    }else{
	        idCheckFunc(order);
	    }    
	});
	
	$('#btn').click(()=> {
	   
	  //1. 아이디 전송
	  //2. 서버(중복 검사) > 1 or 0 반환
	  //3. 결과에 따라 조치(메시지 출력)
	  
	  //데이터 주고(단일 데이터: 아이디) + 받고(단일 데이터: 숫자)
	  $.ajax({
		 
		type: 'GET',
	  	url: '/customer/survey/questionok.do',
	  	data: 'count=' + $('#count').val(), //id=hong
	  	dataType: 'text',
	  	success: function(result) {
	  		if (result == '1'){
	  			$('#result').css('color', 'tomato');
	  			$('#result').text('이미 사용중인 아이디입니다.');
	  		} else {
	  			$('#result').css('color', 'cornflowerblue');
	  			$('#result').text('사용가능한 아이디입니다.');
	  		}
	  	}
		  
	  });
	   
   });


	//x버튼
    const closeBtn = modal.querySelector(".close-area")
        closeBtn.addEventListener("click", e => {
            modal.style.display = "none"
        });
	</script>

</body>
</html>
