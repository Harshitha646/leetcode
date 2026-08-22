public class Solution {
    public static String countAndSay(int n) {
        if (n == 1) return "1";  // Base case
        
        String prev = countAndSay(n - 1);  // Recursive call
        StringBuilder sb = new StringBuilder();

        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i) == prev.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(prev.charAt(i - 1));
                count = 1;
            }
        }

        // Append the last group
        sb.append(count).append(prev.charAt(prev.length() - 1));

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // 1
        System.out.println(countAndSay(2)); // 11
        System.out.println(countAndSay(3)); // 21
        System.out.println(countAndSay(4)); // 1211
        System.out.println(countAndSay(5)); // 111221
    }
}
