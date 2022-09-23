import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DisjointSetsAlgorithm_3 {
    static int v,e;
    static int[] parent;
    static int findParent(int x){
        if(parent[x]==x ) return x;
        return parent[x]=findParent(parent[x]);
    }
    static void unionParents(int a,int b){
        a= findParent(a);
        b=findParent(b);
        if(a>b){
            parent[a]=b;
        }else{
            parent[b]=a;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        parent=new int[v+1];
        for(int i=1;i<=v;i++){
            parent[i]=i;
        }
        boolean cycle = false;
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            if(findParent(a)==findParent(b)){
                cycle=true;
                break;
            }
            unionParents(a,b);
        }
        System.out.print(cycle);
    }
}

/* sample_input
3 3
1 2
1 3
2 3
 */