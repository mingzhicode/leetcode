import java.util.Arrays;
import java.util.Comparator;

/**
 * 1. 最简单做法，根据sqrt方式排序，取前K个即可
 * 时间复杂度即为排序的时间复杂度nlogn,空间为排序需要的额外空间logn;
 *
 * 2. 观察题目特定取前K个数，自然想到堆排序，快速排序取前K个的思路
 * 原题目实际就是求一堆int数排序的前K个，其中他们的大小比较即是点到原点的距离
 * @author mingzhi
 * @date 2020-11-09
 */
public class Solution973 {

    public int[][] kClosest(int[][] points, int K) {
        return topK(points, K);
    }

    public static int[][] plainSort(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] pointA, int[] pointB) {
                //点到原点(0,0)的距离
               int sqrA = pointA[0] * pointA[0] + pointA[1] * pointA[1];
               int sqrB = pointB[0] * pointB[0] + pointB[1] * pointB[1];
               return sqrA - sqrB;
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    public static int[][] topK(int[][] points, int K) {
        int n = points.length;
        return select(points, 0, n-1, K);
    }

    private static int[][] select(int[][] points, int left, int right, int K) {
        if (left > right) {
            return new int[0][0];
        }
        int j = partition(points, left, right);
        if (j == K-1) {
            return Arrays.copyOfRange(points, 0, K);
        }
        if (j < K-1) {
            return select(points, j + 1, right, K);
        }else {
            return select(points, left, j - 1 , K);
        }
    }

    public static int partition(int[][] points, int left, int right) {
        int pivot = getDis(points[left]);
        int i = left, j = right;
        while (i != j) {
            while (getDis(points[j]) >= pivot && j > i) {
                j--;
            }
            while (getDis(points[i]) <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, left, i);
        return i;
    }

    private static int getDis(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    private static void swap(int[][] points, int right, int pivot) {
        int[] tmp = points[right];
        points[right] = points[pivot];
        points[pivot] = tmp;
    }
}
