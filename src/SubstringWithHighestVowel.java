package src;
/*
Given a string s and int k, write a function that find and returns a substring of s with exact length k
    that contains the highest number of vowel letter
- If s contains no vowel, return the string "Not found!" without the quotes.
- If more than one substring of s has the same number of highest vowel, return the substring which starts at the
    lowest index.

    Example:
        Given s := "azerdii" and k := 5;
        Your function should return "erdii"
 */
public class SubstringWithHighestVowel {
    public static void main(String[] args) {
        System.out.println(findSubstring("azerdii", 5));
    }
    public static String findSubstring(String s, int k) {
        String str = "";
        int maxVol = 0;
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            int volCount = 0;
            for (int j = 0; j < k; j++) {
                switch (sub.charAt(j)) {
                    case 'a', 'e', 'i', 'o', 'u' -> volCount++;
                }
            }
            if (volCount > maxVol) str = sub;
        }
        return str.equals("") ? "Not found!" : str;
    }
}
