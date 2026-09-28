import java.util.Scanner;
import java.io.File;

public class Satellite {


    static int[][] readImage(Scanner in, int n, int m) {
        int[][] img = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                img[i][j] = in.nextInt();
        return img;
    }

    static int pick(int cur, int v, boolean min) {
        return min ? Math.min(cur, v) : Math.max(cur, v);
    }


    static int bound(int[][] a, int[][] b, boolean rows, boolean min) {
        int best = min ? Integer.MAX_VALUE : 0;
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[i].length; j++)
                if (a[i][j] != b[i][j])
                    best = pick(best, (rows ? i : j) + 1, min);
        return best;
    }

    static void report(int[][] a, int[][] b) {
        if (bound(a, b, true, false) == 0) {
            System.out.println("NO DIFFERENCE");
            return;
        }
        System.out.println(bound(a, b, true, true) + " " + bound(a, b, false, true) + " "
                + bound(a, b, true, false) + " " + bound(a, b, false, false));
    }

    public static void main(String[] args) throws Exception {
        Scanner in = args.length > 0 ? new Scanner(new File(args[0])) : new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] oldImg = readImage(in, n, m);
        int[][] newImg = readImage(in, n, m);
        report(oldImg, newImg);
    } }

