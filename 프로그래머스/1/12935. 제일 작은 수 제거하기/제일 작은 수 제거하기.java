class Solution {
    public int[] solution(int[] arr) {
        int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        
        int idx = 0;
        int[] answer = new int[arr.length - 1];
        
        for (int value : arr) {
            if (value != min) {
                answer[idx++] = value;
            }
        }
        
        return arr.length <= 1 ? new int[] {-1} : answer;
    }
}
