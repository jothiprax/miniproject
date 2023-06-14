package com.kce.bean;

public class LocalCourier extends Courier {
    public String city;
    
    // Getters and setters
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
}

// Subclass for specific courier type
class InternationalCourier extends Courier {
    public String country;
    
    // Getters and setters
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
}