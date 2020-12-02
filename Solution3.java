import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author mingzhi
 * @date 2020-12-02
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        return useSet(s);
    }

    private int useSet(String s) {
        Set<Character> set = new HashSet<>();
        int right = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            max = Math.max(max, right - i);
            set.remove(s.charAt(i));
            if (right >= s.length()) {
                break;
            }
        }
        return max;
    }

    private int useMap(String s) {
        if (s == null) {
            return 0;
        }
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().lengthOfLongestSubstring("abba"));
    }



}
