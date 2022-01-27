package com.test.main.home;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home/dashboard.do")
public class DashBoard extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
    	String store = req.getParameter("store");
    	
    	//[dashboard.jsp [지역장] 지점 선택시 들어오는 값에 대한 기본값 설정]
    	if(store == null) {
    		store = "10101";
    		req.setAttribute("store", store);
    	}
    	
    	//[세션에서 불러들일 값]
    	//String seq_department = (String) session.getAttribut("seq_department");
    	//String seq_position = (String) session.getAttribut("seq_position");
    	//String seq_store = (String) session.getAttribut("seq_store");
    	

    	DashBoardDAO dao = new DashBoardDAO();
    	
    	//position 점장(8), [(1),(2),(3),(4),(7) 지역장, 과장이상], 매니저(9), 사원(6), 대리(5)
    	//[로그인] 손윤희 - 세션에서 불러들이면 지울 코드
    	String seq_department = "31010";
    	String seq_position = "7";
    	
    	//로그인에 필요한 세션값을 Int로 바꿔 If문에 사용한다.
    	int department = Integer.parseInt(seq_department);
    	int position = Integer.parseInt(seq_position);
    	
    	//부서번호가 300000 이상 이며 점장 포지션일때
    	if (department > 300000 && position == 8) {
    	
    	//세션값 중 seq_store 값을 통해 SQL문 수정 예정
    	//[점장] 당일 판매액
    	String total = dao.total();
    	//[점장] 월간 판매액
    	ArrayList<MontlyTotalDTO> list = dao.list();
    	//[점장] 당일 상품별 판매량
    	ArrayList<DailySellProdDTO> prod = dao.prod();
    	//[점장] 재고상황 
    	ArrayList<StockRemainDTO> stockremain = dao.stockremain();
    	//[점장] 스태프 당일 근무표 21년 11월 1~3 까지밖에 데이터 없음 데이터 생성 Current_date로 오늘날짜로 변경 DataGrip 참조
    	ArrayList<StaffScheduleDTO> staffschedule = dao.staffschedule();
    	//[점장] 직원 당일 근무표 데이터 없음 이름만 추가해놓음. 데이터 입력받아도 어떻게 넣어야 할지 모르겠음..
    	ArrayList<EmployeeScheduleDTO> employeeschedule = dao.employeeschedule();
    	
    	req.setAttribute("total", total);
    	req.setAttribute("list", list);
    	req.setAttribute("prod", prod);
    	req.setAttribute("stockremain", stockremain);
    	req.setAttribute("staffschedule", staffschedule);
    	req.setAttribute("employeeschedule", employeeschedule);
    	
    	}
    	
    	//부서번호가 300000 이하 이며 점장 이외의 포지션일때
    	else if (department < 300000 && position < 8) {
    	
    	//선택되는 지점 번호에 따라 다르며, 공통인 전지역 매출현황, 월간 상품별 판매량은 바뀌지 않음
    	//[지역장] 지역내 지점 일일 매출 현황 (상품별 판매량) 
    	ArrayList<AreaDailySellProdDTO> areaprod = dao.areaprod(store);
    	//[지역장] 지점별 당일 판매액
    	String areatotal = dao.areatotal(store);
    	//[지역장] 지점별 월간 총 판매액 
    	ArrayList<AreaMontlyTotalDTO> areamontotal = dao.areamontotal(store);
    	//[지역장] 전지역 매출 현황
    	ArrayList<AreaDalyAllTotalDTO> areaalltotal = dao.areaalltotal();
    	//[지역장] 전지점 월간 상품별 판매량
    	ArrayList<AreaMonSellProdDTO> areamonsellprod = dao.areamonsellprod();
    	
    	req.setAttribute("areamonsellprod", areamonsellprod);
    	req.setAttribute("areatotal", areatotal);
    	req.setAttribute("areamontotal", areamontotal);
    	req.setAttribute("areaprod", areaprod);
    	req.setAttribute("areaalltotal", areaalltotal);
    	
    	
    	} 
    	
    	//[점장], [지역장] 공지사항은 공통사항이기에 따로 빼놓음
    	ArrayList<NoticeDTO> notice = dao.notice();
    	req.setAttribute("notice", notice);
    	
    	//[connection close() 메모리 누수 방지]
    	dao.close();
    	
    	//세션에서 받은 값을 dashboard.jsp 로 보내 <c:if> 분기에 사용
    	req.setAttribute("seq_department", seq_department);
    	req.setAttribute("seq_position", seq_position);
//    	req.setAttribute("store", store);
    	
    	
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home/dashboard.jsp");
        dispatcher.forward(req, resp);
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	System.out.println("-- doPost() --");
    	
    	doGet(req, resp);
    }
    
}
