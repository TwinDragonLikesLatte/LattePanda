package com.test.main.order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.main.notice.BoardDAO;
import com.test.main.notice.BoardDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * 진행중 주문의 서블릿
 * @author JH LEE
 *
 */
@WebServlet("/order/now.do")
public class Now extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	String column = req.getParameter("column");
    	
    	
		//DTO > HashMap
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("column", column);
    	
    	//페이징
		int nowPage = 0;		//현재 페이지 번호
		int totalCount = 0;
		int pageSize = 10;		//한페이지당 출력할 게시물 수
		int totalPage = 0;
		int begin = 0;			//where 시작 위치
		int end = 0;			//where 끝 위치
		int n = 0;
		int loop = 0;
		int blockSize = 10;
		
		//board.do > board.do?page=1
		//board.do?page=3
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") nowPage = 1;
		else nowPage = Integer.parseInt(page);
		
		//nowPage > 현재 보게될 페이지 번호
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
    	
    	ListDAO dao = new ListDAO();
    	ArrayList<ListDTO> list = dao.list();
    	
    	
    	
    	//페이지 바

		totalCount = dao.getTotalCount(map);
		totalPage = (int)Math.ceil((double)totalCount / pageSize);
		
		String pagebar = "";

		
		loop = 1; //루프변수(while)
		n = ((nowPage - 1) / blockSize) * blockSize + 1; //페이지 번호
		
		
		
		pagebar += "<nav><ul class=\"pagination\">";
		
		
		if (n == 1) {
			pagebar += String.format("<li class='disabled'><a href='#!' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>");
		} else {
			pagebar += String.format("<li><a href='/order/now.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>", n-1);
		}
		
		
		

		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				pagebar += String.format("<li class='active'><a href='#!'>%d</a></li>", n);
			} else {
				pagebar += String.format("<li><a href='/order/now.do?page=%d'>%d</a></li>", n, n);
			}			
			
			loop++;
			n++;
		}
		

		
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		} else {
			pagebar += String.format("<li><a href='/order/now.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>", n);
		}
		
		pagebar += "</ul></nav>";
    	
		
		req.setAttribute("list", list);
		req.setAttribute("map", map);
		
		req.setAttribute("pagebar", pagebar);
		req.setAttribute("nowPage", nowPage);
    	
    	
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order/now.jsp");
        dispatcher.forward(req, resp);
    }
}
