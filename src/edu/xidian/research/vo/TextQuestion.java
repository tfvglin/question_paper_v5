package edu.xidian.research.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class TextQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tID;
	private Integer t_qnum;
	
	//@ManyToOne(fetch = FetchType.EAGER,cascade={CascadeType.ALL})
	//@JoinColumn(name="pID")
	//private Paper paper;
	private String t_que;
	public Integer getT_qID() {
		return tID;
	}
	public void setT_qID(Integer t_qID) {
		this.tID = t_qID;
	}
	public Integer getT_qnum() {
		return t_qnum;
	}
	public void setT_qnum(Integer t_qnum) {
		this.t_qnum = t_qnum;
	}
	
	
	

	public String getT_que() {
		return t_que;
	}
	public void setT_que(String t_que) {
		this.t_que = t_que;
	}

	
	
	
	

}
