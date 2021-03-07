// Java program to sort an array
// using bucket sort
import java.util.*;
import java.util.Collections;

class BucketSort 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of array : ");
		int n = sc.nextInt();
		float arr[] = new float[n];
		System.out.println("Enter the elements of the array : ");
		for(int i = 0; i < n; i++)
			arr[i] = (float)sc.nextFloat();
//		bucketSort(arr, n);
		Arrays.sort(arr);
		System.out.println("Sorted array is ");
		for (float el : arr) 
			System.out.print(el + " ");
	}
	static void bucketSort(float arr[], int n)
	{
		Vector<Float>[] buckets = new Vector[n];
		for (int i = 0; i < n; i++)
			buckets[i] = new Vector<Float>();
		for (int i = 0; i < n; i++)
		{
			float idx = arr[i] * n;
			buckets[(int)idx].add(arr[i]);
		}
		for (int i = 0; i < n; i++)
			Collections.sort(buckets[i]);
		int index = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < buckets[i].size(); j++)
				arr[index++] = buckets[i].get(j);
		}
	}
}
