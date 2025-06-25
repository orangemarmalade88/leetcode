package design;

public class ImplementRand10UsingRand7 {
    public int rand10() {
        int result = 100;
        while (result > 40) {
            result = 7 * (rand7() - 1 ) + rand7();  // [1 - 49]
        }
        return result % 10 + 1;
    }

    private int rand7() {
        return -1;
    }
}
