package Task1005;

public class Member {
    private String name;//会员姓名
    private  int sex;//会员性别
    private String phone;//会员手机号
    private int score;//会员积分

    public Member() {
    }

    public Member(String name, int sex, String phone, int score) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public String getPhone() {
        return phone;
    }

    public int getScore() {
        return score;
    }
    public void printScore(){
        System.out.println("积分是："+getScore());

    }
}
