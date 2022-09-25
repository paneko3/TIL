import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class PermutationWithRepetition {
    static int N,R;
    static int[] input, numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        input = new int[N];
        numbers = new int[R];
        st = new StringTokenizer(br.readLine()) ;
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        permutation(0);
    }
    public static void permutation(int cnt) {
        if(cnt == R) {
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 0; i < N; i++) {
            numbers[cnt] = input[i];
            permutation(cnt+1);
        }
    }
}

/* sample_input
4 2
1 2 3 4
 */