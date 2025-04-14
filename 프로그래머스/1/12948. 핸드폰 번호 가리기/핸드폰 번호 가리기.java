class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int len = phone_number.length();
        for (int i = 0; i < len - 4; i++) {
            sb.append("*");
        }
        
        String last4Num = phone_number.substring(len - 4, len);
        
        sb.append(last4Num);
        
        return sb.toString();
    }
}