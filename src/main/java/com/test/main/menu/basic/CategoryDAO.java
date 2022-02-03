package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * 메뉴 카테고리 DAO 클래스
 * @author 최선희
 */
public class CategoryDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * CategoryDAO 생성자
     */
    public CategoryDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("CategoryDAO.CategoryDAO");
            e.printStackTrace();
        }
    }

    /**
     * 메뉴 카테고리 리스트를 반환하는 메소드
     * @return 메뉴 카테고리 리스트
     */
    public ArrayList<CategoryDTO> list() {

        try {
            /* Execute Query */
            String sql = "select * from tblcategory";
            rs = stat.executeQuery(sql);

            /* Return Result */
            ArrayList<CategoryDTO> category = new ArrayList<CategoryDTO>();

            while(rs.next()){
                CategoryDTO dto = new CategoryDTO();

                dto.setSeqCategory(rs.getString("seq_category"));
                dto.setCategoryName(rs.getString("category_name"));
                dto.setUpperCategory(rs.getString("upper_category"));

                category.add(dto);
            }

            conn.close();
            return category;

        } catch (Exception e){
            System.out.println("CategoryDAO.list");
            e.printStackTrace();
        }

        return null;
    }
}
