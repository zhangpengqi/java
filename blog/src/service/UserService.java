package service;

import bean.User;
import impl.UserDAOImpl;

public class UserService {
    UserDAOImpl userDAOImpl=new UserDAOImpl();

    /**
     * 登录
     * @param username 账号
     * @param password 密码
     * @return 成功返回1，账号不存在返回-1，密码错误返回0
     */
    public int Login(String username,String password){
        //查询账号是否存在
        User user=userDAOImpl.selectByUsername(username);

        //账号存在
        if(user!=null){
            //密码正确
            if(user.getPassword().equals(password)){
                return 1;
            }
            //密码错误
            return 0;
        }
        //账号不存在
        return -1;
    }

    /**
     *  账号注册
     * @param username 账号
     * @param password 密码
     * @return 成功返回true，失败返回false
     */
    public boolean Sign(String username,String password){
        //查询账号是否存在
        User user=userDAOImpl.selectByUsername(username);
        //账号存在，返回false
        if(user!=null){
            return false;
        }
        //账号不存在，注册账号
        if(user==null){
            userDAOImpl.insertByUsernameAndPassword(username,password);
            return true;
        }
        return false;
    }

    /**
     *  修改密码
     * @param username 账号
     * @param oldPassword 老密码
     * @param password 新密码
     * @return 修改成功返回1，失败返回-1
     */
    public int updatePassword(String username,String oldPassword, String password){
        //根据账号查询
        User user=userDAOImpl.selectByUsername(username);
        //原密码正确，修改，返回1
        if(user.getPassword().equals(oldPassword)){
        userDAOImpl.update(username,password);
        return 1;
        }else {
            //原密码不正确，返回-1
            return -1;
        }
    }
}
