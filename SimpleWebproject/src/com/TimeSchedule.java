package com;
import java.io.Serializable;
import java.sql.Time;
 
public class TimeSchedule implements Serializable{
 
    private static final long serialVersionUID = 1L;
    private Time time_block;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;    
    private String building_name_no;
    private String time;
    
    public Time getTimeBlock() {
        return time_block;
    }
    public void setTimeBlock(Time timeBlock) {
        this.time_block = timeBlock;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }    
    
    public String getMonday() {
    	return monday;
    }
    public void setMonday(String mon) {
    	this.monday = mon;
    }
    public String getTuesday() {
    	return tuesday;
    }
    public void setTuesday(String tues) {
    	this.tuesday = tues;
    }     
    public String getWednesday() {
    	return wednesday;
    }
    public void setWednesday(String wed) {
    	this.wednesday = wed;
    }    
    public String getThursday() {
    	return thursday;
    }
    public void setThursday(String thurs) {
    	this.thursday = thurs;
    }    
    public String getFriday() {
    	return friday;
    }
    public void setFriday(String fri) {
    	this.friday = fri;
    }        
    public String getRoomInfo(){
    	return building_name_no;    	
    }
    public void setRoomInfo(String roomInfo){
    	this.building_name_no = roomInfo;
    }
}