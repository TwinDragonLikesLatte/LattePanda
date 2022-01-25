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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		String ame = req.getParameter("ame");
		
		
		ListDAO dao = new ListDAO();
		ListDTO
		int result = dao.add();
		
		req.setAttribute("result", result);
		
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order/buttonorder.jsp");
		dispatcher.forward(req, resp);
	}

}
