import java.util.*;

public class GeneralFIS 
{
	static ArrayList[] buckets = new ArrayList[1001];
	static ArrayList<Integer> itemList = new ArrayList<Integer>();
	static ArrayList[] kComboSet = new ArrayList[3000];
	
	public static void main(String[] args)
	{
		generateFactor();
		//printTest(buckets);
		//contains(buckets,try1);
	}

	public static void generateFactor()
	{
		for(int b = 1 ; b < 1001 ; b++)
		{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int i = 1 ; i < 1001 ; i++)
			{
				if( (b > i || b==i) && b%i == 0)
				{
					temp.add(i);
				}
			}
			buckets[b] = temp;
		}
		
	}
	
	public static void pass(int passNum,int[][] itemList, int support)
	{
		
	}
	
	public static ArrayList[] kCombination(int[] itemList,int power)
	{
		int numOfItem = 0;
		int i = 0;
		while(itemList[i]!=0)
		{
			numOfItem++;
		}
		
		if(itemList[0] == 0)
		{
			kComboSet[0] = new ArrayList<Integer>();
			System.out.println("The inputed Array have 0 at the first element, are you sure this is right?.... Lol");
		}
		else
		{
			if(power > 1)
			{
				int[] head = new int[1];
				head[0] = itemList[0];
				itemList = Arrays.copyOfRange(itemList, 1, numOfItem);
				
				while(numOfItem + 1 >= power)
				{
					ArrayList[] tempSubList = new ArrayList[1000];
					tempSubList = kCombination(itemList, power -1 );
					
					int[] tempSubArray;
					
				}
				
			}
		}
		
	}
	
	public static int contains(ArrayList[] buckets, ArrayList<Integer> tempList)
	{
		int count = 0;
		System.out.println(tempList);
		for(int i = 1 ; i < 1001; i++)
		{
			//System.out.println("Checking : " + buckets[i]);
			if(buckets[i]!=null)
			{
				if(buckets[i].containsAll(tempList))
				{
					count++;
				}
			}
			else
			{
				break;
			}

		}
		//System.out.print(count);
		return count;
	}
	
	public static void printTest(ArrayList[] buckets)
	{
		for(int i = 1 ; i < 1001 ; i++)
		{
			if(buckets[i]!=null)
			{
				System.out.println("Factors of " + i + " is " + buckets[i]);
			}
			else
			{
				break;
			}
		}
	}
}
