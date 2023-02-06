
public class VaibhaviTest3 {

    private static void fundCount(int x, int y) {
        int answer = 0;
        for (int i = 0; i < x;) {
            int curr = 0;
            int temp = i;
            while (temp != 0) {
                curr += (temp % 10);
                temp /= 10;
            }
            if (curr == y) {
                answer++;
                i += 9;
            } else {
                i++;
            }
        }
        System.out.println(answer);
    }

    public static void main(String[] args) {
        fundCount(20, 5);
        fundCount(10, 3);
    }
}
