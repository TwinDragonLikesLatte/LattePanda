package com.test.main.stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.main.util.DBUtil;

/**
 * 재고 정보 DAO
 * @author 임호혁
 *
 */
public class StockDAO {
	
	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
	private ResultSet rs2;
	
	public StockDAO() {

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();
			if(stat == null) {
				System.out.println("test");
			}
			
		} catch (Exception e) {
			System.out.println("StockDAO.StockDAO()");
			e.printStackTrace();
		}
	}
	/**
	 * 재고 수량 조회
	 * @param seq_store 매장 번호
	 * @author 임호혁
	 * @return 해당 매장에서 조회하는 모든 재고의 현재 수량 데이터를 반환함
	 */
	public ArrayList<StockDTO> list(String seq_store) {
		try {
			
			String sql = String.format("select * from vwStockCheck where seq_store = '%s'", seq_store);
			
			rs = stat.executeQuery(sql);
			
			ArrayList<StockDTO> list = new ArrayList<StockDTO>();

			
			while(rs.next()) {
				
				StockDTO dto = new StockDTO();
				
				dto.setSeq_stock(rs.getString("seq_stock"));
				dto.setName(rs.getString("name"));
				dto.setTypes(rs.getString("types"));
				dto.setUnit(rs.getString("unit"));

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setOrder_cost(rs.getInt("order_cost"));
				dto.setOrder_unit(rs.getString("order_unit"));
				dto.setOrder_unit_quantity(rs.getString("order_unit_quantity"));
				
				dto.setPre_quantity(rs.getInt("pre_quantity"));
				dto.setQuantity(rs.getInt("quantity"));
				
				dto.setWaste(rs.getInt("waste"));
				
				if(rs.getString("etc") == null) {
					dto.setEtc("-");
				} else {
					dto.setEtc(rs.getString("etc"));					
				}
				
				list.add(dto);
				
			}
			
			return list;

		} catch (Exception e) {
			System.out.println("StockDAO.list()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void close() {
		
		try {

			conn.close();			

		} catch (Exception e) {
			System.out.println("StockDAO.close()");
			e.printStackTrace();
		}
	}
	public int edit(StockDTO dto) {
		
		String sql = "update tblStockrecord set quantity = ?, waste = ?, etc = ? where seq_store = ? and seq_stock = ? and to_date(regdate, 'yyyy-mm-dd') = to_date(CURRENT_DATE, 'yyyy-mm-dd')";
		
		try {
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getPre_quantity());
			pstat.setInt(2, dto.getWaste());
			pstat.setString(3, dto.getEtc());
			pstat.setString(4, dto.getSeq_store());
			pstat.setString(5, dto.getSeq_stock());
			
			return pstat.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("StockDAO.edit()");
			e.printStackTrace();
		}
		return 0;
		
	}
	public int editCheck(StockDTO dto) {
		
		try {

			String sql = "update tblStockCheck set quantity = ? where seq_store = ? and seq_stock = ?";
			pstat = conn.prepareStatement(sql);
			pstat.setInt(1, dto.getPre_quantity());
			pstat.setString(2, dto.getSeq_store());
			pstat.setString(3, dto.getSeq_stock());
			
			return pstat.executeUpdate();

		} catch (Exception e) {
			System.out.println("StockDAO.editCheck()");
			e.printStackTrace();
		}
		
		return 0;
	}
	public String getSeqStockOrder(String seq_store) {
		
		try {

			String sql = "select seq_stock_order from tblstockorder where seq_store = ? and to_date(regdate, 'yyyy-mm-dd') = to_date(CURRENT_DATE, 'yyyy-mm-dd')";

			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq_store);
			
			rs = pstat.executeQuery();
			
			if(rs.next()) {
				return rs.getString("seq_stock_order");
			}
			
		} catch (Exception e) {
			System.out.println("StockDAO.getSeqStockOrder()");
			e.printStackTrace();
		}
		
		return null;
	}
	public ArrayList<StockDTO> orderlist(String seq_store, String seq_stock_order, ArrayList<StockDTO> list) {
		
		try {

			String sql = "select seq_stock, quantity, seq_stock_order_record from tblStockorderrecord where seq_stock_order = ?";
			
			pstat = conn.prepareStatement(sql);
			pstat.setString(1, seq_stock_order);
			
			rs = pstat.executeQuery();
			int i = 0;
			while(rs.next()) {
				StockDTO dto = new StockDTO();
				dto = list.get(i);
				dto.setQuantity_order(rs.getInt("quantity"));
				dto.setSeq_stock_order_record(rs.getString("seq_stock_order_record"));
				
				
				list.set(i, dto);
				i++;
			}
			return list;
			
		} catch (Exception e) {
			System.out.println("StockDAO.orderlist()");
			e.printStackTrace();
		}
		
		return null;
	}
	public int editorder(StockDTO dto) {
		
		String sql = "update tblStockorderrecord set quantity = ? where seq_stock_order_record = ?";
		try {
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, dto.getQuantity_order());
			pstat.setInt(2, Integer.parseInt(dto.getSeq_stock_order_record()));
			
			return pstat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("StockDAO.editorder()");
			e.printStackTrace();
		}
		
		return 0;
	}	


}
