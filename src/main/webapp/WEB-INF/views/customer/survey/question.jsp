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
            background: rgba( 69, 139, 197, 0.70 );
            box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
            backdrop-filter: blur( 13.5px );
            -webkit-backdrop-filter: blur( 13.5px );
            border-radius: 10px;
            border: 1px solid rgba( 255, 255, 255, 0.18 );
            width: 400px;
            height: 500px;
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
        #modal .title h2 {
            display: inline;
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
            margin-right: 0;
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
                <h2>LattePanda 만족도 조사</h2>
            </div>
            <div class="close-area">X</div>
            <div class="content">
                <p>저희 매장을 이용해주셔서 감사합니다.</p>
                <p>주문번호를 입력해주세요</p>
                <p>단, 주문번호당 1회의 참여만 가능합니다.</p>
                
                
               	<input type="text" class="ordercheck" name="ordercheck">
                <input type="button" class ="btn btn-primary"    onclick="location.href='/customer/survey/questionok.do'" value="확인">
            </div>
        </div>
    </div>
           

        </div>
    </main>

</div>


<script>


    const closeBtn = modal.querySelector(".close-area")
        closeBtn.addEventListener("click", e => {
            modal.style.display = "none"
        })
</script>

</body>
</html>
