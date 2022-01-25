package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CategoryDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public CategoryDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("CategoryDAO.CategoryDAO");
            e.printStackTrace();
        }
    }

    /* 카테고리 목록 반환 메소드 */
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
