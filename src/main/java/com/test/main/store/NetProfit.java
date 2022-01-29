package com.test.main.store;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.main.home.MontlyTotalDTO;
/**
 * 매장관리 순이익 서블릿
 * @author kujun-kang
 *
 */
@WebServlet("/store/netprofit/net.do")
public class NetProfit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.setCharacterEncoding("UTF-8");
    	
    	String store = req.getParameter("store");
    	
    	if(store == null) {
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
    	
    	
    	dao.close();
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/store/netprofit.jsp");
        dispatcher.forward(req, resp);
    }
}
