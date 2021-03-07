import java.io.*; 
import java.util.*; 

class RadixSort
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the array : ");
		int n = sc.nextInt();
		System.out.println("Enter the elements of the array : ");
		int arr[] = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		radixSort(arr, n); 
		display(arr, n);
	}
	static int getMax(int arr[], int n)
	{
		int max = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > max)
				max = arr[i];
		return max;
	}
	static void countSort(int arr[], int n, int ele)
	{
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		for (i = 0; i < n; i++)
			count[(arr[i] / ele) % 10]++;
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		for (i = n - 1; i >= 0; i--)
		{
			output[count[(arr[i] / ele) % 10] - 1] = arr[i];
			count[(arr[i] / ele) % 10]--;
		}
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}
	static void radixSort(int arr[], int n)
	{
		int m = getMax(arr, n);
		for (int ele = 1; m / ele > 0; ele *= 10)
			countSort(arr, n, ele);
	}
	static void display(int arr[], int n)
	{
		System.out.println("Elements after sorting : ");
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
}
