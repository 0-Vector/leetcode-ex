package com.penny.leetcode.zhp.algorithm.common;

/**
 * Creator:Administrator
 * Time:2019-11-05 19:55
 * Project: algorithm
 * Description:选择排序
 */
public class SelectSort {




    public static void selectSort(int [] data){
        if(data==null|| data.length<=0) return;
        int  min;
        int temp;
        for(int i=0;i<data.length;i++){
            min=i;
            for(int j=i+1;j<data.length;j++){
                 if(data[j]<data[min]){
                     min=j;
                 }
            }
            temp=data[i];
            data[i]=data[min];
            data[min]=temp;
        }
        for(int a:data){
            System.out.print(a+",");
        }

    }

    public static void main(String[] args) {
        int []aa={1,2,5,3,8,2,7,3,2,6,1};
        selectSort(aa);
    }
}
