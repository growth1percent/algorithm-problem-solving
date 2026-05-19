public class Solution {
    public bool solution(string s) {
        bool answer = true;
        
        if (s.Length != 4 && s.Length != 6) 
        {
            answer = false;
        }
        
        char[] arr = s.ToCharArray();
        
        foreach (char c in arr) 
        {
            if (!char.IsDigit(c))
                answer = false;
        }
        
        return answer;
    }
}