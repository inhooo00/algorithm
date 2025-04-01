package programmers.p;

public class P49993 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution.solution(skill, skill_trees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            int idx = 0;

            for (int i = 0; i < skill_trees.length; i++) {
                String skillCopy = skill;
                idx = 0;
                int contain = 0;
                for (int j = 0; j < skill.length(); j++) {
                    if (skill_trees[i].contains(String.valueOf(skill.charAt(j)))) {
                        contain++;
                    }
                }
                for (int j = 0; j < skill_trees[i].length(); j++) {
                    if (skillCopy.charAt(idx) == skill_trees[i].charAt(j)) {
                        idx++;
                    }
                    if (idx == contain) {
                        answer++;
                        System.out.println(skill_trees[i]);
                        break;
                    }
                }

            }

            return answer;
        }
    }
}
