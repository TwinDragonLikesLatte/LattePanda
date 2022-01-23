
package com.test.main.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.main.util.DBUtil;

public class DashBoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public DashBoardDAO() {
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
		} catch(Exception e) {
			System.out.println("DailyTotalDAO.DailyTotalDAO()");
			e.printStackTrace();
		}
	}


	public String total() {
		
		try {
			
			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE('20211101','YYYYMMDD')";
//			나중에 당일 판매량을 확인하고 싶다면 CURRNET_DATE로 변경해서 사용하기
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			rs = stat.executeQuery(sql);
			
			rs.next();
			
			String total = rs.getString("TOTAL");

			return total;
			
		} catch (Exception e) {
			System.out.println("실패래");
			e.printStackTrace();
		}
		
		return null ;
	}

	
	
	
}
