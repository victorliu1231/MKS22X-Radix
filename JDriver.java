import java.util.*;
public class JDriver {
  public static void main(String[] args) {
    int size = Integer.parseInt(args[0]);
    int range = Integer.parseInt(args[1]);
    Random r = new Random((int)System.currentTimeMillis());
    int[] ary = new int[size];
	int[] copy = new int[size];
    for(int i = 0; i < ary.length; i++) {
      ary[i] = (int)(Math.random() * range);
	  copy[i] = ary[i];
    }
	Arrays.sort(copy);
	long x = System.currentTimeMillis();
	Radix.radixsort(ary);
	x = System.currentTimeMillis() - x;
    System.out.println(x + " milliseconds");
	System.out.println(Arrays.equals(ary,copy));

  }


}
