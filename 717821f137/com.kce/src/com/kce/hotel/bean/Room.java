package com.kce.hotel.bean;

public class Room {
private String RoomNumber;
private String RoomType;
private String Status;
private int CostPerDay;
public Room() {
	
}
public Room(String RoomNumber,String RoomType,String Status,int CostPerDay) {
	this.RoomNumber=RoomNumber;
	this.RoomType=RoomType;
	this.Status=Status;
	this.CostPerDay=CostPerDay;
}
public String getRoomNumber() {
	return RoomNumber;
}
public void setRoomNumber(String roomNumber) {
	RoomNumber = roomNumber;
}
public String getRoomType() {
	return RoomType;
}
public void setRoomType(String roomType) {
	RoomType = roomType;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public int getCostPerDay() {
	return CostPerDay;
}
public void setCostPerDay(int costPerDay) {
	CostPerDay = costPerDay;
}

}
