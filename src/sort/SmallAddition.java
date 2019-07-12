package sort;

public class SmallAddition {
    //一个数组，将每一个数的左边比其小的数+1；
    //采用归并排序加速小和过程，避免排序
    public static void main(String[] args) {
        System.out.println(getSmallAdd(new int[]{2, 3, 4, 5, 6, 4}, 0, 5));
    }

    public static int getSmallAdd(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return getSmallAdd(arr, l, mid) + getSmallAdd(arr, mid + 1, r) + merge(arr, l, r, mid);
    }

    public static int merge(int[] arr, int l, int r, int mid) {
        int len = r - l + 1;
        int[] tmp = new int[len];
        int p1 = l, p2 = mid + 1, i = 0;
        int result = 0;
        while (p1 <= mid && p2 <= r) {
            result += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            tmp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= l) {
            tmp[i++] = arr[p1++];
        }
        while (p2 <= 1) {
            tmp[i++] = arr[p2++];
        }
        for (int j = 0; j < len; j++) {
            arr[l + j] = tmp[j];
        }
        return result;
    }
}
