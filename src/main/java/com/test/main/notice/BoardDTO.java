package com.test.main.notice;

/**
 * 데이터 보관
 * @author JH LEE
 *
 */
public class BoardDTO {
	
	public String seq_notice;
	public String seq_department;
	public String title;
	public String regdate;
	public String content;
	
	public String name; //부서명
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSeq_notice() {
		return seq_notice;
	}
	public void setSeq_notice(String seq_notice) {
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
