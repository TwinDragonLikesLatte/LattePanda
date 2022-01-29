
package com.test.main.store;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 매장관리 영업이익 서블
 * @author kujun-kang
 *
 */
@WebServlet("/store/netprofit/operating.do") // 주소를 적는 부분이고 앞에 code까지 들어가있는 상태이다. do 부분만 적는데 앞에 가상주소가 있으면 그것도 적어준다.
public class OperatingProfit extends HttpServlet { // HttpServlet 상속 받고

	// doGet
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");

		String store = req.getParameter("store");

		if (store == null) {
			store = "11801";
		}

		System.out.println(store);
		
		//[세션에서 불러들일 값]
    	//String seq_position = (String) session.getAttribut("seq_position");
    	//position 점장(8), [(1),(2),(3),(4),(7) 지역장, 과장이상], 매니저(9), 사원(6), 대리(5)
    	
    	String seq_position = "7";

		StoreDAO dao = new StoreDAO();

		ArrayList<StoreProfitDTO> storeprofit = dao.storeprofit();
		ArrayList<ProfitValuesDTO> profitvalues = dao.profitvalues(store);

		req.setAttribute("storeprofit", storeprofit);
		req.setAttribute("profitvalues", profitvalues);
		req.setAttribute("store", store);

		req.setAttribute("seq_position", seq_position);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/store/operatingprofit.jsp"); // 지금 이경로
																												// 기본으론
																												// webapp임
		dispatcher.forward(req, resp);
	}
}