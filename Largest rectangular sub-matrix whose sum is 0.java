
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
		int maxl =Integer.MIN_VALUE;
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
				int mx = kadaneresult.maxSum;
				int ele = (kadaneresult.end - kadaneresult.start+1) *(right-left+1);
				if(mx != 0 && ele  > maxl)
				{
					result._maxSum =kadaneresult.maxSum;
					result._leftBound = left;
					result._rightBound = right;
					result._upBound = kadaneresult.start;
					result._lowBound = kadaneresult.end;
					maxl = ele;
				}
			}
		}
		System.out.println(result._leftBound);
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
		int maxleng = 0;
		int sum = 0;
		int maxStart = -1;
		int maxEnd = -1;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		for(int iter = 0; iter < array.length; iter++)
		{
			sum = sum + array[iter];
			if(array[iter] == 0 && maxleng == 0)
			{
				maxleng = 1;
				maxStart = iter;
				maxEnd = iter;
			}
			if(sum == 0)
			{
				if(maxleng < iter+1)
				{
					maxStart = 0;
					maxEnd = iter;
				}
				maxleng = iter+1;
			}

			if(hm.containsKey(sum))
			{
				int old = maxleng;

				maxleng = Math.max(maxleng, iter-hm.get(sum));
				if(old < maxleng)
				{
					maxEnd = iter;
					maxStart = hm.get(sum)+1;
				}
			}
			else
			{
				hm.put(sum, iter);
			}
		}
		return new KadaneResult(maxleng, maxStart, maxEnd);
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
