package com.pranavacharya.hackerrank;

import java.util.ArrayList;
import java.util.List;

public class UsernameChanges {

    public static List<String> possibleChanges(List<String> usernames) {
        // Write your code here
        List<String> result = new ArrayList();
        for (int i = 0; i < usernames.size(); i++) {
            String uname = usernames.get(i);
            if (isChangeable(uname)) {
                result.add("YES");
            } else {
                result.add("NO");
            }
        }
        return result;
    }

    private static boolean isChangeable(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
            for (int i = c - 'a' + 1; i < freq.length; i++) {
                if (freq[i] != 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
