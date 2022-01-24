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
	
	
	public ArrayList<ListDTO> listall(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("searchmode").equals("y")) {
				where = String.format("where %s like '%%%s%%'"
								, map.get("column")
								, map.get("word").replace("'", "''"));
			
			}
			
			
			String sql = "select rownum, a.* from (select\r\n"
					+ "    rownum as rnum,\r\n"
					+ "    od.seq_order_detail as detail,\r\n"
					+ "    to_char(o.start_order, 'yyyy-mm-dd hh24:mi:ss') as start_order,\r\n"
					+ "    to_char(o.start_order, 'yyyy-mm-dd hh24:mi:ss') as end_order,\r\n"
					+ "    m.name_kr,\r\n"
					+ "    s.size_name,\r\n"
					+ "    p.selling_price * od.count as total\r\n"
					+ "        from tblorder o\r\n"
					+ "            inner join tblorderdetail od \r\n"
					+ "                on o.seq_order = od.seq_order\r\n"
					+ "                    inner join tblproduct p\r\n"
					+ "                        on p.seq_product = od.seq_product\r\n"
					+ "                            inner join tblRegMenu rm\r\n"
					+ "                                on rm.seq_category = p.seq_category\r\n"
					+ "                                    inner join tblMenu m\r\n"
					+ "                                        on m.seq_menu = rm.seq_menu\r\n"
					+ "                                            inner join tblSize s\r\n"
					+ "                                                on s.seq_size = rm.seq_size\r\n"
					+ "                                                    inner join tblStore s\r\n"
					+ "                                                        on s.seq_store = o.seq_store\r\n"
					+ "                                                            where o.seq_store = 10101\r\n"
					+ "                                                                order by start_order desc) a where rnum < 100";
			
		rs = stat.executeQuery(sql);
		
		ArrayList<ListDTO> listall = new ArrayList<ListDTO>();
		
		while (rs.next()) {
			
			ListDTO dto = new ListDTO();
			
			dto.setDetail(rs.getString("detail"));
			dto.setName_kr(rs.getString("name_kr"));
			dto.setTotal(rs.getString("total"));
			dto.setStart_order(rs.getString("start_order"));
			dto.setEnd_order(rs.getString("end_order"));
			
			
			listall.add(dto);
		}
		return listall;
			
		} catch (Exception e) {
			System.out.println("ListDAO.listall()");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public ArrayList<ListDTO> list() {
		
		try {

			
			String sql = "select rownum , a.* from (\r\n"
					+ "select \r\n"
					+ "    distinct(o.seq_order),\r\n"
					+ "    to_char(o.start_order, 'yyyy-mm-dd hh24:mi:ss') as start_order ,\r\n"
					+ "    m.name_kr,\r\n"
					+ "    s.size_name,\r\n"
					+ "    od.count,\r\n"
					+ "    p.selling_price * od.count as total,\r\n"
					+ "    s.name\r\n"
					+ "        from tblorder o\r\n"
					+ "            inner join tblorderdetail od \r\n"
					+ "                on o.seq_order = od.seq_order\r\n"
					+ "                    inner join tblproduct p\r\n"
					+ "                        on p.seq_product = od.seq_product\r\n"
					+ "                            inner join tblRegMenu rm\r\n"
					+ "                                on rm.seq_category = p.seq_category\r\n"
					+ "                                    inner join tblMenu m\r\n"
					+ "                                        on m.seq_menu = rm.seq_menu\r\n"
					+ "                                            inner join tblSize s\r\n"
					+ "                                                on s.seq_size = rm.seq_size\r\n"
					+ "                                                    inner join tblStore s\r\n"
					+ "                                                        on s.seq_store = o.seq_store\r\n"
					+ "--                                                    where o.end_order is null and od.refund = 'N' and o.seq_store = 10101\r\n"
					+ "                                                    where o.start_order <= current_date and o.end_order < current_date and od.refund = 'N' and o.seq_store = 10101\r\n"
					+ "                                                        order by start_order desc) a where rownum between 1 and 15";
					
			
			
			rs = stat.executeQuery(sql);
			//rs = stat.executeQuery(sqlmenu);
			
			ArrayList<ListDTO> list = new ArrayList<ListDTO>();
			ArrayList<ListDTO> menu = new ArrayList<ListDTO>();
			
			while (rs.next()) {
				ListDTO dto = new ListDTO();
				
//				dto.setRownum(rs.getString("rownum"));
				dto.setStart_order(rs.getString("start_order"));
				dto.setName_kr(rs.getString("name_kr"));
				dto.setSize_name(rs.getString("size_name"));
				dto.setTotal(rs.getString("total"));
				dto.setCount(rs.getString("count"));
				
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
			
			
			String sql = "select count(*) as cnt from tblorderdetail" + where;
			
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
	
	
	
}//class
