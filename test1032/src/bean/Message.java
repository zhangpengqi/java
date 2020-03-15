package bean;

import java.util.Date;
import java.util.Objects;

/**
 * 聊天信息表
 */
public class Message {
    private int id;//用户id
    private int fromUserId;//发信人ID
    private int toUserId;//接收人id（0表示公开聊天）
    private  String content;//消息内容
    private Date createdAt;//发信息时间

    public Message() {
    }

    public Message(int id, int fromUserId, int toUserId, String content, Date createdAt) {
        this.id = id;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.content = content;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(int fromUserId) {
        this.fromUserId = fromUserId;
    }

    public int getToUserId() {
        return toUserId;
    }

    public void setToUserId(int toUserId) {
        this.toUserId = toUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id &&
                fromUserId == message.fromUserId &&
                toUserId == message.toUserId &&
                Objects.equals(content, message.content) &&
                Objects.equals(createdAt, message.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromUserId, toUserId, content, createdAt);
    }
}
