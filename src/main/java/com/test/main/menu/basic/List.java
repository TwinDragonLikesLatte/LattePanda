package com.test.main.menu.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * '메뉴조회' 서블릿
 * @author 최선희
 */
@WebServlet("/menu/basic/list.do")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 메뉴조회
        * 1. 쿼리 스트링 세팅
        * 2. DB 데이터 가져오기
        * 3. 반환값 JSP 전달
        * */

        /* 메뉴조회 필터링 기능
        * 1) 전체보기만 클릭시  > list.do?all=on&search=
        * 2) 카테고리만 선택시  > list.do?category=블렌디드&category=병음료&search=
        * 3) 이름만 검색시     > list.do?name=아메리카노
        * 4) 카테고리 + 이름   > list.do?category=커피&category=아이스크림&search=아이스
        * */

        
        /* Query String (Filter values) */
        String all = req.getParameter("all");
        String[] category = req.getParameterValues("category");
        String search = req.getParameter("search");
        String filterMode = "n";

        HashMap<String, Object> filter = new HashMap<String, Object>();
        filter.put("all", all);
        filter.put("category", category != null ? category : null);
        filter.put("search", search);
        filter.put("filterMode", category != null || search != null ? "y" : filterMode);

        /* DB */
        RegMenuDAO dao = new RegMenuDAO();
        ArrayList<RegMenuDTO> list = dao.list(filter);

        /* Setting request attribute */
        req.setAttribute("list", list);
        req.setAttribute("filter", filter);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/basic/list.jsp");
        dispatcher.forward(req, resp);
    }

}
