
import java.io.*;
import java.util.*;
import java.lang.*;

public class GFG
{
	class KResult
	{
		int maxLength;
		int start;
		int end;

		KResult(int maxLength, int maxStart, int maxEnd)
		{
			this.maxLength = maxLength;
			this.start = maxStart;
			this.end = maxEnd;
		}
	}
	private KResult kresult(ArrayList<Integer> A)
	{
		int maxLength = 0;
		int maxStart = -1;
		int maxEnd = -1;
		int maxSum = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int iter = 0; iter < A.size(); iter++)
		{
			maxSum = maxSum + A.get(iter);
			if(A.get(0) == 0 && maxLength == 0 )
			{
				maxLength = 1;
				maxStart = iter;
				maxEnd = iter;
			}
			if(maxSum == 0)
			{
				if(maxLength < iter+1)
				{
					maxStart = 0;
					maxEnd = iter;
				}
				maxLength = iter+1;
			}
			if(hm.containsKey(maxSum))
			{
				int old = maxLength;
				maxLength = Math.max(maxLength, iter-hm.get(maxSum));
				if(old < maxLength)
				{
					maxStart = hm.get(maxSum) +1;
					maxEnd = iter;
				}
			}
			else
			{
				hm.put(maxSum, iter);
			}
		}
		return new KResult(maxLength, maxStart, maxEnd);
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
		KResult result = gfg.kresult(ai);
		System.out.println(result.maxLength);
		for(int iter = result.start; iter <= result.end; iter++)
		{
			System.out.print(ai.get(iter) + " ");
		}
	}
}
