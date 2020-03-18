package impl;

import bean.User;
import dao.UserDAO;
import util.DBUtil;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class UserDAOImpl implements UserDAO {
    private static final String SQL_FIND_BY_USERNAME_AND_PASSWORD ="SELECT * FROM USER WHERE USERNAME=? AND PASSWORD_HASH =?";
    private static final String SQL_INSERT_USER ="INSERT INTO USER ( USERNAME,PASSWORD_HASH,CREATED_AT) VALUES(?,?,?)";
    private static final String SQL_UPDATE_LAST_ACTIVE_AT ="UPDATE USER SET LAST_ACTIVE_AT =? WHERE USERNAME=?";
    private static final String SQL_SELECT_ONLINE_USERS ="SELECT id FROM USER WHERE LAST_ACTIVE_AT BETWEEN ? AND ?";
    private static final String SQL_FIND_BY_ID = "SELECT USERNAME FROM USER WHERE ID=?";
    private static final String SQL_FIND_BY_USERNAME ="SELECT * FROM USER WHERE USERNAME=?" ;

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
        int a=0;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_INSERT_USER);
            //3.填充参数
            state.setString(1,username);
            state.setString(2,password);
            state.setTimestamp(3,new Timestamp(new Date().getTime()));
            //4.执行SQL语句，得到结果
            a=state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
        return a;
    }

    /**
     * 登录
     * @param username 账号
     * @param password 密码
     * @return 返回用户id，没查询到返回-1
     */
    @Override
    public int login(String username, String password) {
        Connection conn =null;
        PreparedStatement state=null;
        int id =-1;

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
            while(result.next()){
                id=result.getInt("id");
                username=result.getString("username");
                //更新用户最后活动时间
                updateLastActiveAt(username);
            }
            DBUtil.releaseResource(conn,state,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 根据用户id查询用户账号
     * @param id 用户id
     * @return 用户账号
     */
    @Override
    public String selectUsername(int id) {

    Connection conn =null;
    PreparedStatement state=null;
    ResultSet result=null;
    String username=null;

        try {
        //1.得到数据库的连接对象
        conn=DBUtil.getConnection();
        //2.预编译SQL
        state=conn.prepareStatement(SQL_FIND_BY_ID);
        //3.填充参数
        state.setInt(1,id);
        //4.执行SQL语句，得到结果
        result =state.executeQuery();
        //5.循环遍历结果集
        while (result.next()){
            username=result.getString("username");
            //更新用户最后活动时间
        }
        DBUtil.releaseResource(conn,state,null);
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return username;
}

    /**
     * 根据账号查询是否已注册
     * @param username 账号
     * @return 存在返回id，不存在返回-1
     */
    @Override
    public int selectUserId(String username) {

        Connection conn =null;
        PreparedStatement state=null;
        ResultSet result=null;
        int id=-1;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_FIND_BY_USERNAME);
            //3.填充参数
            state.setString(1,username);
            //4.执行SQL语句，得到结果
            result =state.executeQuery();
            //5.循环遍历结果集
            while (result.next()){
                id=result.getInt("id");
                //更新用户最后活动时间
            }
            DBUtil.releaseResource(conn,state,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
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

    /**
     * 查询在线人数
     * @return 返回在线人数
     */
    @Override
    public int selectOnlineUsers() {
        Connection conn =null;
        PreparedStatement state=null;
        ResultSet result = null;
        Set<Integer> userSet=new HashSet<>();
        //系统id=0;
        userSet.add(0);
        int a=0;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_SELECT_ONLINE_USERS);
            //3.填充参数
            state.setTimestamp(1,new Timestamp(new Date().getTime()-1000*60*2));
            state.setTimestamp(2,new Timestamp(new Date().getTime()));
            //4.执行SQL语句，得到结果
            result=state.executeQuery();
            while (result.next()){
                userSet.add(result.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,null);
        //减去系统id=0，
        return userSet.size()-1;
    }
}
