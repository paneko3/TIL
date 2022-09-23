import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DisjointSetsAlgorithm_2 {
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
        for(int i=0;i<e;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b  = Integer.parseInt(st.nextToken());
            unionParents(a,b);
        }
        System.out.print("각 원소가 속한 집합: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();
        System.out.print("부모 테이블: ");
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();
    }
}

/* sample_input
6 4
1 4
2 3
2 4
5 6
 */