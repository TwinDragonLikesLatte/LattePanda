package com.test.main.customer.survey;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.main.notice.BoardDTO;
import com.test.main.util.DBUtil;

public class QuestionDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public QuestionDAO() {
		
		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
		} catch (Exception e) {

			System.out.println("QuestionDAO.QuestionDAO()");
			e.printStackTrace();
		}
	
	}

	public int check(QuestionDTO dto) {
		
		
		try {
			String sql = "select seq_order from tblsurvey";
			
			rs = stat.executeQuery(sql);

			ArrayList<QuestionDTO> list = new ArrayList<QuestionDTO>();
			
			pstat = conn.prepareStatement(sql);

			//dto.setSeq_order(rs.getString("count"));
			
		} catch (Exception e) {
			System.out.println("QuestionDAO.check()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	
	

	
	
	
	
	
	

}
