package algorithm;

public class 自守数 {

    public static int CalcAutomorphicNumbers(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            if (yes(i)) {
                System.out.println(i+","+i*i);
                sum++;
            }
        }

        return sum;
    }

    public static boolean yes(int num) {
        String sum = num * num + "";
        String son = num + "";
        int index = sum.length() - 1;
        for (int i = son.length() - 1; i >= 0; i--) {
            if (!(son.charAt(i) == sum.charAt(index))) {
                return false;
            }
            index--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CalcAutomorphicNumbers(400));
    }
}
