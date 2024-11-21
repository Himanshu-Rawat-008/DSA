import java.util.*;

public class Main {
    static boolean v[];

    public static boolean helper(boolean[][] graph, int M, int i, ArrayList<Integer> set) {
        if (set.contains(i))
            return false;
        if (v[i])
            return true;

        set.add(i);

        for (int j = 0; j < M; j++)
            if (graph[i][j]) {
                if (helper(graph, M, j, set))
                    v[i] = true;
                else
                    return false;
            }

        set.remove(set.size() - 1);
        return true;
    }

    public static boolean canFinish(int numCourses, int[][] pre) {
        int M = numCourses;
        int N = pre.length;

        boolean[][] graph = new boolean[M][M];
        v = new boolean[M];

        for (int i = 0; i < N; i++) {
            int a = pre[i][0];
            int b = pre[i][1];
            graph[a][b] = true;
        }

        for (int i = 0; i < M; i++)
            if (helper(graph, M, i, new ArrayList<>()))
                v[i] = true;
            else
                return false;

        return true;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] pre = { { 1, 0 } };

        System.out.println(canFinish(numCourses, pre));
    }
}
