package com.test.main.menu.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu/product/list.do")
public class List extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 판매제품 조회
         * 1. 쿼리 스트링 세팅
         * 2. DB 데이터 가져오기
         * 3. 반환값 JSP 전달
         * */

        /* 메뉴조회 필터링 기능
         * list.do?category=커피&open-level=판매예정&start-date=2022-01-01&end-date=2022-01-24&search=아이스
         * 1) 전체보기
         * 2) 카테고리
         * 3) 메뉴공개등급
         * 4) 판매기간
         * 5) 메뉴이름
         * */


        /* Filter values */
        String all = req.getParameter("all");                           // 전체조회
        String[] category = req.getParameterValues("category");         // 카테고리 조회
        String[] openLevel = req.getParameterValues("open-level");      // 메뉴공개등급 조회
        String startDate = req.getParameter("start-date");              // 판매 시작 날짜 조회
        String endDate = req.getParameter("end-date");                  // 판매 종료 날짜 조회
        String search = req.getParameter("search");                     // 메뉴 이름 검색
        String filterMode = "n";                                           // 필터 선택 여부


        HashMap<String, Object> filter = new HashMap<String, Object>();
        filter.put("all", all);
        filter.put("category", category != null ? category : null);
        filter.put("openLevel", openLevel != null ? openLevel : null);
        filter.put("startDate", startDate);
        filter.put("endDate", endDate);
        filter.put("search", search);
        filter.put("filterMode",
                            category != null
                            || openLevel != null
                            || startDate != null
                            || endDate != null
                            || search != null ? "y" : filterMode);


        /* DB */
        ProductDAO dao = new ProductDAO();
        ArrayList<ProductDTO> list = dao.list(filter);

        /* Date type format 수정 */
        for(ProductDTO dto : list){
            // Reg-date
            dto.setRegDate(dto.getRegDate().substring(0, 10));

            // Sale start-date
            if(dto.getStartDate() != null)
                dto.setStartDate(dto.getStartDate().substring(0, 10));

            // Sale end-date
            if(dto.getEndDate() != null)
                dto.setEndDate(dto.getEndDate().substring(0, 10));
        }

        /* Setting request attribute */
        req.setAttribute("list", list);
        req.setAttribute("filter", filter);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/product/list.jsp");
        dispatcher.forward(req, resp);
    }

}
