
package com.test.main.store;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.main.home.MontlyTotalDTO;
import com.test.main.util.DBUtil;

public class StoreDAO {

	private Connection conn;
	private Statement stat;
	private PreparedStatement pstat;
	private ResultSet rs;

	public StoreDAO() {
		try {

			conn = DBUtil.open();
			stat = conn.createStatement();

		} catch (Exception e) {
			System.out.println("StoreDAO.StoreDAO()");
			e.printStackTrace();
		}
	}

	public ArrayList<StoreProfitDTO> storeprofit() {
		try {

			String sql = "SELECT * FROM VWSTOREPROFIT  WHERE YEAR_MONTH = to_char(add_months(CURRENT_DATE,-1),'yyyymm') ORDER BY NETPROFIT DESC ";

			ArrayList<StoreProfitDTO> storeprofit = new ArrayList<StoreProfitDTO>();

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				StoreProfitDTO dto = new StoreProfitDTO();

				dto.setYear_month(rs.getString("year_month"));
				dto.setSeq_store(rs.getString("seq_store"));
				dto.setSales(rs.getString("sales"));
				dto.setCost_of_sales(rs.getString("cost_of_sales"));
				dto.setAdministration_cost(rs.getString("administration_cost"));
				dto.setSale_fee(rs.getString("sale_fee"));
				dto.setRent_fee(rs.getString("rent_fee"));
				dto.setTax(rs.getString("tax"));
				dto.setInsurance(rs.getString("insurance"));
				dto.setNetprofit(rs.getString("netprofit"));
				dto.setOperatingprofit(rs.getString("operatingprofit"));
				dto.setName(rs.getString("name"));

				storeprofit.add(dto);
			}
			return storeprofit;

		} catch (Exception e) {
			System.out.println("StoreDAO.storeprofit()");
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<ProfitValuesDTO> profitvalues(String store) {
		try {

			String sql = "SELECT * FROM VWSTOREPROFIT WHERE SEQ_STORE = "+store+" AND YEAR_MONTH = to_char(add_months(CURRENT_DATE,-1),'yyyymm') ";

			ArrayList<ProfitValuesDTO> profitvalues = new ArrayList<ProfitValuesDTO>();

			rs = stat.executeQuery(sql);

			while (rs.next()) {
				ProfitValuesDTO dto = new ProfitValuesDTO();

				dto.setYear_month(rs.getString("year_month"));
				dto.setSeq_store(rs.getString("seq_store"));
				dto.setSales(rs.getString("sales"));
				dto.setCost_of_sales(rs.getString("cost_of_sales"));
				dto.setAdministration_cost(rs.getString("administration_cost"));
				dto.setSale_fee(rs.getString("sale_fee"));
				dto.setRent_fee(rs.getString("rent_fee"));
				dto.setTax(rs.getString("tax"));
				dto.setInsurance(rs.getString("insurance"));
				dto.setNetprofit(rs.getString("netprofit"));
				dto.setOperatingprofit(rs.getString("operatingprofit"));
				dto.setName(rs.getString("name"));

				profitvalues.add(dto);
			}
			return profitvalues;

		} catch (Exception e) {
			System.out.println("StoreDAO.profitvalues()");
			e.printStackTrace();
		}
		return null;
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {
			System.out.println("StoreDAO.close()");
			e.printStackTrace();
		}
	}
}
