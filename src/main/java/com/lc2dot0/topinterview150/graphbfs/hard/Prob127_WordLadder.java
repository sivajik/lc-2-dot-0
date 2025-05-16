package com.lc2dot0.topinterview150.graphbfs.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Prob127_WordLadder {
    public static void main(String[] args) {
        System.out.println(ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<WordNode> q = new LinkedList<>();
        q.add(new WordNode(beginWord, 1));

        set.add(endWord); // if we dont add we never find this in set.

        while (!q.isEmpty()) {
            WordNode node = q.poll();
            String word = node.word;
            if (word.equals(endWord)) { // this is not possible with out line 20
                return node.steps;
            }

            char[] arr = word.toCharArray(); // hit
            for (int i = 0; i < arr.length; i++) {
                char temp = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String tempStr = new String(arr);
                    if (set.contains(tempStr)) {
                        q.add(new WordNode(tempStr, node.steps + 1));
                        set.remove(tempStr);
                    }
                }
                arr[i] = temp;
            }
        }

        return 0;
    }

    static class WordNode {
        String word;
        int steps;

        WordNode(String a, int steps) {
            this.word = a;
            this.steps = steps;
        }
    }
}


