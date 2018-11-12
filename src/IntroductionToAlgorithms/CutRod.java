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

    // 自顶向下的CutRod过程，加入了备忘机制
    public static int memoizedCudRod(int[] prices, int n) {
        int[] m = new int[n];
        for (int i= 1; i <= n; i ++ ) {
            m[i] = 0;
        }
        return 0;
    }

    public static int memoizedCutRodAux(int[] prices, int n, int[] m) {
        if (m[n] > 0) {
            return m[n];
        }
        int q = 0;
        {
            for (int i= 1; i <= n; i ++ ){
                q = Integer.max(q, prices[i] + memoizedCutRodAux(prices, n - i, m));
            }
        }
        m[n] = q;
        return q;
    }
}
