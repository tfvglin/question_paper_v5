package edu.xidian.research.vo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class AnswersPaper {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer pID;
	private Integer pnum;
	private String stuname;
	private String stunum;
	private String phone;
	private String time;
	@OneToMany(fetch=FetchType.LAZY,targetEntity=SingleAnswer.class,cascade={CascadeType.ALL})
	@JoinColumns(value={@JoinColumn(name="pID",referencedColumnName="pID")})
	private List<SingleAnswer> singleanswer = new ArrayList<SingleAnswer>();
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=MultipleAnswer.class,cascade={CascadeType.ALL})
	@JoinColumns(value={@JoinColumn(name="pID",referencedColumnName="pID")})
	private List<MultipleAnswer> multipleanswer = new ArrayList<MultipleAnswer>();	
	
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=TextAnswer.class,cascade={CascadeType.ALL})
	@JoinColumns(value={@JoinColumn(name="pID",referencedColumnName="pID")})
	private List<TextAnswer> textanswer = new ArrayList<TextAnswer>();
	
	@OneToMany(fetch=FetchType.LAZY,targetEntity=ListAnswer.class,cascade={CascadeType.ALL})
	@JoinColumns(value={@JoinColumn(name="pID",referencedColumnName="pID")})
	private List<ListAnswer> listanswer = new ArrayList<ListAnswer>();
	public Integer getpID() {
		return pID;
	}
	public void setpID(Integer pID) {
		this.pID = pID;
	}

	public Integer getPnum() {
		return pnum;
	}
	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getStunum() {
		return stunum;
	}
	public void setStunum(String stunum) {
		this.stunum = stunum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public List<SingleAnswer> getSingleanswer() {
		return singleanswer;
	}
	public void setSingleanswer(List<SingleAnswer> singleanswer) {
		this.singleanswer = singleanswer;
	}
	public List<MultipleAnswer> getMultipleanswer() {
		return multipleanswer;
	}
	public void setMultipleanswer(List<MultipleAnswer> multipleanswer) {
		this.multipleanswer = multipleanswer;
	}
	public List<TextAnswer> getTextanswer() {
		return textanswer;
	}
	public void setTextanswer(List<TextAnswer> textanswer) {
		this.textanswer = textanswer;
	}
	public List<ListAnswer> getListanswer() {
		return listanswer;
	}
	public void setListanswer(List<ListAnswer> listanswer) {
		this.listanswer = listanswer;
	}
	
	
}
