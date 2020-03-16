package dao;

import bean.Message;

import java.sql.Timestamp;
import java.util.List;

public interface MessageDAO {

    /**
     * 查询信息
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @param toUserId 收信人id
     * @return
     */
    List<Message> findMessages(Timestamp beginTime, Timestamp endTime,int toUserId);

    /**
     * 用户登录
     * @param message 
     */
    void createMessage(Message message);
}
