package com.test.main.customer.complain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/customer/complain/board.do")
public class Board extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String column = req.getParameter("column");
		String word = req.getParameter("word");
		String searchmode = "n";
		
		
		if ((column == null && word == null) 
				|| (column.equals("") && word.equals(""))) {
			searchmode = "n";
		} else {
			searchmode = "y";
		}
		
    	
		//DTO > HashMap
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("column", column);
		map.put("word", word);
		map.put("searchmode", searchmode);
		
    	
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
		
		String page = req.getParameter("page");
		
		if (page == null || page == "") nowPage = 1;
		else nowPage = Integer.parseInt(page);
		
		//nowPage > 현재 보게될 페이지 번호
		begin = ((nowPage - 1) * pageSize) + 1;
		end = begin + pageSize - 1;
		
		map.put("begin", begin + "");
		map.put("end", end + "");
		
		BoardDAO dao = new BoardDAO();
    	ArrayList<BoardDTO> list = dao.list(map);
    	
    	
    	Calendar now = Calendar.getInstance();
		String strNow = String.format("%tF", now); //"2022-01-13"
		
		for (BoardDTO dto : list) {
			
			//날짜 자르기
			if (dto.getRegdate().startsWith(strNow)) {
				dto.setRegdate(dto.getRegdate().substring(11));
			} else {
				dto.setRegdate(dto.getRegdate().substring(0, 10));
			}
			
			
			//제목이 길면 자르기
			if (dto.getTitle().length() > 20) {
				dto.setTitle(dto.getTitle().substring(0, 20) + "..");
			}
		}
		
		
		
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
			pagebar += String.format("<li><a href='/customer/complain/board.do?page=%d' aria-label='Previous'><span aria-hidden='true'>&laquo;</span></a></li>", n-1);
		}
		
		
		

		
		
		while (!(loop > blockSize || n > totalPage)) {
			
			if (n == nowPage) {
				pagebar += String.format("<li class='active'><a href='#!'>%d</a></li>", n);
			} else {
				pagebar += String.format("<li><a href='/customer/complain/board.do?page=%d'>%d</a></li>", n, n);
			}			
			
			loop++;
			n++;
		}
		

		
		if (n > totalPage) {
			pagebar += String.format("<li class='disabled'><a href='#!' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");
		} else {
			pagebar += String.format("<li><a href='/customer/complain/board.do?page=%d' aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>", n);
		}
		
		pagebar += "</ul></nav>";
		
		
		//2.
		req.setAttribute("list", list);
		
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/customer/complain/board.jsp");
        dispatcher.forward(req, resp);
    }
}
