public class quicksort {
    /*
    In the best case, the algorithm will divide the list into two equal size sub-lists. So, the first iteration of the full n-sized list needs O(n). Sorting the remaining two sub-lists with n/2 elements takes 2*O(n/2) each. As a result, the QuickSort algorithm has the complexity of O(n log n).

In the worst case, the algorithm will select only one element in each iteration, so O(n) + O(n-1) + … + O(1), which is equal to O(n2).

On the average QuickSort has O(n log n) complexity, making it suitable for big data volumes.
     */
    void sort(int arr[], int low, int high)
    {
        if(low<high)
        {
            int pi = partition(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    int partition(int arr[], int low, int high)
    {
     int i = (low-1);
     int pivot = arr[high];
     for(int j=low; j<high; j++)
     {
         if(arr[j]<pivot){
             i++;
             int temp = arr[j];
             arr[j] = arr[i];
             arr[i] = temp;
         }
     }
     int temp = arr[i+1];
     arr[i+1] = arr[high];
     arr[high] = temp;
     return (i+1);
    }

    public static void main(String args[])
    {
        int arr[] = {2, 1, 19, 23, 21, 4, 8};
        quicksort sorted = new quicksort();
        sorted.sort(arr, 0, 6);
        for(int i: arr){
            System.out.println(i);
        }
    }
}
