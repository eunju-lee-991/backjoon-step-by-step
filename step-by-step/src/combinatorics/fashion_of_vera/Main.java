package combinatorics.fashion_of_vera;

import java.io.*;

// 15439 - 베라의 패션
public class Main {
    static int N;
    static int count = 0;

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        br.close();

        boolean[] visited = new boolean[N];
        dfs_perm(0, visited);
//        dfs_comb(0, 0, visited);
//        dfs(0, 0);

        bw.write(count + "");
        bw.flush();
        bw.close();
    }

    static void dfs(int index, int pick) {
        if (pick == 2) {
            count++;
            return;
        }
        for (int i = index; i < N; i++) {
            dfs(i + 1, pick + 1);
        }
    }


    static void dfs_comb(int index, int pick, boolean[] visited) {
        if (pick == 3) {
            count++;
            // visited까지 출력하는 ver도 구현!
            // 아 ㅇㅣ 때는 visited 체크 로직이 필요?
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                System.out.print(i + " ");
                visited[i] = true;
                dfs_comb(i + 1, pick + 1, visited);
                visited[i] = false;
            }
        }
    }

    static void dfs_perm(int pick, boolean[] visited) {
        if (pick == 2) {
            count++;

            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs_perm(pick + 1, visited);
                visited[i] = false;
            }
        }
    }

}
