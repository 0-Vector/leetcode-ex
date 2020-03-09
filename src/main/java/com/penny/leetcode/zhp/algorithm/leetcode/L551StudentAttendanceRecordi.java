package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/2 0002
 * @desc
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
你需要根据这个学生的出勤记录判断他是否会被奖赏。
示例 1:
输入: "PPALLP"
输出: True
示例 2:
输入: "PPALLL"
输出: False
 *
 */
public class L551StudentAttendanceRecordi {

    public static boolean checkRecord(String s) {
        int aNum = 0;
        int lNum = 0;
        int i = 0;
        int temp = 0;
        while (i < s.length()){
            if(s.charAt(i) == 'A'){
                temp = 0;
                aNum++;
                if(aNum >1){
                    break;
                }
            }else if (s.charAt(i) == 'L'){
                if(temp ==0){
                    temp ++;
                }else if(temp ==1){
                    temp ++;
                }else{
                    lNum ++;
                    break;
                }
            }else temp =0;
            i = i+1;
        }
        if(aNum <=1 && lNum <= 0){
            return true;
        }
       return false;
    }

    public static void main(String[] args) {
      String s = "PPALLPLLPLL";
        System.out.println(L551StudentAttendanceRecordi.checkRecord(s));
    }

}