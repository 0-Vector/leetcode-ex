package com.penny.leetcode;

import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 0-Vector
 * @date 2019/10/22 16:51
 */
class Problem118SolutionTest {

    @Test
    void generate() {

        Instant t1 = Instant.now();
        int numRows = 5;
        Problem118Solution solution = new Problem118Solution();
        List<List<Integer>> lists = solution.generate(numRows);
        Instant t2 = Instant.now();
        System.out.println(t2.getNano() - t1.getNano());
//        System.out.println(lists);

    }
}