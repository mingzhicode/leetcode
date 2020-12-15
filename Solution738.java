/**
 * @author mingzhi
 * @date 2020-12-15
 */
public class Solution738 {

    public int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < strN.length && strN[i - 1] <= strN[i]) {
            i += 1;
        }
        if (i < strN.length) {
            while (i > 0 && strN[i - 1] > strN[i]) {
                strN[i - 1] -= 1;
                i -= 1;
            }
            for (i += 1; i < strN.length; ++i) {
                strN[i] = '9';
            }
        }
        return Integer.parseInt(new String(strN));
    }

    public static void main(String[] args) {
        System.out.println(new Solution738().monotoneIncreasingDigits(233332));
    }
}
