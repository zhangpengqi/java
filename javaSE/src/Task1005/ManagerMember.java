package Task1005;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerMember {
    int i;//主菜单输入的值
    boolean flag=true;//循环

    Scanner sc=new Scanner(System.in);
    List<Member> memberList=new ArrayList<Member>();

    /**
     * 首页界面
     */
    public void first(){
        while (flag){
            System.out.println("==========欢迎进入会员管理系统==========");
            System.out.println("------主菜单------");
            System.out.println("1.查看会员\n2.新增会员\n3.积分管理\n0.退出");
            System.out.println("请输入：");
            i=sc.nextInt();
            switch(i){
                case 1:
                    show(memberList);//查询会员
                    break;
                case 2:
                    add(memberList);//增加会员
                    break;
                case 3:
                    update(memberList);//更新会员积分
                    break;
                case 0:
                    flag=!flag;//退出管理系统
                    break;
                default:
                    break;
            }
        }
        System.out.println("退出系统成功！");
    }

    /**
     * 查看会员信息
     * @param mem
     */

    public void show(List<Member> mem){
        System.out.println("-----查看会员-----");
        System.out.println("姓名 "+" "+" 性别 " +" 手机 "+" 积分 ");
        for (Member m: mem){
            System.out.println(m.getName()+"  "+m.getSex()+"    " +m.getPhone()+"  "+m.getScore());
        }
    }
    /**
     *  增加会员
     * @param mem 用于储存会员信息的集合
     */
    public void add(List<Member> mem){
        Member m=new Member();
        System.out.println("-----新增会员-----");
        System.out.print("请输入姓名：");
        m.setName(sc.next());
        System.out.print("请输入性别(0女1男)：");
        m.setSex(sc.nextInt());
        System.out.print("请输入手机号：");
        m.setPhone(sc.next());
        System.out.print("请输入积分：");
        m.setScore(sc.nextInt());
        mem.add(m);
        System.out.println("添加成功！");
    }

    /**
     * 根据名称查询会员信息
     * @param mem 会员集合
     * @param s 要查询会员的姓名
     * @return 有这个会员返回个人信息，没有返回null
     */
    public Member show(List<Member> mem,String s){
        for(Member m:mem){
            if (m.getName().equals(s)){
                return m;
            }
        }
        return null;
    }
    /**
     * 查看和修改单个会员积分
     * @param mem
     */
    public void update(List<Member> mem){
        String findName;
        int isUpdate;
        System.out.println("-----查看会员积分-----");
        System.out.print("请输入要查看会员的姓名：");
        findName=sc.next();
        Member result=show(mem,findName);
        if(result!=null){
            //名称存在，显示会员积分
            System.out.println(findName+"的积分是："+result.getScore());
            while (true){
                System.out.println("修改请按1，不修改请按2");
                isUpdate=sc.nextInt();
                //修改
                if (isUpdate==1){
                    System.out.print("请输入修改后的积分：");
                    for(Member m:mem){
                        if(m.equals(result)){
                            m.setScore(sc.nextInt());
                            System.out.println(m.getName()+"修改后的积分是："+m.getScore());
                        }
                    }
                    return;
                }
                //不修改
                if(isUpdate==2){
                    return;
                }
            }
        }else {
            //名称不存在
            System.out.println("查看的会员名不存在！");
        }

    }
    public static void main(String[] args) {
       ManagerMember m=new ManagerMember();
       m.first();
    }
}
