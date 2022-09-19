import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort {
    static int v,e=0;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        indegree=new int[v+1];
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            indegree[b]++;
        }
        topologySort();
    }
    static void topologySort(){
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=v;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            int now =queue.poll();
            result.add(now);
            for(int i=0;i<graph.get(now).size();i++){
                indegree[graph.get(now).get(i)]--;
                if(indegree[graph.get(now).get(i)]==0){
                    queue.add(graph.get(now).get(i));
                }
            }
        }
        for (int i =0;i<result.size();i++){
            System.out.print(result.get(i)+" ");
        }
    }
}

/* sample_input
7 8
1 2
1 5
2 3
2 6
3 4
4 7
5 6
6 4
 */