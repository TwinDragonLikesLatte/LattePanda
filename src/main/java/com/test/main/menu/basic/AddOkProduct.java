package com.test.main.menu.basic;

import com.test.main.menu.product.ProductDAO;
import com.test.main.menu.product.ProductDTO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/menu/basic/addokproduct.do")
public class AddOkProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* 신규 판매제품등록 처리
        * 1. 쿼리 스트링 세팅
        * 2. 새로운 제품 seq 받아오기
        * 3. 제품 테이블 insert
        * 4. 레시피 테이블 insert
        * 5. 반환값 JSP 전달
        * */


        /* Query String */
        String seqMenu = req.getParameter("seqmenu");
        String sizeName = req.getParameter("sizename");
        String seqCategroy = req.getParameter("seqcategory");
        String saleStartDate = req.getParameter("sale-start-date");
        String saleEndDate = req.getParameter("sale-end-date");
        String sellingPrice = req.getParameter("selling-price");
        String costPrice = req.getParameter("cost-price");
        String costRate = req.getParameter("cost-rate");
        String[] seqStock = req.getParameterValues("seq-stock");
        String[] quantity = req.getParameterValues("quantity");

        String size = "";
        if(sizeName.equals("Regular")) size = "R";
        if(sizeName.equals("Large")) size = "L";
        if(sizeName.equals("1-Size")) size = "1S";


        /* Get new Product Sequence */
        ProductDAO pdao = new ProductDAO();
        String newSeqProduct = pdao.getNewSeq();


        /* Insert tblProduct */
        ProductDTO pdto = new ProductDTO();
        pdto.setSeqProduct(newSeqProduct);
        pdto.setSeqCategory(seqCategroy);
        pdto.setSeqMenu(seqMenu);
        pdto.setSizeName(size);
        pdto.setCostPrice(Integer.parseInt(costPrice));
        pdto.setSellingPrice(Integer.parseInt(sellingPrice));
        pdto.setCostRate(Double.parseDouble(costRate));
        pdto.setStartDate(saleStartDate);
        pdto.setEndDate(saleEndDate);

        int result = pdao.add(pdto);


        /* Insert tblRecipe */
        if(result == 1){
            HashMap<String, Object> recipeMap = new HashMap<String, Object>();
            recipeMap.put("newSeqProduct", newSeqProduct);
            recipeMap.put("seqStock", seqStock);
            recipeMap.put("quantity", quantity);

            RecipeDAO rdao = new RecipeDAO();
            result = rdao.add(recipeMap);
        }

        PrintWriter writer = resp.getWriter();
        writer.print(result);
        writer.close();

    }

}
