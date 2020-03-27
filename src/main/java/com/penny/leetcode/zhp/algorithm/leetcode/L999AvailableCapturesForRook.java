package com.penny.leetcode.zhp.algorithm.leetcode;

/**
 * @author zhangpeng110
 * @create 2020/3/27 0027
 * @desc
在一个 8 x 8 的棋盘上，有一个白色车（rook）。
也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。
它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，
直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，
车不能与其他友方（白色）象进入同一个方格。
返回车能够在一次移动中捕获到的卒的数量。
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/available-captures-for-rook
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L999AvailableCapturesForRook {
    public static int numRookCaptures(char[][] board) {
        if(board == null || board.length <=0 ) return 0;
        int sum = 0;
        ladel1:
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[i].length;j++){
                 if(board[i][j] == 'R'){
                   sum = calculateRook(i,j,board);
                     break  ladel1;
                 }

            }
        }
      return  sum;
    }

    private static int calculateRook(int i, int j, char[][] board) {
        int len = board.length;
        int cowLen = board[0].length;
        int sum = 0;
        int a = i-1;
        int b = j -1;
        int t = i+1;
        int y = j+1;
        while (a >=0){
          int temp = calculateElm(a,j,board);
           if(temp == 0){
               break;
           }
            if(temp == 1){
                sum++;
                break;
            }
            a--;
        }

        while (b >=0){
            int temp = calculateElm(i,b,board);
            if(temp == 0){
                break;
            }
            if(temp == 1){
                sum++;
                break;
            }
            b--;
        }
        while (t <= len-1){
            int temp = calculateElm(t,j,board);
            if(temp == 0){
                break;
            }
            if(temp == 1){
                sum++;
                break;
            }
            t++;
        }
        while (y <= cowLen-1){
            int temp = calculateElm(i,y,board);
            if(temp == 0){
                break;
            }
            if(temp == 1){
                sum++;
                break;
            }
            y++;
        }
    return sum;
    }

    private static int calculateElm(int i, int j, char[][] board) {
        if(board[i][j] == 'B'){
            return 0;
        }
        if(board[i][j] == 'p' ){
            return 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        char[][] temp = {{'.','.','.','.','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'p','p','.','R','.','p','B','.'},{'.','.','.','.','.','.','.','.'},{'.','.','.','B','.','.','.','.'},{'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'}};
        System.out.println(L999AvailableCapturesForRook.numRookCaptures(temp));


    }

}