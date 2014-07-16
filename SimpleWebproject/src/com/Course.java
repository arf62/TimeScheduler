package com;
import java.io.Serializable;
 
public class Course implements Serializable{
 
    private static final long serialVersionUID = 1L;
    private String course_name;
    private String course_id;
    private int credit_hours;
    private String class_level;
    private String course_desc;
    private int reference;
    private int profId ;
    private int Mid;
    private String ProfName;
   
    
    public String getcourse_name() {
        return course_name;
    }
    public void setcourse_name(String course_name) {
        this.course_name = course_name;
    }
    public String getcourse_id() {
        return course_id;
    }
    public void setcourse_id(String course_id) {
        this.course_id = course_id;
    }
    public int getcredit_hours() {
        return credit_hours;
    }
    public void setcredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }
    public String getclass_level() {
        return class_level;
    }
    public void setclass_level(String class_level) {
        this.class_level = class_level;
    }
	public String getCourse_desc() {
		return course_desc;
	}
	public void setCourse_desc(String course_desc) {
		this.course_desc = course_desc;
	}
	public int getReference() {
		return reference;
	}
	public void setReference(int reference) {
		this.reference = reference;
	}
	public int getProfId() {
		return profId;
	}
	
	public void setProfId(int profId) {
		// TODO Auto-generated method stub
		this.profId = profId;
	}
	public int getMid() {
		return Mid;
	}
	public void setMid(int mid) {
		Mid = mid;
	}
	public String getProfName() {
		return ProfName;
	}
	public void setProfName(String profName) {
		ProfName = profName;
	}
     
}