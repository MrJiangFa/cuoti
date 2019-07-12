package sort;

public class MergeSort<AnyType extends Comparable<? super AnyType>> {
    public static void main(String[] args) {
        MergeSort<Integer> ms = new MergeSort<>();
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
//        ms.mergeSort(arr);
        System.out.println(InversePairs(arr));
    }

    public void mergeSort(AnyType[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    public void sortProcess(AnyType[] arr, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sortProcess(arr, left, mid);
        sortProcess(arr, mid + 1, right);
        merge(arr, left, right, mid);
    }

    //使用辅助额外空间可以想象成使用一个全局数组tmp，此处采用的是临时创建临时销毁
    private void merge(AnyType[] arr, int left, int right, int mid) {
        int len = right - left + 1;
        AnyType[] tmp = (AnyType[]) new Comparable[len];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= right) {
            tmp[i++] = arr[p1].compareTo(arr[p2]) < 0 ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= right) {
            tmp[i++] = arr[p2++];
        }
        for (i = 0; i < len; i++) {
            arr[left + i] = tmp[i];
        }
    }

    //求解逆序对的个数
    public static int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return process(array, 0, array.length - 1);
    }

    public static int process(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        int l = process(array, left, mid)%(1000000007);
        int r = process(array, mid + 1, right)%(1000000007);
        int m = merge(array, left, right, mid);
        return (l+r+m)%(1000000007);
    }

    public static int merge(int[] array, int left, int right, int mid) {
        int len = right - left + 1;
        int[] help = new int[len];
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int res = 0;
        while (p1 <= mid && p2 <= right) {
            if (array[p1] > array[p2]) {
                res += (mid - p1 + 1);
                if(res>=1000000007)
                    res %= 1000000007;
                help[i++] = array[p2++];
            } else {
                help[i++] = array[p1++];
            }
        }
        while (p1 <= mid) {
            help[i++] = array[p1++];
        }
        while (p2 <= right) {
            help[i++] = array[p2++];
        }
        for (int j = left; j <= right; j++) {
            array[j] = help[j - left];
        }
        return res;
    }
}
