import java.util.Scanner;
public class Array2d {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        int[][] a = new int[n][m];

        // input

        for(int i = 0; i < a.length; i++) {

            for(int j = 0; j < a[i].length; j++) {

                a[i][j] = sc.nextInt();

            }

        }

        // output

        for(int i = 0; i < a.length; i++) {

            for(int j = 0; j < a[i].length; j++) {

                System.out.print(a[i][j] + " ");

            }

            System.out.println();

        }

	}

}
