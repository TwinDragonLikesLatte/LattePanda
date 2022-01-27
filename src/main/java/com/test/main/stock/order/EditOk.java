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

@WebServlet("/stock/order/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String[] quantity = req.getParameterValues("quantity");
		String seq_store = "10101";
		StockDAO dao = new StockDAO();
		String seq_stock_order = dao.getSeqStockOrder(seq_store);
		
		
		ArrayList<StockDTO> list = dao.list(seq_store);
		list = dao.orderlist(seq_store, seq_stock_order, list);
		
		int i = 0;
		int result = 1;
		//int result2 = 1;
		
		for(StockDTO dto : list) {
			dto.setQuantity_order(Integer.parseInt(quantity[i]));
			result = dao.editorder(dto);
			if(result == 0) {
				break;
			}
			i++;
		}
		
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/stock/order/editok.jsp");

		dispatcher.forward(req, resp);

	}
}
