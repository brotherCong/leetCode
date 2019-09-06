package algorithms.lt0004;

/**
 * @ClassName FindMedianSortedArrays
 * Description TODO
 * Author cds
 * Date 2019/9/6 15:10
 * Version 1.0
 **/
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] a = new int[]{1,3};
        int[] b = new int[]{2};
        double d=findMedianSortedArrays(a,b);
        System.out.println(d);
    }


    public static double findMedianSortedArrays(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;

        if (m > n) {//确保m<=n
            int[] tmp = A;
            A = B;
            B = tmp;
            int t = m;
            m = n;
            n = t;
        }

        int imin = 0, imax = m, halfLen = (m + n + 1) / 2;
        while (imin <= imax) {
            int i = (imin + imax) / 2;
            int j = halfLen - i;
            if (i < imax && B[j - 1] > A[i]) {//需要增加i 此时j是减小的  因为m<=n 所以j>0
                imin = i + 1;
            } else if (i > imin && A[i - 1] > B[j]) {//需要减小i 此时j是增加的 m<=n 所以j<n
                imax = i - 1;
            }else{//找到i值
                //此时获取左端最大的A和B
                int maxleft=0;
                if(i==0){
                    maxleft=B[j-1];//为什么减一  因为数组是从0开始
                }else if(j==0){
                    maxleft=A[i-1];
                }else {
                    maxleft=Math.max(A[i-1],B[j-1]);
                }
                if((m+n)%2==1){
                    return maxleft;
                }

                int minright=0;
                if(i==m){
                    minright=B[j];
                }else if(j==n){
                    minright=A[i];
                }else{
                    minright=Math.min(A[i],B[j]);
                }
                return (maxleft+minright)/2.0;
            }
        }

        return 0.0;
    }
}
