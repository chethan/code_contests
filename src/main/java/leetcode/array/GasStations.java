package leetcode.array;

public class GasStations {

    //https://leetcode.com/problems/gas-station/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0, total = 0, index = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            gasInTank += diff;
            if (gasInTank < 0) {
                index = i + 1;
                gasInTank = 0;
            }
            total += diff;
        }
        return total < 0 ? -1 : index;
    }
}
