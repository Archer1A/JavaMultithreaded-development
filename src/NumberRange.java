import java.util.concurrent.atomic.AtomicInteger;


/**
 * 线程不安全的；没有约束好lower和upper的不变约束。setLower和setUpper试图保护不变约束，单又显得力不从心。setLower和setUpper都是检查再运行的
 * 操作，但是他们没用适当的枷锁以保证其原子性。 假设值域为（0，10），一个线程调用setLower（5）,li另一个线程则会个你在调用setUpper（4），在
 * 一些偶发的情况下他们都能满足set方法中的检查。使修改全部生效。结果值域是现在的（5，4） 一个无效的状态
 */
public class NumberRange {

    //不变约束： lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        //worming: 不安全的检查再运行
        if (i > upper.get()) {
            throw new IllegalArgumentException("Can't set lower to " + i + ">upper " );
        }
        lower.set(i);
    }

    public void setUpper(int i ){
        //worming: 不安全的检查再运行
        if(i< lower.get()){
            throw new IllegalArgumentException("Can't set lower to " + i + ">upper " );

        }
        upper.set(i);
    }

    public boolean isRange(int i ){
        return (i >= lower.get() && i <= upper.get());
    }
}
