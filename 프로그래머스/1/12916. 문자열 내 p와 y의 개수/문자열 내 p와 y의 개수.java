class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        int plen = 0;
        int ylen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                plen += 1;
            }
            if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                ylen += 1;
            }
        }
        
        return plen == ylen ? true : false;
    }
}