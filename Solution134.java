/**
 * @author mingzhi
 * @date 2020-11-18
 */
public class Solution134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        return loopOnce(gas, cost);
    }

    public int doubleLoop(int[] gas, int[] cost) {
        int gasNum = gas.length;
        for (int i = 0; i < gasNum; i++) {
            int j = i;
            int remain = gas[i];
            while (remain >= cost[j]) {
                remain = remain - cost[j] + gas[(j+1)%gasNum];
                j = (j+1) % gasNum;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int loopOnce(int[] gas, int[] cost) {
        int curRemain = 0;
        int totalRemain = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            curRemain = curRemain +  gas[i] - cost[i];
            totalRemain = totalRemain + gas[i] - cost[i];
            if (curRemain < 0) {
                curRemain = 0;
                start = i + 1;
            }
        }
        if (totalRemain < 0) {
            return -1;
        }
        return start;
    }

}
