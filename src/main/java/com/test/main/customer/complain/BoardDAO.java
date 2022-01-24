package com.test.main.customer.complain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.bootstrap.DOMImplementationRegistry;

import com.test.main.util.DBUtil;



public class BoardDAO {


	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	public BoardDAO() {
		
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("BoardDAO.BoardDAO()");
			e.printStackTrace();
		}
		
	}
	
	
//	public int add(BoardDTO dto) {
//		
//		try {
//
//			String sql = "insert into tblBoard (seq, id, subject, content, regdate, readcount, userip) values (seqBoard.nextVal, ?, ?, ?, default, default, ?)";
//			pstat = conn.prepareStatement(sql);
//			
//			pstat.setString(1, dto.getId());      //X
//			pstat.setString(2, dto.getSubject()); //O
//			pstat.setString(3, dto.getContent()); //O
//			pstat.setString(4, dto.getUserip());  //X
//			
//			return pstat.executeUpdate();
//
//		} catch (Exception e) {
//			System.out.println("BoardDAO.add()");
//			e.printStackTrace();
//		}
//		
//		return 0;
//	}

	
	
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {

			String where = "";
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''"));
			}
			
			
			String sql = String.format("select * from vwcomplain %s", where);
			
			rs = stat.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {

				BoardDTO dto = new BoardDTO();
				
				dto.setSeq_complain(rs.getString("seq_complain"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
			}
			
			return list;

		} catch (Exception e) {
			System.out.println("BoardDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	//Board 서블릿 게시물 개수
	public int getTotalCount(HashMap<String, String> map) {
		
		try {

			String where = "";
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''"));
			}
			
			String sql = "select count(*) as cnt from vwcomplain" + where;
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("BoardDAO.getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
}
	
	
	
	
	
	
	
	

