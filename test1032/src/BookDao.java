import util.DBUtil;

import java.sql.*;

public class BookDao {
    public static void main(String arg[]) {

        Connection conn = DBUtil.getConnection();

        PreparedStatement stmt = null;  // 预处理对象
        ResultSet rs = null;            // 结果集对象

        // 准备SQL语句
        String sql = "INSERT INTO book (name, quantity) VALUES (?, ?)";
        try {
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

        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 释放资源，关闭连接
        DBUtil.releaseResource(conn,stmt,rs);
    }
}
