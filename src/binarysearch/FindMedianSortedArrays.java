package binarysearch;

/**
 * 以O(log(m+n)的时间复杂度，寻找两个大小为m和n的有序数组nums1和nums2的中位数；
 * 如nums1=[1,3],nums2=[2]，则中位数为2.0
 *
 * 解：数组A B
 * 首先将A以随机位置i，划分为左右两个数组
 * left_A: A[0],A[1],...,A[i-1];
 * right_A: A[i],A[i+1],...,A[m-1];   i = 0~m-1; 所以共有m种划分方案
 *
 * 同理将B以随机位置j，划分为左右两个数组
 * left_B: B[0],B[1],...,B[j-1];
 * right_B: B[i],B[i+1],...,B[n-1];
 *
 * 将left_A，left_B 放入集合left_part中
 * 将right_A，right_B 放入集合right_part中
 *
 *       left_part          |        right_part
 * A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
 * B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
 *
 * 如果能够保证如下两个条件：
 * 1) len(left_part) == len(right_part) 或者  len(left_part) == len(right_part)+1
 * 2) max(left_part) <= min(right_part)
 *
 * 为了保证上述条件成立，需要保证下属两个条件成立：
 * (1) i + j == m - i + n - j (or: m - i + n - j + 1)
 *     if n >= m, we just need to set: i = 0 ~ m, j = (m + n + 1)/2 - i
 * (2) B[j-1] <= A[i] and A[i-1] <= B[j]
 *
 *首先假设 A[i-1],B[j-1],A[i],B[j] 对于所有的i=0/i=m,j=0/j=n 都合理
 * Searching i in [0, m], to find an object `i` that:（此处进行合理假设 n>=m)
 *     B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
 */
public class FindMedianSortedArrays {

}
