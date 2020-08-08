package com.fan;


import java.util.*;


/**
 * @Author: Travelmate
 * @CreateTime: 2020/8/7 16:08
 * @Description:成绩功能类
 */
public class main {
    static int X;//学生人数
    int n = 0;//现有人数
    int pd = 0;
    Map<Integer, student> map = new HashMap<Integer, student>();//保存数据
    Scanner sc = new Scanner(System.in);
    String Name = null; //姓名
    int Age = 0;//年龄
    int Python = 0;//python成绩
    int Java = 0;//java成绩
    int Linux = 0;//linux成绩
    int Sql = 0;//sql成绩
    int Total = 0;//总分
    double Pingjun = 0.0;//平均分

    /**
     * 管理系统菜单
     *
     * @return管理员键盘输入的功能操作序号
     */
    public int mainprint() {
        System.out.println("----请选择你要执行的功能----");
        System.out.println("10:添加一个学生\n" +
                "11:查找一个学生\n" +
                "12:根据学生编号更新学生信息\n" +
                "13:根据学生编号删除学生\n" +
                "14:根据学生编号输入学生各门成绩\n" +
                "15:根据某门成绩进行排序\n" +
                "16:根据总分进行排序\n" +
                "99:退出系统");
        System.out.println("----------------------------");
        int x = new Scanner(System.in).nextInt();
        return x;
    }

    /**
     * 添加学生
     */
    public void addstu() {
        if (map.size() >= X) {
            System.out.println("学生已饱和");
            return;
        }
        System.out.println("请输入学生姓名：");
        Name = sc.next();
        System.out.println("请输入学生年龄：");
        Age = sc.nextInt();
        student stu = new student(Name, Age, Python, Java, Linux, Sql, Total, Pingjun);

        map.put(n, stu);
        ++n;//学生编号 ---map键值增加
        System.out.println("添加学生成功");
        showInfo();
    }

    /**
     * 查找学生
     */
    public void selectstu() {
        System.out.println("请输入你要查找的学生的编号");
        int num1 = sc.nextInt();

        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<Integer, student>> entrySet = map.entrySet();
        //遍历Set集合
        Iterator<Map.Entry<Integer, student>> it = entrySet.iterator();
        while (it.hasNext()) {
        //得到每一对对应关系
            Map.Entry<Integer, student> entry = it.next();
        //通过每一对对应关系获取对应的key
            int key = entry.getKey();
        //通过每一对对应关系获取对应的value
            student stu = entry.getValue();
            if (num1 == key) {
                pd = 1;
                System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
                System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
            }
        }
        if (pd != 1) {
            System.out.println("该学生编号不存在！");
        }
    }

    /**
     * 根据学生编号更新学生基本信息
     */
    public void updateForId() {
        System.out.println("请输入你要更新的学生的编号");
        int num1 = sc.nextInt();

        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<Integer, student>> entrySet = map.entrySet();
        //遍历Set集合
        Iterator<Map.Entry<Integer, student>> it = entrySet.iterator();
        while (it.hasNext()) {
        //得到每一对对应关系
            Map.Entry<Integer, student> entry = it.next();
        //通过每一对对应关系获取对应的key
            int key = entry.getKey();
        //通过每一对对应关系获取对应的value
            student stu = entry.getValue();
            if (num1 == key) {
                pd = 2;
                System.out.println("请输入学生姓名");
                Name = sc.next();
                System.out.println("请输入学生年龄");
                Age = sc.nextInt();
                stu.setName(Name);
                stu.setAge(Age);
                System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
                System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
            }
        }
        if (pd != 2) {
            System.out.println("要更新的学生编号不存在");
        }
    }

    /**
     * 根据学生编号删除学生
     */
    public void deleteForId() {
        System.out.println("请输入你要删除的学生编号");
        int num1 = sc.nextInt();
        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<Integer, student>> entrySet = map.entrySet();
        //遍历Set集合
        Iterator<Map.Entry<Integer, student>> it = entrySet.iterator();
        while (it.hasNext()) {
        //得到每一对对应关系
            Map.Entry<Integer, student> entry = it.next();
        //通过每一对对应关系获取对应的key
            int key = entry.getKey();
        //通过每一对对应关系获取对应的value
            if (num1 == key) {
                pd = 3;
                map.remove(num1);
                showInfo();
            }
        }
        if (pd != 3) {
            System.out.println("要删除的学生编号不存在");
        }
    }

    /**
     * 根据学生编号输入学生各门成绩
     */
    public void inputForIdscore() {
        System.out.println("请输入学生编号");
        int num1 = sc.nextInt();
        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<Integer, student>> entrySet = map.entrySet();
        //遍历Set集合
        Iterator<Map.Entry<Integer, student>> it = entrySet.iterator();
        while (it.hasNext()) {
        //得到每一对对应关系
            Map.Entry<Integer, student> entry = it.next();
        //通过每一对对应关系获取对应的key
            int key = entry.getKey();
        //通过每一对对应关系获取对应的value
            student stu = entry.getValue();
            if (num1 == key) {
                pd = 4;
                System.out.println("请输入学生python成绩");
                Python = sc.nextInt();
                System.out.println("请输入学生java成绩");
                Java = sc.nextInt();
                System.out.println("请输入学生linux成绩");
                Linux = sc.nextInt();
                System.out.println("请输入学生sql成绩");
                Sql = sc.nextInt();
                stu.setPython(Python);
                stu.setJava(Java);
                stu.setLinux(Linux);
                stu.setSql(Sql);
                stu.setTotal(Python + Java + Linux + Sql);
                stu.setPingjun((Python + Java + Linux + Sql) / 4);
                System.out.println("录入成绩成功");
                System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
                System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
            }
        }
        if (pd != 4) {
            System.out.println("该学生编号不存在");
        }
        Python = 0;//python成绩
        Java = 0;//java成绩
        Linux = 0;//linux成绩
        Sql = 0;//sql成绩
    }

