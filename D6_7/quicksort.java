package D6_7;
import java.lang.Math;


public class quicksort {
  public static int first;
  public static int last;
  public static void main(String[] args) {
    int[] nums = new int[]{2,3,2,5,6,8,1,6,4};
    quicksort(nums,0,nums.length - 1);
    for(int num : nums){
      System.out.print(num + " ");
    }
  }

  public static void quicksort(int[] nums,int l, int r){
    if(l > r) return;
      int val = nums[l + (int)(Math.random() * (r - l + 1))];
      partition(nums,l,r,val);
      quicksort(nums,l,first - 1);
      quicksort(nums,last + 1, r);
  }

  // start 指向
  public static void partition(int[] nums,int l,int r,int val){
    int start = l;
    int end = r;
    int i = l;
    while(i <= end){
      if(nums[i] < val) swap(nums,i++,start++);
      else if(nums[i] == val) i++;
      else swap(nums,i,end--);
    }
    first = start;
    last = end;
  }

  public static void swap(int[] nums,int i,int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
}
