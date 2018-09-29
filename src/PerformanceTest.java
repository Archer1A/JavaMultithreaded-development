import java.util.ArrayList;
import java.util.Vector;

public class PerformanceTest implements Runnable{

   static ArrayList<Integer> list = new ArrayList<>();



    public static void main(String[] args) {
        PerformanceTest performanceTest = new PerformanceTest();
        long start = System.currentTimeMillis();
        for(int i =0; i<10 ;i++){
            Thread t = new Thread(performanceTest);
            t.start();
        }
        Long end ;
        do {
            end  = System.currentTimeMillis();
        }while (list.size()< 10000);
        System.out.println("ArrayList进行10000000次插入操作耗时："+(end-start)+"ms");

    }

    @Override
    public  void run() {

        while (list.size() < 10000){
            synchronized (list){
                list.add(1) ;
            }

        }

    }
}