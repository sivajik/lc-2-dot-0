package lc.easy;

import java.util.HashSet;
import java.util.Set;

public class Prob0202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(199));
    }

    static public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (true) {
            n = getSumOfDigits(n);
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    static int getSumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += (digit * digit);
            n = n / 10;
        }
        return sum;
    }
}
