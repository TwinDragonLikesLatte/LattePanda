package com.test.main.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import com.test.main.util.DBUtil;
/**
 * 공지사항 CRUD 및 페이징, 검색 처리
 * @author JH LEE
 *
 */
public class BoardDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	
	
	
	/**
	 * 데이터베이스 연결
	 */
	public BoardDAO() {

		try {
			
			conn = DBUtil.open();
			stat = conn.createStatement();
			
		} catch (Exception e) {

			System.out.println("BoardDAO.BoardDAO()");
			e.printStackTrace();
		}
	
	}
	
	
	/**
	 * 글작성(등록)하는 메소드
	 * @param dto
	 * @return 입력한 글
	 */
	public int add(BoardDTO dto) {
		
		try {


			String sql = "insert into tblNotice (seq_notice, seq_department, title, regdate, content) values(seqNotice.nextVal, 310101, ?, default, ?)";
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			
			return pstat.executeUpdate();
			
			

		} catch (Exception e) {
			System.out.println("BoardDAO.add()");
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * 공지사항의 모든 글을 불러오는 메소드
	 * @param map
	 * @return 공지사항의 전체 글 정보
	 */
	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			//내용 검색
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''")
								, map.get("name"));
			}
			
			
			String sql = String.format("select * from (select rownum as rnum, a.* from (select * from vwnotice %s order by seq_notice desc)a ) where rnum between %s and %s order by seq_notice desc", where, map.get("begin"), map.get("end"));
			
			rs = stat.executeQuery(sql);

			ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
			
			while (rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq_notice(rs.getString("seq_notice"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));
				
				list.add(dto);
			}
			
			//conn.close();//**
			
			return list;
			
		} catch (Exception e) {
			System.out.println("BoardDAO.list()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	/**
	 * view 서블릿에서 글 레코드를 반환해주는 메소드
	 * @param seq
	 * @return 해당 seq를 가진 레코드
	 */
	public BoardDTO get(String seq) {
		try {

			String sql = "select n.seq_notice, d.name, n.title, n.regdate, n.content from tblNotice n inner join tblDepartment d on n.seq_department = d.seq_department where seq_notice = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setSeq_notice(rs.getString("seq_notice"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setRegdate(rs.getString("regdate"));
				
				
				
				return dto;
			}

		} catch (Exception e) {
			System.out.println("BoardDAO.get()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 글 수정 메소드
	 * @param dto
	 * @return
	 */
	public int edit(BoardDTO dto) {

		try {

			String sql = "update tblNotice set title= ?, content= ? where seq_notice=?";
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, dto.getTitle());
			pstat.setString(2, dto.getContent());
			pstat.setString(3, dto.getSeq_notice());
//			conn.close();//**
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.edit()");
			e.printStackTrace();
		}
		
		return 0;
	}

	/**
	 * 글 삭제 메소드
	 * @param seq
	 * @return
	 */
	public int del(String seq) {
		
		try {

			String sql = "delete tblNotice where seq_notice = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq);
			
			conn.close();//**
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("BoardDAO.del()");
			e.printStackTrace();
		}
		
		return 0;
	}
	
	
	/**
	 * Board 서블릿의 전체 게시물 개수
	 * @param map
	 * @return 모든 게시물 개수
	 */
	public int getTotalCount(HashMap<String, String> map) {
		
		try {

			String where = "";
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''")
								, map.get("name"));
			}
			
			String sql = "select count(*) as cnt from tblNotice" + where;
			
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



	
	







































