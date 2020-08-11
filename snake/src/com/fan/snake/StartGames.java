package com.fan.snake;

import javax.swing.*;

/**
 * @Author: Travelmate
 * @CreateTime: 2020/8/11 17:04
 * @Description:
 */
public class StartGames {
    public static void main(String[] args) {
        //1.绘制一个静态窗口 JFrame
        JFrame Frame = new JFrame("fan-贪吃蛇游戏");
        Frame.setBounds(10,10,900,720);//设置桌面的大小
        Frame.setResizable(false);//窗口大小不可以改变
        Frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭事件，游戏可以关闭了

        //2.面板 JPanel
        Frame.add(new GamePanel());
        Frame.setVisible(true);
    }
}
