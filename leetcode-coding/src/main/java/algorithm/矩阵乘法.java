package algorithm;

import java.util.Scanner;

public class 矩阵乘法 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {

            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int[][] array1 = new int[x][y];
            int[][] array2 = new int[y][z];
            int[][] array3 = new int[x][z];

            // 注意换行否则下一行nextLine会拿到空字符串
            scanner.nextLine();
            for (int i = 0; i < x; i++) {
                String string = scanner.nextLine();
                String[] str = string.split(" ");
                int j = 0;
                for (String string2 : str) {
                    if (!"".equals(string2)) {
                        array1[i][j] = Integer.valueOf(string2);
                        j++;
                    }
                }

            }

            for (int i = 0; i < y; i++) {
                String string = scanner.nextLine();
                String[] str = string.split(" ");
                int j = 0;
                for (String string2 : str) {
                    if (!"".equals(string2)) {
                        array2[i][j] = Integer.valueOf(string2);
                        j++;
                    }

                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    for (int k = 0; k < y; k++)
                        array3[i][j] += array1[i][k] * array2[k][j];// 每行乘以每列再相加

                }
            }

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    System.out.print(array3[i][j] + " ");

                }
                System.out.println();
            }

        }
    }

}
