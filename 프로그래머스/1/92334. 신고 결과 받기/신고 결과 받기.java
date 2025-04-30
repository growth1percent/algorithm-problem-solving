import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 제거
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // 신고 당한 사람, 신고자 목록 매핑
        Map<String, Set<String>> reportedBy = new HashMap<>();
        
        for (String s : set) {
            String[] array = s.split(" ");
            reportedBy.putIfAbsent(array[1], new HashSet<>());
            reportedBy.get(array[1]).add(array[0]);
        }
        
        // 정지 대상 찾기 (k번 이상 신고당한 사람)
        Set<String> bannedUsers = new HashSet<>();
        for (String user : reportedBy.keySet()) {
            if (reportedBy.get(user).size() >= k) {
                bannedUsers.add(user);
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            for (String banned : bannedUsers) {
                if (reportedBy.get(banned).contains(reporter)) {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}