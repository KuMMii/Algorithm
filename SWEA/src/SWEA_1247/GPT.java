package SWEA_1247;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GPT {
    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N; // 고객 수
    static Pos comp, home; // 회사, 집 좌표
    static Pos[] custPos; // 고객 좌표 배열
    static boolean[] visited;
    static int ans;

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("src/SWEA_1247/input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            comp = new Pos(sc.nextInt(), sc.nextInt());
            home = new Pos(sc.nextInt(), sc.nextInt());

            custPos = new Pos[N];
            visited = new boolean[N];
            ans = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                custPos[i] = new Pos(sc.nextInt(), sc.nextInt());
            }

            perm(0, comp, 0);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    public static void perm(int idx, Pos curr, int dist) {
        if (dist >= ans) return;

        if (idx == N) {
            ans = Math.min(ans, dist + Math.abs(curr.x - home.x) + Math.abs(curr.y - home.y));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm(idx + 1, custPos[i], dist + Math.abs(curr.x - custPos[i].x) + Math.abs(curr.y - custPos[i].y));
                visited[i] = false;
            }
        }
    }
}
