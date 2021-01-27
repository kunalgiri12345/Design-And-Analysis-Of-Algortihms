import java.util.Scanner;
class MergeSort 
{
	public static void main(String args[])
    {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array: ");
		int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the elements of array: ");
        for(int i = 0; i < n; i++)
        {
        	arr[i] = sc.nextInt();
        }
        System.out.println("Given Array");
        printArray(arr, n);
 
        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, n-1);
 
        System.out.println("Sorted array");
        printArray(arr, n);
    }
    void merge(int arr[], int left, int middle, int right)
    {
        int x = middle - left + 1;
        int y = right - middle;
        int leftArray[] = new int[x];
        int rightArray[] = new int[y];
        for (int i = 0; i < x; i++)
        {
        	leftArray[i] = arr[left + i];
        }
        for (int j = 0; j < y; ++j)
        {
        	rightArray[j] = arr[middle + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < x && j < y)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            }
            else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i < x)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < y)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int left, int right)
    {
        if (left < right) 
        {
            int middle = (left + right) / 2;
            sort(arr, left, middle);
            sort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}