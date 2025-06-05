package D6_5;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *     输入两个整数  n m
 *     生成1-n范围上的全排列 按照字典序从小到大的顺序 选择第m个排列打印出来
 */

public class dfs{
    public static int MAXN = 10;
    public static boolean[] visited = new boolean[MAXN];
    public static int m;
    public static int n;
    public static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      m = sc.nextInt();
      Arrays.fill(visited,false);
      List<Integer> path = new ArrayList<>();
      dfs(path,0);
      for(int num : result){
        System.out.print(num + " ");
      }
    }

    public static void dfs(List<Integer> path,int index){
      if(index == n){
          if(--m == 0){
            for(int i = 0; i < path.size(); i++){
              result.add(path.get(i));
            }
            return;
          }
      }
      for(int i = 1; i <= n; i++){
        if(!visited[i]){
          visited[i] = true;
          path.add(i);
          dfs(path,index + 1);
          path.remove(path.size() - 1);
          visited[i] = false;
        }
      }
      return;
    }
}