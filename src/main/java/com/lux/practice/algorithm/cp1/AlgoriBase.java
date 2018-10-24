package com.lux.practice.algorithm.cp1;

import java.util.Random;
import java.util.Scanner;

import org.junit.Test;

import com.lux.practice.algorithm.utils.PrintUtils;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author huanxin
 * 
 * 参考链接：https://www.cnblogs.com/gotodsp/p/4319865.html
 *
 */
public class AlgoriBase {

	
//	@Test
	public void pra1() {
		System.out.println("(0 + 15)/2 = " + ((0 + 15)/2));
		System.out.println("(2.0e-6 * 100000000.1) = " + (2.0e-6 * 100000000.1));
		System.out.println("(true && false || true && true) = " + (true && false || true && true));
	}
	
//	@Test
	public void pra2() {
		System.out.println("((1 + 2.236) / 2) = " + ((1 + 2.236) / 2));
		System.out.println("(1 + 2 + 3 + 4.0) = " + (1 + 2 + 3 + 4.0));
		System.out.println("(4.1 >= 4) = " + (4.1 >= 4));
		System.out.println("(1 + 2 + \"3\") = " + (1 + 2 + "3")); //33
	}
	
//	@Test
	public void pra4() {
		int f=0, g=1;
		for(int i=0;i<=15; i++) {
			System.out.println(f);
			f = f + g;
			g = f - g;
		}
	}
	
//	@Test
	public void pra7() {
		double t = 9.0;
		while (Math.abs(t -9.0/t) > .001) 
			t = (9.0/t + t) / 2.0;
		System.out.println(String.format("%.5f\n", t));
		
		int sum=0;
		for(int i=1;i<1000;i++) 
			for(int j=0;j<i;j++)
				sum++;
		System.out.println(sum);
		
		//输出2的n次方-1
		sum=0;
		for(int i=1;i<1000;i *= 2) 
			for(int j=0;j<i;j++)
				sum++;
		System.out.println(sum);
	}
	
//	@Test
	public void pra8() {
		System.out.println('b');
		
		System.out.println('b' + 'c');
		
		System.out.println((char)('a' + 4));
	}
	
//	@Test
	public void pra11() {
		boolean a[][] = new boolean[4][4];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if((i + j) % 2 == 0) {
					a[i][j] = true;
				}
			}
		}
		printBoolArray(a, 4, 4);
	}
	
	public void printBoolArray(boolean a[][], int row, int col){
	    for(int i=1; i<=row+1; i++){
	        for(int j=1; j<=col+1; j++){
	            if(i==1){
	                if(j==col+1)
	                    break;
	                System.out.print("  "+j);
	                continue;
	            }
	            else{
	                if(j==1)
	                    System.out.print(i-1+" ");
	                else{
	                    if(a[i-2][j-2]==true)   System.out.print("*  ");
	                    else System.out.print("   ");
	                }
	            }
	        }
	        System.out.println();
	    }
	}
	
//	@Test
	public void pra13() {
		Random rand = new Random();
		Integer[][] a = new Integer[4][4];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				a[i][j] = rand.nextInt(10) ;//生成0-100以内的随机数
			}
		}
		PrintUtils.printIntegerArray(a, 4, 4);
		System.out.println("---------------------------------------");
		Integer[][] b=new Integer[4][4];
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				b[i][j] = a[j][i];
			}
		}
		PrintUtils.printIntegerArray(b, 4, 4);
	}
	
//	@Test
	public void pra14() {
		double d = 12.12;
		int i = lg(d);
		System.out.println(i);
		System.out.println("-----------------------------");
		System.out.println(Math.log(d)/Math.log(2));
	}
	
	public int lg(double N) {
		int k=0;
		if(N>0&&N<1) {
			double count=1;
			while(count>=N) {
				count*=1/2.0;
				k-=1;
			}
			return k+1;
		} else if(N>=1) {
			int count=1;
			while(count<=N) {
				count*=2;
				k+=1;
			}
			return k-1;
		}
		else 
			return -1;
	}
	
