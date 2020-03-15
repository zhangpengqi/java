import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDao_bak {
    public static void main(String arg[]) {

        // 操作数据库需要用到 java.sql 包中的三个类
        Connection conn = null;         // 连接对象
        PreparedStatement stmt = null;  // 预处理对象
        ResultSet rs = null;            // 结果集对象

        try {
            // 加载驱动类 (mysql-connector-java-5.x)
            Class.forName("com.mysql.jdbc.Driver");

            // 如果mysql-connector-java-8.x 则使用下面的驱动类，最低要求Java8+
            // Class.forName("com.mysql.cj.jdbc.Driver");

            // 连接到本机(127.0.0.1)的test数据库，使用Unicode字符集UTF-8编码，不使用SSL，时区为东8区
            String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai";
            conn = DriverManager.getConnection(url, "root", "123456");

            // 准备SQL语句
            String sql = "INSERT INTO book (name, quantity) VALUES (?, ?)";
            stmt = conn.prepareStatement(sql);

            // 绑定占位符的值
            stmt.setString(1, "book1");   // 新版本驱动直接支持MySQL中的utf8mb4字符集
            stmt.setInt(2, 100);

            // 执行SQL
            stmt.execute();

            // 获取MySQL自增id
            rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            int id;
            if (rs.next()) {
                id = rs.getInt(1);
                System.out.println("ID:" + id);
            }

            // 释放资源，关闭连接
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
