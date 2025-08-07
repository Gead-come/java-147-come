package heima;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;
import org.junit.runners.Parameterized;

import java.sql.*;

public class JDBCtest {
    @Test
    public void test() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");  //可以省略

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/java147_01";
        String user = "root";
        String password = "1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 获取执行对象
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate("update user set password = '12345678' where id = 1");
        // i 是影响的行数
        System.out.println("i==" + i);

        connection.close();
        statement.close();

    }

    // 参数化测试
    @ParameterizedTest
    // @ValueSource(strings = {"xiaoqaio","123456"})
    @CsvSource(value = {"xiaoqiao,123456", "daqiao,12345678", "xiaoqiao2,'or'1'='1"})
    public void test1(String uman, String upass) throws Exception {
        // 注册驱动
        // Class.forName("com.mysql.jdbc.Driver");  //可以省略

        // 获取连接
        String url = "jdbc:mysql://localhost:3306/java147_01";
        String user = "root";
        String password1 = "1234";
        Connection connection = DriverManager.getConnection(url, user, password1);

        // 获取执行对象
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from user where  username = '" + uman + "'and password ='" + upass + "'");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String password = resultSet.getString(3);
            String name = resultSet.getString(4);
            int age = resultSet.getInt(5);

            System.out.println(id + "--" + username + "--" + password + "--" + name + "--" + age);
        }
        // i 是影响的行数


        connection.close();
        statement.close();

    }

    //防御sql注入
    @ParameterizedTest
    @CsvSource(value = {"xiaoqiao,123456", "daqiao,12345678","xiaoqiao2,'or'1'='1"})
    public void test2(String uman, String upass) throws Exception {
        String url = "jdbc:mysql://localhost:3306/java147_01";
        String user = "root";
        String password1 = "1234";
        try (
                Connection connection = DriverManager.getConnection(url, user, password1);
                PreparedStatement pstmt = connection.prepareStatement(
                        "SELECT * FROM user WHERE username = ? AND password = ?"
                )
        ) {
            pstmt.setString(1, uman);  // 1 对应 ?
            pstmt.setString(2, upass); //

            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");

                    System.out.println(id + "--" + username + "--" + password + "--" + name + "--" + age);
                }
            }
        }
    }
}