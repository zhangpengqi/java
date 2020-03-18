package impl;

import bean.Message;
import bean.User;
import dao.MessageDAO;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageDAOImpl implements MessageDAO {
    private static final String SQL_INSERT_MESSAGE ="INSERT INTO MESSAGE (FROM_USER_ID,TO_USER_ID,CONTENT,CREATED_AT) VALUES (?,?,?,?)";
//    private static final String SQL_FIND_MESSAGES ="SELECT * FROM MESSAGE WHERE CREATED_AT BETWEEN ? AND ? AND TO_USER_ID IN (0,?)" ;
    private static final String SQL_FIND_MESSAGES ="SELECT * FROM MESSAGE WHERE CREATED_AT BETWEEN ? AND DATE_ADD(?,INTERVAL  1 SECOND ) AND TO_USER_ID IN (0,?)" ;

    /**
     *  查询用户信息
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @param userId 用户id
     * @return 返回信息集合List<message>
     */
    @Override
    public List<Message> findMessages(Timestamp beginTime, Timestamp endTime, int userId) {
        List<Message> messageList=new ArrayList<>();
        Connection conn =null;
        PreparedStatement state=null;
        ResultSet result=null;

        try {
            //1.得到数据库的连接对象
            conn=DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_FIND_MESSAGES);
            //3.填充参数
            state.setTimestamp(1,beginTime);
            state.setTimestamp(2,endTime);
            state.setInt(3,userId);
            //4.执行SQL语句，得到结果
            result =state.executeQuery();
            //5.循环遍历结果集
            while (result.next()){
                int id=result.getInt("id");
                int fromUserId=result.getInt("from_user_id");
                int toUserId=result.getInt("to_user_id");
                String content=result.getString("content");
                Timestamp createdAt=result.getTimestamp("created_at");
                //将查询到的聊天信息存到集合中
                messageList.add(new Message(id,fromUserId,toUserId,content,createdAt));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.releaseResource(conn,state,result);
        return messageList;
    }

    /**
     * 发送信息，插入数据库
     * @param message 发送的信息Message
     */
    @Override
    public void createMessage(Message message) {
        Connection conn =null;
        PreparedStatement state=null;

        try {
            //1.得到数据库的连接对象
            conn= DBUtil.getConnection();
            //2.预编译SQL
            state=conn.prepareStatement(SQL_INSERT_MESSAGE);
            //3.填充参数
            state.setInt(1,message.getFromUserId());
            state.setInt(2,message.getToUserId());
            state.setString(3,message.getContent());
            state.setTimestamp(4,message.getCreatedAt());
            //4.执行SQL语句，得到结果
            int a=state.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //释放资源
        DBUtil.releaseResource(conn,state,null);
    }
}
