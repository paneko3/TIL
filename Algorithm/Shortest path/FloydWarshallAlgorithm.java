import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FloydWarshallAlgorithm {
    static int INF = (int)1e9;
    static int n,m;
    static int[][] graph;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        n=Integer.parseInt(br.readLine());
        m=Integer.parseInt(br.readLine());
        graph=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],INF);
            if(i!=0){
                graph[i][i]=0;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[from][to]=dis;
        }
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    graph[i][j]=Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(graph[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

/* sample_input
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */
