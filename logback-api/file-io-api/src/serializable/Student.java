package serializable;

import java.io.Serializable;

public class Student implements Serializable {
    //申明序列化的版本号
    //序列化的版本好与反序列化的版本好必须一致才不会出错
    private static final long serialVersionUID = 1;
    private String name;
    private String loginName;
    private int age;
    //transient 修饰的成员变量不参与序列化了
    private transient String passWord;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", age=" + age +
                ", passWord='" + passWord + '\'' +
                '}';
    }

    public Student(){

    }

    public Student(String name, String loginName, int age, String passWord) {
        this.name = name;
        this.loginName = loginName;
        this.age = age;
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
