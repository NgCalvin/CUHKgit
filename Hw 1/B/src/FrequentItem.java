import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class FrequentItem 
{
	static int[][] buckets = new int[1001][101];
	static ArrayList<ArrayList<Integer>> buckets2 = new ArrayList<ArrayList<Integer>>();
	static int[] count1 = new int[1001];
	static int[][] count2 = new int[2000][3];
	static int[] item = new int[70];
	static ArrayList<ArrayList<Integer>> triplet = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count3 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> quadruple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count4 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> quintuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count5 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> sextuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count6 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> septuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count7 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> octuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count8 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> nonuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count9 = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> decuple = new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> count10 = new ArrayList<ArrayList<Integer>>();

	
	public static void main(String[] args)
	{
/*		PrintStream out;
		try 
		{
			out = new PrintStream(new FileOutputStream("B.txt"));
			System.setOut(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		generateFactor();
		//gentest(buckets);
		pass1(buckets,20);
		System.out.println("");
		generatePair(item);
		
		
		//genPairTest(count2);
		pass2(buckets,20);
		generateTriplet(count2);
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("There are total " + triplet.size() + " triples left after prunning.");
		pass3(buckets2,20);
		System.out.println("Here's the " + count3.size() + " triplet with their respected count with over 20 support! [element 1, element 2, element 3 , count]");
		System.out.println(count3);
		
		System.out.println("");		
		generateQuadruple(count3);
		System.out.println("There are total " + quadruple.size() + " quadruples left after prunning.");

		pass4(buckets2,20);		
		System.out.println("Here's the " + count4.size() + " quadruple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count4);

		System.out.println("");		
		generateQuintuple(count4);
		System.out.println("There are total " + quintuple.size() + " quintuples left after prunning.");

		pass5(buckets2,20);		
		System.out.println("Here's the " + count5.size() + " quintuple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count5);

		System.out.println("");		
		generateSextuple(count5);
		System.out.println("There are total " + sextuple.size() + " sextuples left after prunning.");

		pass6(buckets2,20);		
		System.out.println("Here's the " + count6.size() + " sextuple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count6);

		System.out.println("");		
		generateSeptuple(count6);
		System.out.println("There are total " + septuple.size() + " septuples left after prunning.");

		pass7(buckets2,20);		
		System.out.println("Here's the " + count7.size() + " septuple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count7);

		System.out.println("");		
		generateOctuple(count7);
		System.out.println("There are total " + octuple.size() + " octuples left after prunning.");

		pass8(buckets2,20);		
		System.out.println("Here's the " + count8.size() + " octuple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count8);

		System.out.println("");		
		generateNonuple(count8);
		System.out.println("There are total " + nonuple.size() + " nonuples left after prunning.");

		pass9(buckets2,20);		
		System.out.println("Here's the " + count9.size() + " nonuple with their respected count with over 20 support! [element 1, element 2, ..., count]");
		System.out.println(count9);

		System.out.println("");		
		generateDecuple(count9);
		System.out.println("There are total " + decuple.size() + " decuples left after prunning.");

	}

	
	public static void generateFactor()
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
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
					temp.add(i);
				}
			}
			buckets2.add(new ArrayList<Integer>(temp));
			temp.clear();
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
		
		System.out.println("The following are the frequent pairs of over " + support + " supports!");
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

	public static void generateTriplet(int[][] count2)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> tempCount2 = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0 ; i < 2000 ; i++)
		{
			if(count2[i][2]>=20)
			{
				temp.add(count2[i][0]);
				temp.add(count2[i][1]);
				
//				System.out.println(temp);
				tempCount2.add(new ArrayList<Integer>(temp));
				temp.clear();
			}
		}
		
//		System.out.println(tempCount2);
//		System.out.println(tempCount2.size());
		
		System.out.println("Staring to make triple");
		for(int j = 0 ; j < tempCount2.size() ; j++)
		{
			for(int k = j + 1 ; k < tempCount2.size() ; k++)
			{
//				System.out.println(k);
				if(tempCount2.get(j).get(0) == tempCount2.get(k).get(0) && tempCount2.get(j).get(1) < tempCount2.get(k).get(1))
				{
					temp.addAll(tempCount2.get(j));
					temp.add(tempCount2.get(k).get(1));
					triplet.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(tempCount2.get(j).get(0) < tempCount2.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Triple! Result have size " + triplet.size() + " !");
		System.out.println("Prunning triple");

		//Prunning
		for(int i = 0; i < triplet.size() ; i++)
		{
			Boolean assume = true ;
			int counter = tempCount2.size();
			ArrayList<Integer> checker1 = new ArrayList<Integer>();
			checker1.add(triplet.get(i).get(0));
			checker1.add(triplet.get(i).get(1));
			ArrayList<Integer> checker2 = new ArrayList<Integer>();
			checker2.add(triplet.get(i).get(1));
			checker2.add(triplet.get(i).get(2));
			
			for( int j = 0; j < counter ; j++)
			{
				if(tempCount2.get(j) == checker1)
				{
					for( int k = 0; k < counter ; k++)
					{
						if(tempCount2.get(k) == checker2)
						{
							assume = true;
							break;
						}
						else if(k == (counter-1))
						{
							assume = false;
						}
						
					}
				}
			}
			
			if(assume == false)
			{
				triplet.remove(i);
				i--;
			}


		}
		
	}

	public static int contain3(ArrayList<ArrayList<Integer>> buckets2,ArrayList<Integer> triplet)
	{
		int count = 0;
		for( int i = 0; i < buckets2.size() ; i++)
		{
			if(buckets2.get(i).containsAll(triplet))
			{
				count++;
			}
		}
		return count;
	}

	public static void pass3(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		System.out.println("Starting to do pass 3!");
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		for(int i = 0 ; i < triplet.size() ; i++)
		{
			temp = triplet.get(i);
			temp.add(contain3(buckets2,temp));
			triplet.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		for(int i = 0 ; i < triplet.size() ; i++)
		{
			if(triplet.get(i).get(3) >= support)
			{
				count3.add(triplet.get(i));
			}
		}
	}

	public static void generateQuadruple(ArrayList<ArrayList<Integer>> triplet)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < triplet.size() ; i++)
		{
			triplet.get(i).remove(3);
		}
		
		System.out.println("Starting to make Quadruple");
		for(int i = 0 ; i < triplet.size() ; i++)
		{
			for(int k = i + 1 ; k < triplet.size() ; k++)
			{
//				System.out.println(k);
				if(triplet.get(i).get(0) == triplet.get(k).get(0) && triplet.get(i).get(1) == triplet.get(k).get(1) && triplet.get(i).get(2) < triplet.get(k).get(2))
				{
					temp.addAll(triplet.get(i));
					temp.add(triplet.get(k).get(2));
					quadruple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(triplet.get(i).get(0) < triplet.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Quadruple! Result have size " + quadruple.size() + " !");
		System.out.println("Prunning Quadruple");

		//Prunning
		for(int i = 0; i < quadruple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = triplet.size();
			ArrayList<Integer> checker1 = new ArrayList<Integer>();
			checker1.addAll(quadruple.get(i));
			checker1.remove(3);

			if(assume == true)
			{
				for( int m = 0; m < counter ; m++)
				{
//					System.out.println("Checking " + checker1);
					if(triplet.get(m).containsAll(checker1))
					{
						assume = true;
//						System.out.println("Check1");
						break;
					}
					else if(m == (counter-1) && !triplet.get(m).containsAll(checker1))
					{
						assume = false;
						break;
					}
					
				}

			}
			ArrayList<Integer> checker2 = new ArrayList<Integer>();
			checker2.addAll(quadruple.get(i));
			checker2.remove(2);
			if( assume == true)
			{
				for( int m = 0; m < counter ; m++)
				{
					if(triplet.get(m).containsAll(checker2))
					{
						assume = true;
//						System.out.println("Check2");
						break;
					}
					else if(m == (counter-1)&& !triplet.get(m).containsAll(checker2))
					{
						assume = false;
						break;
					}
					
				}

			}

			ArrayList<Integer> checker3 = new ArrayList<Integer>();
			checker3.addAll(quadruple.get(i));
			checker3.remove(1);
			if( assume == true)
			{
				for( int m = 0; m < counter ; m++)
				{
					if(triplet.get(m).containsAll(checker3))
					{
						assume = true;
//						System.out.println("Check3");
						break;
					}
					else if(m == (counter-1)&& !triplet.get(m).containsAll(checker3))
					{
						assume = false;
						break;
					}
					
				}

			}

			ArrayList<Integer> checker4 = new ArrayList<Integer>();
			checker4.addAll(quadruple.get(i));
			checker4.remove(0);
			if( assume == true)
			{
				for( int m = 0; m < counter ; m++)
				{
					if(triplet.get(m).containsAll(checker4))
					{
						assume = true;
//						System.out.println("Check4");
						break;
					}
					else if(m == (counter-1) && !triplet.get(m).containsAll(checker4))
					{
						assume = false;
						break;
					}
					
				}

			}

			
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				quadruple.remove(i);
				i--;
			}


		}

	}

	public static void pass4(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 4!");
		for(int i = 0 ; i < quadruple.size() ; i++)
		{
			temp = quadruple.get(i);
			temp.add(contain3(buckets2,temp));
			quadruple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < quadruple.size() ; i++)
		{
			if(quadruple.get(i).get(4) >= support)
			{
				count4.add(quadruple.get(i));
			}
		}
	}

	public static void generateQuintuple(ArrayList<ArrayList<Integer>> quadruple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < quadruple.size() ; i++)
		{
			quadruple.get(i).remove(4);
		}
		
		System.out.println("Starting to make Quintuple");
		for(int i = 0 ; i < quadruple.size() ; i++)
		{
			for(int k = i + 1 ; k < quadruple.size() ; k++)
			{
//				System.out.println(k);
				if(quadruple.get(i).get(0) == quadruple.get(k).get(0) && quadruple.get(i).get(1) == quadruple.get(k).get(1) && quadruple.get(i).get(2) == quadruple.get(k).get(2) && quadruple.get(i).get(3) < quadruple.get(k).get(3) )
				{
					temp.addAll(quadruple.get(i));
					temp.add(quadruple.get(k).get(3));
					quintuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(quadruple.get(i).get(0) < quadruple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Quintuple! Result have size " + quintuple.size() + " !");
		System.out.println("Prunning Quintuple");

		//Prunning
		for(int i = 0; i < quintuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = quadruple.size();
			for(int j = 0 ; j < 5 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(quintuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(quadruple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !quadruple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				quintuple.remove(i);
				i--;
			}


		}

	}

	public static void pass5(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 5!");
		for(int i = 0 ; i < quintuple.size() ; i++)
		{
			temp = quintuple.get(i);
			temp.add(contain3(buckets2,temp));
			quintuple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
//		System.out.println(quintuple);
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < quintuple.size() ; i++)
		{
			if(quintuple.get(i).get(5) >= support)
			{
				count5.add(quintuple.get(i));
			}
		}
	}

	public static void generateSextuple(ArrayList<ArrayList<Integer>> quintuple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < quintuple.size() ; i++)
		{
			quintuple.get(i).remove(5);
		}
		
		System.out.println("Starting to make Sextuple");
		for(int i = 0 ; i < quintuple.size() ; i++)
		{
			for(int k = i + 1 ; k < quintuple.size() ; k++)
			{
//				System.out.println(k);
				boolean check1 = quintuple.get(i).get(0) == quintuple.get(k).get(0);
				boolean check2 = quintuple.get(i).get(1) == quintuple.get(k).get(1);
				boolean check3 = quintuple.get(i).get(2) == quintuple.get(k).get(2);
				boolean check4 = quintuple.get(i).get(3) == quintuple.get(k).get(3);
				boolean check5 = quintuple.get(i).get(4) < quintuple.get(k).get(4);

				if(check1 && check2 && check3 && check4 && check5 )
				{
					temp.addAll(quintuple.get(i));
					temp.add(quintuple.get(k).get(4));
					sextuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(quintuple.get(i).get(0) < quintuple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Sextuple! Result have size " + sextuple.size() + " !");
		System.out.println("Prunning Sextuple");

		//Prunning
		for(int i = 0; i < sextuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = quintuple.size();
			for(int j = 0 ; j < 6 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(sextuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(quintuple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !quintuple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				sextuple.remove(i);
				i--;
			}


		}

	}

	public static void pass6(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 6!");
		for(int i = 0 ; i < sextuple.size() ; i++)
		{
			temp = sextuple.get(i);
			temp.add(contain3(buckets2,temp));
			sextuple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < sextuple.size() ; i++)
		{
			if(sextuple.get(i).get(6) >= support)
			{
				count6.add(sextuple.get(i));
			}
		}
	}

	public static void generateSeptuple(ArrayList<ArrayList<Integer>> sextuple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < sextuple.size() ; i++)
		{
			sextuple.get(i).remove(6);
		}
		
		System.out.println("Starting to make Septuple");
		for(int i = 0 ; i < sextuple.size() ; i++)
		{
			for(int k = i + 1 ; k < sextuple.size() ; k++)
			{
//				System.out.println(k);
				boolean check1 = sextuple.get(i).get(0) == sextuple.get(k).get(0);
				boolean check2 = sextuple.get(i).get(1) == sextuple.get(k).get(1);
				boolean check3 = sextuple.get(i).get(2) == sextuple.get(k).get(2);
				boolean check4 = sextuple.get(i).get(3) == sextuple.get(k).get(3);
				boolean check5 = sextuple.get(i).get(4) == sextuple.get(k).get(4);
				boolean check6 = sextuple.get(i).get(5) < sextuple.get(k).get(5);


				if(check1 && check2 && check3 && check4 && check5 && check6)
				{
					temp.addAll(sextuple.get(i));
					temp.add(sextuple.get(k).get(5));
					septuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(sextuple.get(i).get(0) < sextuple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Septuple! Result have size " + septuple.size() + " !");
//		System.out.println(septuple);
		System.out.println("Prunning Septuple");

		//Prunning
		for(int i = 0; i < septuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = sextuple.size();
			for(int j = 0 ; j < 7 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(septuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(sextuple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !sextuple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				septuple.remove(i);
				i--;
			}


		}

	}

	public static void pass7(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 7!");
		for(int i = 0 ; i < septuple.size() ; i++)
		{
			temp = septuple.get(i);
			temp.add(contain3(buckets2,temp));
			septuple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < septuple.size() ; i++)
		{
			if(septuple.get(i).get(7) >= support)
			{
				count7.add(septuple.get(i));
			}
		}
	}

	public static void generateOctuple(ArrayList<ArrayList<Integer>> septuple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < septuple.size() ; i++)
		{
			septuple.get(i).remove(7);
		}
		
		System.out.println("Starting to make Octuple");
		for(int i = 0 ; i < septuple.size() ; i++)
		{
			for(int k = i + 1 ; k < septuple.size() ; k++)
			{
//				System.out.println(k);
				boolean check1 = septuple.get(i).get(0) == septuple.get(k).get(0);
				boolean check2 = septuple.get(i).get(1) == septuple.get(k).get(1);
				boolean check3 = septuple.get(i).get(2) == septuple.get(k).get(2);
				boolean check4 = septuple.get(i).get(3) == septuple.get(k).get(3);
				boolean check5 = septuple.get(i).get(4) == septuple.get(k).get(4);
				boolean check6 = septuple.get(i).get(5) == septuple.get(k).get(5);
				boolean check7 = septuple.get(i).get(6) < septuple.get(k).get(6);


				if(check1 && check2 && check3 && check4 && check5 && check6 && check7)
				{
					temp.addAll(septuple.get(i));
					temp.add(septuple.get(k).get(6));
					octuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(septuple.get(i).get(0) < septuple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Octuple! Result have size " + octuple.size() + " !");
//		System.out.println(septuple);
		System.out.println("Prunning Octuple");

		//Prunning
		for(int i = 0; i < octuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = septuple.size();
			for(int j = 0 ; j < 8 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(octuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(septuple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !septuple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				octuple.remove(i);
				i--;
			}


		}

	}

	public static void pass8(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 8!");
		for(int i = 0 ; i < octuple.size() ; i++)
		{
			temp = octuple.get(i);
			temp.add(contain3(buckets2,temp));
			octuple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < octuple.size() ; i++)
		{
			if(octuple.get(i).get(8) >= support)
			{
				count8.add(octuple.get(i));
			}
		}
	}

	public static void generateNonuple(ArrayList<ArrayList<Integer>> octuple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < octuple.size() ; i++)
		{
			octuple.get(i).remove(8);
		}
		
		System.out.println("Starting to make Octuple");
		for(int i = 0 ; i < octuple.size() ; i++)
		{
			for(int k = i + 1 ; k < octuple.size() ; k++)
			{
//				System.out.println(k);
				boolean check1 = octuple.get(i).get(0) == octuple.get(k).get(0);
				boolean check2 = octuple.get(i).get(1) == octuple.get(k).get(1);
				boolean check3 = octuple.get(i).get(2) == octuple.get(k).get(2);
				boolean check4 = octuple.get(i).get(3) == octuple.get(k).get(3);
				boolean check5 = octuple.get(i).get(4) == octuple.get(k).get(4);
				boolean check6 = octuple.get(i).get(5) == octuple.get(k).get(5);
				boolean check7 = octuple.get(i).get(6) == octuple.get(k).get(6);
				boolean check8 = octuple.get(i).get(7) < octuple.get(k).get(7);


				if(check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8)
				{
					temp.addAll(octuple.get(i));
					temp.add(octuple.get(k).get(7));
					nonuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(octuple.get(i).get(0) < octuple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Nonuple! Result have size " + nonuple.size() + " !");
		System.out.println("Prunning Nonuple");

		//Prunning
		for(int i = 0; i < nonuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = octuple.size();
			for(int j = 0 ; j < 9 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(nonuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(octuple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !octuple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				nonuple.remove(i);
				i--;
			}


		}

	}

	public static void pass9(ArrayList<ArrayList<Integer>> buckets2, int support)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		
		System.out.println("Starting to do pass 9!");
		for(int i = 0 ; i < nonuple.size() ; i++)
		{
			temp = nonuple.get(i);
			temp.add(contain3(buckets2,temp));
			nonuple.set(i, new ArrayList<Integer>(temp));
			temp.clear();
		}
		
		System.out.println("Prunning item with less then 20 support.");
		for(int i = 0 ; i < nonuple.size() ; i++)
		{
			if(nonuple.get(i).get(9) >= support)
			{
				count9.add(nonuple.get(i));
			}
		}
	}
	
	public static void generateDecuple(ArrayList<ArrayList<Integer>> nonuple)
	{
		ArrayList<Integer> temp = new ArrayList<Integer>();
		Boolean assume;

		for(int i = 0 ; i < nonuple.size() ; i++)
		{
			nonuple.get(i).remove(9);
		}
		
		System.out.println("Starting to make Nonuple");
		for(int i = 0 ; i < nonuple.size() ; i++)
		{
			for(int k = i + 1 ; k < nonuple.size() ; k++)
			{
//				System.out.println(k);
				boolean check1 = nonuple.get(i).get(0) == nonuple.get(k).get(0);
				boolean check2 = nonuple.get(i).get(1) == nonuple.get(k).get(1);
				boolean check3 = nonuple.get(i).get(2) == nonuple.get(k).get(2);
				boolean check4 = nonuple.get(i).get(3) == nonuple.get(k).get(3);
				boolean check5 = nonuple.get(i).get(4) == nonuple.get(k).get(4);
				boolean check6 = nonuple.get(i).get(5) == nonuple.get(k).get(5);
				boolean check7 = nonuple.get(i).get(6) == nonuple.get(k).get(6);
				boolean check8 = nonuple.get(i).get(7) == nonuple.get(k).get(7);
				boolean check9 = nonuple.get(i).get(8) < nonuple.get(k).get(8);



				if(check1 && check2 && check3 && check4 && check5 && check6 && check7 && check8 && check9)
				{
					temp.addAll(nonuple.get(i));
					temp.add(nonuple.get(k).get(8));
					decuple.add(new ArrayList<Integer>(temp));
					temp.clear();
				}
				else if(nonuple.get(i).get(0) < nonuple.get(k).get(0))
				{
					break;
				}
			}
		}
		
		System.out.println("Done generating Decuple! Result have size " + decuple.size() + " !");
		System.out.println("Prunning Decuple");

		//Prunning
		for(int i = 0; i < decuple.size() ; i++)
		{
//			System.out.println("Checking " +quadruple.get(i));
			assume = true ;
			int counter = decuple.size();
			for(int j = 0 ; j < 10 ; j++)
			{
				ArrayList<Integer> checker = new ArrayList<Integer>();
				checker.addAll(decuple.get(i));
				checker.remove(j);
				if(assume == true)
				{
					for( int m = 0; m < counter ; m++)
					{
//						System.out.println("Checking " + checker1);
						if(nonuple.get(m).containsAll(checker))
						{
							assume = true;
//							System.out.println("Check1");
							break;
						}
						else if(m == (counter-1) && !nonuple.get(m).containsAll(checker))
						{
							assume = false;
							break;
						}						
					}
				}
			}
				
			if(assume == false)
			{
//				System.out.println("Prunning " + quadruple.get(i));
				decuple.remove(i);
				i--;
			}


		}

	}


}
