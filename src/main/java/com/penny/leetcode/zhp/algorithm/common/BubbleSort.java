package com.penny.leetcode.zhp.algorithm.common;

/**
 * Creator:Administrator
 * Time:2019-11-05 19:56
 * Project: algorithm
 * Description: 冒泡排序
 */
public class BubbleSort {

    public  static  void bubbleSort(int [] data){
        int temp;
        boolean over=true;
        for(int i=0;i<data.length;i++){
             for(int j=0;j<data.length-1-i;j++){
                 if(data[j]>data[j+1]){
                    temp=data[j];
                    data[j]=data[j+1];
                     data[j+1]=temp;
                     over=false;
                 }
             }
            if(over){
               break;
            }
           }
        for(int a:data){
            System.out.print(a+",");
        }

        }
    public static void main(String[] args) {
        int []aa={1,2,5,3,8,2,7,3,2,6,1};
        bubbleSort(aa);
    }
    }
