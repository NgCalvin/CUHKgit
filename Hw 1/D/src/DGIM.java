import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DGIM 
{
	
	public static int[][] c0 = new int[3][100];
	public static int[][] c1 = new int[3][100];
	public static int[][] c2 = new int[3][100];
	public static int[][] c3 = new int[3][100];
	public static int[][] c4 = new int[3][100];
	public static int[][] c5 = new int[3][100];
	public static int[][] c6 = new int[3][100];
	public static int[][] c7 = new int[3][100];
	public static int[][] c8 = new int[3][100];
	public static int[][] c9 = new int[3][100];
	public static int timeStamp = 0;
	public static int counter = 0;

	public static void main(String[] args)
	{

		
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
/*					int lenght = bitString.length();
					int i = 10 - lenght;
					for(int j = 0 ; j < i ; j++)
					{
						bitString = "0" + bitString;
					}		
*/					
					printResult(c0);
					printResult(c1);
					printResult(c2);
					printResult(c3);
					printResult(c4);
					printResult(c5);
					printResult(c6);
					printResult(c7);
					printResult(c8);
					printResult(c9);
					break;
				}
			}
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
		updateBucket(c0,c0[0][counter]);
		
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
				
		if(/*counter == 99*/ false)
		{
			timeStamp = c0[1][99];

			if(nextBit == 0)
			{
				for(int i = 0 ; i < 99 ; i++)
				{
					ci[0][i] = ci[0][i+1];
					ci[1][i] = ci[0][i+1];
					ci[2][i] = ci[2][i+1];
				}
				ci[0][99] = nextBit;
				ci[1][99] = timeStamp;
				ci[2][99] = 0;
			}
			else 
			{
				
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
				
				//For merging bucket 1
				for(int k = counter ; k >= 0 ; k--)
				{
					if(ci[2][k] == 1)
					{
						slot.add(k);
					}
					else if(ci[2][k] > 1)
					{
						if(slot.size()==3)
						{
							if(ci[1][slot.get(0)] > ci[1][slot.get(1)] && ci[1][slot.get(0)] > ci[1][slot.get(2)])
							{
								ci[2][slot.get(1)] = 2;
								ci[2][slot.get(2)] = 2;
							}
							slot.clear();
						}
						break;
					}
					
				}
				
				//For merging bucket 2 to 32.
				for(int i = 1 ; i < 5 ; i++)
				{
					for(int j = counter ; j >= 0 ; j--)
					{
						if(ci[2][j] == (2^i))
						{
							slot.add(j);
						}
						else if(ci[2][j] > (2^i))
						{
							if(slot.size() == 5)
							{
								boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
								boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
								boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
								boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
								
								if(check1&&check2&&check3&&check4)	
								{
									ci[2][slot.get(2)] = (2^(i+1));
								}


							}
							else if(slot.size() == 6)
							{
								boolean check1 = ci[1][slot.get(0)]>ci[1][slot.get(1)];
								boolean check2 = ci[1][slot.get(1)]>ci[1][slot.get(2)];
								boolean check3 = ci[1][slot.get(2)]>ci[1][slot.get(3)];
								boolean check4 = ci[1][slot.get(3)]>ci[1][slot.get(4)];
								boolean check5 = ci[1][slot.get(4)]>ci[1][slot.get(5)];
								
								if(check1&&check2&&check3&&check4&&check5)	
								{
									ci[2][slot.get(2)] = (2^(i+1));
									ci[2][slot.get(5)] = (2^(i+1));
								}

							}
							break;
						}
					}
				}
			}
		}
	}
	
	public static void count1(int[][] ci)
	{
		
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
