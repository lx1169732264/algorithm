package lc_0400;

/**
 * 给定一个正整数n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * <p>
 * 示例2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36。
 * 说明: 你可以假设n不小于 2 且不大于 58。
 */
public class Lc_0343_integerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        //123属于3种不需要拆分的数字,而从4开始,2*2=4,乘数将大于合数
        if (n <= 2) {
            return 1;
        } else if (n == 3) {
            return 2;
        }
        //所以对于123,不采用乘,而采用合,将其存入dp,进行动态规划
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        //从4开始,计算最优乘数
        for (int i = 4; i <= n; i++) {
            //j为切分的位置,将i分为j,i-j两个部分
            for (int j = 1; j <= (i / 2); j++) {
                //dp[i]保存了n=i时,对应的最大数,而任何大于i的数都可以拆分为dp[i] * dp[i+x],dp[i]将简化了后续计算的步骤
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }
}
