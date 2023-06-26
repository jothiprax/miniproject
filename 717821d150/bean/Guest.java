package com.kce.bean;

public class Guest {
	private int guest_id;
    private String name;
    private String email;
    private String phone_number;

    public Guest() {
    }

    public Guest(int guest_id, String name, String email, String phone_number) {
        this.guest_id = guest_id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
    }

    public int getGuest_id() {
        return guest_id;
    }

    public void setGuest_id(int guest_id) {
        this.guest_id = guest_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
    
}

