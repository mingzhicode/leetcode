import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 204题解
 * 计数质数
 * 统计所有小于非负整数 n 的质数的数量。
 * 例：
 *  输入：n = 10
 *  输出：4
 *  解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * @author mingzhi
 * @date 2020-12-03
 */
public class Solution204 {

    public int countPrimes(int n) {
        return linearFilter(n);
    }

    private int loop(int n) {
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans += isPrice(i)? 1 : 0;
        }
        return ans;
    }

    private boolean isPrice(int i) {
        for (int j = 2; j * j <= i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public int linearFilter(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution204().countPrimes(20));
    }
}
