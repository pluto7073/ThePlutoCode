package io.pex64;

import java.util.Stack;

public class Pex64 {

    public static String flipString(String s) {
        char[] array1 = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        char[] array2 = new char[s.length()];
        for (char c : array1)
            charStack.add(0, c);
        for (int i = 0; i < charStack.size(); i++) {
            char c = charStack.get(i);
            array2[i] = c;
        }
        return new String(array2);
    }

}
