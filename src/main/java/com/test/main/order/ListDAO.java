package com.test.main.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.main.notice.BoardDTO;
import com.test.main.util.DBUtil;

public class ListDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	public ListDAO() {
	
	try {
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
	} catch (Exception e) {

		System.out.println("ListDAO.ListDAO()");
		e.printStackTrace();
	}
	
	}
	
	//전체주문
	public ArrayList<ListDTO> listall(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''"));
			
			}
			

			
			//수정쿼리 view 수정함
			String sql = String.format("select * from (select rownum as rnum, a.* from vwlisttest a %s) where rnum between %s and %s order by rnum asc", where, map.get("begin"), map.get("end"));
		
			
		rs = stat.executeQuery(sql);
		
		ArrayList<ListDTO> listall = new ArrayList<ListDTO>();
		
		while (rs.next()) {
			
			ListDTO dto = new ListDTO();
			
			dto.setSeq_order(rs.getString("seq_order"));
			dto.setDetail(rs.getString("detail"));
			dto.setName_kr(rs.getString("name_kr"));
			dto.setTotal(rs.getString("total"));
			dto.setStart_order(rs.getString("start_order"));
			dto.setEnd_order(rs.getString("end_order"));
			dto.setCount(rs.getString("count"));
			dto.setRefund(rs.getString("refund"));
			dto.setSeq_size(rs.getString("seq_size"));
			
			
			listall.add(dto);
		}
		return listall;
			
		} catch (Exception e) {
			System.out.println("ListDAO.listall()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	//주문완료
//	public int edit(ListDTO dto) {
//
//		try {
//			
//			
//			String sql = "update tblorder set end_order = default where seq_order =?";
//			pstat = conn.prepareStatement(sql);
//			
//			
//			pstat.setString(1, dto.getEnd_order());
//			
//			return pstat.executeUpdate();
//
//		} catch (Exception e) {
//			System.out.println("BoardDAO.edit()");
//			e.printStackTrace();
//		}
//		
//		return 0;
//	}
	
	
	
	
	
	//진행중
	public ArrayList<ListDTO> list() {
		
		try {

			
			String sql = "select * from (select rownum as rnum, a.* from (select * from vwlisttest order by start_order)a where end_order is null) order by rnum asc";
					
			
			
			rs = stat.executeQuery(sql);
			
			ArrayList<ListDTO> list = new ArrayList<ListDTO>();
			ArrayList<ListDTO> menu = new ArrayList<ListDTO>();
			
			while (rs.next()) {
				ListDTO dto = new ListDTO();
				
				dto.setStart_order(rs.getString("start_order"));
				dto.setName_kr(rs.getString("name_kr"));
				dto.setSeq_size(rs.getString("seq_size"));
				dto.setTotal(rs.getString("total"));
				dto.setCount(rs.getString("count"));
				dto.setRnum(rs.getString("rnum"));
				
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("ListDAO.list()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	//AllList 서블릿 주문개수
	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = ""; //위에 where 쿼리 해야함
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''"));
			}
			
			
			String sql = "select count (*) as cnt from tblorderdetail" + where;
			
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			System.out.println("ListDAO().getTotalCount()");
			e.printStackTrace();
		}
		
		return 0;
		
	}
	
	
	
	// 버튼 클릭 주문 쿼리 2번 insert 필요
	//1. tblorder 추가
	public int addorder(ListDTO dto) {
		
		try {
			
			String sql = "insert into tblorder values (seqOrder.nextVal, ?, default, null)";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getStart_order());
			
			System.out.println("addorder");
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ListDAO.addorder()");
			e.printStackTrace();
		}
		return 0;
	}
	
	//2. tblorderdetail 추가
	public int addorderdetail(ListDTO dto) {
		
		try {

			String sql = "insert into tblorderdetail values (seqOrderDetail.nextVal, seqSameOrder.nextVal, ?, 1, 'N')";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getSeq_product());
			
			
			System.out.println("addorderdetail");
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("ListDAO.adddetail()");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	
	
	
}//class