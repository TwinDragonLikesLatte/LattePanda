package com.test.main.hr.staff;

import com.test.main.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StaffDAO {

    private Connection conn;
    private Statement stat;
    private PreparedStatement pstat;
    private ResultSet rs;

    public StaffDAO() {

        try {
            conn = DBUtil.open();
        } catch (Exception e) {
            System.out.println("LoginDAO.LoginDAO()");
            e.printStackTrace();
        }
    }

    public void closeConn() {

        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("LoginDAO.closeConn()");
            e.printStackTrace();
        }
    }


    public ArrayList<StaffDTO> getList(String seqDepartment) {

        String whereDepartment = "";

        if (!seqDepartment.equals("")) {
            whereDepartment = "AND seq_department = " + seqDepartment;
        }

        try {

            String sql = "SELECT * FROM vwStaffList WHERE NOT status = '퇴직'" + whereDepartment;

            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            ArrayList<StaffDTO> list = new ArrayList<StaffDTO>();

            while(rs.next()) {
                String seqStaff = rs.getString("seq_staff");
                String name = rs.getString("name");
                String tel = rs.getString("tel");
                String store = rs.getString("store");
                String contractExpire = rs.getString("contract_expire").substring(0, 10);
                String healthExpire = rs.getString("health_expire").substring(0, 10);
                String eduExpire = rs.getString("edu_expire") != null
                        ? rs.getString("edu_expire").substring(0, 10)
                        : "";
                String join = rs.getString("join").substring(0, 10);

                StaffDTO dto = new StaffDTO();
                dto.setSeqStaff(seqStaff);
                dto.setName(name);
                dto.setTel(tel);
                dto.setStore(store);
                dto.setContractExpire(contractExpire);
                dto.setHealthExpire(healthExpire);
                dto.setEduExpire(eduExpire);
                dto.setJoin(join);
                list.add(dto);
            }

            stat.close();
            return list;

        } catch (Exception e) {
            System.out.println("StaffDAO.getList()");
            e.printStackTrace();
        }

        return null;
    }
//
//    public ArrayList<StaffDTO> getList(String seqDepartment) {
//
//        try {
//
//            String sql = "SELECT * FROM vwStaffList WHERE NOT status = '퇴직' AND seq_department = ?";
//
//            pstat = conn.prepareStatement(sql);
//            pstat.setString(1, seqDepartment);
//            ResultSet rs = pstat.executeQuery();
//
//            ArrayList<StaffDTO> list = new ArrayList<StaffDTO>();
//
//            while(rs.next()) {
//                String seqStaff = rs.getString("seq_staff");
//                String name = rs.getString("name");
//                String tel = rs.getString("tel");
//                String store = rs.getString("store");
//                String contractExpire = rs.getString("contract_expire").substring(1, 10);
//                String healthExpire = rs.getString("health_expire").substring(0, 10);
//                String eduExpire = rs.getString("edu_expire") != null
//                        ? rs.getString("edu_expire").substring(0, 10)
//                        : "";
//                String join = rs.getString("join").substring(0, 10);
//
//                StaffDTO dto = new StaffDTO();
//                dto.setSeqStaff(seqStaff);
//                dto.setName(name);
//                dto.setTel(tel);
//                dto.setStore(store);
//                dto.setContractExpire(contractExpire);
//                dto.setHealthExpire(healthExpire);
//                dto.setEduExpire(eduExpire);
//                dto.setJoin(join);
//                list.add(dto);
//            }
//
//            stat.close();
//            return list;
//
//        } catch (Exception e) {
//            System.out.println("StaffDAO.getList()");
//            e.printStackTrace();
//        }
//
//        return null;
//    }
}
