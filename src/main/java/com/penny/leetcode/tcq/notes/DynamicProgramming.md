# 动态规划（dynamic programming）
### 概况：
- 一般场景：最优化问题（optimization problem）
- 适用情况：
    - 最优子结构
    - 子问题重叠
- 实现方法：
    - 带备忘的自顶向下法（top-down with memoization）
    - 自底向上法（bottom-up method）

### 最优子结构（optimal substructure）
问题满足**最优子结构**性质：问题的最优解由相关子问题的最优解组合而成，而这些子问题可以独立求解。
### 重叠子问题（overlapping subproblems）
如果递归算法反复求解相同的子问题，我们就称最优化问题具有**重叠子问题**。
    
### 设计一个动态规划算法的步骤：
1. 刻画一个最优解的结构特征。
2. 递归的定义最优解的值。
3. 计算最优解的值，通常采用自底向上的方法。
4. 利用计算出的信息构造一个最优解（*an optimal solution, not the optimal solution*）
