import java.util.Random;

public class test
{
	public static void main(String[] args)
	{
		Random rng = new Random();
		int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
		int x;
		int placeholder;
		for(int i = array.length-1; i > 0; i--)
		{
			x = rng.nextInt(i+1);
			placeholder = array[i];
			array[i] = array[x];
			array[x] = placeholder; 


		}
		for(int i: array)
		{
			System.out.print(i + " ");
		}
	}
				
	
}