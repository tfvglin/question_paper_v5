package edu.xidian.research.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class MultipleAnswer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer mID;
	private Integer pnum;
	private Integer qnum;
	private String mans;
	private String other;
	public Integer getmID() {
		return mID;
	}
	public void setmID(Integer mID) {
		this.mID = mID;
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
	public String getMans() {
		return mans;
	}
	public void setMans(String mans) {
		this.mans = mans;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	
	
	

}
