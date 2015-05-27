package com.company;

import java.sql.*;

public class MySqlConnect {
    public static Connection connection;
    public static PreparedStatement preparedStatement;
    public static ResultSet resultSet;
    public static long l=0;


    public static void addData(String name, String map) throws SQLException{

        String stmt = "Insert into test values(?, ?)";
        preparedStatement = connection.prepareStatement(stmt);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, map);
        long start = System.currentTimeMillis();
        preparedStatement.execute();
        l += System.currentTimeMillis() - start;

    }

    public static void getMap(String name) {
        try {
            preparedStatement = connection.prepareStatement("select map from test where name = ?");
            preparedStatement.setString(1, name);
            long start = System.currentTimeMillis();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                System.out.println(name +"->"+ resultSet.getString("map"));
            l = l + System.currentTimeMillis() - start;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void closeCon() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void process(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }


        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "password");

        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("");
        } else {
            System.out.println("Failed to make connection!");
        }
    }
}
