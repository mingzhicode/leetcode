import java.util.ArrayList;
import java.util.List;

/**
 * @author mingzhi
 * @date 2020-12-06
 */
public class Solution118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                }else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution118().generate(5));
    }
}
