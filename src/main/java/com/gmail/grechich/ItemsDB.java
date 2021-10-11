package com.gmail.grechich;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ItemsDB {
    public static void addItem(Scanner sc, Connection conn) throws SQLException {

        System.out.print("Enter item name: ");
        String itemName = sc.nextLine();
        System.out.print("Enter item price: ");
        String sItemPrice = sc.nextLine();
        double itemPrice = Double.parseDouble(sItemPrice);



        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO ItemsDB (itemName, itemPrice, availability) VALUES(?, ?, ?)");
        try {
            ps.setString(1, itemName);
            ps.setDouble(2, itemPrice);
            ps.setBoolean(3, true);
            ps.executeUpdate();
        } finally {
            ps.close();
        }

    }
}
