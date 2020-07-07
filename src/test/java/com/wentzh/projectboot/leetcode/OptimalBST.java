package com.wentzh.projectboot.leetcode;
 
import java.util.Scanner;
 
public class OptimalBST {
 
	private double[] p;
	private double[] q;
	private int n;
	
	private double[][] e;
	private double[][] w;
	private int[][] root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OptimalBST sample=new OptimalBST();
		sample.getInputInfo();
		sample.optimalBST();
		sample.constructOptimalBST(sample.root, 1, sample.n);
		
	}
	
	public void getInputInfo()
	{
		System.out.println("输入关键字的个数");
		Scanner in=new Scanner(System.in);
		this.n=in.nextInt();
		p=new double[n+1];
		q=new double[n+1];
		System.out.println("依次输入"+this.n+"个关键字的概率p");
		for(int i=0;i<n;i++)
		{
			p[i+1]=in.nextDouble();
		}
		System.out.println("依次输入"+(this.n+1)+"个非关键字的概率q");
		for(int i=0;i<=n;i++)
		{
			q[i]=in.nextDouble();
		}
		
	}
	
	public void optimalBST()
	{
		e=new double[n+2][n+1];
		w=new double[n+2][n+1];
		root=new int[n+1][n+1];
		
		for(int i=1;i<n+2;i++)
		{
			e[i][i-1]=q[i-1];
			w[i][i-1]=q[i-1];
		}
		
		for(int l=1;l<=n;l++)
		{
			for(int i=1;i<=n-l+1;i++)
			{
				int j=i+l-1;
				e[i][j]=Double.MAX_VALUE;
				w[i][j]=w[i][j-1]+p[j]+q[j];
				for(int r=i;r<=j;r++)
				{
					double t=e[i][r-1]+e[r+1][j]+w[i][j];
					if(t<e[i][j])
					{
						e[i][j]=t;
						root[i][j]=r;
					}
				}
			}
		}
		
	}
	
	public void constructOptimalBST(int[][] root,int i,int j)
	{
		int r=root[i][j];
		if(i==1&&j==this.n)
		{
			System.out.println("k"+r+"是根");
		}
		if(r-1<i)
		{
			System.out.println("d"+(r-1)+" 是 k"+r+"的左子树");
		}else
		{
			System.out.println("k"+root[i][r-1]+" 是 k"+r+"的左子树");
			constructOptimalBST(root,i,r-1);
		}
		
		if(j<r+1)
		{
			System.out.println("d"+j+" 是 k"+r+"的右子树");
		}else
		{
			System.out.println("k"+root[r+1][j]+" 是 k"+r+"的右子树");
			constructOptimalBST(root,r+1,j);
		}
	}
	
	
}