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

@WebServlet("/menu/basic/detail.do")
public class Detail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 상세조회
        * 1. 쿼리 스트링 세팅         > seqMenu
        * 2. 등록된 size 가져오기     > seqMenu -> (regMenu 조회) -> 우선순위: Regular > Large > 1-Size
        * 3. Product DAO            > seqMenu + size + seqProduct desc
        * 4. 레시피 가져오기          > seqProduct
        * 5. 메뉴변경내역 가져오기    > seqMenu + size
        * 6. 반환값 JSP 전달
        * */


        /* Query string */
        String seqMenu = req.getParameter("seqmenu");


        /* Select one record from *RegMenu* and Get the 'available size' */
        RegMenuDAO menuDao = new RegMenuDAO();
        RegMenuDTO menuDto  = menuDao.get(seqMenu);

        // - Default로 보여줄 페이지의 size 세팅
        // - 첫페이지 세팅을 위한 select where 조건으로 사용
        String size = "";
        if(menuDto.getRegular().equals("Y")) size = "Regular";
        else if (menuDto.getLarge().equals("Y")) size = "Large";
        else if (menuDto.getOneSize().equals("Y")) size = "1-Size";


        /* Available size list */
        // - 메뉴의 현재 가용 가능한 size list
        // - list로 넘겨서 detail.jsp 상단 사이즈 탭 구성
        ArrayList<String> slist = new ArrayList<String>();
        if(menuDto.getRegular().equals("Y")) slist.add("Regular");
        if(menuDto.getLarge().equals("Y")) slist.add("Large");
        if(menuDto.getOneSize().equals("Y")) slist.add("1-Size");


        /* Select one record from *Product* */
        HashMap<String, String> map =new HashMap<String, String>();
        map.put("seqMenu", seqMenu);
        map.put("size", size);

        ProductDAO productDao = new ProductDAO();
        ProductDTO dto = productDao.get(map);


        /* Recipe list */
        RecipeDAO recipeDao = new RecipeDAO();
        ArrayList<RecipeDTO> rlist = null;
        if(dto != null)
            rlist = recipeDao.list(dto.getSeqProduct());


        /* Product History list */
        ArrayList<ProductDTO> hlist = productDao.getHistoryList(map);


        /* Setting request attribute */
        req.setAttribute("dto", dto);
        req.setAttribute("rlist", rlist);
        req.setAttribute("hlist", hlist);
        req.setAttribute("slist", slist);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/basic/detail.jsp");
        dispatcher.forward(req, resp);
    }

}