    /**
     * 根据某门成绩进行排序
     */
    public void paixuForScore() {
        System.out.println("请选择你要排序的课程（1：python 2:java 3:linux 4:sql）");
        int xuaz = sc.nextInt();

        switch (xuaz) {
            case 1://python
                paixuPython();
                break;
            case 2://java
                paixuJava();
                break;
            case 3://linux
                paixuLinux();
                break;
            case 4://sql
                paixuSql();
                break;
            default:
                System.out.println("---------------------");
                System.out.println("功能选择有误，请输入正确的功能序号");
                break;
        }


    }

    /**
     * python
     */
    public void paixuPython() {
        List<Map.Entry<Integer, student>> list = new ArrayList<Map.Entry<Integer, student>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, student>>() {
            //对python排序
            public int compare(Map.Entry<Integer, student> o1,
                               Map.Entry<Integer, student> o2) {
                return o2.getValue().getPython() - o1.getValue().getPython();
            }

        });
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        for (Map.Entry<Integer, student> mapping : list) {
            int key = mapping.getKey();
        //通过每一对对应关系获取对应的value
            student stu = mapping.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }

    }

    /**
     * Java
     */
    public void paixuJava() {
        List<Map.Entry<Integer, student>> list = new ArrayList<Map.Entry<Integer, student>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, student>>() {
            //对python排序
            public int compare(Map.Entry<Integer, student> o1,
                               Map.Entry<Integer, student> o2) {
                return o2.getValue().getJava() - o1.getValue().getJava();
            }

        });
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        for (Map.Entry<Integer, student> mapping : list) {
            int key = mapping.getKey();
        //通过每一对对应关系获取对应的value
            student stu = mapping.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }
    }


    /**
     * Linux
     */
    public void paixuLinux() {
        List<Map.Entry<Integer, student>> list = new ArrayList<Map.Entry<Integer, student>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, student>>() {
            //对python排序
            public int compare(Map.Entry<Integer, student> o1,
                               Map.Entry<Integer, student> o2) {
                return o2.getValue().getLinux() - o1.getValue().getLinux();
            }

        });
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        for (Map.Entry<Integer, student> mapping : list) {
            int key = mapping.getKey();
        //通过每一对对应关系获取对应的value
            student stu = mapping.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }
    }

    /**
     * Sql
     */
    public void paixuSql() {
        List<Map.Entry<Integer, student>> list = new ArrayList<Map.Entry<Integer, student>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, student>>() {
            //对python排序
            public int compare(Map.Entry<Integer, student> o1,
                               Map.Entry<Integer, student> o2) {
                return o2.getValue().getSql() - o1.getValue().getSql();
            }

        });
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        for (Map.Entry<Integer, student> mapping : list) {
            int key = mapping.getKey();
//通过每一对对应关系获取对应的value
            student stu = mapping.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }
    }

    /**
     * 根据总分进行排序
     */
    public void paixuForAllscore() {
        List<Map.Entry<Integer, student>> list = new ArrayList<Map.Entry<Integer, student>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, student>>() {
            //对python排序
            public int compare(Map.Entry<Integer, student> o1,
                               Map.Entry<Integer, student> o2) {
                return o2.getValue().getTotal() - o1.getValue().getTotal();
            }

        });
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        for (Map.Entry<Integer, student> mapping : list) {
            int key = mapping.getKey();
//通过每一对对应关系获取对应的value
            student stu = mapping.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }
    }

    /**
     * 显示信息
     */
    public void showInfo() {
        System.out.println("\t编号\t姓名\t\t年龄\t\tpython\tjava\tlinux\tsql\t\t总分\t\t平均分");
        //获取Map中的所有key与value的对应关系
        Set<Map.Entry<Integer, student>> entrySet = map.entrySet();
//遍历Set集合
        Iterator<Map.Entry<Integer, student>> it = entrySet.iterator();
        while (it.hasNext()) {
//得到每一对对应关系
            Map.Entry<Integer, student> entry = it.next();
//通过每一对对应关系获取对应的key
            int key = entry.getKey();
//通过每一对对应关系获取对应的value
            student stu = entry.getValue();
            System.out.println("\t" + key + "\t" + stu.getName() + "\t\t" + stu.getAge() + "\t\t" + stu.getPython() + "\t\t" + stu.getJava() + "\t\t" + stu.getLinux() + "\t\t" + stu.getSql() + "\t\t" + stu.getTotal() + "\t\t" + stu.getPingjun());
        }

    }

    /**
     * 退出系统
     */
    public void exit() {
        System.out.println("------------退出--------------");
        System.out.println("你已退出系统");
    }

    public void menu() {
        System.out.println("请定义学生人数：");
        X = sc.nextInt();
        while (true) {
            int choose = mainprint();
            switch (choose) {
                case 10://添加一个学生
                    this.addstu();
                    break;
                case 11://查找一个学生
                    selectstu();
                    break;
                case 12://根据学生编号更新学生基本信息
                    updateForId();
                    break;
                case 13://根据学生编号删除学生
                    deleteForId();
                    break;
                case 14://根据学生编号输入学生各门成绩
                    inputForIdscore();
                    break;
                case 15://根据某门成绩进行排序
                    paixuForScore();
                    break;
                case 16://根据总分进行排序
                    paixuForAllscore();
                    break;
                case 99://退出系统
                    exit();
                    return;
                default:
                    System.out.println("---------------------");
                    System.out.println("功能选择有误，请输入正确的功能序号");
                    break;
            }
        }
    }

}

