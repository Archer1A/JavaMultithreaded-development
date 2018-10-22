package IntroductionToAlgorithms;

public class RandomizedSelect {
    public int partition(int[] arr, int l, int r) {
        int end = arr[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (arr[j] <= end) {
                int tmp = arr[++i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int tmp = arr[i + 1];
        arr[i+1] = arr[r];
        arr[r] = tmp;
        return i + 1;
    }

    //去除数组中第I小的数组
    public int RandomizedSelect(int[] arr,int l,int r,int i){
        if (l == r) return arr[l];
        int q = partition(arr, l, r);
        int k = q - l + 1;
        if (i ==k){
            return arr[q];
        }
        else  if ( i< k ) return RandomizedSelect(arr, l, q - 1, i);
        else return RandomizedSelect(arr, q + 1, r, i - k);
    }

    public static void main(String[] args) {
        RandomizedSelect randomizedSelect = new RandomizedSelect();
        int[] arr = {1,25,7,9,63,7,58,6,854,646,8,4,64,48,46,64,6,9,10};
        System.out.println(randomizedSelect.RandomizedSelect(arr,0,arr.length-1,6));
    }
}
