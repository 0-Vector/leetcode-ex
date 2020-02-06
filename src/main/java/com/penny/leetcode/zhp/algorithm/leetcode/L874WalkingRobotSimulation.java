package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangpeng110
 * @create 2020/2/4 0004
 * @desc 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * <p>
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * <p>
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 如果机器人试图走到障碍物上方，那么它将停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人的最大欧式距离的平方
 */
public class L874WalkingRobotSimulation {
    /**
     * 优化障碍判断
     * @param commands
     * @param obstacles
     * @return
     */
    public static int robotSim(int[] commands, int[][] obstacles) {
        String now = "N";
        Set<String> obstacleSet=new HashSet<>();
        for(int i=0;i<obstacles.length;i++){
            obstacleSet.add(obstacles[i][0]+"&&"+obstacles[i][1]);
        }
        Integer max=Integer.MIN_VALUE;
        Integer x = 0, y = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1 || commands[i] == -2) {
                now = selectDirection(commands[i], now);
            } else {
               int[][] coordinate = moveRobot(x, y, now, obstacleSet,commands[i]);
                x = coordinate[0][0];
                y = coordinate[0][1];
                max = Math.max(max,x*x+y*y);
            }
        }
        return max;
    }

    private static int[][] moveRobot(int x, int y, String now, Set<String> obstacles,int l) {
        Integer tempx =  x;
        Integer tempy = y;
        for(int i=0;i<l;i++){
            if (now.equals("N")) {
               tempy += 1;
            } else if (now.equals("S")) {
                tempy -= 1;
            } else if (now.equals("W")) {
                tempx -= 1;
            } else if (now.equals("E")) {
                tempx += 1;
            }
            //判断是否在障碍物中
            if (isObstacle(tempx,tempy,obstacles)){
                break;
             }else{
                x = tempx;
                y =tempy;
            }
        }
        return new int[][] {{x,y}};

    }

    private static boolean isObstacle(Integer tempx, Integer tempy, Set<String> obstacles) {
        String temp = tempx+"&&"+tempy;
        if(obstacles.contains(temp)){
            return true;
        }
        return  false;
    }

    private static String selectDirection(int command, String now) {
        switch (command) {
            case -1:
                if (now.equals("N")) {
                    now = "E";
                } else if (now.equals("S")) {
                    now = "W";
                } else if (now.equals("W")) {
                    now = "N";
                } else if (now.equals("E")) {
                    now = "S";
                }
                break;
            case -2:
                if (now.equals("N")) {
                    now = "W";
                } else if (now.equals("S")) {
                    now = "E";
                } else if (now.equals("W")) {
                    now = "S";
                } else if (now.equals("E")) {
                    now = "N";
                }
                break;
        }
        return now;
    }

    public static void main(String[] args) {
        //[1,2,-2,5,-1,-2,-1,8,3,-1,9,4,-2,3,2,4,3,9,2,-1,-1,-2,1,3,-2,4,1,4,-1,1,9,-1,-2,5,-1,5,5]

        int[] commands = {4,-1,4,-2,4};
        int[][] obstacles = {{2,4}};
        System.out.println(L874WalkingRobotSimulation.robotSim(commands,obstacles));
    }

}