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
//    	
//    	String store = req.getParameter("store");
//    	System.out.println(store);
    	

    	DashBoardDAO dao = new DashBoardDAO();
    	
    	//로그인 20160006 손윤희
    	String loginNum = "20160006";
    	
    	
    	
    	if (loginNum == "20160006") {
    	
    	//[점장] 당일 판매액
    	String total = dao.total();
    	//[점장] 월간 판매액
    	ArrayList<MontlyTotalDTO> list = dao.list();
    	//[점장] 당일 상품별 판매량
    	ArrayList<DailySellProdDTO> prod = dao.prod();
    	//[점장] 재고상황 
    	ArrayList<StockRemainDTO> stockremain = dao.stockremain();
    	//[점장] 스태프 당일 근무표
    	ArrayList<StaffScheduleDTO> staffschedule = dao.staffschedule();
    	
    	req.setAttribute("total", total);
    	req.setAttribute("list", list);
    	req.setAttribute("prod", prod);
    	req.setAttribute("stockremain", stockremain);
    	req.setAttribute("staffschedule", staffschedule);
    	
    	}
    	
    	
    	else {
    	
    	//id , 부서명, 직책명, 부서번호, 직책번호
    	// 강남대로점 310101 
    	//
    	//[지역장] 지역내 지점 일일 매출 현황 (상품별 판매량) 
    	ArrayList<AreaDailySellProdDTO> areaprod = dao.areaprod();
    	//[지역장] 지점별 당일 판매액
    	String areatotal = dao.areatotal();
    	//[지역장] 지점별 월간 총 판매액 
    	ArrayList<AreaMontlyTotalDTO> areamontotal = dao.areamontotal();
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
    	
    	//[점장], [지역장] 공지사항
    	ArrayList<NoticeDTO> notice = dao.notice();
    	req.setAttribute("notice", notice);
    	
    	dao.close();
    	
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/home/dashboard.jsp");
        dispatcher.forward(req, resp);
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    	System.out.println("-- doPost() --");
    	
    	doGet(req, resp);
    }
    
}
