package learning.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 8/23/15.
 */
public class BinaryValues {

    public List<String> allBinaryValues(int nBits) {
        ArrayList<String> bitStrings = new ArrayList<>();
        allBinaryValues("", nBits, bitStrings);
        return bitStrings;
    }

    private void allBinaryValues(String bitString, int nBits, ArrayList<String> bitStrings) {
        if (nBits < 1) {
            bitStrings.add(bitString);
            return;
        }
        String newBitString = bitString + "0";
        allBinaryValues(newBitString, nBits - 1, bitStrings);
        newBitString = bitString + "1";
        allBinaryValues(newBitString, nBits - 1, bitStrings);
    }
}
