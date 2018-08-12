/*
 * 4 5
2 1 -3 -4 5
0 6 3 4 1
2 -2 -1 4 -5
-3 3 1 0 3
 *
 *
 */




/*
 *
 * 4 4
  9 7 16 5
  1 -6 -7 3
  1 8 7 9
  7 -2 0 10
 *
 *
 */

import java.lang.*;
import java.util.*;
import java.io.*;

public class Conviva
{
	public class Result
	{
		int _maxSum;
		int _leftBound;
		int _rightBound;
		int _lowBound;
		int _upBound;
	}

	public void  maxSum(int[][] array)
	{
		Result result = new Result();
		int row = array.length;
		int col = array[0].length;
		int[] temp = new int[row];
		for(int left = 0; left < col; left++)
		{
			for(int iter = 0; iter <row; iter++)
			{
				temp[iter] = 0;
			}
			for(int right = left; right < col; right++)
			{
				for(int iter = 0; iter < row; iter++)
				{
					temp[iter] = temp[iter] + array[iter][right];
				}
				KadaneResult kadaneresult = kadane(temp);
				if(kadaneresult.maxSum > result._maxSum)
				{
					result._maxSum =kadaneresult.maxSum;
					result._leftBound = left;
					result._rightBound = right;
					result._upBound = kadaneresult.start;
					result._lowBound = kadaneresult.end;
				}
			}
		}
		System.out.println(result._maxSum);
		for(int iter = result._leftBound; iter <= result._lowBound; iter++)
		{
			for(int jter = result._upBound; jter <= result._rightBound ; jter++)
			{
				System.out.print(array[iter][jter] + " ");
			}
			System.out.println();
		}
	}
	public class KadaneResult
	{
		int maxSum;
		int start;
		int end;
		KadaneResult(int maxSum, int start, int end)
		{
			this.maxSum = maxSum;
			this.start = start;
			this.end = end;
		}
	}
	private KadaneResult kadane(int[] array)
	{
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;
		for(int iter = 0; iter < array.length; iter++)
		{
			max_ending_here = max_ending_here + array[iter];
			if(max_ending_here < 0)
			{
				max_ending_here = 0;
				currentStart = iter+1;
			}
			if(max_so_far < max_ending_here)
			{
				max_so_far = max_ending_here;
				maxStart = currentStart;
				maxEnd = iter;
			}
		}
		return new KadaneResult(max_so_far, maxStart, maxEnd);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		int[][] matrix = new int[row][col];
		for(int iter = 0; iter < row; iter++)
		{
			for(int jter = 0; jter < col; jter++)
			{
				int data = input.nextInt();
				matrix[iter][jter] = data;
			}
		}
		Conviva saw = new Conviva();
		saw.maxSum(matrix);
	}
}
/*

4 5
1 2 -1 -4 -20
-8 -3 4 2 1
3 8 10 1 3
-4 -1 1 7 -6

*/
