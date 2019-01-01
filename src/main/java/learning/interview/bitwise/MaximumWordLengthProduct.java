package learning.interview.bitwise;

class MaximumWordLengthProduct {
    //https://leetcode.com/problems/maximum-product-of-word-lengths
    int maxProduct(String[] words) {
        int result = 0;
        int[] maskArray = getMaskArray(words);
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((maskArray[i] & maskArray[j]) == 0) {
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    /*
       Since there are only 26 unique characters, it can be represented in an int(32 bit)
     */
    private int[] getMaskArray(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            masks[i] = 0;
            for (int k = 0; k < words[i].length(); k++) {
                int pos = words[i].charAt(k) - 'a';
                masks[i] |= (1 << pos);
            }
        }
        return masks;

    }

}
