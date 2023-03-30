package org.example.utils;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3307/subway";
    private static String username = "root";
    private static String password = "123456";
    private static Connection connection;
    private static PreparedStatement preparedStatement;

    @SneakyThrows
    public static void getConnection() {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
    }

    @SneakyThrows
    public static int update(String sql, Object[] s) {
        preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        if(s==null) return preparedStatement.executeUpdate();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                return 0;
            }
            preparedStatement.setObject(i + 1, s[i]);
        }
        return preparedStatement.executeUpdate();
    }

    @SneakyThrows
    public static ResultSet query(String sql, Object[] s) {
        preparedStatement = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        if(s==null) return preparedStatement.executeQuery();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == null) {
                break;
            }
            preparedStatement.setObject(i + 1, s[i]);
        }
        return preparedStatement.executeQuery();
    }
    @SneakyThrows
    public static void closeConnection(){
        if(preparedStatement!=null) preparedStatement.close();
        if(connection!=null) connection.close();
    }
}
