using System;
using System.Collections.Generic;

public class Solution {
    public string[] solution(string[] strings, int n) {
        Array.Sort(strings, (a, b) => {
            if (a[n] == b[n]) 
                return string.Compare(a, b);
            return a[n].CompareTo(b[n]);
        });
        
        /** Linq 풀이
        
        return strings
            .OrderBy(s => s[n])
            .ThenBy(s => s)
            .ToArray();
            
        **/
    
        return strings;
    }
}