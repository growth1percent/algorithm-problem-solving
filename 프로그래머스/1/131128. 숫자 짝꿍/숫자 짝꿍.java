class Solution {
    public String solution(String X, String Y) {
        int[] x_count = new int[10];
        int[] y_count = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            int c = X.charAt(i) - '0';
            x_count[c]++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            int c = Y.charAt(i) - '0';
            y_count[c]++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 9; i >= 0; i--) {
            int minCount = Math.min(x_count[i], y_count[i]);
            for (int j = 0; j < minCount; j++) {
                sb.append(i);
            }
        }
        
        if (sb.length() > 0 && sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.length() == 0 ? "-1" : sb.toString();
    }
}