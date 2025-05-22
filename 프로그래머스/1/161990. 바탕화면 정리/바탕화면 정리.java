import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minRow = wallpaper.length;
        int minCol = wallpaper[0].length();
        int maxRow = 0;
        int maxCol = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minRow = Math.min(minRow, i);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i + 1);
                    maxCol = Math.max(maxCol, j + 1);
                }
            }
        }
        
        return new int[] {minRow, minCol, maxRow, maxCol};
    }
}