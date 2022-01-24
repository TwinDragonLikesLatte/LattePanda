
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

		} catch (Exception e) {
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
			String sql = "SELECT NAME_KR, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE('20211101','YYYYMMDD') GROUP BY (NAME_KR)";
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

			return notice;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.notice()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<StockRemainDTO> stockremain() {
		try {

			String sql = "SELECT SEQ_STORE, NAME, QUANTITY, REGDATE FROM VWSTOCKREMAIN WHERE SEQ_STORE='10101' AND REGDATE = '2022-01-25' ORDER BY QUANTITY DESC";
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

	public ArrayList<AreaMonSellProdDTO> areamonsellprod() {
		try {

			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE BETWEEN TO_DATE('20211101','YYYYMMDD') AND TO_DATE('20211201','YYYYMMDD') GROUP BY (NAME_KR)";
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

	public String areatotal() {
		try {

			String sql = "SELECT SUM(TOTAL_SALE_PRICE) AS TOTAL FROM VWDAILYSELLING WHERE SEQ_STORE ='10101' AND ORDER_DATE = TO_DATE('20211101','YYYYMMDD')";
//			나중에 당일 판매량을 확인하고 싶다면 CURRNET_DATE로 변경해서 사용하기
//			지역장에서 선택한 값에 따라 바뀌게 만들기
			rs = stat.executeQuery(sql);

			rs.next();

			String total = rs.getString("TOTAL");

			return total;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areatotal()");
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<AreaMontlyTotalDTO> areamontotal() {
		try {

			String sql = "SELECT * FROM VWMONTHLYTOTAL WHERE SEQ_STORE='10101' ORDER BY START_ORDER";
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

			return areamontotal;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.list()");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AreaStockRemainDTO> areastockremain() {
		try {

			String sql = "SELECT SEQ_STORE, NAME, QUANTITY, REGDATE FROM VWSTOCKREMAIN WHERE SEQ_STORE='10101' AND REGDATE = '2022-01-25' ORDER BY QUANTITY DESC";
//			지역장에서 선택한 값에 따라 바뀌게 만들기
			ArrayList<AreaStockRemainDTO> areastockremain = new ArrayList<AreaStockRemainDTO>();
			rs = stat.executeQuery(sql);

			while (rs.next()) {
				AreaStockRemainDTO dto = new AreaStockRemainDTO();

				dto.setSeq_store(rs.getString("seq_store"));
				dto.setName(rs.getString("name"));
				dto.setQuantity(rs.getString("quantity"));
				dto.setRegdate(rs.getString("regdate"));

				areastockremain.add(dto);
			}

			return areastockremain;

		} catch (Exception e) {
			System.out.println("DashBoardDAO.areastockremain()");
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AreaDailySellProdDTO> areaprod() {
		
		try {
			String sql = "SELECT NAME_KR AS NAME, SUM(COUNT) AS SUM FROM VWDAILYSELLING WHERE ORDER_DATE = TO_DATE('20211101','YYYYMMDD') GROUP BY (NAME_KR)";
			//날짜 세션에서 받고 
			//전매장이기에 버튼 입력값과는 상관이 없다.
			
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

}
