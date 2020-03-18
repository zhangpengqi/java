import bean.Message;
import impl.MessageDAOImpl;
import impl.UserDAOImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Chat {
    int isLock=1;
    Scanner sc=new Scanner(System.in);
    UserDAOImpl userDAOtImpl=new UserDAOImpl();
    MessageDAOImpl messageDAOImpl=new MessageDAOImpl();

    /**
     * 聊天室主页
     */
    public void home(){
        while (true){
            System.out.println("==============================");
            System.out.println("\t欢迎进入内部交流系统 v0.1");
            System.out.println("==============================");
            System.out.println("请选择  [1]登录\t[2]注册\t[0]退出");
            int a=Integer.parseInt(sc.next());
            switch (a){
                case 1://登录
                    login();
                    break;
                case 2://注册
                    sign();
                    break;
                case 0://退出
                    System.out.println("您已退出聊天室！");
                    return;
                default:
                    break;
            }
        }
    }

    /**
     * 登录界面
     */
    public void login(){
            System.out.println("==============================");
            System.out.println("\t\t\t登录");
            System.out.println("==============================");
            System.out.print("请输入账号：");
            String username=sc.next();
            System.out.print("请输入密码：");
            String password=sc.next();
            int id=userDAOtImpl.login(username,password);
            //得到用户id，账号密码正确，登录成功
            if(id!=-1){
                //更新用户最后活动时间
                userDAOtImpl.updateLastActiveAt(username);
                //插入系统信息
                messageDAOImpl.createMessage(
                        new Message(
                                0,
                                0,
                                username+"进入了聊天室，当前在线人数"+userDAOtImpl.selectOnlineUsers(),
                                new Timestamp(new Date().getTime())
                        ));
                System.out.println("登录成功！");
                homeChat(id);
            }
            //返回-1，账号密码错误，登录失败
            if(id==-1){
                System.out.println("账号或密码不匹配");
            }
    }

    /**
     * 注册
     */
    public void sign(){
        String username=null;
        String password=null;
        while (true){
            System.out.println("==============================");
            System.out.println("\t\t\t注册");
            System.out.println("==============================");
            System.out.print("请输入账号：");
            username=sc.next();
            //账号正则表达
            if(!username.matches("[\\u4e00-\\u9fa5a-zA-Z0-9]{2,10}")){
                System.out.println("账号要求长度2~10位，只能是字母、数字或中文");
                continue;
            }
            System.out.print("请输入密码：");
            password=sc.next();
            //密码正则表达
            if(!password.matches("[a-zA-Z0-9]{4,10}")){
                System.out.println("密码要求长度4~10位，只能是字母、数字");
                continue;
            }
            break;
        }
        //查询账号是否存在
        int isSign=userDAOtImpl.selectUserId(username);
        //账号不存在，调用注册方法注册
        if(isSign==-1){
            userDAOtImpl.register(username,password);
            System.out.println("注册成功，请登录后聊天！");
        }
        //账号存在
        if(isSign!=-1){
            System.out.println("账号已存在，请重新注册！");
        }
    }

    /**
     * 聊天界面
     * @param userId 登录账户的id
     */
    public void homeChat(int userId){
        System.out.println("==============================");
        System.out.println("\t\t聊天室");
        System.out.println("\t\t\t当前在线:"+userDAOtImpl.selectOnlineUsers());
        System.out.println("[1]发言\t[0]退出");
        System.out.println("==============================");
        //多线程查询聊天信息并打印
        new Thread(()->{
            Timestamp beginTime=new Timestamp(new Date().getTime());
            while (true){
                //isLock==1时,查询信息。
                if (isLock==1){
                    Timestamp endTime=new Timestamp(new Date().getTime());
                    //查询数据库中信息，遍历打印
                    List<Message> messageList=messageDAOImpl.findMessages(beginTime,endTime,userId);
                    for(Message message:messageList){
                        //如果是系统信息
                        if(message.getFromUserId()==0){
                            System.out.println( "[系统]:"+message.getContent());
                        }else {
                            //如果不是系统信息
                            System.out.println( userDAOtImpl.selectUsername(message.getFromUserId())+":"+message.getContent());
                        }
                    }
                    //这次的结束时间是下次的开始时间
                    beginTime=endTime;
                    //每3秒刷新一次
                }
                try {
                    //3秒查询一次
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //主线程用于用户发信息
        while(true){
            String op=sc.next();
            if(op.equals("1")){
                //暂停查询数据库
                isLock=2;
                //获取键盘输入信息，插入数据库Message
                messageDAOImpl.createMessage(getContent(userId));
                //开启查询数据库
                isLock=1;
            }
            if(op.equals("0")){
                isLock=2;
                System.out.println("退出聊天");
                return;
            }
        }
    }

    /**
     * 获取用户输入信息
     * @param userId 用户id
     * @return 获取信息，打包
     */
    public Message getContent(int userId){
        //死循环获取输入，获取成功return,失败就重新获取。
        while (true){
            System.out.println("请输入:");
            sc.useDelimiter("\n");//加这行代码 sc.next()就可以接受空格了
            String input=sc.next();
            //私聊
            if(input.startsWith("@")){
                //私信人账号
                String toUsername=input.substring(1,input.indexOf(" "));
                //查询账号是否存在，不存在返回-1，存在返回id
                int toUserId=userDAOtImpl.selectUserId(toUsername);
                //私信账号存在
                if(toUserId!=-1){
                    //私信内容
                    String content=input.substring(input.indexOf(" ")+1);
                    return new Message(userId,toUserId,content,new Timestamp(new Date().getTime()));
                //私信账号不存在
                }else {
                    System.out.println("私信人账号不存在，请重新输入内容");
                }
            }else {
                //群聊
                return new Message(userId,0,input,new Timestamp(new Date().getTime()));
            }
        }
    }

    public static void main(String[] args) {
        Chat chat= new Chat();
        //聊天室页面
        chat.home();
    }
}
