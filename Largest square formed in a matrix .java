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

		int max_of_s;
		int max_of_iter;
		int max_of_jter;

		int[][] dp = new int[row][col];


		for(int iter = 0; iter < row; iter++)
		{
			dp[iter][0] = array[iter][0];
		}

		for(int jter = 0; jter < col; jter++)
		{
			dp[0][jter] = array[0][jter];
		}

		for(int iter = 1; iter < row; iter++)
		{
			for(int jter = 1; jter < col; jter++)
			{
				if(array[iter][jter] == 1)
				{
					dp[iter][jter] = Math.min(Math.min(dp[iter-1][jter], dp[iter][jter-1]), dp[iter-1][jter-1]) +1;
				}
				else
				{
					dp[iter][jter] = 0;
				}
			}
		}

		max_of_s = dp[0][0];
		max_of_iter = 0;
		max_of_jter = 0;
		for(int iter = 0; iter < row; iter++)
		{
			for(int jter = 0; jter < col; jter++)
			{
				if(max_of_s < dp[iter][jter])
				{
					max_of_s = dp[iter][jter];
					max_of_iter = iter;
					max_of_jter = jter;
				}
			}
		}

		int count = 0;
		for(int iter = max_of_iter; iter > max_of_iter - max_of_s; iter--)
		{
			count++;
			for(int jter = max_of_jter ; jter > max_of_jter - max_of_s; jter--)
			{
				System.out.print(array[iter][jter] + " ");
			}
			System.out.println();
		}
		return;
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
