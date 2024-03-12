package com.kce.train;

import com.kce.train.service.MenuService;

public class TicketBookingPlatform {
    public static void main(String[] args) {
        MenuService menuService = new MenuService();
        menuService.startMenu();
    }
}