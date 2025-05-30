package java_learning.D5_25;

/**
 *    并查集
 *    对外提供以下功能函数
 *    集合的代表元素查询 find（）
 *    集合的合并 union()
 *    判断元素是否属于同一个集合 isSameSet()
 *    增加两个优化操作 小挂大和扁平化
 *    扁平化 ： 在find函数中利用栈收集沿途经过的节点 最后将这些节点全部指向集合的代表节点
 *    小挂大 ： 小集合挂在大集合下面 两者的目的都是尽可能让结构中不出现很长的链条
 *    时间复杂度均摊下来就是O(1)
 *    横夺情况下可以省去小挂大的操作 同时在find函数中可以利用递归，让递归栈帮我们完成扁平化的操作
 * 
 * 
 *    Leetcode
 *    情侣交换问题
 *    相似字符串组（字母异位词）
 *    岛屿问题
 */

public class UnionSet {
    public static int MAXN = 1000001;
    public static int[] father = new int[MAXN];
    public static int[] size = new int[MAXN];
    public static int[] stack = new int[MAXN];
    public static int n;

    public static void build()
    {
       for(int i = 0; i < n; i++)
       {
           father[i] = i;
           size[i] = 1;
       }
    }

    public static int find(int i)
    {
        int size = 0;
        while(i != father[i])
        {
            stack[size++] = i;
            i = father[i];
        }
        while(size > 0)
        {
            father[stack[--size]] = i;
        }
        return i;
    }

    public static boolean isSameSet(int x,int y)
    {
        return find(x) == find(y);
    }

    public static void union(int x,int y)
    {
        if(!isSameSet(x, y))
        {
          int fatherx = find(x);
          int fathery = find(y);
          if(size[fatherx] > size[fathery])
          {
              father[fathery] = fatherx;
              size[fatherx] += size[fathery];
          }
          else{
              father[fatherx] = fathery;
              size[fathery] += size[fatherx];
          }
        }
    }
}