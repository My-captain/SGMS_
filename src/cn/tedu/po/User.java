package cn.tedu.po;

/**
 * @author Mr.Robot
 * @date 2018/7/6 15:56
 */

public class User {
    int id;
    String username;
    String password;
    String realname;
    int age;
    String sex;
    String birthday;
    double salary;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {

        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

