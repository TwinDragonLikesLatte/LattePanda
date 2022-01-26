
package com.test.main.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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


		} catch (Exception e) {
			System.out.println("DailyTotalDAO.DailyTotalDAO()");
			e.printStackTrace();
		}
	}

	public String total() {

		try {

			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD')";
//			나중에 당일 판매량을 확인하고 싶다면 CURRNET_DATE로 변경해서 사용하기
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			rs = stat.executeQuery(sql);

			rs.next();

			String total = rs.getString("TOTAL");

			return total;
		} catch (Exception e) {
			System.out.println("DashBoardDAO.total()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<MontlyTotalDTO> list() {

		try {

			String sql = "SELECT * FROM VWMONTHLYTOTAL WHERE SEQ_STORE='10101' ORDER BY START_ORDER";

			ArrayList<MontlyTotalDTO> list = new ArrayList<MontlyTotalDTO>();

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				MontlyTotalDTO dto = new MontlyTotalDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setStart_order(rs.getString("start_order"));
				dto.setMontotal(rs.getInt("montotal"));

				list.add(dto);
			}
			return list;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.list()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<DailySellProdDTO> prod() {

		try {
			String sql = "SELECT NAME_KR, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (NAME_KR)";
			ArrayList<DailySellProdDTO> prod = new ArrayList<DailySellProdDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				DailySellProdDTO dto = new DailySellProdDTO();

				dto.setName_kr(rs.getString("name_kr"));
				dto.setSum(rs.getString("sum"));

				prod.add(dto);
			}
			return prod;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.prod()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<NoticeDTO> notice() {

		try {

			String sql = "SELECT * FROM TBLNOTICE ORDER BY SEQ_NOTICE DESC";
			ArrayList<NoticeDTO> notice = new ArrayList<NoticeDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				NoticeDTO dto = new NoticeDTO();

				dto.setSeq_notice(rs.getInt("seq_notice"));
				dto.setSeq_department(rs.getString("seq_department"));
				dto.setTitle(rs.getString("title"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setContent(rs.getString("content"));

				notice.add(dto);
			}
//			conn.close();
//			stat.close();
			return notice;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.notice()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<StockRemainDTO> stockremain() {
		try {

			String sql = "SELECT SEQ_STORE, NAME, QUANTITY, REGDATE FROM VWSTOCKREMAIN WHERE SEQ_STORE='10101' AND REGDATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') ORDER BY QUANTITY DESC";
			ArrayList<StockRemainDTO> stockremain = new ArrayList<StockRemainDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				StockRemainDTO dto = new StockRemainDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setName(rs.getString("name"));
				dto.setQuantity(rs.getString("quantity"));
				dto.setRegdate(rs.getString("regdate"));

				stockremain.add(dto);
			}
//			conn.close();
//			stat.close();
			return stockremain;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.notice()");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AreaMonSellProdDTO> areamonsellprod() {
		try {

			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE ORDER_DATE BETWEEN to_char(add_months(CURRENT_DATE,-1),'yyyy-mm') || '-01' AND to_char(LAST_DAY(add_months(CURRENT_DATE,-1)),'yyyy-mm-dd') GROUP BY (NAME_KR)";
			ArrayList<AreaMonSellProdDTO> areamonsellprod = new ArrayList<AreaMonSellProdDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaMonSellProdDTO dto = new AreaMonSellProdDTO();

				dto.setName(rs.getString("name"));
				dto.setSum(rs.getString("sum"));

				areamonsellprod.add(dto);
			}
//			conn.close();
//			stat.close();
			return areamonsellprod;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areamonsellprod()");
			e.printStackTrace();
		}
		return null;
	}

	public String areatotal(String store) {
		try {

			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ="+store+" AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD')";
//			나중에 당일 판매량을 확인하고 싶다면 CURRNET_DATE로 변경해서 사용하기
//			지역장에서 선택한 값에 따라 바뀌게 만들기
			rs = stat.executeQuery(sql);

			rs.next();

			String areatotal = rs.getString("TOTAL");
//			conn.close();
			return areatotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areatotal()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<AreaMontlyTotalDTO> areamontotal(String store) {
		try {

			String sql = "SELECT * FROM VWMONTHLYTOTAL WHERE SEQ_STORE="+store+" ORDER BY START_ORDER";
//			지역장에서 선택한 값에 따라 바뀌게 만들기
			ArrayList<AreaMontlyTotalDTO> areamontotal = new ArrayList<AreaMontlyTotalDTO>();

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaMontlyTotalDTO dto = new AreaMontlyTotalDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setStart_order(rs.getString("start_order"));
				dto.setMontotal(rs.getInt("montotal"));

				areamontotal.add(dto);
			}
//			conn.close();
//			stat.close();
			return areamontotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.list()");
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<AreaDailySellProdDTO> areaprod(String store) {
		
		try {
			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE="+store+" AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (NAME_KR)";
			//날짜 세션에서 받고 
			//
			
			
			ArrayList<AreaDailySellProdDTO> areaprod = new ArrayList<AreaDailySellProdDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaDailySellProdDTO dto = new AreaDailySellProdDTO();

				dto.setName(rs.getString("name"));
				dto.setSum(rs.getString("sum"));

				areaprod.add(dto);
			}
//			conn.close();
//			stat.close();
			return areaprod;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areaprod()");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AreaDalyAllTotalDTO> areaalltotal() {
		
		try {
			String sql = "SELECT SEQ_STORE,SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (SEQ_STORE)";
			//날짜 세션에서 받고 
			//
			
			ArrayList<AreaDalyAllTotalDTO> areaalltotal = new ArrayList<AreaDalyAllTotalDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaDalyAllTotalDTO dto = new AreaDalyAllTotalDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setTotal(rs.getString("total"));

				areaalltotal.add(dto);
			}
//			conn.close();
//			stat.close();
			return areaalltotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areaalltotal()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public ArrayList<StaffScheduleDTO> staffschedule() {
		
		try {
			String sql = "SELECT * FROM VWSTAFFSCHEDULE WHERE TO_DATE(START_TIME,'YY-MM-DD') = '20211101' AND SEQ_STORE ='10101'";
			//날짜 세션에서 받고 
			//지점 입력버튼으로 받고
			
			ArrayList<StaffScheduleDTO> staffschedule = new ArrayList<StaffScheduleDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				StaffScheduleDTO dto = new StaffScheduleDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setName(rs.getString("name"));
				dto.setStart_time(rs.getString("start_time"));
				dto.setHourfrom(rs.getString("hourfrom"));

				staffschedule.add(dto);
			}

			return staffschedule;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.staffschedule()");
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<EmployeeScheduleDTO> employeeschedule() {
		try {
			String sql = "SELECT * FROM VWEMPLOYEESCHEDULE WHERE SEQ_STORE = '10101'";
			//날짜 세션에서 받고 
			//지점 입력버튼으로 받고
			
			ArrayList<EmployeeScheduleDTO> employeeschedule = new ArrayList<EmployeeScheduleDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				EmployeeScheduleDTO dto = new EmployeeScheduleDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setName(rs.getString("name"));
				

				employeeschedule.add(dto);
			}

			return employeeschedule;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.employeeschedule()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("DashBoardDAO.close()");
			e.printStackTrace();
		}
	}



}


