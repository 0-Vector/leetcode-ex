package com.penny.leetcode.zhp.algorithm.common;

/**
 * Creator:Administrator
 * Time:2019-11-05 19:56
 * Project: algorithm
 * Description:插入排序
 */
public class InsertSort {


    public static  void insertSort(int[] data){
     if(data==null || data.length<=0){
         return;
     }
     int j;
     int value;
     int length=data.length;
     for(int i=1;i<length;i++){
          value=data[i];
          j=i-1;
         for(;j>=0;j--){
             if(data[j]>value){
                 data[j+1]=data[j];
             }else {
                 break;
             }
         }
         data[j+1]=value;
     }
        for(int a:data){
            System.out.print(a+",");
        }
    }

    public static void main(String[] args) {
        int []aa={1,2,5,3,8,2,7,3,2,6,1};
        insertSort(aa);
    }


}
