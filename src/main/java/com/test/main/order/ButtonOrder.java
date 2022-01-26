package com.test.main.order;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/order/buttonorder.do") 
public class ButtonOrder extends HttpServlet { 

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		//아메리카노
		String txtame = req.getParameter("txtame");
		String txtamedetail = req.getParameter("txtamedetail");
		
		
		ListDAO dao = new ListDAO();
		ListDTO dto = new ListDTO();
		
		//아메리카노
		dto.setStart_order(txtame);
		dto.setSeq_product(txtamedetail);
		
		
		int resultorder = dao.addorder(dto);
		req.setAttribute("resultorder", resultorder);

		int resultdetail = dao.addorderdetail(dto);
		req.setAttribute("resultdetail", resultdetail);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order/buttonorder.jsp");
		dispatcher.forward(req, resp);
	}

}
