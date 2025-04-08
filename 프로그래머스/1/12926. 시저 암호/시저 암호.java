class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
       
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                answer.append(" ");
            } else if (c >= 'a' && c <= 'z') {
                char shiftedChar = (char) ((c - 'a' + n) % 26 + 'a');
                answer.append(shiftedChar);
            } else if (c >= 'A' && c <= 'Z') {
                char shiftedChar = (char) ((c - 'A' + n) % 26 + 'A');
                answer.append(shiftedChar);
            }
        }
        
        return answer.toString();
    }
}