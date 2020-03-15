package dao;

import bean.User;

import java.util.List;

public interface UserDAO {
    /**
     * 用户注册
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    User register(String username, String password);

    /**
     * 用户登录
     *
     * @param username 账号
     * @param password 密码
     * @return
     */
    User login(String username, String password);
}
