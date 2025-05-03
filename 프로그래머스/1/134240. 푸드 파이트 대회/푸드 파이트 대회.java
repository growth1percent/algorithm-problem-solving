class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < food.length; i++) {
            int value = food[i];
            if (food[i] % 2 != 0) {
                for (int j = 0; j < (value - 1) / 2; j++) {
                    sb.append(i);
                }
            } else {
                for (int j = 0; j < value / 2; j++) {
                    sb.append(i);
                }
            }
        }        
        StringBuilder answer = new StringBuilder(sb);
        answer.append(0);
        answer.append(sb.reverse());
        
        return answer.toString();
    }
}