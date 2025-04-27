class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int high = 7;
        int low = 7;
        
       A: for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < win_nums.length; j++) {
                if(lottos[i] == 0) {
                    high -= 1;
                    continue A;
                } else if (lottos[i] == win_nums[j]) {
                    high -= 1;
                    low -= 1;
                    continue A;
                } 
            }
        }
        if (high == 7) {
            high = 6;
        }
        if (low == 7) {
            low = 6;
        }
        return new int[] {high, low};
    }
}