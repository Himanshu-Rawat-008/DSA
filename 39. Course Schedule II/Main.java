import java.util.*;

public class Main {
    public static boolean dfs(ArrayList<ArrayList<Integer>> arr,
            ArrayList<Integer> res,
            int curr,
            int[] v) {

        if (res.contains(curr))
            return true;
        if (v[curr] == 1)
            return false;

        v[curr] = 1;
        for (int i : arr.get(curr)) {
            if (!dfs(arr, res, i, v))
                return false;
        }

        v[curr] = 0;
        res.add(curr);
        return true;
    }

    public static int[] findOrder(int numCourses, int[][] p) {
        int N = numCourses;

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>(N);
        ArrayList<Integer> res = new ArrayList<>();
        int[] ans = new int[0];

        // create Graph
        for (int i = 0; i < N; i++)
            arr.add(new ArrayList<Integer>());

        for (int[] courses : p)
            arr.get(courses[0]).add(courses[1]);

        for (int i = 0; i < N; i++)
            if (!dfs(arr, res, i, new int[N]))
                return ans;

        ans = new int[res.size()];

        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);

        return ans;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] p = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        int[] ans = findOrder(numCourses, p);

        for (int a : ans)
            System.out.println(a);
    }
}
