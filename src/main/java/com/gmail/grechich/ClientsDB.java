package com.gmail.grechich;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ClientsDB {

    public static void addClient(Scanner sc, Connection conn) throws SQLException {

        System.out.print("Enter clients name: ");
        String clientName = sc.nextLine();
        System.out.print("Enter clients phone: ");
        String clientPhone = sc.nextLine();
        System.out.print("Enter clients mail: ");
        String clientMail = sc.nextLine();

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO ClientsDB (clientName, clientPhone, clientMail) VALUES(?, ?, ?)");
        try {
            ps.setString(1, clientName);
            ps.setString(2, clientPhone);
            ps.setString(3, clientMail);
            ps.executeUpdate();
        } finally {
            ps.close();
        }


    }
}
