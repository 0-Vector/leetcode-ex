package com.penny.leetcode.zhp.algorithm.machine;

import com.penny.leetcode.zhp.algorithm.utils.Logarithm;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Creator:Administrator
 * Time:2020-02-20 11:23
 * Project: leetcode-ex
 * Description:
 */
public class DecisionTree {

    public static void main(String[] args) {
        // 1.准备数据
        List<Watermelon> watermelonss = dataSet();

        List<Watermelon> watermelons = new ArrayList<>();
        for (Watermelon watermelon : watermelonss){
             if(watermelon.getStripes().equals("模糊")){
                 watermelons.add(watermelon);
             }
         }

        //决策树的构造
         //1.1 计算数据集的信息熵
        double ok = 0;
        double no = 0;
        double len = watermelons.size();
        for(Watermelon watermelon:watermelons) {
          if(watermelon.getIsGoodWatermelon().equals("是")){
              ok ++;
          }
          if(watermelon.getIsGoodWatermelon().equals("否")){
              no ++;
          }
        }
        double isGoodWatermelon = ok / len;
        double isBadWatermelon  = no / len;
        double informationEntropy = -(isGoodWatermelon*Logarithm.log2(isGoodWatermelon)+isBadWatermelon*Logarithm.log2(isBadWatermelon));
        double colorInformationEntropy = colorInformationGainEntropy(watermelons,informationEntropy);
        double rootInformationEntropy  = rootInformationGainEntropy(watermelons,informationEntropy);
        double soundInformationEntropy = soundInformationGainEntropy(watermelons,informationEntropy);
        //double stripesInformationEntropy = stripesInformationGainEntropy(watermelons,informationEntropy);
        double abdomenInformationEntropy =  abdomenInformationGainEntropy(watermelons,informationEntropy);
        double touchInformationEntropy = touchInformationGainEntropy(watermelons,informationEntropy);
        //System.out.println(colorInformationEntropy);
        System.out.println("色泽"+colorInformationEntropy);
        System.out.println("根蒂"+rootInformationEntropy);
        System.out.println("敲声"+soundInformationEntropy);
       // System.out.println("纹理"+stripesInformationEntropy);
        System.out.println("脐部"+abdomenInformationEntropy);
        System.out.println("触感"+touchInformationEntropy);




    }

