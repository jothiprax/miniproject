package com.kce.hbs.bean;

public class Room extends Hotel {
    private int roomNo;
    private int guestCount;
    private String guestName;
    private String check_in_date;
    private String check_out_date;

    public Room(int hotelId, String name, String location, int roomNo, int guestCount, String guestName,
            String check_in_date, String check_out_date) {
        super(hotelId, name, location);
        this.roomNo = roomNo;
        this.guestCount = guestCount;
        this.guestName = guestName;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public Room(int hotelId, int roomNo, int guestCount, String guestName, String check_in_date,
            String check_out_date) {
        super(hotelId);
        this.roomNo = roomNo;
        this.guestCount = guestCount;
        this.guestName = guestName;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(int guestCount) {
        this.guestCount = guestCount;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    @Override
    public String toString() {
        return "Booking [HotelId=" + getHotelId() + ", Hotel Name=" + getName() + ", Location=" + getLocation()
                + ", roomNo=" + roomNo + ", guestCount=" + guestCount + ", guestName=" + guestName + ", check_in_date="
                + check_in_date + ", check_out_date=" + check_out_date + "]";
    }

}