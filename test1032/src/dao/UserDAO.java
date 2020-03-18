package dao;
import bean.User;

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
    int login(String username, String password);

    /**
     * 查询用户账号
     * @param id 用户id
     * @return 返回用户账号
     */
    String selectUsername(int id);

    /**
     * 根据账号查询是否存在
     * @param username 账号
     * @return 存在返回用户id，不存在返回-1
     */
    int selectUserId(String username);
    /**
     * 更新最后一次活动时间
     * @param username 用户账号
     */
    void updateLastActiveAt(String username);

    /**
     * 查询在线人数
     * @return 在线人数
     */
    int selectOnlineUsers();
}
