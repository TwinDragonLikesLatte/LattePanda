package com.test.main.stock.list;

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

@WebServlet("/stock/list/editok.do")
public class EditOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//1. UTF-8 인코딩
		req.setCharacterEncoding("UTF-8");
				
		//2. 전달받은 값 배열로 저장
		String[] quantity = req.getParameterValues("quantity");
		String[] waste = req.getParameterValues("waste");
		String[] etc = req.getParameterValues("etc");
//		String seq_store = req.getParameter("seq_store");
		String seq_store = "10101";
		
		
		StockDAO dao = new StockDAO();
		ArrayList<StockDTO> list = dao.list(seq_store);
		int i = 0;
		int result = 1;
		int result2 = 1;
		
		for(StockDTO dto : list) {
			dto.setPre_quantity(Integer.parseInt(quantity[i]));
			dto.setWaste(Integer.parseInt(waste[i]));
			dto.setEtc(etc[i]);
			
			result = dao.edit(dto);
			if(result == 0) {
				break;
			}
			
			result2 = dao.editCheck(dto);
			if(result2 == 0) {
				break;
			}
			
			i++;
		}
		
		
		
		
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/stock/list/editok.jsp");

		dispatcher.forward(req, resp);

	}
}
