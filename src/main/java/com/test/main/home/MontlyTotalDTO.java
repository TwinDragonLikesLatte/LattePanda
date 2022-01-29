
package com.test.main.home;
/**
 * 점장 월간판매액 DTO
 * @author kujun-kang
 *
 */
public class MontlyTotalDTO {
	
	private String seq_store;
	private String start_order;
	private int montotal;
	
	
	public int getMontotal() {
	
		return montotal;
	}
	public void setMontotal(int montotal) {
	
		this.montotal = montotal;
	}
	public String getSeq_store() {
	
		return seq_store;
	}
	public void setSeq_store(String seq_store) {
	
		this.seq_store = seq_store;
	}
	public String getStart_order() {
	
		return start_order;
	}
	public void setStart_order(String start_order) {
	
		this.start_order = start_order;
	}
	
	
	

	
	
	
	

}
