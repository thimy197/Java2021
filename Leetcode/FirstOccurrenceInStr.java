package com.alibou.aws.test;

public class FirstOccurrenceInStr {
    public static void main(String[] args) {
        String hayStack = "a";
        String needle = "a";
        System.out.println(new FirstOccurrenceInStr().strStr(hayStack, needle));
    }

    public int strStr(String haystack, String needle) {
        for (int i = 0; i <= haystack.length() - needle.length(); i++ ) {
            int j = 0;
            while (j < needle.length()) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            if (j == needle.length()) return i;
        }
//        using substring
//        for (int i = 0; i <= haystack.length() - needle.length(); i++ ) {
//            if (haystack.substring(i, i + needle.length()).equals(needle)) return i;
//        }
        return -1;
    }
}
