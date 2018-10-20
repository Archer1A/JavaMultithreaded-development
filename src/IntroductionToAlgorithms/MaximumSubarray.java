package IntroductionToAlgorithms;

import java.util.Arrays;

public class MaximumSubarray {
    int[] arr = new int[]{1,2,-1,-8,3,4};
    //若最大值跨越mid
    public int findMaxCrossingSubarray(int low,int mid, int high){
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        //包含mid的左边最大值
        for(int i = mid;i>=low;i--){
            sum += arr[i];
            if(sum> leftSum){
                leftSum =sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        //包含mid+1右边的最大值
        for(int i = mid + 1 ; i<=high;i++){
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return  rightSum + leftSum;
    }

    public int findMaximumSubarray(int low,int high){

        if(low  == high) return arr[low];
        else {
            int mid = (low+high)/2;
            int leftMax = findMaximumSubarray(low,mid);
            int rightMax = findMaximumSubarray(mid+1,high);
            int midMax = findMaxCrossingSubarray(low,mid,high);
            if(leftMax>=rightMax&& rightMax>=midMax){
                return  leftMax;

            }else if (rightMax>= leftMax &&leftMax>=midMax){
                return rightMax;

            }else {
                return midMax;
            }

        }
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
     int max =    maximumSubarray.findMaximumSubarray(0,maximumSubarray.arr.length-1);
        System.out.println(max);
    }
//public static double MIN_VALUE = -10000000;
//    private static double[] work;
//
//    public static class Result{
//        public int start;
//        public int end;
//        public double max;
//    }
//
//    private static void generate_work(double[] a){
//        work = new double[a.length - 1];
//        for(int i = 1; i < a.length; i++){
//            work[i - 1] = a[i] - a[i-1];
//        }
//        System.out.println(Arrays.toString(work));
//    }
//
//    public static Result find(double[] a){
//        generate_work(a);
//        Result res = do_rec_find(0, work.length - 1);
//        res.end++;
//        return res;
//    }
//
//    private static Result do_rec_find(int start, int end){
//        if(start < end){
//            int mid = (start + end) / 2;
//            Result rl = do_rec_find(start, mid);
//            Result rh = do_rec_find(mid + 1, end);
//            Result rc = do_cross_find(start, mid, end);
//            if(rl.max >= rh.max && rl.max >= rc.max){
//                return rl;
//            }
//            if(rh.max >= rl.max && rh.max >= rc.max){
//                return rh;
//            }
//            if(rc.max >= rl.max && rc.max >= rh.max){
//                return rc;
//            }
//        }
//        Result res = new Result();
//        res.start = start;
//        res.end = start;
//        res.max = work[start];
//        return res;
//    }
//
//    private static Result do_cross_find(int start, int mid, int end){
//        double add = 0;
//        Result res = new Result();
//        double maxl = MIN_VALUE;
//        for(int i = mid; i >= start; i--){
//            add += work[i];
//            if(add > maxl){
//                res.start = i;
//                maxl = add;
//            }
//        }
//        double maxh = MIN_VALUE;
//        add = 0;
//        for(int i = mid + 1; i <= end; i++){
//            add += work[i];
//            if(add > maxh){
//                res.end = i;
//                maxh = add;
//            }
//        }
//        res.max = maxl + maxh;
//        return res;
//    }
//
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        double[] a = {9,10,8,12,6,10,12,11,9,1};
//        //double[] a = {9,10,8,12,10,6,12,11,9,1};
//        System.out.println(Arrays.toString(a));
//        Result res = find(a);
//        System.out.println(res.start + " " + res.end + " " + res.max);
//    }


}
