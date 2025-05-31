import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class createGraph{
  // 图中节点的最大数量
  // 图中边的最大数量
  public static int MAXN = 11;
  public static int MAXM = 21;
  
  public static int[][] graph1 = new int[MAXN][MAXN];
  public static List<List<int[]>> graph2 = new ArrayList<>();

  public static int[] head = new int[MAXN];
  public static int[] next =  new int[MAXM];
  public static int[] to = new int[MAXM];
  public static int[] weight = new int[MAXM];
  public static int cnt;

  public static void initGraph(int n){
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        graph1[i][j] = 0;
      }
    }
    graph2.clear();
    for(int i = 0; i <= n; i++){
      graph2.add(new ArrayList<>());
    }
    cnt = 1;
    Arrays.fill(head,1,n + 1,0);
  }

  // 开始建图 可以分为无向图和有向图
  public static void buildGraph(int[][] edge){
      for(int i = 0; i < edge.length; i++){
        graph1[edge[i][0]][edge[i][1]] = edge[i][2];
        // graph1[edge[i][1]][edge[i][0]] = edge[i][2];
      }
      for(int i = 0;i < edge.length; i++){
        graph2.get(edge[i][0]).add(new int[]{edge[i][1], edge[i][2]}); 
        // graph2.get(edge[i][1]).add(new int[]{edge[i][0],edge[i][2]});
      }
      for(int[] cur : edge){
        addEdge(cur[0], cur[1], cur[2]);
      }
  }

  public static void addEdge(int u,int v,int w){
    next[cnt] = head[u];
    to[cnt] = v;
    weight[cnt] = w;
    head[u] = cnt++;
  }

  public static void traverseGraph(int n){
    System.out.println("邻接矩阵遍历：");
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        System.out.println(i + "->" + j + "权重为:" + graph1[i][j]);
      }
    }
    System.out.println("邻接表遍历：");
    for(int i = 1; i <= n; i++){
        for(int[] num : graph2.get(i)){
          System.out.println(i + "->" + num[0] + "权重为:" + num[1]);
        }
      }
    System.out.println("链式前向星遍历：");
    for(int i = 1; i <= n; i++){
      for(int ei = head[i]; ei > 0; ei = next[ei]){
        System.out.println(i + "->" + to[ei] + "权重为:" + weight[ei]);
      }
    }
    }

    public static void main(String[] args){
      int n = 4;
      int[][] edges = {{ 1, 3, 6 }, { 4, 3, 4 }, { 2, 4, 2 }, { 1, 2, 7 }, { 2, 3, 5 }, { 3, 1, 1 }};
      initGraph(n);
      buildGraph(edges);
      traverseGraph(n);
    }

  }
