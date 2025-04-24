class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        
        int[][] keypad = {
            {3, 1},
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2}
        };
        
        int[] leftPos = {3, 0};
        int[] rightPos = {3, 2};
        
        for (int num : numbers) {
            int[] target = keypad[num];
            
            if (num == 1 || num == 4 || num == 7) {
                leftPos = target;
                answer.append("L");
            } else if (num == 3 || num == 6 || num == 9) {
                rightPos = target;
                answer.append("R");
            } else {
                int leftDist = Math.abs(leftPos[0] - target[0]) + Math.abs(leftPos[1] - target[1]);
                int rightDist = Math.abs(rightPos[0] - target[0]) + Math.abs(rightPos[1] - target[1]);
                
                if (leftDist < rightDist) {
                    leftPos = target;
                    answer.append("L");
                } else if (rightDist < leftDist) {
                    rightPos = target;
                    answer.append("R");
                } else {
                    if (hand.equals("left")) {
                        leftPos = target;
                        answer.append("L");
                    } else {
                        rightPos = target;
                        answer.append("R");
                    }
                }
            }
        }
        
        return answer.toString();
    }
}