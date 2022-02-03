package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 레시피 DAO 클래스
 * @author 최선희
 */
public class RecipeDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * RecipeDAO 생성자
     */
    public RecipeDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("RecipeDAO.RecipeDAO");
            e.printStackTrace();
        }
    }

    /**
     * 레시피 리스트(재료정보)를 반환하는 메소드
     * Detail.java > 제품 레시피 리스트 요청
     * @param seqProduct 제품코드
     * @return 레시피 리스트
     */
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
                dto.setSeqStock(rs.getString("seq_stock"));
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

    /**
     * DB에 레시피를 INSERT하는 메소드
     * AddOkProduct.java > 제품 레시피 등록
     * @param recipeMap 저장할 레시피 HashMap
     * @return INSERT 결과값 반환
     */
    public int add(HashMap<String, Object> recipeMap) {

        try{
            String sql = "insert into tblrecipe(seq_recipe, seq_product, seq_stock, quantity) " +
                        "values ((select max(seq_recipe)+1 from tblrecipe), ?, ?, ?)";

            String[] seqStock = (String[])recipeMap.get("seqStock");
            String[] quantity = (String[])recipeMap.get("quantity");
            int length = seqStock.length;
            int result = 0;


            for(int i = 0; i < length; i++){
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, (String)recipeMap.get("newSeqProduct"));
                pstat.setString(2, seqStock[i]);
                pstat.setString(3, quantity[i]);
                result = pstat.executeUpdate();
                pstat.close();
            }

            return result;

        }catch (Exception e){
            System.out.println("RecipeDAO.add");
            e.printStackTrace();
        }

        return 0;
    }
}
