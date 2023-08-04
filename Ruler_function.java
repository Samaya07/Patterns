package rulerfunction;

import java.util.ArrayList;

public class Ruler_function {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ruler(5);
		

	}
	
	public static void ruler(int n) {
	      /* write your solution here */
	      
	      ArrayList<Integer> series=new ArrayList<Integer>();
	      recur(n+1,series);
	      for(int i=0;i<series.size();i++)
	      {
	          System.out.print(series.get(i)+" ");
	          
	      }
	      System.out.println();
	  }
	    public static void recur(int x,ArrayList<Integer> series)
	    {
	        if(x>1)
	        {
	            for(int j=1;j<x;j++)
	            {
	                series.add(j);
	                recur(j,series);
	            }
	        }
	    }

}
