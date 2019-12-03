# 动态规划（dynamic programming）
### 概况：
- 一般场景：最优化问题（optimization problem）
- 适用情况：
    - 最优子结构
    - 子问题重叠
- 实现方法：
    - 带备忘的自顶向下法（top-down with memoization）
    - 自底向上法（bottom-up method）
    
### 设计一个动态规划算法的步骤：
1. 刻画一个最优解的结构特征。
2. 递归的定义最优解的值。
3. 计算最优解的值，通常采用自底向上的方法。
4. 利用计算出的信息构造一个最优解（*an optimal solution, not the optimal solution*）

### 最优子结构（optimal substructure）
问题满足最优子结构性质：问题的最优解由相关子问题的最优解组合而成，而这些子问题可以独立求解。

