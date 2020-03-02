package com.penny.leetcode.zhp.algorithm.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangpeng110
 * @create 2020/2/29 0029
 * @desc
 */
public class L963MinimumAreaRectangleii {

    public double minAreaFreeRect(int[][] points) {
        Double rect = Double.MAX_VALUE;
        for(int i = 0; i <points.length;i++){
            Node node1 = new Node(points[i][0],points[i][1]);
            for(int j = i + 1 ; j<points.length;j++){
                Node node2 = new Node(points[j][0],points[j][1]);
                for(int a = j+1 ; a <points.length;a++){
                    Node node3 = new Node(points[a][0],points[a][1]);
                    for(int b = a+1;b <points.length;b++){
                        Node node4 = new Node(points[b][0],points[b][1]) ;
                        Double[] side = isAreaRect(node1,node2,node3,node4);
                        if(side != null){
                            rect =side.length == 3?Math.min(rect,Math.sqrt(side[0])*Math.sqrt(side[1])):Math.min(rect, side[0]);
                        }
                    }
                }
            }
        }
        return rect < Double.MAX_VALUE ?rect:0;
    }

    private boolean isSideXandY(Node node1, Node node2, Node node3, Node node4) {
        if(node1.x == node2.x && node3.x==node4.x){
            return true;
        }
        if(node1.x == node3.x && node2.x==node4.x){
            return true;
        }
        if(node1.x == node4.x && node2.x==node3.x){
            return true;
        }
        return false;
    }

    private Double[] isAreaRect(Node node1, Node node2, Node node3, Node node4) {
        if(node1.equals(node2) || node1.equals(node3) || node1.equals(node4) || node2.equals(node3) || node2.equals(node4) || node3.equals(node4)){
            return null;
        }
        Set<Double> sets = new HashSet<>();
        sets.add(areaRectTwo(node1,node2));
        sets.add(areaRectTwo(node1,node3));
        sets.add(areaRectTwo(node1,node4));
        sets.add(areaRectTwo(node2,node3));
        sets.add(areaRectTwo(node2,node4));
        sets.add(areaRectTwo(node3,node4));
        if(sets.size() != 3 && + sets.size() != 2){
            return null;
        }
        Double[] rect = pythagoreanOk(sets);
        return rect;
    }

    private Double[] pythagoreanOk(Set<Double> set) {
        Double[] rect = new Double[set.size()];
        rect = set.toArray(rect);
        Arrays.sort(rect);
        if(rect.length ==2){
            if(!(rect[0]*2 == rect[1])){
                return null;
            }
        }else{
            if(!((rect[0]+rect[1]) == rect[2])){
                return null;
            }
        }
        return rect;
    }

    private double areaRectTwo(Node node1, Node node2) {
        return Math.pow(node1.x-node2.x,2)+Math.pow(node1.y-node2.y,2);
    }


    class Node{
        private int x;
        private int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            return y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

    public static void main(String[] args) {
        L939MinimumAreaRectangle l939MinimumAreaRectangle =  new L939MinimumAreaRectangle();
        // [[0,1],[1,3],[3,3],[4,4],[1,4],[2,3],[1,0],[3,4]]
        int [][] rect =  {{2,4},{4,2},{1,0},{3,4},{4,4},{2,2},{1,1},{3,0},{1,4},{0,3},{0,1},{2,1},{4,0}};
        System.out.println(l939MinimumAreaRectangle.minAreaRect(rect));
    }


}