import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * @author mingzhi
 * @date 2020-12-16
 */
public class Solution290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> match = new HashMap<>();
        Set<String> matchedWord = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character c = pattern.charAt(i);
            if (match.containsKey(c)) {
                if (!match.get(c).equals(words[i])) {
                    return false;
                }
            }else {
                if (matchedWord.contains(words[i])) {
                    return false;
                }
                match.put(c, words[i]);
                matchedWord.add(words[i]);
            }
        }
        return true;
    }
}
