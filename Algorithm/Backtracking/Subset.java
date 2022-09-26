import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Subset {
    static int N;
    static int[] input;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        input = new int[N];
        isSelected = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        subset(0);
    }
    public static void subset(int cnt) {
        if (cnt == N) {
            for (int i = 0; i < N; i++) {
                System.out.print((isSelected[i] ? input[i] : "X") + " ");
            }
            System.out.println();
            return;
        }
        isSelected[cnt] = true;
        subset(cnt + 1);
        isSelected[cnt] = false;
        subset(cnt + 1);
    }
}

/* sample_input
4
1 2 3 4
 */