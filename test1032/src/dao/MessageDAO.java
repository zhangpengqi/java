package dao;

import bean.Message;

import java.util.List;

public interface MessageDAO {

    /**
     * 查询消息
     * @param userId
     * @param nextId
     * @return
     */
    List<Message> findMessages(int userId, int nextId);

    /**
     * 用户登录
     * @param message 
     */
    void createMessage(Message message);
}
