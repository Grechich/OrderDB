package com.gmail.grechich;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class OrdersDB {

    public static void addOrder(Scanner sc, Connection conn) throws SQLException {
        System.out.print("Enter clients id: ");
        String sClientId = sc.nextLine();
        int clientId = Integer.parseInt(sClientId);
        System.out.print("Enter item id: ");
        String sItemId = sc.nextLine();
        int itemId = Integer.parseInt(sItemId);
        LocalDate date = LocalDate.now();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO OrdersDB (clientId, itemId, orderDate ) VALUES(?, ?, ?)");
        try {
            ps.setInt(1, clientId);
            ps.setInt(2, itemId);
            ps.setDate(3, Date.valueOf(date));
            ps.executeUpdate();
        } finally {
            ps.close();
        }
    }
}
