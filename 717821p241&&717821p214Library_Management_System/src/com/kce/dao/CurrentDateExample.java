package com.kce.dao;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class CurrentDateExample {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.now();
        LocalDate date2 = LocalDate.of(2023, 2, 30);
        long days = ChronoUnit.DAYS.between(date1, date2);
        

        System.out.println(days);
    }
}
