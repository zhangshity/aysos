package com.zcy.DB;

import java.sql.*;

public class SimpleConnection {

    /**
     * 阳爸爸的DIY
     */
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/zcy_test", "root", "1995418");
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from course;");

            while (resultSet.next()) {
                int cno = resultSet.getInt("cno");
                String cname = resultSet.getString("cname");
                int cpno = resultSet.getInt("cpno");
                int ccredit = resultSet.getInt("ccredit");

                System.out.println(cno + "|" + cname + "|" + cpno + "|" + ccredit);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

}
