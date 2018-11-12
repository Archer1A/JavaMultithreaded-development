package IntroductionToAlgorithms;

public class CutRod {
    private static final int[] prices = new int[]{1,5,8,9,10,17,17,20,24,30};

    //效率极差的算法，进行大量的重复计算
    public static int cutRod(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0;
        for (int i : prices) {
            a = Integer.max(a, prices[i] + cutRod(prices, n - i));
        }
        return a ;
    }
}
