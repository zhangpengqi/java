package impl;

import bean.User;
import dao.UserDAO;
import util.DBUtil;

import java.sql.*;

public class userDAO implements UserDAO {
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD ="SELECT * FROM USER WHERE USERNAME=? AND PASSWORD =?";
    private static final String SQL_INSERT_USER ="INSERT INTO USER VALUES(USER_ID.NEXTVAL,?,?,1,?,?)";

    @Override
    public User register(String username, String password) {
        Connection conn =null;
        PreparedStatement state=null;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_INSERT_USER);
            //3.填充参数
            state.setString(1,username);
            state.setString(2,password);
            //4.执行SQL语句，得到结果
            ResultSet result =state.executeQuery();
            //5.循环遍历结果集
            if(result.next()){
                String userName=result.getString("userName");
                String passWordHash=result.getString("passWordHash");
                return new User(userName,passWordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User login(String username, String password) {
        Connection conn =null;
        PreparedStatement state=null;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_FIND_BY_USERNAME_AND_PASSWORD);
            //3.填充参数
            state.setString(1,username);
            state.setString(2,password);
            state.setTime(3,new Date());
            state.setString(2,password);
            //4.执行SQL语句，得到结果
            ResultSet result =state.executeQuery();
            //5.循环遍历结果集
            if(result.next()){
                String userName=result.getString("userName");
                String passWordHash=result.getString("passWordHash");
                return new User(userName,passWordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
