package com.kce.service;

import com.kce.bean.Guest;
import com.kce.dao.GuestDao;

public class GuestService {
    private GuestDao guestDao;

    public GuestService() {
        guestDao = new GuestDao();
    }

    public void addGuest(Guest guest) {
        guestDao.addGuest(guest);
    }

    public Guest getGuestById(int guestId) {
        return guestDao.getGuestById(guestId);
    }

    public void updateGuest(Guest guest) {
        guestDao.updateGuest(guest);
    }

    public void deleteGuest(int guestId) {
        guestDao.deleteGuest(guestId);
    }
}