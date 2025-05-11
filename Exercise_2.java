class QuickSort 
{ 
    // Time Complexity : O(nlogn) -> most of the cases (O(n^2) in real worst cases like wrong pivot chosen)
    // Space Complexity : O(log n) -> recursive calls stack (O(n) if worst pivot chose, completely imbalanced tree)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : took time to understand it and brush up again properly
    
    
    /* This function takes last element as pivot, 
       places the pivot element at its correct 
       position in sorted array, and places all 
       smaller (smaller than pivot) to left of 
       pivot and all greater elements to right 
       of pivot */
     //creating one more function to take median for effectively choosing pivot  
    int medianOfThree(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int a = arr[low], b = arr[mid], c = arr[high];
        // Find median of a, b, c
        if ((a > b) != (a > c)) return low;
        else if ((b > a) != (b > c)) return mid;
        else return high;
    }
    
    void swap(int arr[],int i,int j){
        //Your code here
        //swapping using third variable to be safe (rather than XOR)
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    int partition(int arr[], int low, int high) 
    { 
   	//Write code here for Partition and Swap 
   	// Use median-of-three to choose a pivot
    int pivot_idx = medianOfThree(arr, low, high);
    // Move pivot to end
    swap(arr, pivot_idx, high);  
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
        if (arr[j] < pivot) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, high);
    return i + 1;
    } 
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    void sort(int arr[], int low, int high) 
    {  
            // Recursively sort elements before 
            // partition and after partition 
        if (low < high) {
        int pidx = partition(arr, low, high);

        sort(arr, low, pidx - 1);
        sort(arr, pidx + 1, high);
        }
    } 
  
    /* A utility function to print array of size n */
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
    } 
  
    // Driver program 
    public static void main(String args[]) 
    { 
        int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
    } 
} 
