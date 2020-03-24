package dao;

import bean.User;

public interface UserDAO {
    /**
     * 插入数据库
     * @param username 账号
     * @param password 密码
     * @return
     */
    int insertByUsernameAndPassword(String username,String password);

    /**
     * 查询数据库
     * @param username 账号
     * @param password 密码
     * @return
     */

    /**
     * 查询数据库
     * @param username 账号
     * @return
     */
    User selectByUsername(String username);

    /**
     * 更新数据库
     * @param username 账号
     * @param password 密码
     */
    int update(String username,String password);
}
