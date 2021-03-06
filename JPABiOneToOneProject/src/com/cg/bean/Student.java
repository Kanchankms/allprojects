package com.cg.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Students")
public class Student
{
	@Id												//rollno is the primary key
	@GeneratedValue(strategy=GenerationType.AUTO)	//generate automatically rollno.
	@Column(name="roll_no" ,length=10)				//column creation for rollno, must contain underscore
	private int rollNo;
	@Column(name="stu_name" ,length=25)
	private String stuName;
	@Transient										//stumarks property is not mapped ,its ignored
	private int stuMarks;
	
	@OneToOne(cascade=CascadeType.ALL)		
	@JoinColumn(name="add_id")
	private Address stuAdd;
	
	public Student() {
		super();
	}
	
	public Student(int rollNo, String stuName, int stuMarks, Address stuAdd) {
		super();
		this.rollNo = rollNo;
		this.stuName = stuName;
		this.stuMarks = stuMarks;
		this.stuAdd = stuAdd;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuMarks() {
		return stuMarks;
	}
	public void setStuMarks(int stuMarks) {
		this.stuMarks = stuMarks;
	}
	
	public Address getStuAdd() {
		return stuAdd;
	}

	public void setStuAdd(Address stuAdd) {
		this.stuAdd = stuAdd;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", stuName=" + stuName
				+ ", stuMarks=" + stuMarks + ", stuAdd=" + stuAdd + "]";
	}


	
}
