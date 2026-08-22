import java.util.*;

public class Solution{
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {
        // Base case: found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Explore further candidates
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) continue; // Skip if current number is too large

            current.add(candidates[i]); // Choose the candidate
            backtrack(candidates, target - candidates[i], i, current, result); // Not i+1 because reuse allowed
            current.remove(current.size() - 1); // Backtrack
        }
    }

    public static void main(String[] args) {
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println(combinationSum(candidates1, target1)); // [[2,2,3],[7]]

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println(combinationSum(candidates2, target2)); // [[2,2,2,2],[2,3,3],[3,5]]

        int[] candidates3 = {2};
        int target3 = 1;
        System.out.println(combinationSum(candidates3, target3)); // []
    }
}
