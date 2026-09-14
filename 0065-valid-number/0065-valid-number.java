public class Solution{
    public static boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
    
      for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                numSeen = true;
            } 
            else if (c == '.') {
                // '.' can appear only once and not after 'e' or 'E'
                if (dotSeen || eSeen) return false;
                dotSeen = true;
            } 
            else if (c == 'e' || c == 'E') {
                // 'e' can appear only once and only after a number
                if (eSeen || !numSeen) return false;
                eSeen = true;
                numSeen = false; // need a number after e
            } 
            else if (c == '+' || c == '-') {
                // sign can appear at start or just after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')
                    return false;
            } 
            else {
                // invalid character
                return false;
            }
        }

        return numSeen;
    }

    public static void main(String[] args) {
        String[] tests = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", 
                          "3e+7", "+6e-1", "53.5e93", "-123.456e789",
                          "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};

        for (String t : tests) {
            System.out.println(t + " → " + isNumber(t));
        }
    }
}
