import java.util.*;https://github.com/Molotov13/ArrayListAssignment2/blob/main/ArrayListAssignment2
class Main{
  public static ArrayList<Integer> EraSieve(int n){
    int[] nums = new int[n];
    for(int i = 2 ; i < n ; i ++) nums[i] = i;
    for(int i = 2 ; i < n ; i ++){
      if(nums[i] == 0) continue;
      for(int j = 2 ; nums[i] * j < n ; j ++){
        nums[nums[i] * j] = 0;
      }
    }
    ArrayList<Integer> res = new ArrayList<Integer>();
    for(int i = 2 ; i < n ; i ++){
      if(nums[i] != 0) res.add(i);
    }
    return res;
  }
  public static void Goldbach(int x){
    ArrayList<Integer> primes = EraSieve(x);
    HashMap<Integer,Integer> hax = new HashMap<Integer,Integer>();
    for(int i:primes){
      if(primes.contains(x-i)){
        System.out.print(i+","+(x-i));
        return ;
      }
    }
  }
  public static ArrayList<Integer> add(ArrayList<Integer> a, ArrayList<Integer> b){
    Collections.reverse(a);
    Collections.reverse(b);
    ArrayList<Integer> res = new ArrayList<>(a);
    int ten = 0;
    for(int i = 0 ; i < Math.min(a.size(),b.size()); i ++){
      int cur = a.get(i) + b.get(i) + ten;
      ten = 0;
      if(cur >= 10){
        ten = 1;
        cur -= 10;
      }
      res.set(i,cur);
    }
    Collections.reverse(res);
    return res;
  }
  public static void main(String[]args){
    System.out.println(EraSieve(20));
    System.out.println(Goldbach(20));
    ArrayList<Integer> a = new ArrayList<Integer>();
    a.add(1);
    a.add(9);
    a.add(2);
    a.add(6);
    a.add(0);
    a.add(8);
    a.add(1);
    a.add(7);
    ArrayList<Integer> b = new ArrayList<Integer>();
    b.add(4);
    b.add(3);
    b.add(2);
    b.add(1);
    System.out.println(add(a,b));
    return ;
  }  
}
