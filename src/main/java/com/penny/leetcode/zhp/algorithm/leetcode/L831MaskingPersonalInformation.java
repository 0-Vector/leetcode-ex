package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/2/27 0027
 * @desc
给你一条个人信息 string S，它可能是一个邮箱地址，也可能是一个电话号码。

我们将隐藏它的隐私信息，通过如下规则:

 

<u>1. 电子邮箱</u>

定义名称 <name> 是长度大于等于 2 （length ≥ 2），并且只包含小写字母 a-z 和大写字母 A-Z 的字符串。

电子邮箱地址由名称 <name> 开头，紧接着是符号 <font face="Menlo, Monaco, Consolas, Courier New, monospace">'@'</font>，后面接着一个名称 <name>，再接着一个点号 '.'，然后是一个名称 <name>。

电子邮箱地址确定为有效的，并且格式是 "name1@name2.name3"。

为了隐藏电子邮箱，所有的名称 <name> 必须被转换成小写的，并且第一个名称 <name> 的第一个字母和最后一个字母的中间的所有字母由 5 个 '*' 代替。

 

<u>2. 电话号码</u>

电话号码是一串包括数字 0-9，以及 {'+', '-', '(', ')', ' '} 这几个字符的字符串。你可以假设电话号码包含 10 到 13 个数字。

电话号码的最后 10 个数字组成本地号码，在这之前的数字组成国际号码。注意，国际号码是可选的。我们只暴露最后 4 个数字并隐藏所有其他数字。

本地号码是有格式的，并且如 "***-***-1111" 这样显示，这里的 1 表示暴露的数字。

为了隐藏有国际号码的电话号码，像 "+111 111 111 1111"，我们以 "+***-***-***-1111" 的格式来显示。在本地号码前面的 '+' 号和第一个 '-' 号仅当电话号码中包含国际号码时存在。例如，一个 12 位的电话号码应当以 "+**-" 开头进行显示。

注意：像 "("，")"，" " 这样的不相干的字符以及不符合上述格式的额外的减号或者加号都应当被删除。
最后，将提供的信息正确隐藏后返回。

 *
 */
public class L831MaskingPersonalInformation {


    public static String maskPII(String S) {
        if(S.contains("@")&&S.contains(".")){
            //说明是邮箱
            StringBuilder sb = new StringBuilder();
            String[] splitArray = S.toLowerCase().split("@");
             return sb.append(splitArray[0].charAt(0)).append("*****").append(splitArray[0].charAt(splitArray[0].length()-1)).append("@").append(splitArray[1]).toString();
        } else {
         String tel = S.replaceAll("[\\D]","");
            if(tel.length() == 10){
              return   structureTel10(tel);
            }else{
              return "+"+structureString(tel.length()-10)+"-"+structureTel10(tel.substring(tel.length()-10,tel.length()));
            }
        }
    }

    private static String structureTel10(String tel) {
        return "***-***-"+tel.substring(6,10);
    }

    private static String structureString(int i) {
       StringBuilder sb = new StringBuilder();
        while (i >0){
            sb.append("*");
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String tel = "86-(10)12345678";
        System.out.println(L831MaskingPersonalInformation.maskPII(tel));
    }

}