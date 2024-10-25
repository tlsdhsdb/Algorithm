class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for(char ch : magazine.toCharArray()){
            count[(int)ch - (int)'a'] += 1;
        }

        for(char ch : ransomNote.toCharArray()){
            if(count[(int)ch - (int)'a'] > 0) count[(int)ch - (int)'a'] -= 1;
            else return false;
        }

        return true;
        
    }
}