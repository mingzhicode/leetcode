import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author mingzhi
 * @date 2020-11-14
 */
public class Solution1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return useArrIndex(arr1, arr2);
    }

    private int[] useArrIndex(int[] arr1, int[] arr2) {
        int max = 0;
        for (int i : arr1) {
            max = Math.max(max, i);
        }
        int[] frequency = new int[max+1];
        for (int i : arr1) {
            frequency[i]++;
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for (int val : arr2) {
            for (int i = 0; i < frequency[val]; i++) {
                ans[index] = val;
                index++;
            }
            frequency[val] = 0;
        }
        for (int i = 0; i < max + 1; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                ans[index] = i;
                index++;
            }
        }
        return ans;
    }

    private int[] sortByMap(int[] arr1, int[] arr2) {
        Map<Integer, Integer> relativeSortMap = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            relativeSortMap.put(arr2[i], i);
        }
        Map<Integer, List<Integer>> sortedList = new TreeMap<>();
        List<Integer> notInArr = new ArrayList<>();
        for (int i : arr1) {
            Integer pos = relativeSortMap.get(i);
            if (pos == null) {
                notInArr.add(i);
                continue;
            }
            List<Integer> certainPosList = sortedList.computeIfAbsent(pos, k -> new ArrayList<>());
            certainPosList.add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (List<Integer> posInteger : sortedList.values()) {
            result.addAll(posInteger);
        }
        if (notInArr.size() != 0) {
            notInArr.sort(Comparator.comparingInt(integer -> integer));
            result.addAll(notInArr);
        }
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = result.get(i);
        }
        return arr1;
    }

    private int[] sortByMapAndSort(int[] arr1, int[] arr2) {
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            rank.put(arr2[i], i);
        }
        List<Integer> arrList = new ArrayList<>();
        for (int i : arr1) {
            arrList.add(i);
        }
        arrList.sort((val1, val2) -> {
            if (rank.containsKey(val1)) {
                return rank.containsKey(val2) ? rank.get(val1) - rank.get(val2) : -1;
            } else {
                return rank.containsKey(val2) ? 1 : val1 - val2;
            }
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = arrList.get(i);
        }
        return arr1;
    }

    public static void main(String[] args) {
        Solution1122 solution1122 = new Solution1122();
        int[] arr1 = new int[] {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = new int[] {2,1,4,3,9,6};
        System.out.println(Arrays.toString(solution1122.relativeSortArray(arr1, arr2)));
    }

}
