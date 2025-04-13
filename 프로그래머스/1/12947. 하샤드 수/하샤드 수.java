class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String[] str = Integer.toString(x).split("");
        int value = 0;
        
        for (int i = 0; i < str.length; i++) {
            value += Integer.parseInt(str[i]);
        }
        
        if (x % value == 0) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}