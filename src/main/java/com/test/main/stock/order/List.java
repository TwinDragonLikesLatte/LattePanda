package com.test.main.stock.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.main.stock.StockDAO;
import com.test.main.stock.StockDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 재고 정보 조회
 * @author 임호혁
 *
 */
@WebServlet("/stock/order/list.do")
public class List extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String seq_store = "10101";
		String seq_stock_order = "";
		//1. DB 연결
		StockDAO dao = new StockDAO();
		seq_stock_order = dao.getSeqStockOrder(seq_store);
		
		// select
		ArrayList<StockDTO> list = new ArrayList<StockDTO>();
		
		list = dao.list(seq_store);
		list = dao.orderlist(seq_store, seq_stock_order, list);
		
		dao.close();
		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/stock/order/list.jsp");

		dispatcher.forward(req, resp);

	}
}
