package IntroductionToAlgorithms;

import java.util.Arrays;

public class QuickSortDemo {

    public    int partition(int[] arr,int p,int r){

        int end = arr[r];
        int i = p -1;
        for (int j = p ; j < r; j ++){
            if(arr[j] <= end){
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }

        int tmp = arr[i+1];
        arr[i+1] = arr[r];
        arr[r] = tmp;
        return  i+1;
    }

    public void quickSort(int[] arr,int p,int r){
        if(p<r){
            int q = partition(arr,p,r);
            quickSort(arr, p, q - 1);
            quickSort(arr, q + 1, r);
        }
    }


    public static void main(String[] args) {

        QuickSortDemo quickSortDemo = new QuickSortDemo();
        int[] arr = new int[]{1,3,4,5,2,6,7,8,9};
        quickSortDemo.quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(x ->{
            System.out.print(x);
        });

        }

    }

