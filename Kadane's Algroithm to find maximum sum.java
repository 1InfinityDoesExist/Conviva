import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG
{
	class KadaneResult
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
	public KadaneResult kadane(ArrayList<Integer> A)
	{
		int max_ending_here = 0;
		int max_so_far = Integer.MIN_VALUE;
		int maxStart = -1;
		int maxEnd = -1;
		int currentStart = 0;
		for(int iter = 0; iter < A.size(); iter++)
		{
			max_ending_here = max_ending_here + A.get(iter);

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
		int n = input.nextInt();
		ArrayList<Integer> ai = new ArrayList<Integer>();
		for(int iter = 0; iter < n; iter++)
		{
			ai.add(input.nextInt());
		}
		GFG gfg = new GFG();
		KadaneResult result = gfg.kadane(ai);
		System.out.println(result.maxSum);
		for(int iter = result.start; iter <= result.end; iter++)
		{
			System.out.print(ai.get(iter) + " ");
		}
	}
}
