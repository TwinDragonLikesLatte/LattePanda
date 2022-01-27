package com.test.main.hr.staff;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PaystubDAO {
    
    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;
    
    public PaystubDAO() {
    
        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("PaystubDAO.PaystubDAO");
            e.printStackTrace();
        }
    }
    
    public void closeConn() {
    
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("PaystubDAO.closeConn()");
            e.printStackTrace();
        }
    }


    public ArrayList<PaystubDTO> getList(String seqStore) {


        try {
            System.out.println(seqStore);
            String sql = "SELECT * FROM vwStaffPaystub WHERE seq_store = ? AND year_month = '2021-12' ORDER BY NAME ASC";

            pstat = conn.prepareStatement(sql);
            pstat.setString(1, seqStore);
            ResultSet rs = pstat.executeQuery();

            ArrayList<PaystubDTO> list = new ArrayList<PaystubDTO>();
            while(rs.next()) {

                System.out.println(rs.getString("seq_staff"));
                PaystubDTO dto = new PaystubDTO();
                dto.setSeqStaff(rs.getString("seq_staff"));
                dto.setName(rs.getString("name"));
                dto.setTime(rs.getInt("time"));
                dto.setTotal(rs.getInt("total"));
                dto.setReal(rs.getInt("total")
                        - (rs.getInt("gukmin")
                        + (rs.getInt("gungang"))
                        + (rs.getInt("goyong"))
                        + (rs.getInt("income_tax"))
                        + (rs.getInt("local_tax"))
                ));
                dto.setBasic(rs.getInt("basic"));
                dto.setHoliday(rs.getInt("holiday"));
                dto.setOver(rs.getInt("over"));
                dto.setNight(rs.getInt("night"));
                dto.setGukmin(rs.getInt("gukmin"));
                dto.setGungang(rs.getInt("gungang"));
                dto.setGoyong(rs.getInt("goyong"));
                dto.setIncomeTax(rs.getInt("income_tax"));
                dto.setLocalTax(rs.getInt("local_tax"));
                list.add(dto);
            }

            pstat.close();
            return list;

        } catch (Exception e) {
            System.out.println("PaystubDAO.getList()");
            e.printStackTrace();
        }

        
        
        return null;
    }
}
