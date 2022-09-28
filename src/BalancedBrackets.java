/*
* A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

By this logic, we say a sequence of brackets is balanced if the following conditions are met:

It contains no unmatched brackets.
The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return true. Otherwise, return false.

Function Description

Complete the function isBalanced in the editor below.

isBalanced has the following parameter(s):

string s: a string of brackets
Returns

boolean: either true or false
Input Format

s contains a single string , a sequence of brackets.

Constraints

All characters in the sequences ∈ { {, }, (, ), [, ] }.
*
* */

package src;

import java.util.ArrayList;
import java.util.List;

public class BalancedBrackets {

    public static void main(String[] args) {
        System.out.println(isBalanced("{}[]{}{{((){}{()()})}}()"));
        System.out.println(isBalanced("{[(])}"));
        System.out.println(isBalanced("{{[[(())]]}}"));
    }

    static boolean isBalanced(String s) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int lastIndex = list.size() - 1;
            if (
                    (list.size() == 0 && (c == '}' || c == ')' || c == ']')) ||
                            (c == '}' && list.get(lastIndex) != '{') ||
                            (c == ')' && list.get(lastIndex) != '(') ||
                            (c == ']' && list.get(lastIndex) != '[')
            )
                return false;
            if (c == '}' || c == ')' || c == ']')
                list.remove(lastIndex);
            else list.add(c);
        }
        return list.size() == 0;
    }
}
