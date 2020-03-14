package Task1024;

import java.text.DecimalFormat;
import java.util.*;

public class ManagerUser {
    Scanner sc=new Scanner(System.in);
    List<User> userList=new ArrayList<>();//学生信息集合
    List<ClassInfo> classList=new ArrayList<>();//学生班级信息
    DecimalFormat moneyFormat=new DecimalFormat(".00");
    {
        classList.add(new ClassInfo(1,"一班"));
        classList.add(new ClassInfo(2,"二班"));
        classList.add(new ClassInfo(3,"三班"));
    }

    /**
     * 首页
     */
    public void home(){
        while (true){
            System.out.println("===========学生管理系统=========");
            System.out.println("1.插入学生信息\n2.学生个人信息\n3.班级学生信息\n4.学生饭卡充值\n5.男女人数统计\n0.退出");
            System.out.print("请输入：");
            switch (sc.nextInt()){
                case 1:
                    addUser();//插入学生
                    break;
                case 2:
                    show();//学生个人信息
                    break;
                case 3:
                    showClassInfo();//班级学生信息
                    break;
                case 4:
                    updataMoney();//学生饭卡充值
                    break;
                case 5:
                    userNum();//男女人数统计
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }

    public void userNum(){
        Map<String,Integer> userMap=new HashMap<>();//男女统计集合
        int boy=0;//男生人数
        int girl=0;//女生人数
        for(User u:userList){
            if(u.getSex()==1){
                boy++;
            }
            if(u.getSex()==2){
                girl++;
            }
        }
        userMap.put("男生",boy);
        userMap.put("女生",girl);
        System.out.println("------男女统计表-------");
        System.out.println("男生："+userMap.get("男生"));
        System.out.println("女生："+userMap.get("女生"));

    }

    /**
     * 根据学号查询是否存在该学生信息
     * @param i 学号
     * @return 返回false则学号不存在，返回true则学号存在
     */
    public boolean select(int i){
        for(User u:userList){
            if(u.getId()==i){
                return true;
            }
        }
        return false;
    }

    /**
     * 更新学生饭卡金额
     */
    public void updataMoney(){
        int id;//学生id
        float m;//充值金额
        System.out.println("-------饭卡充值界面-------");
        System.out.println("请输入充值学生的学号：");
        id=sc.nextInt();
        System.out.println("请输入要充值的金额：");
        m=sc.nextFloat();

        //如果学生id存在
        if (select(id)){
            for(User u:userList){
                if(u.getId()==id){
                    System.out.println(u.getId()+"充值前的余额为"+moneyFormat.format(u.getMoney()));
                    u.setMoney(u.getMoney()+m);
                    System.out.println("充值成功！！");
                    System.out.println("---------------");
                    System.out.println(u.getId()+"充值后的余额为"+moneyFormat.format(u.getMoney()));
                }
            }
        }else {
            User u=new User();
            u.setId(id);
            u.setMoney(m);
            u.setClassId(0);
            u.setAge(0);
            u.setSex(0);
            u.setName(null);
            userList.add(u);
            System.out.println("该学号是新用户,充值后余额为:"+moneyFormat.format(u.getMoney()));
        }
    }

    /**
     * 插入学生信息
     */
    public void addUser(){

        User u=new User();
        System.out.print("请输入学生学号：");
        u.setId(sc.nextInt());
        System.out.print("请输入学生班级：");
        u.setClassId(sc.nextInt());
        System.out.print("请输入学生姓名：");
        u.setName(sc.next());
        System.out.print("请输入学生年龄：");
        u.setAge(sc.nextInt());
        System.out.print("请输入学生性别(男1女2)：");
        u.setSex(sc.nextInt());
        System.out.print("请输入学生饭卡金额：");
        u.setMoney(sc.nextFloat());
        if(!select(u.getId())){
            //学员不存在，插入集合
            userList.add(u);
            System.out.println("该学员信息插入成功！");
        }else {
            //学员学号存在，提示用户
            System.out.println("该学员学号已存在！");
        }
    }

    public String selectClassName(int i){
        for(ClassInfo c:classList){
            if(c.classId==i){
                return c.className;
            }
        }
        return null;
    }
    /**
     * 学生个人详细信息
     */
    public void show(){
        System.out.println("----------学生详细个人信息----------");
        System.out.println("学号\t\t班级\t姓名\t年龄\t性别\t饭卡金额");
        for(User u:userList){
            if(u.getName()!=null){
                System.out.println(u.getId()+" "+selectClassName(u.getClassId())+"\t"+u.getName()+"\t"+u.getAge()+"\t"+(u.getSex()==1?"男":"女")+"\t"+moneyFormat.format(u.getMoney()));
            }
        }
    }

    /**
     * 打印班级学生信息
     */
    public void showClassInfo(){
        System.out.println("----------班级学生信息----------");
        for (ClassInfo classInfo : classList) {
            System.out.println(classInfo.className);
            System.out.println("学号\t\t姓名\t年龄\t性别\t饭卡金额");
            for (User u : userList) {
                if (u.getClassId() == classInfo.classId && u.getName() != null) {
                    System.out.println(u.getId() + " " + u.getName() + "\t" + u.getAge() + "\t" + (u.getSex() == 1 ? "男" : "女") + "\t" + moneyFormat.format(u.getMoney()));
                }
            }
        }
    }
    public static void main(String[] args) {
        ManagerUser mUser=new ManagerUser();
        mUser.home();
        System.out.println("您已退出系统管理！");
        System.out.println("texthello");
    }
}
