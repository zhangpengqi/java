package dao;

import bean.User;

import java.sql.Timestamp;

public interface UserDAO {
    /**
     * 用户注册
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    int register(String username, String password);

    /**
     * 用户登录
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    User login(String username, String password);

    /**
     * 更新最后一次活动时间
     * @param username 用户账号
     */
    void updateLastActiveAt(String username);
}
