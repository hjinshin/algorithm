package 삼성SW기출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16235_나무_재테크 {
    static int[] dy = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dx = {-1, 0, 1, -1, 0, 1, -1, 1};
    static int N, M, K;
    static int[][] A;
    static int[][] land;
    static Deque<Tree> trees = new LinkedList<>();
    static Queue<Tree> deadTrees = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N + 1][N + 1];
        land = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            trees.add(new Tree(y, x, z));
        }
        initLand();

        while (K-- > 0) {
            eatNutrients();
            deadTreesBecomeNutrients();
            reproduceTrees();
            giveNutrients();
        }

        System.out.println(trees.size());
    }

    static void initLand() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                land[i][j] = 5;
            }
        }
    }

    static void eatNutrients() {
        int len = trees.size();
        for(int i = 0; i < len; i++) {
            Tree tree = trees.poll();
            int y = tree.y, x = tree.x;
            if (land[y][x] < tree.age) {
                deadTrees.add(tree);
                continue;
            }
            land[y][x] -= tree.age;
            trees.add(new Tree(y, x, tree.age + 1));
        }
    }

    static void deadTreesBecomeNutrients() {
        while(!deadTrees.isEmpty()) {
            Tree tree = deadTrees.poll();
            land[tree.y][tree.x] += tree.age / 2;
        }
    }

    static void reproduceTrees() {
        List<Tree> temp = new ArrayList<>();
        for (Tree tree : trees) {
            if (tree.age % 5 == 0) {
                temp.add(tree);
            }
        }

        for(Tree tree : temp) {
            for (int d = 0; d < 8; d++) {
                int ny = tree.y + dy[d];
                int nx = tree.x + dx[d];
                if(ny <= 0 || ny > N || nx <= 0 || nx > N) continue;
                trees.addFirst(new Tree(ny, nx, 1));
            }
        }
    }

    static void giveNutrients() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                land[i][j] += A[i][j];
            }
        }
    }

    static class Tree {
        int y, x, age;

        Tree(int y, int x, int age) {
            this.y = y;
            this.x = x;
            this.age = age;
        }
    }
}
