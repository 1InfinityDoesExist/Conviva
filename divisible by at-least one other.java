
import java.io.*;
import java.lang.*;
import java.util.*;

public class Divisiblity
{
	public ArrayList<Integer> divisibity(ArrayList<Integer> A)
	{
		ArrayList<Integer> ai = new ArrayList<Integer>();
		Collections.sort(A);
		if(A.contains(1))
		{
			return A;
		}
		for(int iter = A.size()-1; iter >= 1; iter--)
		{
			int jter = iter-1;
			while(jter >= 0)
			{
				if(A.get(iter)%A.get(jter) == 0)
				{
					ai.add(A.get(iter));
					break;
				}
				jter--;
			}
		}
		return ai;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> ai = new ArrayList<Integer>();
		int n = input.nextInt();
		for(int iter = 0; iter < n; iter++)
		{
			ai.add(input.nextInt());
		}
		Divisiblity div = new Divisiblity();

		ArrayList<Integer> ans = div.divisibity(ai);

		Collections.sort(ans);
		Iterator iter = ans.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}
}
