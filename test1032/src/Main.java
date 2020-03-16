import bean.Message;
import bean.User;
import impl.MessageDAOImpl;
import impl.UserDAOImpl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        UserDAOImpl userDaoImp=new UserDAOImpl();
        MessageDAOImpl messageDAOImpl=new MessageDAOImpl();
        while (true){

            System.out.println("========================");
            System.out.println("\t欢迎进入内部交流系统   v0.1");
            System.out.println("========================");
            System.out.println("请选择[1]登录\t[2]注册\t[3]插入聊天信息\t[4]查询聊天信息\t[0]退出；");
            System.out.println("当前时间是："+new Timestamp(new Date().getTime()));
            System.out.println("当前时间是："+new Timestamp(new Date().getTime()-1000000));
            Scanner sc = new Scanner(System.in);

            switch (sc.nextInt()){
                case 1://登录
                    User user=userDaoImp.login("张飞","123456");
                    if(user!=null){
                        System.out.println(user.toString());
                    }else{
                        System.out.println(user);
                    }
                    break;
                case 2://注册
                    int a=userDaoImp.register("赵云","123456");
                    System.out.println(a);
                    System.out.println("程序能执行");
                    break;
                case 0://退出
                    return;
                case 3:
                    messageDAOImpl.createMessage(new Message(1002,1002,"你好",(new Timestamp(new Date().getTime()))));
                    System.out.println("插入数据成功");
                    break;
                case 4:
                    List<Message> messageList=messageDAOImpl.findMessages(new Timestamp(new Date().getTime()-1000000),new Timestamp(new Date().getTime()),1001);
                    for(Message m:messageList){
                        System.out.println(m.toString());
                    }
                    break;
                default:
                    break;
            }
        }

    }
//    public static void main(String[] args) {
//        UserDAOImpl userDaoImp=new UserDAOImpl();
//        System.out.println("========================");
//        System.out.println("\t欢迎进入内部交流系统   v0.1");
//        System.out.println("========================");
//        System.out.println("请选择[1]登录\t[2]注册\t[0]退出；");
//        Scanner sc = new Scanner(System.in);
//
//        switch (sc.nextInt()){
//            case 1://登录
//                User user=userDaoImp.login("张飞","123456");
//                if(user!=null){
//                    System.out.println(user.toString());
//                }else{
//                    System.out.println(user);
//                }
//                break;
//            case 2://注册
//                int a=userDaoImp.register("赵云","123456");
//                System.out.println(a);
//                System.out.println("程序能执行");
//                break;
//            case 0://退出
//                return;
//            default:
//                break;
//        }
//    }
}
