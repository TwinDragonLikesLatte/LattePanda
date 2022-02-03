package com.test.main.stock.order;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.main.stock.StockDAO;
import com.test.main.stock.StockDTO;

@WebServlet("/stock/order/edit.do")
public class Edit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String seq_store = "10101";

		StockDAO dao = new StockDAO();
		
		String seq_stock_order = dao.getSeqStockOrder(seq_store);
	
		ArrayList<StockDTO> list = dao.list(seq_store);
		list = dao.list(seq_store);
		list = dao.orderlist(seq_store, seq_stock_order, list);
		
		dao.close();
		
		req.setAttribute("list", list);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/stock/order/edit.jsp");

		dispatcher.forward(req, resp);

	}
}

