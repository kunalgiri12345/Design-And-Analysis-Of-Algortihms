import java.util.*;

class QuickSort
{
	public static int partition(int arr[], int low, int high)
	{
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++)
		{
			if (arr[j] <= pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;
		return (i + 1);
	}
	public static void quickSort(int arr[], int low, int high)
	{
		if (low < high)
		{
			int pi = partition(arr, low, high);
			quickSort(arr, low, pi - 1);
			quickSort(arr, pi + 1, high);
	    }
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of the Array : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		System.out.println("Enter the elements of the Array : ");
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		System.out.println("Array before Sorting : ");
		for(int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		quickSort(arr, 0, n - 1);
		
		System.out.println("Array after Sorting : ");
		System.out.println(Arrays.toString(arr));
		
		sc.close();
	}
}