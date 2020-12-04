import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


/**
 * leetcode 659. 分割数组为连续子序列
 *
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个子序列，其中每个子序列都由连续整数组成且长度至少为 3 。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 *
 * @author mingzhi
 * @date 2020-12-04
 */
public class Solution659 {

    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        return usePriorityQueue(nums);
    }

    private boolean usePriorityQueue(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int x : nums) {
            if (!map.containsKey(x)) {
                map.put(x, new PriorityQueue<>());
            }
            if (map.containsKey(x - 1)) {
                int prevLen = map.get(x - 1).poll();
                if (map.get(x - 1).isEmpty()) {
                    map.remove(x - 1);
                }
                map.get(x).offer(prevLen+1);
            }else {
                map.get(x).offer(1);
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Integer>> lengthEntry : map.entrySet()) {
            if (lengthEntry.getValue().peek() < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution659().isPossible(new int[]{1,2,3,3,4,5}));
    }
}
