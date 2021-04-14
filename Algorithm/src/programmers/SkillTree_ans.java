package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SkillTree_ans {
    static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
        //ArrayList<String> skillTrees = new ArrayList<String>();
        Iterator<String> it = skillTrees.iterator();

        while (it.hasNext()) {
            String n = it.next();
            String s = n.replaceAll("[^" + skill + "]", "");
            System.out.println(n+"/"+s);
            if (skill.indexOf(n.replaceAll("[^" + skill + "]", "")) != 0) {
                it.remove();
            }
        }
        answer = skillTrees.size();
        return answer;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA", "CBD", "CAFB"};
        System.out.println(solution(skill, skill_trees));
    }
}
