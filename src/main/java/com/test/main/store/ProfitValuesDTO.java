
package com.test.main.store;
/**
 * 선택된 매장의 월간회계 데이터와 순이익, 영업이익 데이터를 가져오는 DTO
 * @author kujun-kang
 *
 */
public class ProfitValuesDTO {
	
	private String year_month;
	private String seq_store;
	private String sales;
	private String cost_of_sales;
	private String administration_cost;
	private String sale_fee;
	private String rent_fee;
	private String tax;
	private String insurance;
	private String netprofit;
	private String operatingprofit;
	private String name;
	
	
	
	public String getYear_month() {
	
		return year_month;
	}
	public void setYear_month(String year_month) {
	
		this.year_month = year_month;
	}
	public String getSeq_store() {
	
		return seq_store;
	}
	public void setSeq_store(String seq_store) {
	
		this.seq_store = seq_store;
	}
	public String getSales() {
	
		return sales;
	}
	public void setSales(String sales) {
	
		this.sales = sales;
	}
	public String getCost_of_sales() {
	
		return cost_of_sales;
	}
	public void setCost_of_sales(String cost_of_sales) {
	
		this.cost_of_sales = cost_of_sales;
	}
	public String getAdministration_cost() {
	
		return administration_cost;
	}
	public void setAdministration_cost(String administration_cost) {
	
		this.administration_cost = administration_cost;
	}
	public String getSale_fee() {
	
		return sale_fee;
	}
	public void setSale_fee(String sale_fee) {
	
		this.sale_fee = sale_fee;
	}
	public String getRent_fee() {
	
		return rent_fee;
	}
	public void setRent_fee(String rent_fee) {
	
		this.rent_fee = rent_fee;
	}
	public String getTax() {
	
		return tax;
	}
	public void setTax(String tax) {
	
		this.tax = tax;
	}
	public String getInsurance() {
	
		return insurance;
	}
	public void setInsurance(String insurance) {
	
		this.insurance = insurance;
	}
	public String getNetprofit() {
	
		return netprofit;
	}
	public void setNetprofit(String netprofit) {
	
		this.netprofit = netprofit;
	}
	public String getOperatingprofit() {
	
		return operatingprofit;
	}
	public void setOperatingprofit(String operatingprofit) {
	
		this.operatingprofit = operatingprofit;
	}
	public String getName() {
	
		return name;
	}
	public void setName(String name) {
	
		this.name = name;
	}
	
	
	
	
}
