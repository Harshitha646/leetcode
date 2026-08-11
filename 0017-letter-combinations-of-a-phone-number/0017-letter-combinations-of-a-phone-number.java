import java.util.*;

public class Solution {
    private static final String[] MAP = {
        "", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        backtrack("", digits, 0, result);
        return result;
    }

    private void backtrack(String combination, String digits, int index, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }
        String letters = MAP[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            backtrack(combination + c, digits, index + 1, result);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
        // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}