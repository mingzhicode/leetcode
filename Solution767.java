/**
 * @author mingzhi
 * @date 2020-11-30
 */
public class Solution767 {

    public String reorganizeString(String S) {
        int[] alphabetCount = new int[26];
        int max = 0, thresHold = (S.length() + 1) / 2, maxNumAlpha = 0;
        for (int i = 0; i < S.length(); i++) {
            alphabetCount[S.charAt(i) - 'a'] ++;
            int alphaCount = alphabetCount[S.charAt(i) - 'a'];
            if (alphaCount > max) {
                max = alphaCount;
                maxNumAlpha = S.charAt(i) - 'a';
                if (max > thresHold) {
                    return "";
                }
            }
        }

        char[] ans = new char[S.length()];
        int index = 0;
        while (alphabetCount[maxNumAlpha] > 0) {
            ans[index] = (char) (maxNumAlpha + 'a');
            index += 2;
            alphabetCount[maxNumAlpha]--;
        }
        for (int i = 0; i < alphabetCount.length; i++) {
            while (alphabetCount[i] > 0) {
                if (index >= ans.length) {
                    index = 1;
                }
                ans[index] = (char) (i + 'a');
                index+=2;
                alphabetCount[i]--;
            }
        }
        return new String(ans);
    }

    public static void main(String[] args) {
        String test = "bfrbs";
        System.out.println(new Solution767().reorganizeString(test));
    }

}
