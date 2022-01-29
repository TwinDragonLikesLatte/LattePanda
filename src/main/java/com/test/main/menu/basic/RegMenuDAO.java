package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 등록메뉴 DAO 클래스
 * @author 최선희
 */
public class RegMenuDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * RegMenuDAO 생성자
     */
    public RegMenuDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("RegMenuDAO.RegMenuDAO");
            e.printStackTrace();
        }
    }

    /**
     * 카테고리 필터 query 생성 메소드
     * @param cateList 카테고리 리스트
     * @return 카테고리 where query절
     */
    public String makeWhereCategory(String[] cateList){
        String where = "category_name in (";

        for(int i = 0 ; i < cateList.length; i++){
            where += "'" + cateList[i] + "',";
            if(i == cateList.length - 1)
                where += "'" + cateList[i] + "')";
        }
        return where;
    }


    /**
     * 등록된 메뉴 리스트를 반환하는 메소드
     * List.java > 메뉴 리스트 요청
     * @param filter 검색 조건 HashMap
     * @return 등록메뉴 리스트
     */
    public ArrayList<RegMenuDTO> list(HashMap<String, Object> filter) {

        try {
            /* Filter Condition */
            String where = "";
            if(filter.get("filterMode").equals("y")){
                // 이름만 검색
                if(filter.get("category") == null){
                    where = String.format("where name_kr like '%%%s%%'"
                            , filter.get("search"));
                }

                // 카테고리만 검색
                else if (filter.get("search").equals("")){
                    where = String.format("where %s"
                            , makeWhereCategory((String[])filter.get("category")));
                }

                // 이름 + 카테고리 검색
                else {
                    where = String.format("where name_kr like '%%%s%%' and %s"
                            ,filter.get("search")
                            ,makeWhereCategory((String[])filter.get("category")));
                }
            }

            /* Execute Query */
            String sql = "select * from vwRegMenu " + where;
            rs = stat.executeQuery(sql);

            /* Return Result */
            ArrayList<RegMenuDTO> list = new ArrayList<RegMenuDTO>();

            while(rs.next()){
                RegMenuDTO dto = new RegMenuDTO();
                dto.setUpperCategory(rs.getString("upper_category"));
                dto.setSeqCategory(rs.getString("seq_category"));
                dto.setCategoryName(rs.getString("category_name"));
                dto.setSeqMenu(rs.getString("seq_menu"));
                dto.setNamekr(rs.getString("name_kr"));
                dto.setNameEn(rs.getString("name_en"));
                dto.setRegular(rs.getString("regular"));
                dto.setLarge(rs.getString("large"));
                dto.setOneSize(rs.getString("1-size"));
                dto.setHaveProduct(rs.getString("have_product"));

                list.add(dto);
            }

            conn.close();
            return list;

        } catch (Exception e) {
            System.out.println("RegMenuDAO.list");
            e.printStackTrace();
        }

        return null;
    }


    /**
     * 등록메뉴 레코드 하나를 반환하는 메소드
     * detail.java > 메뉴 목록 하나 요청
     * @param seqMenu 메뉴코드
     * @return 등록메뉴DTO
     */
    public RegMenuDTO get(String seqMenu) {

        try {
            String sql = "select * from vwRegMenu where seq_menu = ?";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqMenu);
            rs = pstat.executeQuery();

            if(rs.next()){
                RegMenuDTO dto = new RegMenuDTO();
                dto.setUpperCategory(rs.getString("upper_category"));
                dto.setSeqCategory(rs.getString("seq_category"));
                dto.setCategoryName(rs.getString("category_name"));
                dto.setSeqMenu(rs.getString("seq_menu"));
                dto.setNamekr(rs.getString("name_kr"));
                dto.setNameEn(rs.getString("name_en"));
                dto.setRegular(rs.getString("regular"));
                dto.setLarge(rs.getString("large"));
                dto.setOneSize(rs.getString("1-size"));
                dto.setHaveProduct(rs.getString("have_product"));

                conn.close();
                return dto;
            }

        } catch (Exception e){
            System.out.println("RegMenuDAO.get");
            e.printStackTrace();
        }
        return null;
    }

}
