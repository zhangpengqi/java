package Task1024;

import java.util.Objects;

/**
 * 学生类信息
 */
public class User {
    int id;//学生学号
    int ClassId;//班级ID
    String name;//学生姓名
    int age;//学生年龄
    int sex;//学生性别
    double money;//凡客金额

    /**
     * 无参构造
     */
    public User() {
    }

    /**
     *
     * @param id 学号
     * @param classId 班级Id
     * @param name 姓名
     * @param age 年龄
     * @param sex 性别
     * @param money 饭卡金额
     */
    public User(int id, int classId, String name, int age, int sex, double money) {
        this.id = id;
        ClassId = classId;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.money = money;
    }

    /**
     *
     * @param id 学号
     * @param money 饭卡金额
     */
    public User(int id, double money) {
        this.id = id;
        this.money = money;
    }

    /**
     * 没有班级的学生信息
     * @param id 学号
     * @param name 姓名
     * @param age 年龄
     * @param sex 性别
     * @param money 金额
     */
    public User(int id, String name, int age, int sex, double money) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.money = money;
    }

    //get
    public int getId() {
        return id;
    }

    public int getClassId() {
        return ClassId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public double getMoney() {
        return money;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }

    public void setClassId(int classId) {
        ClassId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                ClassId == user.ClassId &&
                age == user.age &&
                sex == user.sex &&
                Double.compare(user.money, money) == 0 &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ClassId, name, age, sex, money);
    }

}
