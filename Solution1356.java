import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 求一个数10进制上1的个数，以此为评价标准写大小比较函数，借助标准库的sort方法
 * @author mingzhi
 * @date 2020-11-06
 */
public class Solution1356 {

    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int[] bits = new int[10001];
        for (int i : arr) {
            list.add(i);
            bits[i] = getBit1Count(i);
        }
        Collections.sort(list, (x, y) -> {
            if (bits[x] != bits[y]) {
                return bits[x] - bits[y];
            }else {
                return x - y;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getBit1Count(int i) {
        int res = 0;
        while (i != 0) {
            res += i % 2;
            i = i / 2;
        }
        return res;
    }
}
