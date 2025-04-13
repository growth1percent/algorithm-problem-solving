class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String str = Integer.toString(x);
        int value = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = c - '0';
            value += num;
        }
        if (x % value == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}