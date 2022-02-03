
package com.test.main.home;
/**
 * 공지사항 DTO
 * @author kujun-kang
 *
 */
public class NoticeDTO {
	private int seq_notice;
	private String seq_department;
	private String title;
	private String regdate;
	private String content;
	public int getSeq_notice() {
	
		return seq_notice;
	}
	public void setSeq_notice(int seq_notice) {
	
		this.seq_notice = seq_notice;
	}
	public String getSeq_department() {
	
		return seq_department;
	}
	public void setSeq_department(String seq_department) {
	
		this.seq_department = seq_department;
	}
	public String getTitle() {
	
		return title;
	}
	public void setTitle(String title) {
	
		this.title = title;
	}
	public String getRegdate() {
	
		return regdate;
	}
	public void setRegdate(String regdate) {
	
		this.regdate = regdate;
	}
	public String getContent() {
	
		return content;
	}
	public void setContent(String content) {
	
		this.content = content;
	}
	
	
	
}
