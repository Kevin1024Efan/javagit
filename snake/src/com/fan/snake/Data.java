package com.fan.snake;

import javax.swing.*;
import java.net.URL;

/**
 * @Author: Travelmate
 * @CreateTime: 2020/8/11 17:20
 * @Description:
 */
//存放外部数据
public class Data {
    //头部的照片     URL: 定位图片的地址        ImageIcon: 图片
    public static URL headerURL = Data.class.getResource("/static/header.png");
    public static ImageIcon header = new ImageIcon(headerURL);

    //头部：
    public static URL upUrl = Data.class.getResource("/static/up.png");
    public static URL downUrl = Data.class.getResource("/static/down.png");
    public static URL leftUrl = Data.class.getResource("/static/left.png");
    public static URL rightUrl = Data.class.getResource("/static/right.png");
    public static ImageIcon up = new ImageIcon(upUrl);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);

    //身体：
    public static URL bodyUrl = Data.class.getResource("/static/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);

    //食物：
    public static URL foodUrl = Data.class.getResource("/static/food.png");
    public static ImageIcon food = new ImageIcon(foodUrl);


}
