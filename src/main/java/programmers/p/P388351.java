//package programmers.p;
//
//public class P388351 {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] schedules = {700, 800, 1100};
//        int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}
//                , {800, 801, 805, 800, 759, 810, 809}
//                , {1105, 1001, 1002, 600, 1059, 1001, 1100}};
//        int startday = 5;
//        System.out.println(solution.solution(schedules, timelogs, startday));
//    }
//
//    static class Solution {
//        private int time(int timelog) {
//            return (timelog / 100 * 60) + (timelog % 100);
//        }
//
//        public int solution(int[] schedules, int[][] timelogs, int startday) {
//            int answer = schedules.length;
//
//            for (int i = 0; i < schedules.length; i++) { //3번
//                for (int j = 0; j <= 6; j++) { //7일
//                    int day = (startday + 1 - 1) % 7 + 1;
//                    if (day != 6 && day != 7) {
//                        if (time(schedules[i]) + 10 < time(timelogs[i][j])) {// 통과 못했을 때
//                            answer--;
//                            break;
//                        }
//                    }
//                }
//            }
//            return answer;
//        }
//    }
//}
