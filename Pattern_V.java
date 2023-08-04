package vpattern;

public class Pattern_V {
	public static void Vfinder(char[][] A)
	{
		int n=A.length;
	    int m=A[0].length;
	    int[] myArray=new int[n*m]; // array to store the maximum length sequence of each 'V'
	    int t=0;
	    int count=0;//keeps count of number of 'V's
	    for(int i=0;i<n;i++)//loop to access rows
	    {
	        for(int j=0;j<m;j++)// loop to access columns
	        {
	            int h=0,v=0,d=0,l=0,maximum=0;
	            if(Character.compare(A[i][j],'V')==0)//check if the element is 'V'
	            {
	                count++;
	                int counth=1,countv=1,countd=1,countl=1;//keeps count of length  of sequences horizontally, vertically, diagnally and left diagnally
	                h=checkHorizontal(i,j,n,m,A,counth);//recursive function checks the entire row to find 'V' and returns the number
	                v=checkVertical(i,j,n,m,A,countv);
	                d=checkDiagnol(i,j,n,m,A,countd);
	                l=checkDiagnolLeft(i,j,n,m,A,countl);
	                int[] tempArray=new int[4];//storing the counts to find max 
	                tempArray[0]=h;
	                tempArray[1]=v;
	                tempArray[2]=d;
	                tempArray[3]=l;
	                maximum=tempArray[0];//max sequence for one 'V'
	                for(int k=1;k<4;k++)
	                {
	                    if(tempArray[k]>maximum)
	                    {
	                        maximum=tempArray[k];
	                    }
	                }
	                myArray[t]=maximum;//storing the max of each 'V'
	                t++;
	            }
	        }
	    }
	    int maxim=0;
	    maxim=myArray[0];
	    for(int i=1;i<count;i++)// finding max of all 'V's
	    {
	        if(myArray[i]>maxim)
	        {
	            maxim=myArray[i];
	        }
	    }
	    System.out.println(maxim);
	}
	public static int checkHorizontal(int a,int b,int n,int m,char[][]A,int counth)
	{
	    if(b==m-1)//the columns dont exceed m
	    {
	        return counth;
	    }
	    else
	    {
	        if(Character.compare(A[a][b+1],'V')==0) //check if next element in same row is 'V'
	        {
	            counth++;//increment counth if it is 'V'
	            return checkHorizontal(a,b+1,n,m,A,counth);//recursive function to keep checking
	        }
	    }
	    return counth;//returns counth once there is a '*' and not 'V'
	}
	public static int checkVertical(int a,int b,int n,int m,char[][]A,int countv)
	{
	    if(a==n-1)
	    {
	        return countv;
	    }
	    else
	    {
	        if(Character.compare(A[a+1][b],'V')==0)
	        {
	            countv++;
	            return checkVertical(a+1,b,n,m,A,countv);
	        }
	    }
	    return countv;
	}
	public static int checkDiagnol(int a,int b,int n,int m,char[][]A,int countd)
	{
	    if(a==n-1 || b==m-1)
	    {
	        return countd;
	    }
	    else
	    {
	        if(Character.compare(A[a+1][b+1],'V')==0)
	        {
	            countd++;
	            return checkDiagnol(a+1,b+1,n,m,A,countd);
	        }
	    }
	    return countd;
	}
	public static int checkDiagnolLeft(int a,int b,int n,int m,char[][]A,int countl)
	{
	    if(a==n-1 || b==0)
	    {
	        return countl;
	    }
	    else
	    {
	        if(Character.compare(A[a+1][b-1],'V')==0)
	        {
	            countl++;
	            return checkDiagnolLeft(a+1,b-1,n,m,A,countl);
	        }
	    }
	    return countl;
	}
	
	public static void main(String[] args)
	{
		char[][] array= {{'*','V','*','*','*'},
				         {'V','V','V','*','V'},
				 	     {'*','*','V','*','V'},
				         {'V','V','*','V','*'},
				         {'*','*','V','V','V'}};
		Vfinder(array);
		
		
	}

}
