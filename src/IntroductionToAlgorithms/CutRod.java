package IntroductionToAlgorithms;

import java.util.Calendar;
import java.util.Date;

public class CutRod {
    private static final int[] prices = new int[]{0,1,5,8,9,10,17,17,20,24,30};

    //效率极差的算法，进行大量的重复计算
    public static int cutRod(int[] prices, int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0;
        for (int i= 1; i <= n; i ++ ) {
            a = Integer.max(a, prices[i] + cutRod(prices, n - i));
        }
        return a ;
    }

    // 自顶向下的CutRod过程，加入了备忘机制
    public static int memoizedCudRod(int[] prices, int n) {
        int[] m = new int[n+1];
        for (int i= 0; i < n+1; i ++ ) {
            m[i] = 0;
        }
        return memoizedCutRodAux(prices,n,m);
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

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(cutRod(prices,10));
        System.out.println(System.currentTimeMillis());
        System.out.println(memoizedCudRod(prices, 10));
        System.out.println(System.currentTimeMillis());
    }
}
