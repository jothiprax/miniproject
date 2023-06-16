package com.kce.util;
import java.sql.SQLException;

import com.kce.service.*;
public class Main {
	public static void main(String[] args) throws OverbookingException,SQLException{
        EventManagementService eventManagementService = new EventManagementService();
        eventManagementService.displayMenu();
    }
}
