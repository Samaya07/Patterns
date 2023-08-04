package spiral;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral_pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<List<Integer>> myArr= new ArrayList<List<Integer>>();
		myArr.add(Arrays.asList(5,2,12,9));
		myArr.add(Arrays.asList(-7,9,20,-1));
		myArr.add(Arrays.asList(4,-5,29,1));
		myArr.add(Arrays.asList(-4,-15,23,45));
		spiral_patt(myArr);
		
		

	}
	
	public static void spiral_patt(ArrayList<List<Integer>> myArr2) {
	      /* write your solution here */
	      int n=myArr2.size();
	      int m=0,k=0,a=0,s=0;
	      int[] myArr=new int[n*n];
	      int[] resultArr=new int[n*n];
	      resultArr= spiralh(myArr2,n-1,a,myArr,m,k,s);
	      for(int i=0;i<n*n;i++)
	      {
	          System.out.print(resultArr[i]+" ");
	      }
	      System.out.println();
	  }
	    /*arr= array given
	    n=number of integers to consider for one function
	    a=the varying row/column to start from in the array given
	    myArr= the array that stores the result
	    m=the fixed row/column to traverse in the array given
	    k=holds the index of the result array*/
	    public static int[] spiralh(ArrayList<List<Integer>> myArr2,int n,int a,int[]myArr,int m,int k,int s)
	    {
	        for(int i=a;i<=n;i++)
	        {
	            myArr[k]=myArr2.get(m).get(i);
	            k++;
	        }
	        if(k==n*n)
	        {
	            return myArr;
	        }
	        return spiralv(myArr2,n,a+1,myArr,n,k,s);
	    }
	    public static int[] spiralv(ArrayList<List<Integer>> myArr2,int n,int a,int[]myArr,int m,int k,int s)
	    {
	        for(int i=a;i<=n;i++)
	        {
	            myArr[k]=myArr2.get(i).get(m);
	            k++;
	        }
	        if(k==n*n)
	        {
	            return myArr;
	        }
	        return spirallh(myArr2,n,n-1,myArr,n,k,s);
	    }
	    public static int[] spirallh(ArrayList<List<Integer>> myArr2,int n,int a,int[]myArr,int m,int k,int s)
	    {
	        for(int i=a;i>=s;i--)
	        {
	            myArr[k]=myArr2.get(m).get(i);
	            k++;
	        }
	        if(k==n*n)
	        {
	            return myArr;
	        }
	        return spiraluv(myArr2,n-1,a,myArr,s,k,s+1);
	    }
	    public static int[] spiraluv(ArrayList<List<Integer>> myArr2,int n,int a,int[] myArr,int m,int k,int s)
	    {
	        for(int i=a;i>=s;i--)
	        {
	            myArr[k]=myArr2.get(i).get(m);
	            k++;
	        }
	        if(k==n*n)
	        {
	            return myArr;
	        }
	        return spiralh(myArr2,n,s,myArr,m+1,k,s);
	    }

}
