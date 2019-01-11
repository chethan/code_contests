package learning.interview.string;

class RansomNote {
    //https://leetcode.com/problems/ransom-note
    boolean canConstruct(String ransomNote, String magazine) {
    	int[] counts = new int[26];

    	if(ransomNote.length()>magazine.length()) return false;

    	for(int i=0;i<magazine.length();i++){
    		counts[magazine.charAt(i)-'a']++;
    	}

    	for(int i=0;i<ransomNote.length();i++){
    		counts[ransomNote.charAt(i)-'a']--;
    		if(counts[ransomNote.charAt(i)-'a']<0){
    			return false;
    		}
    	}

    	return true;
    }
}
