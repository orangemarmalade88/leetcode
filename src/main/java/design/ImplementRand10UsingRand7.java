package design;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        return helper(rand7());
    }

    public int helper(int r) {
        int temp = rand7() * r; // [1 -> 7 * r]
        int d = temp / 10;
        if (temp <= d * 10) // [1 -> d * 10]
            return temp % 10 + 1;
        else // [d*10 + 1 -> 7 * r]
            return helper(temp - d * 10);
    }

    private int rand7() {
        return -1;
    }
}
