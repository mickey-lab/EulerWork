public class Euler40 {

    public static void main(String[] args) {
        int total = 1;
        for (int i = 0; i < 6; i++) {
            total *= chap((int) Math.pow(10, i) - 1);
        }
        System.out.println(total);
    }

    public static int chap(int n) {
        int degree = 0;
        int position;
        WHILE:
        while (true) {
            for (int i = (int) (Math.pow(10, degree)); i < Math.pow(10, degree + 1); i++) {
                if (n <= degree) {
                    position = i;
                    break WHILE;
                }
                n -= (degree + 1);
            }
            degree++;
        }
        return Integer.parseInt(Character.toString(String.valueOf(position).charAt(n)));
    }

}