//	@Test
	public void pra15() {
		int arr[] = {1, 2, 4, 5, 3, 5, 3, 4, 3, 5, 4, 2, 4, 5, 4, 5};
		int a[] = histogram(arr, arr.length);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]);
		}
	}
	
	int[] histogram(int arr[],int m) {  
        int a[]=new int[m];  
        for(int i=0;i<m;i++) {  
            a[i]=0;//依次遍历  
            for(int j=0;j<arr.length;j++)  {  
                if(arr[j]==i) a[i]++;  
            }  
        }  
          
        return a;  
    }
	
//	@Test
	public void pra16() {
		System.out.println(exR1(6));
	}
	
	String exR1(int n) {
		if(n <= 0) return "";
		return exR1(n - 3) + n + exR1(n - 2) + n;
	}
	
//	@Test
	public void pra18() {
		System.out.println(mystery(2, 25));// 2+16+32
		System.out.println(mystery(3, 11));// 3+6+24
		System.out.println(mystery2(2, 25));// 2+256+65536
		System.out.println(mystery2(3, 11));// 3+9+81*81
	}
	
	int mystery(int a, int b) {
		if(b == 0) return 0;
		if(b % 2 == 0) return mystery(a + a, b/2);
		System.out.print(a + " ");
		return mystery(a + a, b/2) + a;
	}
	
	int mystery2(int a, int b) {
		if(b == 0) return 0;
		if(b % 2 == 0) return mystery2(a * a, b/2);
		System.out.print(a + " ");
		return mystery2(a * a, b/2) + a;
	}
	
	/**
	 * 您要输入几个同学的信息？
	 * 3
	 * 请输入所有同学的信息：
	 * 张甲 100 100
	 * 张一 200 200
	 * 张丙 300 300
	 */
//	@Test
	@SuppressWarnings("resource")
	public void pra21() {
		Scanner input = new Scanner(System.in);
        System.out.println("您要输入几个同学的信息？");
        int i = input.nextInt();
        input.nextLine();//过滤\n
        System.out.println("请输入所有同学的信息：");
        String[] str = new String[i];
        for (int j = 0; j < i; j++) {
            str[j] = input.nextLine();
        }
        System.out.println("-------------表格-------------");
        for (int j = 0; j < i; j++) {
        	process(str[j]);
        }
	}

	private void process(String msg) {
		String[] s = msg.split("\\s+");//  \\s表示 空格,回车,换行等空白符
        // split()方法将一个字符串按照空格分割，结果作为字符串数组返回。
        System.out.printf("姓名：%-10s   成绩1：%-10s   成绩二：%-10s   相除：%-13.3f \n", s[0], s[1], s[2],
                Double.parseDouble(s[1]) / Double.parseDouble(s[2]));
	}
	
//	@Test
	public void pra22() {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
		int len = this.rank(9, a, 0, a.length, 1);
		System.out.println(len);
	}
	
	private int rank(int key, int[] a, int lo, int hi, int cir) {
		System.out.println("当前所处深度：" + (cir++) + "，当前lo：" + lo + "，当前hi：" + hi);
		if(lo > hi) return -1;
		int mid = lo + (hi - lo) / 2;
		if(key < a[mid]) return rank(key, a, lo, mid - 1, cir);
		else if (key > a[mid]) return rank(key, a, mid + 1, hi, cir);
		else return mid;
	}
	
//	@Test
	public void pra24() {
		Integer x = 7, y=2;
		Integer divisor = this.calculcateCommonDivisor(x, y);
		System.out.println(x + "和" +y + "的公约数：" +divisor);
	}
	
	/**
	 * @description ： 计算公约数（阿基米德原理）
	 * @param x
	 * @param y
	 * @return  
	 * @author：lux_zhang    
	 * @date：2018年7月16日
	 */
	public Integer calculcateCommonDivisor(Integer x, Integer y) {
		if(x==0 || y == 0) return 0;
		if(y == 1) return 1;
		if(x % y == 0) return y;
		return calculcateCommonDivisor(y, x % y);
	}
	
	/**
	 * @description ： 删除二分排序后数组中重复的元素
	 * @author：lux_zhang    
	 * @date：2018年7月24日
	 */
