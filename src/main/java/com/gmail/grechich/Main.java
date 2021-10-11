package com.gmail.grechich;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/OrderDB?serverTimezone=Europe/Kiev";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "01410252";
    static Connection conn;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            try {
                conn = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
                while (true) {
                    System.out.println("1: add item");
                    System.out.println("2: add client");
                    System.out.println("3: do order");

                    System.out.print("-> ");
                    String s = sc.nextLine();
                    switch (s) {
                        case "1":
                            ItemsDB.addItem(sc, conn);
                            break;
                        case "2":
                            ClientsDB.addClient(sc, conn);
                            break;
                        case "3":
                            OrdersDB.addOrder(sc, conn);
                            break;
                        default:
                            return;
                    }
                }
            } finally {
                sc.close();
                if (conn != null) conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return;
        }
    }
}

