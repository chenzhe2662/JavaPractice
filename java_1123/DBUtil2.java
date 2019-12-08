package java_1123;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.math.BigDecimal;
import java.sql.*;

public class DBUtil2 {
    private static final String URL = "jdbc:mysql://127.0.1:3306/test";
    private static final String USENAME = "root";
    private static final String PASSWORD = "045510";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setURL(URL);
            ds.setUser(USENAME);
            ds.setPassword(PASSWORD);
            connection = ds.getConnection();

            System.out.println(connection);
            String sql = "select id,name,chinese,math,english from exam_result where id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1,3);
            System.out.println(sql);
            resultSet = statement.executeQuery();


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
        } catch ( SQLException e) {
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