//	@Test
	public void pra29() {
		//思路 因已排好序，故将数组中前一位与后一位进行比较，相同则清除后一位，
		//然后继续与后一位进行比较，直到比较到数组结束
	}
	
	/**
	 * 设置N*N的布尔数组a[][]。i和j互质
	 */
//	@Test
	public void pra30() {
		//设置N*N的布尔数组a[][]。i和j互质
		//实现原理：互质则i、j的最大公约数为1
		boolean[][] a = new boolean[20][30];
		for(int i=0;i<20;i++) {
			for(int j=0;j<30;j++) {
				if(calculcateCommonDivisor(i, j) == 1) {
					a[i][j] = true;
					System.out.println("互质数，i：" + i + "，j：" + j);
				} else {
					a[i][j] = false;
				}
			}
		}
	}
	
//	@Test
	public void pra31() {
		//随机连接。从命令行获取整数N及dubbo值p（0到1之间）作为参数，
		//	在一个圆上画出大小为0.05且间距相等的N个点，然后将每对点按照概率p用灰线连接。
		randomLink(20, 0.2);
		System.out.println("随机连接完成。。。");
	}
	
	/**
	 * 画圆
	 * @param x 圆心x坐标
	 * @param y 圆心y坐标
	 * @param r 半径r
	 */
	private void drawCircle(double x, double y, double r) {
	    StdDraw.setXscale(0, 2 * x);
	    StdDraw.setYscale(0, 2 * y);
	    StdDraw.setPenRadius(0.003);
	    StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
	    StdDraw.circle(x, y, r);
	}

	/**
	 * 在圆上描点
	 * @param x0 圆心x坐标
	 * @param y0 圆心y坐标
	 * @param r 半径r
	 * @param N N个点
	 */
	private double[][] drawPoints(double x0, double y0, double r, int N) {
	    double[][] points = new double[N][2];
	    StdDraw.setPenRadius(0.005);
	    StdDraw.setPenColor(StdDraw.BOOK_RED);
	    for(int idx = 0; idx < N; ++idx) {
	        double x = x0 + r * Math.cos(2 * Math.PI * idx / N);
	        double y = y0 + r * Math.sin(2 * Math.PI * idx / N);
	        StdDraw.point(x, y);
	        points[idx][0] = x;
	        points[idx][1] = y;
	    }
	    return points;
	}

	/**
	 * 以概率p随机连接顶点集points中的点
	 * @param points    点集
	 * @param p 概率p
	 */
	private void randomLinkPoints(double[][] points, double p) {
	    StdDraw.setPenRadius(0.002);
	    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
	    int length = points.length;
	    for(int i = 0; i < length; ++i)
	        for(int j = 0; j < length; ++j)
	            if(true == StdRandom.bernoulli(p))
	                StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]); // 应该再建立一个包含x坐标和y坐标的数据结构
	}

	/**
	 * 在圆上画N个点然后每两点间以概率p连接
	 * @param N N个点
	 * @param p 概率p
	 */
	private void randomLink(int N, double p) {
	    double x = 10.0;
	    double y = 10.0;
	    double r = 9.0;
	    drawCircle(x, y, r);
	    double[][] points = drawPoints(x, y, r, N);
	    randomLinkPoints(points, p);
	}
	
	@Test
	public void pra32() {
		//直方图。假设标准输入流中含有一系列double 值。
		//编写一段程序，从命令行接受一个整数N 和两个double 值l 和r。将(l，r) 分为N 段并使用StdDraw 画出输入流中的值落入每段的数量的直方图。
		System.out.println("直方图完成。。。");
	}
}
