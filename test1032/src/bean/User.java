package bean;

import java.util.Date;
import java.util.Objects;

/**
 * 用户表
 */

public class User {
    private int id;//用户id
    private String userName;//账号
    private String passWordHash;//密码哈希值
    private int status;//状态(1.正常用户，2.黑名单)
    private Date lastActiveAt;//最近活动时间，举例当前时间小于2分钟表示在线
    private Date createdAt;//注册时间
    public User() {
    }

    public User(String userName, String passWordHash) {
        this.userName = userName;
        this.passWordHash = passWordHash;
    }

    public User(String userName, String passWordHash, Date createdAt) {
        this.userName = userName;
        this.passWordHash = passWordHash;
        this.createdAt = createdAt;
    }

    public User(int id, String userName, String passWordHash, int status, Date lastActiveAt, Date createdAt) {
        this.id = id;
        this.userName = userName;
        this.passWordHash = passWordHash;
        this.status = status;
        this.lastActiveAt = lastActiveAt;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWordHash() {
        return passWordHash;
    }

    public void setPassWordHash(String passWordHash) {
        this.passWordHash = passWordHash;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastActiveAt() {
        return lastActiveAt;
    }

    public void setLastActiveAt(Date lastActiveAt) {
        this.lastActiveAt = lastActiveAt;
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
        User user = (User) o;
        return id == user.id &&
                status == user.status &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(passWordHash, user.passWordHash) &&
                Objects.equals(lastActiveAt, user.lastActiveAt) &&
                Objects.equals(createdAt, user.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, passWordHash, status, lastActiveAt, createdAt);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passWordHash='" + passWordHash + '\'' +
                ", status=" + status +
                ", lastActiveAt=" + lastActiveAt +
                ", createdAt=" + createdAt +
                '}';
    }
}
