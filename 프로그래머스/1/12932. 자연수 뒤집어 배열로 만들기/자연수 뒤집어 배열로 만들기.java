class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        StringBuilder sb = new StringBuilder(str).reverse();
        
        int[] answer = new int[sb.length()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = sb.charAt(i) - '0';
        }
        
        return answer;
    }
}