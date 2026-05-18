class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        s = s.toLowerCase();

        int pNum = 0;
        int yNum = 0;
        
        char[] cArr = s.toCharArray();
        
        for (char c : cArr) {
            if (c == 'p') {
                pNum++;
            } else if (c == 'y'){
                yNum++;
            }
        }
        
        if (pNum != yNum) {
            answer = false;
        }

        return answer;
    }
}