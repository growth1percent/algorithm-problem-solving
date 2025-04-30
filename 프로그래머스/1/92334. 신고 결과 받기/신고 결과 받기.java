import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 중복 제거
        Set<String> set = new HashSet<>(Arrays.asList(report));
        
        // 신고당한 사람, 신고자 해시 맵
        Map<String, Set<String>> reportedBy = new HashMap<>();
        
        for (String s : set) {
            String[] array = s.split(" ");
            String reporter = array[0];
            String reported = array[1];
            
            reportedBy.putIfAbsent(reported, new HashSet<>());
            reportedBy.get(reported).add(reporter);
        }
        
        // 정지된 유저 해시 셋
        Set<String> bannedUsers = new HashSet<>();
        for (String reported : reportedBy.keySet()) {
            if (reportedBy.get(reported).size() >= k) {
                bannedUsers.add(reported);
            }
        }
        
        // 인덱스 해시 맵
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            indexMap.put(reporter, i);
        }
        
        int[] answer = new int[id_list.length];
        for (String banned : bannedUsers) {
            for (String reporter : reportedBy.get(banned)) {
                int idx = indexMap.get(reporter);
                answer[idx]++;
            }
        }
        
        return answer;
    }
}