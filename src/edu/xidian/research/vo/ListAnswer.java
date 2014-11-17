package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ListAnswer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer lID;
	private Integer pnum;
	private Integer qnum;
	private String lans;
	public Integer getlID() {
		return lID;
	}
	public void setlID(Integer lID) {
		this.lID = lID;
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
	public String getLans() {
		return lans;
	}
	public void setLans(String lans) {
		this.lans = lans;
	}
	
	
}
