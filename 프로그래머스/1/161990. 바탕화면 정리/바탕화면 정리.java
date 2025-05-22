class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int[] min = {wallpaper.length, wallpaper[0].length()};
        int[] max = {0, 0};
        
        for (int i = 0; i < wallpaper.length; i++) {
                String s = wallpaper[i];
                char[] array = s.toCharArray();
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (array[j] == '#') {
                    if (min[0] > i) {
                        min[0] = i;
                    }
                    if (min[1] > j) {
                        min[1] = j;
                    }
                    if (max[0] < i + 1) {
                        max[0] = i + 1;
                    }
                    if (max[1] < j + 1) {
                        max[1] = j + 1;
                    }
                } 
            }
        }
        
        answer[0] = min[0];
        answer[1] = min[1];
        answer[2] = max[0];
        answer[3] = max[1];
        
        return answer;
    }
}