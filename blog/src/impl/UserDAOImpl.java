package impl;

import bean.User;
import dao.UserDAO;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_INSERT_USER ="INSERT INTO TASK1040USER (USERNAME,PASSWORD) VALUES (?,?)";
    private static final String SQL_SELECT_USER_BY_USERNAME ="SELECT * FROM TASK1040USER WHERE USERNAME=?";
    private static final String SQL_UPDATE_USER ="UPDATE TASK1040USER SET PASSWORD=? WHERE USERNAME=?";

    /**
     * 注册账号
     * @param username 账号
     * @param password 密码
     * @return 成功返回1，失败返回-1
     */
    @Override
    public int insertByUsernameAndPassword(String username, String password) {
        Connection conn=null;
        PreparedStatement state=null;
        int a=-1;
        try {
            //1.得到数据库的连接对象
            conn =DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_INSERT_USER);
            //3.填充参数
            state.setString(1,username);
            state.setString(2,password);
            //4.执行sql语句，得到结果
            a=state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
        return a;
    }


    /**
     *  查询用户是否存在
     * @param username 账号
     * @return 失败返回null，成功返回User
     */
    @Override
    public User selectByUsername(String username) {
        Connection conn=null;
        PreparedStatement state=null;
        ResultSet result=null;

        try {
            //1.得到数据库的连接对象
            conn =DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_SELECT_USER_BY_USERNAME);
            //3.填充参数
            state.setString(1,username);
            //4.执行sql语句，得到结果
            result=state.executeQuery();
            while(result.next()){
                String u=result.getString("username");
                String pwd=result.getString("password");
                return new User(u,pwd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,result);
        return null;
    }
    /**
     *  修改密码
     * @param username 账号
     * @param password 密码
     * @return 成功返回1
     */
    @Override
    public int update(String username, String password) {
        Connection conn=null;
        PreparedStatement state=null;
        int a=-1;
        try {
            //1.得到数据库的连接对象
            conn =DBUtil.getConnection();
            //2.预编译SQL语句
            state=conn.prepareStatement(SQL_UPDATE_USER);
            //3.填充参数
            state.setString(1,password);
            state.setString(2,username);
            //4.执行sql语句，得到结果
            a=state.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
        return a;
    }
}
