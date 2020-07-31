public class heapsort
{
    public void sort(int arr[])
    {
        int n = arr.length;
        for(int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i);
        }
        for(int i= n-1; i>0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }
    void heapify(int arr[], int n, int i)
    {
        int large = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l<n && arr[l]>arr[large])
        {
            large = l;
        }

        if(r<n && arr[r]>arr[large])
        {
            large = r;
        }

        if(large != i)
        {
            int temp = arr[i];
            arr[i] = arr[large];
            arr[large] = temp;

            heapify(arr, n, large);
        }
    }
    public static void main(String args[])
    {
        int arr[] = {2, 19, 3, 22, 13, 7};
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();

        heapsort heap = new heapsort();
        heap.sort(arr);
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
