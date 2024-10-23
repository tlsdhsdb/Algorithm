class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\p{Punct}","").toLowerCase().replaceAll(" ","");
        char[] arr = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(arr[i] == arr[s.length()-1-i]) continue;
            return false;
        }
        return true;
    }
}