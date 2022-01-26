package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RecipeDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public RecipeDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("RecipeDAO.RecipeDAO");
            e.printStackTrace();
        }
    }

    /* detail.java > 제품 레시피 내역 요청 */
    public ArrayList<RecipeDTO> list(String seqProduct) {

        try {
            String sql = "select * from vwrecipe where seq_product = ? ";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqProduct);
            rs = pstat.executeQuery();

            ArrayList<RecipeDTO> recipeList = new ArrayList<RecipeDTO>();
            while(rs.next()){
                RecipeDTO dto = new RecipeDTO();
                dto.setSeqProduct(rs.getString("seq_product"));
                dto.setSeqMenu(rs.getString("seq_menu"));
                dto.setName(rs.getString("name"));
                dto.setUnit(rs.getString("unit"));
                dto.setQuantity(rs.getString("quantity"));
                dto.setUnitCost(rs.getString("unit_cost"));
                dto.setOnePrice(rs.getString("one_price"));

                recipeList.add(dto);
            }

            conn.close();
            return recipeList;

        }catch (Exception e){
            System.out.println("RecipeDAO.list");
            e.printStackTrace();

        }

        return null;
    }
}
