package com.penny.leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author 0-Vector
 * @date 2019/10/23 9:50
 */
class L119PascalsTriangleIITest {

    @Test
    void getRow() {
        int rowIndex = 34;
        L119PascalsTriangleII pascalsTriangleII = new L119PascalsTriangleII();
        System.out.println(pascalsTriangleII.getRow(rowIndex));
    }
}