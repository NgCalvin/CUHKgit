import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DGIM 
{
	
	public static int[][] c0 = new int[3][101];
	public static int[][] c1 = new int[3][101];
	public static int[][] c2 = new int[3][101];
	public static int[][] c3 = new int[3][101];
	public static int[][] c4 = new int[3][101];
	public static int[][] c5 = new int[3][101];
	public static int[][] c6 = new int[3][101];
	public static int[][] c7 = new int[3][101];
	public static int[][] c8 = new int[3][101];
	public static int[][] c9 = new int[3][101];
	public static int timeStamp = 0;
	public static int counter = 0;
	public static int totalNumOf1 = 0;
	public static int sum = 0;

	public static void main(String[] args)
	{
		sum = 0;
		
		Scanner sr = null;
		int next;
		String bitString;
		try
		{
			sr = new Scanner(new File("src/cmsc5741_stream_data.txt"));
			
			while(sr.hasNext())
			{
				next = sr.nextInt();
				bitString = Integer.toBinaryString(next);
				//System.out.println(bitString);
				
				if(counter <= 99)
				{
					assignBit(bitString);
					counter++;
				}
				else
				{
					int lenght = bitString.length();
					int i = 10 - lenght;
					for(int j = 0 ; j < i ; j++)
					{
						bitString = "0" + bitString;
					}
					
					timeStamp++;
//					System.out.println(timeStamp);
					updateBucket(c0,Integer.parseInt(bitString.substring(9,10)));
					updateBucket(c1,Integer.parseInt(bitString.substring(8,9)));
					updateBucket(c2,Integer.parseInt(bitString.substring(7,8)));
					updateBucket(c3,Integer.parseInt(bitString.substring(6,7)));
					updateBucket(c4,Integer.parseInt(bitString.substring(5,6)));
					updateBucket(c5,Integer.parseInt(bitString.substring(4,5)));
					updateBucket(c6,Integer.parseInt(bitString.substring(3,4)));
					updateBucket(c7,Integer.parseInt(bitString.substring(2,3)));
					updateBucket(c8,Integer.parseInt(bitString.substring(1,2)));
					updateBucket(c9,Integer.parseInt(bitString.substring(0,1)));
				}
			}
			
			System.out.println("Result of c0 stream:");
			printResult(c0);
			count1(c0);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 0!");
			sum+=((int) Math.pow((double) 2 , 0))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");
			
			System.out.println("Result of c1 stream:");
			printResult(c1);
			count1(c1);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 1!");
			sum+=((int) Math.pow((double) 2 , 1))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");
			
			System.out.println("Result of c2 stream:");						
			printResult(c2);
			count1(c2);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 2!");
			sum+=((int) Math.pow((double) 2 , 2))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");
			
			System.out.println("Result of c3 stream:");
			printResult(c3);
			count1(c3);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 3!");
			sum+=((int) Math.pow((double) 2 , 3))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");


			System.out.println("Result of c4 stream:");
			printResult(c4);
			count1(c4);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 4!");
			sum+=((int) Math.pow((double) 2 , 4))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");

			System.out.println("Result of c5 stream:");
			printResult(c5);
			count1(c5);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 5!");
			sum+=((int) Math.pow((double) 2 , 5))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");


			System.out.println("Result of c6 stream:");
			printResult(c6);
			count1(c6);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 6!");
			sum+=((int) Math.pow((double) 2 , 6))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");

			System.out.println("Result of c7 stream:");
			printResult(c7);
			count1(c7);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 7!");
			sum+=((int) Math.pow((double) 2 , 7))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");


			System.out.println("Result of c8 stream:");
			printResult(c8);
			count1(c8);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 8!");
			sum+=((int) Math.pow((double) 2 , 8))*totalNumOf1;
			System.out.println("Current sum is " + sum + " !");
			System.out.println("");


			System.out.println("Result of c9 stream:");
			printResult(c9);
			count1(c9);
			System.out.println("There are " + totalNumOf1 + " 1's in stream 9!");
			sum+=((int) Math.pow((double) 2 , 9))*totalNumOf1;
			System.out.println("Final estimated sum is " + sum + " !");
			System.out.println("");


			
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
			System.out.println("Can't find the txt file, check code File path!");
		}
		finally
		{
			if(sr != null)
			{
				sr.close();
				System.out.println("This is the end of this program~~");
			}
		}

	}
	public static void assignBit(String bitString)
	{
		int lenght = bitString.length();
		int i = 10 - lenght;
		for(int j = 0 ; j < i ; j++)
		{
			bitString = "0" + bitString;
		}
		
		timeStamp++;
		
		c0[0][counter] = Integer.parseInt(bitString.substring(9,10));
		c0[1][counter] = timeStamp;
/*		if(c0[0][counter] == 1)
		{
			System.out.println("");
			System.out.println("Next bit = " + c0[0][counter] + " , TimeStamp : " + timeStamp);			
		}
*/		updateBucket(c0,c0[0][counter]);
		
		c1[0][counter] = Integer.parseInt(bitString.substring(8,9));
		c1[1][counter] = timeStamp;
		updateBucket(c1,c1[0][counter]);

		c2[0][counter] = Integer.parseInt(bitString.substring(7,8));
		c2[1][counter] = timeStamp;		
		updateBucket(c2,c2[0][counter]);

		c3[0][counter] = Integer.parseInt(bitString.substring(6,7));
		c3[1][counter] = timeStamp;
		updateBucket(c3,c3[0][counter]);

		c4[0][counter] = Integer.parseInt(bitString.substring(5,6));		
		c4[1][counter] = timeStamp;
		updateBucket(c4,c4[0][counter]);

		c5[0][counter] = Integer.parseInt(bitString.substring(4,5));
		c5[1][counter] = timeStamp;
		updateBucket(c5,c5[0][counter]);
		
		c6[0][counter] = Integer.parseInt(bitString.substring(3,4));
		c6[1][counter] = timeStamp;
		updateBucket(c6,c6[0][counter]);

		c7[0][counter] = Integer.parseInt(bitString.substring(2,3));
		c7[1][counter] = timeStamp;
		updateBucket(c7,c7[0][counter]);

		c8[0][counter] = Integer.parseInt(bitString.substring(1,2));
		c8[1][counter] = timeStamp;
		updateBucket(c8,c8[0][counter]);

		c9[0][counter] = Integer.parseInt(bitString.substring(0,1));
		c9[1][counter] = timeStamp;
		updateBucket(c9,c9[0][counter]);

		
		
	}	
	public static void updateBucket(int[][] ci,int nextBit)
	{
		ArrayList<Integer> slot = new ArrayList<Integer>();
				
		if(counter == 100)
		{			
			if(nextBit == 0)
			{
				for(int i = 0 ; i < 99 ; i++)
				{
					ci[0][i] = ci[0][i+1];
					ci[1][i] = ci[1][i+1];
					ci[2][i] = ci[2][i+1];
				}
				
				ci[0][99] = nextBit;
				ci[1][99] = timeStamp;
				ci[2][99] = 0;
			}
			else 
			{
				
				//Put new bit into a temp slot, this temp slot will get reset to 0 at the end of each update. 
				ci[0][100] = nextBit;
				ci[1][100] = timeStamp;
				ci[2][100] = 1;
				
				//System.out.println("Merging bucket 1!");
				//For merging bucket 1
				for(int k = 100 ; k >= 0 ; k--)
				{
					if(ci[2][k] == 1)
					{
						slot.add(k);
						//System.out.println("Adding " + k + " to arraylist for merging!");
					}
					
					if(slot.size()==3)
					{
						//System.out.println("Found 3 buckets of 1!");
						if(ci[1][slot.get(0)] > ci[1][slot.get(1)] && ci[1][slot.get(0)] > ci[1][slot.get(2)])
						{
							ci[2][slot.get(1)] = 2;
							ci[2][slot.get(2)] = 2;
						}
						slot.clear();
						break;
					}

				}
				
				slot.clear();
				
				//For merging bucket 2 to 32.
				for(int i = 1 ; i < 5 ; i++)
				{
					//System.out.println("Checking for bucket " + (int) Math.pow((double) 2, (double) i));
					
					for(int j = 100 ; j >= 0 ; j--)
					{
						if(ci[2][j] == (int) Math.pow((double) 2, (double) i))
						{
							slot.add(j);
							//System.out.println("Adding " + j + " to arraylist for merging!");
						}
						
						if(slot.size() == 5 && j == 0)
						{
							boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
							boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
							boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
							boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
							
							//System.out.println("Found 5 buckets of size " + (int) Math.pow((double) 2, (double) i));
							if(check1&&check2&&check3&&check4)	
							{
								ci[2][slot.get(2)] = (int) Math.pow((double) 2, (double) (i+1));
								ci[2][slot.get(3)] = 0;
								ci[2][slot.get(4)] = 0;
							}
							//System.out.println("Clearing Slot arraylist!");
							slot.clear();
							break;
						}
 
						if(slot.size() == 6)
						{
							boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
							boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
							boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
							boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
							boolean check5 = ci[1][slot.get(4)]>ci[1][slot.get(5)];

							//System.out.println("Found 6 buckets of size " + (int) Math.pow((double) 2, (double) i));
							if(check1&&check2&&check3&&check4&&check5)	
							{
								ci[2][slot.get(2)] = (int) Math.pow((double) 2, (double) (i+1));
								ci[2][slot.get(3)] = 0;
								ci[2][slot.get(4)] = 0;
								ci[2][slot.get(5)] = (int) Math.pow((double) 2, (double) (i+1));
							}
							//System.out.println("Clearing Slot arraylist!");
							slot.clear();
							break;
						}
					}
					//System.out.println("Clearing Slot arraylist!");
					slot.clear();
				}
				slot.clear();
				
				
				//Move the bit now
				for(int i = 0 ; i <= 99 ; i++)
				{
					ci[0][i] = ci[0][i+1];
					ci[1][i] = ci[1][i+1];
					ci[2][i] = ci[2][i+1];
				}
				
				//Reset the bit.
				ci[0][100] = 0;
				ci[1][100] = 0;
				ci[2][100] = 0;				
				
			}

		}
		else 
		{
			if(nextBit == 0)
			{
				ci[2][counter] = 0;
			}
			else
			{
				ci[2][counter] = 1;
				
				//System.out.println("Merging bucket 1!");
				//For merging bucket 1
				for(int k = counter ; k >= 0 ; k--)
				{
					if(ci[2][k] == 1)
					{
						slot.add(k);
						//System.out.println("Adding " + k + " to arraylist for merging!");
					}
					
					if(slot.size()==3)
					{
						//System.out.println("Found 3 buckets of 1!");
						if(ci[1][slot.get(0)] > ci[1][slot.get(1)] && ci[1][slot.get(0)] > ci[1][slot.get(2)])
						{
							ci[2][slot.get(1)] = 2;
							ci[2][slot.get(2)] = 2;
						}
						slot.clear();
						break;
					}

				}
				
				slot.clear();
				
				//For merging bucket 2 to 32.
				for(int i = 1 ; i < 5 ; i++)
				{
					//System.out.println("Checking for bucket " + (int) Math.pow((double) 2, (double) i));
					
					for(int j = counter ; j >= 0 ; j--)
					{
						if(ci[2][j] == (int) Math.pow((double) 2, (double) i))
						{
							slot.add(j);
							//System.out.println("Adding " + j + " to arraylist for merging!");
						}
						
						if(slot.size() == 5 && j == 0)
						{
							boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
							boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
							boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
							boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
							
							//System.out.println("Found 5 buckets of size " + (int) Math.pow((double) 2, (double) i));
							if(check1&&check2&&check3&&check4)	
							{
								ci[2][slot.get(2)] = (int) Math.pow((double) 2, (double) (i+1));
								ci[2][slot.get(3)] = 0;
								ci[2][slot.get(4)] = 0;
							}
							//System.out.println("Clearing Slot arraylist!");
							slot.clear();
							break;
						}
 
						if(slot.size() == 6)
						{
							boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
							boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
							boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
							boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
							boolean check5 = ci[1][slot.get(4)]>ci[1][slot.get(5)];

							//System.out.println("Found 6 buckets of size " + (int) Math.pow((double) 2, (double) i));
							if(check1&&check2&&check3&&check4&&check5)	
							{
								ci[2][slot.get(2)] = (int) Math.pow((double) 2, (double) (i+1));
								ci[2][slot.get(3)] = 0;
								ci[2][slot.get(4)] = 0;
								ci[2][slot.get(5)] = (int) Math.pow((double) 2, (double) (i+1));
							}
							//System.out.println("Clearing Slot arraylist!");
							slot.clear();
							break;
						}
					}
					//System.out.println("Clearing Slot arraylist!");
					slot.clear();
				}
				slot.clear();
			}
		}
	}
	
	public static void count1(int[][] ci)
	{
		totalNumOf1 = 0;
		int numOf1 = 0;
		int numOf2 = 0;
		int numOf4 = 0;
		int numOf8 = 0;
		int numOf16 = 0;
		int numOf32 = 0;
		
		for(int i = 99 ; i >=0 ; i--)
		{
			switch(ci[2][i])
			{
				case 1 :
				{
					numOf1++;
					break;
				}
				case 2 :
				{
					numOf2++;
					break;
				}
				case 4 :
				{
					numOf4++;
					break;
				}
				case 8 :
				{
					numOf8++;
					break;
				}
				case 16 :
				{
					numOf16++;
					break;
				}
				case 32 :
				{
					numOf32++;
					break;
				}
				default:
				{
					break;
				}
			}
		}
		totalNumOf1+=numOf1;
		
		if(numOf2 == 2)
		{
			totalNumOf1+=2;
		}
		else
		{
			totalNumOf1+=4;
		}

		if(numOf4 > 3)
		{
			totalNumOf1+=8;
		}
		else if(numOf4!=0)
		{
			totalNumOf1+=4;
		}
		
		if(numOf8 > 3)
		{
			totalNumOf1+=16;
		}
		else if(numOf8!=0)
		{
			totalNumOf1+=8;
		}

		if(numOf16 > 3)
		{
			totalNumOf1+=32;
		}
		else if(numOf16!=0)
		{
			totalNumOf1+=16;
		}

		if(numOf32 > 3)
		{
			totalNumOf1+=64;
		}
		else if(numOf32!=0)
		{
			totalNumOf1+=32;
		}

		
	}
	
	public static void printResult(int[][] ci)
	{
		for(int row = 0 ; row < 3 ; row++)
		{
			for(int column = 0 ; column < 100 ;column++)
			{
				System.out.format("%-5d", ci[row][column]);
			}
			System.out.println();
		}
	}
}
