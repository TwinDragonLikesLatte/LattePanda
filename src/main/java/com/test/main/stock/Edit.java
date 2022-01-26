package com.test.main.stock;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/stock/list/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//호출
    	//1. DB 작업 > select > DAO 위임
    	//1.5 데이터 조작
    	//2. 반환값 전달 + JSP 호출
    	
    	//매장 번호
    	String seq_store = "10101";
    	
    	//1.
    	StockDAO dao = new StockDAO();
    	
    	ArrayList<StockDTO> list = dao.list(seq_store);
    	
    	HttpSession session = req.getSession();
    	
    	req.setAttribute("list", list);
    	
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/stock/list/edit.jsp");

		dispatcher.forward(req, resp);

	}
}