    /**
     * 硬滑，软粘
     * @param watermelons
     * @param informationEntropy
     * @return
     */
    private static double touchInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
        double touch1 = conditionEntropy(watermelons,"硬滑","getTouch");
        double touch2 = conditionEntropy(watermelons,"软粘","getTouch");
        return  informationEntropy-(touch1+touch2);
    }

    /**
     * 凹陷,稍凹,平坦
     * @param watermelons
     * @param informationEntropy
     * @return
     */
    private static double abdomenInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
        double abdomen1 = conditionEntropy(watermelons,"凹陷","getAbdomen");
        double abdomen2 = conditionEntropy(watermelons,"稍凹","getAbdomen");
        double abdomen3 = conditionEntropy(watermelons,"平坦","getAbdomen");
        return  informationEntropy-(abdomen1+abdomen2+abdomen3);
    }

    /**
     * 清晰,稍糊,模糊
     * @param watermelons
     * @param informationEntropy
     * @return
     */
    private static double stripesInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
        double stripes1 = conditionEntropy(watermelons,"清晰","getStripes");
        double stripes2 = conditionEntropy(watermelons,"稍糊","getStripes");
        double stripes3 = conditionEntropy(watermelons,"模糊","getStripes");
        return  informationEntropy-(stripes1+stripes2+stripes3);

    }

    /**
     *  浊响,沉闷,清脆
     * @param watermelons
     * @param informationEntropy
     * @return
     */
    private static double soundInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
        double sound1 = conditionEntropy(watermelons,"浊响","getSound");
        double sound2 = conditionEntropy(watermelons,"沉闷","getSound");
        double sound3 = conditionEntropy(watermelons,"清脆","getSound");
        return  informationEntropy-(sound1+sound2+sound3);


    }

    /**
     * 蜷缩,稍蜷,稍蜷
     * @param watermelons
     * @param informationEntropy
     * @return
     */
    private static double rootInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
        double root1 = conditionEntropy(watermelons,"蜷缩","getRoot");
        double root2 = conditionEntropy(watermelons,"稍蜷","getRoot");
        double root3 = conditionEntropy(watermelons,"硬挺","getRoot");
        return  informationEntropy-(root1+root2+root3);
    }


    /**
     * 青绿、乌黑,浅白
     * @param watermelons
     * @param informationEntropy
     */
    private static double colorInformationGainEntropy(List<Watermelon> watermelons, double informationEntropy) {
     double color1 = conditionEntropy(watermelons,"青绿","getColor");
     double color2 = conditionEntropy(watermelons,"乌黑","getColor");
     double color3 = conditionEntropy(watermelons,"浅白","getColor");
     return  informationEntropy-(color1+color2+color3);
    }

    private static double conditionEntropy(List<Watermelon> watermelons, String value,String tag) {
        double ok = 0;
        double no = 0;
        double number = 0;
        try {
        for(Watermelon watermelon:watermelons){
            Method method = watermelon.getClass().getMethod(tag);
            String name = (String) method.invoke(watermelon);
                if (name.equals(value)) {
                    if (watermelon.getIsGoodWatermelon().equals("是")) {
                        ok++;
                    }
                    if (watermelon.getIsGoodWatermelon().equals("否")) {
                        no++;
                    }
                    number++;
                }

        }
        } catch (Exception e){
            e.printStackTrace();
        }
        double isGoodWatermelon = (ok == 0||number == 0)?0:ok / number;
        double isBadWatermelon  = (no == 0||number == 0)?0: no / number;

      /*  System.out.println(ok / number*Logarithm.log2(ok / number));
        System.out.println(isGoodWatermelon==0d?0d:(isGoodWatermelon*Logarithm.log2(isGoodWatermelon)));
        System.out.println(isBadWatermelon==0d?0d:(isBadWatermelon*Logarithm.log2(isBadWatermelon)));
*/
        double informationEntropy = -(isGoodWatermelon==0d?0d:(isGoodWatermelon*Logarithm.log2(isGoodWatermelon)))-(isBadWatermelon==0d?0d:(isBadWatermelon*Logarithm.log2(isBadWatermelon)));
        return (number/watermelons.size())*informationEntropy;
    }

    /**
     *  青绿、乌黑,浅白
     *  蜷缩,稍蜷,硬挺
     *  浊响,沉闷,清脆
     *  清晰,稍糊,模糊
     *  凹陷,稍凹,平坦
     *  硬滑，软粘
     *  是，否
     */
    private static List<Watermelon> dataSet() {
        List<Watermelon> datas = new ArrayList<>();
        Watermelon watermelon1=new Watermelon(1,  "青绿","蜷缩","浊响","清晰","凹陷","硬滑","是");
        Watermelon watermelon2=new Watermelon(2,  "乌黑","蜷缩","沉闷","清晰","凹陷","硬滑","是");
        Watermelon watermelon3=new Watermelon(3,  "乌黑","蜷缩","浊响","清晰","凹陷","硬滑","是");
        Watermelon watermelon4=new Watermelon(4,  "青绿","蜷缩","沉闷","清晰","凹陷","硬滑","是");
        Watermelon watermelon5=new Watermelon(5,  "浅白","蜷缩","浊响","清晰","凹陷","硬滑","是");
        Watermelon watermelon6=new Watermelon(6,  "青绿","稍蜷","浊响","清晰","稍凹","软粘","是");
        Watermelon watermelon7=new Watermelon(7,  "乌黑","稍蜷","浊响","稍糊","稍凹","软粘","是");
        Watermelon watermelon8=new Watermelon(8,  "乌黑","稍蜷","浊响","清晰","稍凹","硬滑","是");
        Watermelon watermelon9=new Watermelon(9,  "乌黑","稍蜷","沉闷","稍糊","稍凹","硬滑","否");
        Watermelon watermelon10=new Watermelon(10,"青绿","硬挺","清脆","清晰","平坦","软粘","否");
        Watermelon watermelon11=new Watermelon(11,"浅白","硬挺","清脆","模糊","平坦","硬滑","否");
        Watermelon watermelon12=new Watermelon(12,"浅白","蜷缩","浊响","模糊","平坦","软粘","否");
        Watermelon watermelon13=new Watermelon(13,"青绿","稍蜷","浊响","稍糊","凹陷","硬滑","否");
        Watermelon watermelon14=new Watermelon(14,"浅白","稍蜷","沉闷","稍糊","凹陷","硬滑","否");
        Watermelon watermelon15=new Watermelon(15,"乌黑","稍蜷","浊响","清晰","稍凹","软粘","否");
        Watermelon watermelon16=new Watermelon(16,"浅白","蜷缩","浊响","模糊","平坦","硬滑","否");
        Watermelon watermelon17=new Watermelon(17,"青绿","蜷缩","沉闷","稍糊","稍凹","硬滑","否");
        datas.add(watermelon1);
        datas.add(watermelon2);
        datas.add(watermelon3);
        datas.add(watermelon4);
        datas.add(watermelon5);
        datas.add(watermelon6);
        datas.add(watermelon7);
        datas.add(watermelon8);
        datas.add(watermelon9);
        datas.add(watermelon10);
        datas.add(watermelon11);
        datas.add(watermelon12);
        datas.add(watermelon13);
        datas.add(watermelon14);
        datas.add(watermelon15);
        datas.add(watermelon16);
        datas.add(watermelon17);
        return datas;
    }

    /**
     * 西瓜
      */
  public  static   class  Watermelon{
     private int id;//编号
     private String color;//色泽:青绿、乌黑和浅白
     private String root; //根蒂：蜷缩,稍蜷,硬挺
     private String sound;//敲声: 浊响,沉闷,清脆
     private String stripes;//纹理：清晰,稍糊,模糊
     private String abdomen;//脐部：凹陷,稍凹,平坦
     private String touch;//触感：硬滑，软粘
     private String isGoodWatermelon;//是否是好瓜,是，否

    public Watermelon(int id,String color, String root, String sound, String stripes, String abdomen, String touch, String isGoodWatermelon) {
        this.id = id;
        this.color = color;
        this.root = root;
        this.sound = sound;
        this.stripes = stripes;
        this.abdomen = abdomen;
        this.touch = touch;
        this.isGoodWatermelon = isGoodWatermelon;

    }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAbdomen() {
            return abdomen;
        }

        public void setAbdomen(String abdomen) {
            this.abdomen = abdomen;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getIsGoodWatermelon() {
            return isGoodWatermelon;
        }

        public void setIsGoodWatermelon(String isGoodWatermelon) {
            this.isGoodWatermelon = isGoodWatermelon;
        }

        public String getRoot() {
            return root;
        }

        public void setRoot(String root) {
            this.root = root;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public String getStripes() {
            return stripes;
        }

        public void setStripes(String stripes) {
            this.stripes = stripes;
        }

        public String getTouch() {
            return touch;
        }

        public void setTouch(String touch) {
            this.touch = touch;
        }

        @Override
    public String toString() {
        return "Watermelon{" +
                "abdomen='" + abdomen + '\'' +
                ", id=" + id +
                ", color='" + color + '\'' +
                ", root='" + root + '\'' +
                ", sound='" + sound + '\'' +
                ", stripes='" + stripes + '\'' +
                ", touch='" + touch + '\'' +
                ", isGoodWatermelon='" + isGoodWatermelon + '\'' +
                '}';
    }
}
}
