import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraAlgorithm_1 {
    static int INF = Integer.MAX_VALUE;
    static int n,m,start;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] d;

    static class Node{
        int index, distance;
        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        public int getIndex() {
            return index;
        }
        public int getDistance() {
            return distance;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()) ;
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(br.readLine());
        visited=new boolean[n+1];
        d=new int[n+1];
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<Node>());
        }
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to,dis));
        }
        Arrays.fill(d,INF);
        dijkstra(start);
        for (int i = 1; i <= n; i++) {
            System.out.println(d[i] == INF?"INFINITY":d[i]);
        }
    }
    static void dijkstra(int start){
        d[start]=0;
        visited[start]= true;
        for(int i=0;i<graph.get(start).size();i++){
            d[graph.get(start).get(i).getIndex()]=graph.get(start).get(i).getDistance();
        }
        for(int i=0;i<n-1;i++){
            int now = getSmallestNode();
            visited[now]=true;
            for(int j=0;j<graph.get(now).size();j++){
                int cost =d[now]+graph.get(now).get(j).getDistance();
                if(cost<d[graph.get(now).get(j).index]){
                    d[graph.get(now).get(j).index]=cost;
                }
            }
        }
    }
    static int getSmallestNode(){
        int min=INF;
        int index=0;
        for(int i=1;i<=n;i++){
            if(d[i]<min&&!visited[i]){
                min=d[i];
                index=i;
            }
        }
        return index;
    }
}

/* sample_input
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
