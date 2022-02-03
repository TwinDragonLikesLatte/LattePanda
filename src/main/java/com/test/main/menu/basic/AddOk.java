package com.test.main.menu.basic;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * '메뉴등록' 처리 서블릿
 * @author 최선희
 */
@WebServlet("/menu/basic/addok.do")
public class AddOk extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 메뉴등록 처리
        * 1. POST > 인코딩
        * 2. 데이터 가져오기 (regMenu)
        * 3. DB > insert (tblMenu, tblRegMenu)
        * 4. 결과 피드백
        * */

        /* Setting UTF-8 */
        req.setCharacterEncoding("UTF-8");

        /* Get parameter */
        String upperCategory = req.getParameter("upper-category");
        String seqCategory = req.getParameter("category");
        String seqMenu = req.getParameter("seq-menu");
        String nameKr = req.getParameter("name-kr");
        String nameEn = req.getParameter("name-en");
        String regular = req.getParameter("regular");
        String large = req.getParameter("large");
        String oneSize = req.getParameter("1-size");


        /* DB insert */
        MenuDAO menuDao = new MenuDAO();
        MenuDTO menuDto = new MenuDTO();

        menuDto.setSeqCategory(seqCategory);
        menuDto.setSeqMenu(seqMenu);
        menuDto.setNameKr(nameKr);
        menuDto.setNameEn(nameEn);

        ArrayList<String> menuSize = new ArrayList<String>();
        if(regular.equals("Y")) menuSize.add("R");
        if(large.equals("Y")) menuSize.add("L");
        if(oneSize.equals("Y")) menuSize.add("1S");
        menuDto.setMenuSize(menuSize);

        /* insert result */
        int result = menuDao.add(menuDto);


        /* Setting request attribute */
        req.setAttribute("result", result);


        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/basic/addok.jsp");
        dispatcher.forward(req, resp);
    }

}
