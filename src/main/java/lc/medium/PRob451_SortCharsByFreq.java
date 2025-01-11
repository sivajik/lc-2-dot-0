package lc.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class PRob451_SortCharsByFreq {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
        System.out.println(frequencySort("cccaaa"));
        System.out.println(frequencySort("Aabb"));
    }

    static public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                map.put(c, 1 + map.get(c));
            } else {
                map.put(c, 1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.freq - o1.freq;
            }
        });

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        StringBuilder sbr = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            sbr.append(String.valueOf(p.c).repeat(Math.max(0, p.freq)));
        }

        return sbr.toString();
    }

    static class Pair {
        char c;
        int freq;

        Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
