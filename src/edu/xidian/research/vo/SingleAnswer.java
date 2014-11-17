package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SingleAnswer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer sID;
	private Integer pnum;
	private Integer qnum;
	private String sans;
	private String other;
	public Integer getsID() {
		return sID;
	}
	public void setsID(Integer sID) {
		this.sID = sID;
	}
	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public Integer getQnum() {
		return qnum;
	}
	public void setQnum(Integer qnum) {
		this.qnum = qnum;
	}
	public String getSans() {
		return sans;
	}
	public void setSans(String sans) {
		this.sans = sans;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
	

}
