public class Solution {
    public bool solution(string s) {
        if (s.Length != 4 && s.Length != 6) 
        {
            return false;
        }
        
        foreach (char c in s) 
        {
            if (!char.IsDigit(c))
                return false;
        }
        
        /** Linq 풀이
        
        if (s.Length != 4 && s.Length != 6 && !s.All(char.IsDigit))
        {
            return false;
        }
        
        **/
        
        return true;
    }
}