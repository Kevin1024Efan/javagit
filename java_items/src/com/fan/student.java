package com.fan;



/**
 * @Author: Travelmate
 * @CreateTime: 2020/8/7 1:00
 * @Description:学生信息类
 */
public class student {

    private String name; //姓名
    private int age;//年龄
    private int python;//python成绩
    private int java;//java成绩
    private int linux;//linux成绩
    private int sql;//sql成绩
    private int total;//总分
    private double pingjun;//平均分

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getLinux() {
        return linux;
    }

    public void setLinux(int linux) {
        this.linux = linux;
    }

    public int getSql() {
        return sql;
    }

    public void setSql(int sql) {
        this.sql = sql;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPingjun() {
        return pingjun;
    }

    public void setPingjun(double pingjun) {
        this.pingjun = pingjun;
    }

    public student(String name, int age, int python, int java, int linux, int sql,int total,double pingjun){
        this.name = name;
        this.age = age;
        this.python = python;
        this.java =java;
        this.linux =linux;
        this.sql =sql;
        this.total = total;
        this.pingjun = pingjun;

    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", python=" + python +
                ", java=" + java +
                ", linux=" + linux +
                ", sql=" + sql +
                ", total=" + total +
                ", pingjun=" + pingjun +
                '}';
    }
}