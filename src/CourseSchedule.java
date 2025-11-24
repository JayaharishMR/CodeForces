import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[1]).add(p[0]);
        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (!dfs(i, graph, state)) return false;
            }
        }
        return true;
    }

    boolean dfs(int idx, List<List<Integer>> graph, int[] state) {
        state[idx] = 1;
        for (int course : graph.get(idx)) {
            if (state[course] == 1) return false;
            if (state[course] == 0) {
                if (!dfs(course, graph, state)) return false;
            }
        }
        state[idx] = 2;
        return true;
    }
}
