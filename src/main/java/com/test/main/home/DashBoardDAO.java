
package com.test.main.home;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.main.util.DBUtil;
/**
 * 대시보드 DAO 클래스
 * @author kujun-kang
 *
 */
public class DashBoardDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;
/**
 * DashBoardDAO 생성자
 */
	public DashBoardDAO() {

		try {

			conn = DBUtil.open();
			stat = conn.createStatement();


		} catch (Exception e) {
			System.out.println("DailyTotalDAO.DailyTotalDAO()");
			e.printStackTrace();
		}
	}
	/**
	 * 일일 총 판매액을 데이터를 가져오는 메소드
	 * @return
	 */
	public String total() {

		try {

			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD')";
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
	/**
	 * 대시보드 점장화면에 월간 판매액 데이터를 가져오는 메소드
	 * @return
	 */
	public ArrayList<MontlyTotalDTO> list() {

		try {

			String sql = "SELECT * FROM VWMONTHLYTOTAL WHERE SEQ_STORE='10101' ORDER BY START_ORDER";
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			
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
	/**
	 * 대시보드 점장화면에 당일 상품별 판매량 데이터를 가져오는 메소드
	 * @return
	 */
	public ArrayList<DailySellProdDTO> prod() {

		try {
			String sql = "SELECT NAME_KR, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (NAME_KR) ORDER BY SUM DESC";
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			
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
	/**
	 * 대시보드 점장화면에 공지사항 데이터를 가져오는 메소드
	 * @return
	 */
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
			return notice;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.notice()");
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 대시보드 점장화면에 재고현황 데이터 중 실 재고량을 가져오는 메소드
	 * @return
	 */
	public ArrayList<StockRemainDTO> stockremain() {
		try {

			String sql = "SELECT SEQ_STORE, NAME, QUANTITY, REGDATE FROM VWSTOCKREMAIN WHERE SEQ_STORE='10101' AND REGDATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') ORDER BY QUANTITY DESC";
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			
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
			return stockremain;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.notice()");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 대시보드 지역장화면에 지역내 전지점 월간 매출 현황 중 상품별 판매량 데이터를 가져오는 메소드
	 * @return
	 */
	public ArrayList<AreaMonSellProdDTO> areamonsellprod() {
		try {

			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE ORDER_DATE BETWEEN to_char(add_months(CURRENT_DATE,-1),'yyyy-mm') || '-01' AND to_char(LAST_DAY(add_months(CURRENT_DATE,-1)),'yyyy-mm-dd') GROUP BY (NAME_KR) ORDER BY SUM DESC";
			ArrayList<AreaMonSellProdDTO> areamonsellprod = new ArrayList<AreaMonSellProdDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaMonSellProdDTO dto = new AreaMonSellProdDTO();

				dto.setName(rs.getString("name"));
				dto.setSum(rs.getString("sum"));

				areamonsellprod.add(dto);
			}
			return areamonsellprod;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areamonsellprod()");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 대시보드 지역장화면에 해당 지점의 당일 판매액 데이터를 가져오는 데이터
	 * @param store 버튼에서 받아온 seq_store
	 * @return
	 */
	public String areatotal(String store) {
		try {

			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ="+store+" AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD')";
			rs = stat.executeQuery(sql);

			rs.next();

			String areatotal = rs.getString("TOTAL");
			return areatotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areatotal()");
			e.printStackTrace();
		}

		return null;
	}
	/**
	 * 대시보드 지역장화면에 선택된 지점의 월간 판매액 데이터를 가져오는 메소드
	 * @param store 버튼에서 받아온 seq_store
	 * @return
	 */
	public ArrayList<AreaMontlyTotalDTO> areamontotal(String store) {
		try {

			String sql = "SELECT * FROM VWMONTHLYTOTAL WHERE SEQ_STORE="+store+" ORDER BY START_ORDER";
			ArrayList<AreaMontlyTotalDTO> areamontotal = new ArrayList<AreaMontlyTotalDTO>();

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaMontlyTotalDTO dto = new AreaMontlyTotalDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setStart_order(rs.getString("start_order"));
				dto.setMontotal(rs.getInt("montotal"));

				areamontotal.add(dto);
			}
			return areamontotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.list()");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 대시보드 지역장화면에 지역내 전지점별 당일 판매된 상품별 갯수 데이터를 가져오는 메소드 
	 * @param store
	 * @return
	 */
	public ArrayList<AreaDailySellProdDTO> areaprod(String store) {

		try {
			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE="+store+" AND ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (NAME_KR) ORDER BY SUM DESC";
			
			
			ArrayList<AreaDailySellProdDTO> areaprod = new ArrayList<AreaDailySellProdDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaDailySellProdDTO dto = new AreaDailySellProdDTO();

				dto.setName(rs.getString("name"));
				dto.setSum(rs.getString("sum"));

				areaprod.add(dto);
			}
			
			return areaprod;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areaprod()");
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 대시보드 지역장화면에 전지역 당일 매출 데이터를 가져오는 메소드
	 * @return
	 */
	public ArrayList<AreaDalyAllTotalDTO> areaalltotal() {
		
		try {
			String sql = "SELECT SEQ_STORE,SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE ORDER_DATE = TO_DATE(CURRENT_DATE, 'YY-MM-DD') GROUP BY (SEQ_STORE)";

			
			ArrayList<AreaDalyAllTotalDTO> areaalltotal = new ArrayList<AreaDalyAllTotalDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaDalyAllTotalDTO dto = new AreaDalyAllTotalDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setTotal(rs.getString("total"));

				areaalltotal.add(dto);
			}

			return areaalltotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areaalltotal()");
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * 대시보드 점장화면에 스태프 근무일정 데이터를 가져오는 메소드
	 * @return
	 */
	public ArrayList<StaffScheduleDTO> staffschedule() {
		
		try {
			String sql = "SELECT * FROM VWSTAFFSCHEDULE WHERE TO_DATE(START_TIME,'YY-MM-DD') = '20211101' AND SEQ_STORE ='10101'";
			//데이터 저장 추가되면 날짜 Current_date로 변경 
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			
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
	/**
	 * 대시보드 점장화면에 직원 근무 일정 데이터를 가져오는 메소드 
	 * @return
	 */
	public ArrayList<EmployeeScheduleDTO> employeeschedule() {
		try {
			String sql = "SELECT * FROM VWEMPLOYEESCHEDULE WHERE SEQ_STORE = '10101'";
			//날짜 Current_date로 변경 
//			나중에 로그인 관련 값이 저장되면 거기서 SEQ_STORE에 해당하는 값 가져와 사용하기
			
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
	/**
	 * DB Connection Close 메소드
	 */
	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("DashBoardDAO.close()");
			e.printStackTrace();
		}
	}



}


