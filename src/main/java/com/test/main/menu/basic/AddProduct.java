package com.test.main.menu.basic;

import com.test.main.menu.product.ProductDAO;
import com.test.main.menu.product.ProductDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu/basic/addproduct.do")
public class AddProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 신규 판매제품등록 화면
        * 1. 쿼리 스트링 세팅                  > seqMenu + sizeName(Regular)
        * 2. 메뉴 등록된 size 가져오기          > seqMenu
        * 3. 제품 불러오기                     > seqProduct
        * 4. 레시피 가져오기                   > seqProduct
        * 5. 메뉴변경내역 가져오기              > seqMenu + sizeName
        * 6. 레시피 등록을 위한 재고리스트 가져오기
        * */


        /* Query string */
        String seqMenu = req.getParameter("seqmenu");
        String sizeName = req.getParameter("sizename");


        /* menu */
        RegMenuDAO menuDAO = new RegMenuDAO();
        RegMenuDTO dto = menuDAO.get(seqMenu);


        /* Available size list */
        // - 메뉴의 현재 가용 가능한 size list
        // - list로 넘겨서 detail.jsp 상단 사이즈 탭 구성
        ArrayList<String> slist = new ArrayList<String>();
        if(dto.getRegular().equals("Y")) slist.add("Regular");
        if(dto.getLarge().equals("Y")) slist.add("Large");
        if(dto.getOneSize().equals("Y")) slist.add("1-Size");


        /* An product for recipe list */
        HashMap<String, String> map =new HashMap<String, String>();
        map.put("seqMenu", seqMenu);
        map.put("size", sizeName);

        ProductDAO productDao = new ProductDAO();
        ProductDTO pdto = productDao.get(map);


        /* Recipe list */
        RecipeDAO recipeDao = new RecipeDAO();
        ArrayList<RecipeDTO> rlist = null;
        if(dto != null)
            rlist = recipeDao.list(pdto.getSeqProduct());


        /* Product History list */
        ArrayList<ProductDTO> hlist = productDao.getHistoryList(map);


        /* Stock list */
        StockDAO stockDao = new StockDAO();
        ArrayList<StockDTO> stockList = stockDao.list();


        /* Setting request attribute */
        req.setAttribute("dto", dto);
        req.setAttribute("sizeName", sizeName);
        req.setAttribute("rlist", rlist);
        req.setAttribute("hlist", hlist);
        req.setAttribute("slist", slist);
        req.setAttribute("stockList", stockList);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/basic/addproduct.jsp");
        dispatcher.forward(req, resp);
    }

}
