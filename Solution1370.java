/**
 * @author mingzhi
 * @date 2020-11-25
 */
public class Solution1370 {

    public String sortString(String s) {
        char[] bucket = new char[26];
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (bucket[i] > 0) {
                    sb.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (bucket[i] > 0) {
                    sb.append((char)(i + 'a'));
                    bucket[i]--;
                }
            }
        }
        return sb.toString();
    }

}
