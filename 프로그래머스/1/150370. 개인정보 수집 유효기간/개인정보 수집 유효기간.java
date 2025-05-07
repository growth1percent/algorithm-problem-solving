import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < terms.length; i++) {
            String[] split_array = terms[i].split(" ");
            int month = Integer.parseInt(split_array[1]);
            map.put(split_array[0], month);
        }
        
        String[] today_split = today.split("\\.");
        int todayToDays = dateToDays(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] privacies_split = privacies[i].split(" ");
            int privaciesToDays = dateToDays(privacies_split[0]);
            int expiredDay = privaciesToDays + 
                map.get(privacies_split[1]) * 28 - 1;
            
            if (todayToDays > expiredDay) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dateToDays(String date) {
        String[] date_array = date.split("\\.");
        int year = Integer.parseInt(date_array[0]);
        int month = Integer.parseInt(date_array[1]);
        int days = Integer.parseInt(date_array[2]);
        
        return (year * 12 * 28) + (month * 28) + days;
    }
}