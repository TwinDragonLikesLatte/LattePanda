package com.test.main.menu.product;

import com.test.main.util.DBUtil;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class ProductDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public ProductDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("ProductDAO.ProductDAO");
            e.printStackTrace();
        }
    }

    /* 카테고리 필터 쿼리 생성 메소드 */
    public String makeWhereCategory(String[] cateList) {
        String where = "category_name in (";

        for (String cate : cateList) {
            where += "'" + cate + "',";
        }
        where = where.substring(0, where.length() - 1);
        where += ")";

        return where;
    }

    /* 메뉴공개등급 필터 쿼리 생성 메소드 */
    public String makeWhereOpenLevel(String[] olList) {
        String where = "open_level in (";

        for (String ol : olList) {
            where += "'" + ol + "',";
        }
        where = where.substring(0, where.length() - 1);
        where += ")";

        return where;
    }

    /* 판매제품조회 */
    public ArrayList<ProductDTO> list(HashMap<String, Object> filter) {

        try {
            /* Filter condition */
            String where = "where ";

            // 전체조회시
            if (filter.get("filterMode").equals("n"))
                where = "";

                // 필터 적용시
            else if (filter.get("filterMode").equals("y")) {

                ArrayList<String> whereList = new ArrayList<String>();

                // 이름 검색
                if (!filter.get("search").equals(""))
                    whereList.add(String.format("name_kr like '%%%s%%'", filter.get("search")));

                // 카테고리 검색
                if (filter.get("category") != null)
                    whereList.add(makeWhereCategory((String[]) filter.get("category")));

                // 메뉴공개등급 검색
                if (filter.get("openLevel") != null)
                    whereList.add(makeWhereOpenLevel((String[]) filter.get("openLevel")));

                // 판매기간 검색
                if (filter.get("startDate") != null && filter.get("endDate") != null
                        && !filter.get("startDate").equals("") && !filter.get("endDate").equals("")) {

                    // if 종료일자 <= 오늘일자 then 종료기간 조건 (O) else 종료조건 (X)
                    LocalDate today = LocalDate.now();
                    int isToday = filter.get("endDate").toString().compareTo(today.toString());

                    if (isToday < 0)
                        whereList.add(String.format("sale_start_date >= '%s' and sale_end_date <= '%s'"
                                , filter.get("startDate"), filter.get("endDate")));
                    else
                        whereList.add(String.format("sale_start_date >= '%s'", filter.get("startDate")));
                }

                // 검색 조건 조합
                for (String query : whereList) {
                    where += query + " and ";
                }
                where = where.substring(0, where.length() - 4);
                System.out.println("where : " + where);
            }

            /* Execute Query */
            String sql = "select * from vwProduct " + where;
            rs = stat.executeQuery(sql);

            /* Return Result */
            ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();

            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setSeqProduct(rs.getString("seq_product"));
                dto.setUpperCategory(rs.getString("upper_category"));
                dto.setCategoryName(rs.getString("category_name"));
                dto.setNamekr(rs.getString("name_kr"));
                dto.setNameEn(rs.getString("name_en"));
                dto.setSeqMenu(rs.getString("seq_menu"));
                dto.setSizeName(rs.getString("size_name"));
                dto.setRegDate(rs.getString("regdate"));
                dto.setStartDate(rs.getString("sale_start_date"));
                dto.setEndDate(rs.getString("sale_end_date"));
                dto.setOpenLevel(rs.getString("open_level"));
                dto.setCostPrice(rs.getInt("cost_price"));
                dto.setSellingPrice(rs.getInt("selling_price"));
                dto.setCostRate(rs.getDouble("cost_rate"));

                list.add(dto);
            }

            conn.close();
            return list;

        } catch (Exception e) {
            System.out.println("ProductDAO.list");
            e.printStackTrace();
        }

        return null;
    }

    /* detail.java > 제품 목록 하나 요청 */
    public ProductDTO get(HashMap<String, String> map) {
        try {
            String sql = "select * from vwproduct " +
                    "where seq_menu = ? and size_name = ? " +
                    "order by seq_product desc";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, map.get("seqMenu"));
            pstat.setString(2, map.get("size"));
            rs = pstat.executeQuery();

            if (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setSeqProduct(rs.getString("seq_product"));
                dto.setUpperCategory(rs.getString("upper_category"));
                dto.setCategoryName(rs.getString("category_name"));
                dto.setNamekr(rs.getString("name_kr"));
                dto.setNameEn(rs.getString("name_en"));
                dto.setSeqMenu(rs.getString("seq_menu"));
                dto.setSizeName(rs.getString("size_name"));
                dto.setRegDate(rs.getString("regdate"));
                dto.setStartDate(rs.getString("sale_start_date"));
                dto.setEndDate(rs.getString("sale_end_date"));
                dto.setOpenLevel(rs.getString("open_level"));
                dto.setCostPrice(rs.getInt("cost_price"));
                dto.setSellingPrice(rs.getInt("selling_price"));
                dto.setCostRate(rs.getDouble("cost_rate"));

                //conn.close();
                return dto;
            }

        } catch (Exception e) {
            System.out.println("ProductDAO.get");
            e.printStackTrace();
        }

        return null;
    }


    /* detail.java > 제품 변경 내역 요청 */
    public ArrayList<ProductDTO> getHistoryList(HashMap<String, String> map) {
        try {
            String sql = "select * from vwproduct " +
                    "where seq_menu = ? and size_name = ? " +
                    "order by seq_product desc";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, map.get("seqMenu"));
            pstat.setString(2, map.get("size"));
            rs = pstat.executeQuery();

            ArrayList<ProductDTO> historyList = new ArrayList<ProductDTO>();
            while (rs.next()) {
                ProductDTO dto = new ProductDTO();
                dto.setSeqProduct(rs.getString("seq_product"));
                dto.setNamekr(rs.getString("name_kr"));
                dto.setRegDate(rs.getString("regdate"));
                dto.setStartDate(rs.getString("sale_start_date"));
                dto.setEndDate(rs.getString("sale_end_date"));
                dto.setOpenLevel(rs.getString("open_level"));

                historyList.add(dto);
            }

            //conn.close();
            return historyList;

        } catch (Exception e) {
            System.out.println("ProductDAO.get");
            e.printStackTrace();
        }

        return null;


    }

    /* AddOkProduct.java > 신규 제품코드 요청 */
    public String getNewSeq() {

        try {
            String sql = "select concat('P', Lpad(max(substr(seq_product,2))+1,3,'0')) as new_seq_product from tblproduct";
            rs = stat.executeQuery(sql);

            if(rs.next())
                return rs.getString("new_seq_product");

        } catch (Exception e){
            System.out.println("ProductDAO.getNewSeq");
            e.printStackTrace();
        }

        return null;
    }

    /* AddOkProduct.java > 제품 등록 */
    public int add(ProductDTO pdto) {

        try{
            String sql = "insert into tblproduct(" +
                            "seq_product, seq_category, seq_menu, seq_size, " +
                            "cost_price, selling_price, cost_rate, " +
                            "regdate, sale_start_date, sale_end_date, " +
                            "seq_open_grade, pic_path) " +
                        "values (?, ?, ?, ?, ?, ?, ROUND(?,3), current_date, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), default, null)";


            pstat = conn.prepareStatement(sql);
            pstat.setString(1, pdto.getSeqProduct());
            pstat.setString(2, pdto.getSeqCategory());
            pstat.setString(3, pdto.getSeqMenu());
            pstat.setString(4, pdto.getSizeName());
            pstat.setInt(5, pdto.getCostPrice());
            pstat.setInt(6, pdto.getSellingPrice());
            pstat.setDouble(7, pdto.getCostRate());
            pstat.setString(8, pdto.getStartDate());
            pstat.setString(9, pdto.getEndDate());

            return pstat.executeUpdate();


        }catch (Exception e){
            System.out.println("ProductDAO.add");
            e.printStackTrace();
        }

        return 0;
    }
}

