package com.test.main.menu.basic;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 메뉴 DAO 클래스
 * @author 최선희
 */
public class MenuDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * MenuDAO 생성자
     */
    public MenuDAO() {

        try {
            conn = DBUtil.open();
            stat = conn.createStatement();
        } catch (Exception e) {
            System.out.println("MenuDAO.MenuDAO");
            e.printStackTrace();
        }
    }

    /**
     * DB에 메뉴를 INSERT하는 메소드
     * AddOk.java > 메뉴등록 요청
     * @param menuDto 등록할 메뉴 DTO
     * @return INSERT 결과값 반환
     */
    public int add(MenuDTO menuDto) {

        try {

            int isInsertOk = 0;

            // 1. Insert into tblMenu
            String sql = "insert into tblmenu(seq_menu, name_kr, name_en) values(?, ?, ?)";
            pstat = conn.prepareStatement(sql);
            pstat.setString(1, menuDto.getSeqMenu());
            pstat.setString(2, menuDto.getNameKr());
            pstat.setString(3, menuDto.getNameEn());

            isInsertOk = pstat.executeUpdate();
            pstat.close();

            // 2. Insert into tblRegMenu
            for(String size : menuDto.getMenuSize()){
                sql = "insert into tblregmenu(seq_menu, seq_size, seq_category, is_size_sell) values(?, ?, ?, ?)";
                pstat = conn.prepareStatement(sql);
                pstat.setString(1, menuDto.getSeqMenu());
                pstat.setString(2, size);
                pstat.setString(3, menuDto.getSeqCategory());
                pstat.setString(4, "Y");

                isInsertOk = pstat.executeUpdate();
                pstat.close();
            }

            return isInsertOk;

        } catch (Exception e) {
            System.out.println("MenuDAO.add");
            e.printStackTrace();
        }

        return 0;

    }
}
