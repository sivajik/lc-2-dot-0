package com.lc2dot0.topinterview150.stack.medium;

import java.util.Stack;

public class Prob71_SimplifyPath {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/home//foo/"));
        System.out.println(simplifyPath("/home/user/Documents/../Pictures"));
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }

    public static String simplifyPath(String path) {
        String[] tokens = path.split("/");
        Stack<String> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (t.equals(".") || t.isEmpty()) {
                continue;
            } else if (t.equals("..")) {
                if (!s.isEmpty()) {
                    s.pop();
                }
            } else {
                s.push(t);
            }
        }

        StringBuilder sbr = new StringBuilder();
        for (String str : s) {
            sbr.append("/");
            sbr.append(str);
        }
        return !sbr.isEmpty() ? sbr.toString() : "/";
    }
}
