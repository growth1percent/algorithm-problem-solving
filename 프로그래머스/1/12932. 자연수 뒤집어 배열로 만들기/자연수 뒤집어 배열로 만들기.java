class Solution {
    public int[] solution(long n) {
        /*
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder(str).reverse();
        
        int[] answer = new int[sb.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sb.charAt(i) - '0';
        }
        
        return answer;
        */
        
        String str = Long.toString(n);
        int len = str.length();
        int[] answer = new int[len];
        
        for (int i = 0; i < len; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        } 
        
        return answer;
    }
}