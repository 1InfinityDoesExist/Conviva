
import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * 4 4
1 0 1 0
1 1 1 1
1 1 1 1
1 1 1 0
 */

public class GFG
{
	public void maxArea(int[] heights)
	{
		Stack<Integer> s = new Stack<Integer>();
		int maxarea = Integer.MIN_VALUE;
		int newArea = 0;
		int iter = 0;
		while(iter < heights.length)
		{
			if(s.isEmpty() || heights[s.peek()] < heights[iter])
			{
				s.push(iter++);
			}
			else
			{
				int top = s.peek();
				s.pop();
				newArea = heights[top] * (s.isEmpty() ?iter : iter - s.peek()-1);
				if(maxarea < newArea)
				{
					maxarea = newArea;
				}
			}
			iter++;
		}
		while(!s.empty())
		{
			int top = s.peek();
			s.pop();
			newArea = heights[top] * (s.isEmpty() ? iter : iter-s.peek()-1);
			if(maxarea < newArea)
			{
				maxarea = newArea;
			}
		}
		System.out.println(maxarea);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int h = input.nextInt();
		int[] heights = new int[h];
		for(int iter = 0; iter < h; iter++)
		{
			heights[iter] = input.nextInt();
		}
		GFG gfg = new GFG();
		gfg.maxArea(heights);
	}
}


/*
4 4
1 0 1 0
1 1 1 1
1 1 1 1
1 1 1 0
*/
