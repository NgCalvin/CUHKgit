import java.util.*;

public class FrequentItem 
{
	static int[][] buckets = new int[1001][101];
	static int[] count1 = new int[1001];
	static int[][] count2 = new int[2000][3];
	static int[] item = new int[70];
	
	public static void main(String[] args)
	{
		generateFactor();
		//gentest(buckets);
		pass1(buckets,20);
		generatePair(item);
		//genPairTest(count2);
		pass2(buckets,20);
	}

	
	public static void generateFactor()
	{
		for(int b = 1 ; b < 1001 ; b++)
		{
			int j = 0;
			//System.out.println("b = " + b);
			for(int i = 1 ; i < 1001 ; i++)
			{
				if( (b > i || b==i) && b%i == 0)
				{
					//System.out.println("i = " + i);
					//System.out.println(b%i);
					buckets[b][j] = i;
					j++;
				}
			}
		}
	}
	
	public static void gentest(int[][] item)
	{
		for(int b = 1 ; b < 1001 ; b++)
		{
			System.out.print("Bucket " + b + " : ");

			for(int i = 0 ; i < 101 ; i++)
			{
				if(item[b][i]!=0)
				{
					System.out.print(item[b][i] + ",");
				}
				else
				{
					System.out.println();
					break;
				}
			}
		}
	}
	
	public static void pass1(int[][] itemList, int support)
	{
		int j = 0;
		System.out.println("Itemset of element 1 with over " + support + " support are : ");
		for(int k = 1 ; k < 1001 ; k++)
		{
			contains(itemList, k);
			if(count1[k] >= support)
			{
				item[j] = k;
				System.out.print(item[j]+",");
				j++;
			}
		}
		System.out.println();
	}
	public static void contains(int[][] buckets, int k)
	{
		for(int b = 1 ; b < 1001 ; b++)
		{
			for(int i = 0 ; i < 101 ; i++)
			{
				if(buckets[b][i] == k)
				{
					count1[k]++;
				}
				else if(buckets[b][i] == 0)
				{
					break;
				}
			}
		}

	}
	
	public static void generatePair(int[] itemset)
	{
		int k = 0;
		while(itemset[k]!=0)
		{
			k++;
		}
		System.out.println("Total number of individual item with over 20 support is " + k);
		
		int temp = 0;
		for(int i = 0 ; i < k ; i++)
		{
			for(int j = i ; j < k-1 ; j++)
			{
				count2[temp][0] = itemset[i];
				count2[temp][1] = itemset[j+1];
				temp++;
			}
		}
	}
	public static void genPairTest(int[][] itemset)
	{
		for(int i = 0 ; i < 1225 ; i++)
		{
			if(itemset[i][0]!=0)
			{
				System.out.println("(" + itemset[i][0] + " , "+ itemset[i][1] + ")");
			}
			else
			{
				break;
			}
		}
	}
	
	public static void pass2(int[][] buckets, int support)
	{
		ArrayList<Integer> tempItemList = new ArrayList<Integer>();
		item = new int[70];
		for(int i = 0; i < 2000 ; i++)
		{
			if(count2[i][0]!=0)
			{
			int[] check = new int[2];
			check[0] = count2[i][0];
			check[1] = count2[i][1];
			//System.out.println("Checking pair " + i + " of element (" + check[0] + " , " + check[1] + ").");
			count2[i][2] = contain2(buckets,check);
			//System.out.println("Count of (" + check[0] + " , " + check[1] + ") is " + count2[i][2]);
			}
			else
			{
				break;
			}
		}
		
		//System.out.println("The following are the frequent pairs of over " + support + " supports!");
		for(int i = 0 ; i < 2000 ; i++)
		{
			if(count2[i][2]>=20)
			{
				if(!tempItemList.contains(count2[i][0]))
				{
					tempItemList.add(count2[i][0]);					
				}
				if(!tempItemList.contains(count2[i][1]))
				{
					tempItemList.add(count2[i][1]);
				}
				System.out.print("(" + count2[i][0] + "," + count2[i][1] + ")" );
			}
		}
		System.out.println();
		System.out.println("Itemset of 2 elements with over " + support + " support are : ");
		for(int j = 0 ; j < tempItemList.size() ; j++)
		{
			item[j] = tempItemList.get(j);
			System.out.println(item[j]);
		}
		
		System.out.println("Total number of pair  with over 20 support is " + tempItemList.size());
	}
	
	public static int contain2(int[][] buckets,int[] tuple)
	{
		int element1 = tuple[0];
		//System.out.println(element1);
		int element2 = tuple[1];
		//System.out.println(element2);
		int count = 0;
		
		for(int b = 1 ; b < 1001 ; b++)
		{
			//System.out.println("b = " + b);
			for (int i = 0 ; i < 101 ; i++)
			{
				if(buckets[b][i] == 0)
				{
					//System.out.println("break!");
					break;
				}
			//	System.out.println("i = " + i);
			//	System.out.println(buckets[b][i] + " and " + element1);
				
				if(buckets[b][i] == element1)
				{
					//System.out.println(element1 + " found!");
					for(int j = i ; j < 101 ; j++)
					{
						//System.out.println("j = " + j);
						if(buckets[b][j] == 0)
						{
							//System.out.println("break!");
							break;
						}
						//System.out.println(buckets[b][j] + " and " + element2);
						
						if(buckets[b][j] == element2)
						{
							//System.out.println(element2 + " found!");
							count++;
							//System.out.println(count);
							break;
						}
					}
				}
			}
		}
		
		//System.out.println(count);
		return count;
	}
}
