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
 * '메뉴등록' 서블릿
 * @author 최선희
 */
@WebServlet("/menu/basic/add.do")
public class Add extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 메뉴등록
        * - select로 사용할 category dto 세팅
        * */

        /* DB */
        CategoryDAO dao = new CategoryDAO();
        ArrayList<CategoryDTO> category = dao.list();

        /* Setting request attribute */
        req.setAttribute("category", category);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/menu/basic/add.jsp");
        dispatcher.forward(req, resp);
    }

}
