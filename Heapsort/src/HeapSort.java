import java.util.*;

public class HeapSort 
{ 
	public static void heapSort(int n, int arr[]) 
	{
		for (int i = n / 2 - 1; i >= 0; i--) 
			heapify(arr, n, i);
		for (int i = n-1; i >= 0; i--) 
		{ 
			int temp = arr[0]; 
			arr[0] = arr[i]; 
			arr[i] = temp;
			heapify(arr, i, 0); 
		} 
	}
	public static void heapify(int arr[], int n, int i) 
	{ 
		int high = i;
		int l = 2*i + 1;
		int r = 2*i + 2; 
		if (l < n && arr[l] > arr[high]) 
			high = l; 
		if (r < n && arr[r] > arr[high]) 
			high = r;
		if (high != i) 
		{ 
			int temp = arr[i]; 
			arr[i] = arr[high]; 
			arr[high] = temp;
			heapify(arr, n, high); 
		} 
	}
	static void display(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; i++) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of Array : ");
		int n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter the elements of the Array : ");
		for(int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		heapSort(n, arr); 

		System.out.println("Array after sorting : ");
		display(arr);
	} 
} 
