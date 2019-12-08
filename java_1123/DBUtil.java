package java_1123;

import java.math.BigDecimal;
import java.sql.*;

public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.1:3306/test";
    private static final String USENAME = "root";
    private static final String PASSWORD = "045510";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager
                    .getConnection(URL, USENAME, PASSWORD);
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select id,name,chinese,math,english from exam_result";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                BigDecimal chinese = resultSet.getBigDecimal("chinese");
                BigDecimal math = resultSet.getBigDecimal("math");
                BigDecimal english = resultSet.getBigDecimal("english");
                System.out.print(" id = " + id + " name = " + name + " chinese = " + chinese +" math = "
                        + math + " english = " +english);
                System.out.println();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null   ) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
