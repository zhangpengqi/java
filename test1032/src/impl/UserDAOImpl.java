package impl;

import bean.User;
import dao.UserDAO;
import util.DBUtil;

import java.sql.*;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD ="SELECT * FROM USER WHERE USERNAME=? AND PASSWORD_HASH =?";
    private static final String SQL_INSERT_USER ="INSERT INTO USER ( USERNAME,PASSWORD_HASH,LAST_ACTIVE_AT,CREATED_AT) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE_LAST_ACTIVE_AT ="UPDATE USER SET LAST_ACTIVE_AT =? WHERE USERNAME=?";

    /**
     * 注册
     * @param username 账号
     * @param password 密码
     * @return 返回1，插入成功。返回0，插入失败。
     */
    @Override
    public int register(String username, String password) {
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
            state.setTimestamp(3,new Timestamp(new Date().getTime()));
            state.setTimestamp(4,new Timestamp(new Date().getTime()));
            //4.执行SQL语句，得到结果
            int a=state.executeUpdate();
            DBUtil.releaseResource(conn,state,null);
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 登录
     * @param username 账号
     * @param password 密码
     * @return
     */
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
            //4.执行SQL语句，得到结果
            ResultSet result =state.executeQuery();
            //5.循环遍历结果集
            if(result.next()){
                String userName=result.getString("username");
                String passWordHash=result.getString("password_hash");
                DBUtil.releaseResource(conn,state,null);
                return new User(userName,passWordHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新用户活动时间
     * @param username 活动用户账号
     */
    @Override
    public void updateLastActiveAt(String username) {
        Connection conn =null;
        PreparedStatement state=null;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_UPDATE_LAST_ACTIVE_AT);
            //3.填充参数
            state.setTimestamp(1,new Timestamp(new Date().getTime()));
            state.setString(2,username);
            //4.执行SQL语句，得到结果
            state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
    }
}
