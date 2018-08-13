
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
	public void maxSquareSubArray(int[][] array)
	{
		int row = array.length;
		int col = array[0].length;
		int[] left = new int[col];
		int[] right = new int[col];
		int[] height = new int[col];

		for(int iter = 0; iter < col; iter++)
		{
			left[iter] = 0;
		}
		for(int iter = 0; iter < col; iter++)
		{
			right[iter] = row;
		}
		for(int iter = 0; iter < col; iter++)
		{
			height[iter] = 0;
		}
		for(int iter = 0; iter < row; iter++)
		{
			int current_left =0;
			int current_right = col;
			for(int jter = 0; jter < col; jter++)
			{
				if(array[iter][jter] == 1)
				{
					height[jter]++;
				}
				else
				{
					height[jter] = 0;
				}
			}
			for(int jter = 0; jter < col; jter++)
			{
				if(array[iter][jter] == 1)
				{
					left[jter] = Math.max(current_left, left[jter]);
				}
				else
				{
					current_left = jter+1;
					left[jter] = 0;
				}
			}
			for(int jter = col-1; jter >= 0; jter--)
			{
				if(array[iter][jter] == 1)
				{
					right[jter] = Math.min(current_right, right[jter]);
				}
				else
				{
					current_right = jter;
					right[jter] = col;
				}
			}
		}

		int result = 0;
		for(int iter = 0; iter < row; iter++)
		{
			result = Math.max(result, (right[iter]-left[iter]) * height[iter]);
		}

		System.out.println(result);
	}

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int row = input.nextInt();
		int col = input.nextInt();
		int[][] array = new int[row][col];
		for(int iter = 0; iter < row; iter++)
		{
			for(int jter = 0; jter < col; jter++)
			{
				array[iter][jter] = input.nextInt();
			}
		}
		GFG gfg = new GFG();
		gfg.maxSquareSubArray(array);
	}
}


/*
4 4
1 0 1 0
1 1 1 1
1 1 1 1
1 1 1 0
*/
