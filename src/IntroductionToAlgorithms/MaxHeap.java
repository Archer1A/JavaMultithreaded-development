package IntroductionToAlgorithms;

import java.util.Arrays;

/**
 * 最大堆
 * @author vic
 * @since 2018-10-13
 */
public class MaxHeap {
    static int[] arr = new int[]{16,4,10,14,7,9,3,2,15,10};
    public static int parent(int i){
        return  i/2;
    }

    public static int left(int i){
        return 2*i;
    }
    public static int right(int i){
        return  2*i+1;
    }

    /**
     * 输入一个数组和下标i 返回以i为根节点的子树遵从最大堆的性质
     * @param arr 数组
     * @param i 下标
     * @return 构建后的数组
     */
    public  static void maxHeapify(int[] arr, int i){
        int latest = Integer.MIN_VALUE;
        int l = left(i)-1;
        int r = right(i)-1;
        i--;
        //若左叶节点不超过数组长度且坐叶节点大于根节点
        if(l <= arr.length-1 && arr[l]>arr[i]){
            latest = l;
        }else {
            latest = i;
        }
        if (r<= arr.length-1 && arr[r]> arr[latest]){
            latest = r;
        }
        if(latest != i){
            int tem ;
            tem = arr[i];
            arr[i] = arr[latest];
            arr[latest] = tem;
          //  System.out.println(arr);
            maxHeapify(arr,latest+1);
        }
       // return  null;
    }

    // 从下往上构建最大堆
    public  static  void buildMaxHeap(){
        for (int i = (arr.length/2);i >= 1 ;i--){
            maxHeapify(arr,i);
        }
    }

    public static void main(String[] args) {
        buildMaxHeap();
        Arrays.stream(arr).forEach(x->{
            System.out.print(x+" ,");
        });
      //  maxHeapify(arr,2);
    }

}