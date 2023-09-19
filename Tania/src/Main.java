import java.io.*;
import java.lang.*;
class Sort
{
    public static void main(String args[])throws IOException
    {
        int ch;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        do
            
        {
            System.out.println("\n\n\n1.Bubble Sort\n2.Selection Sort\n3.Insertion Sort.\n4.MergeSort.\n5.Exit.");
            ch=Integer.parseInt(br.readLine());
            if(ch==6)
                return;
            System.out.println("Enter n");
            int n=Integer.parseInt(br.readLine());
            int a[]=new int[n];
            for(int i=0;i<n;i++)
            {
                a[i]=Integer.parseInt(br.readLine());
            }
            switch(ch)
            {
                case 1:
                    BubbleSort(a,n);
                    break;
                case 2:
                    SelectionSort(a,n);
                    break;
                case 3:
                    InsertionSort(a,n);
                    break;
                
                case 4:
                    MergeSort(a,n);
                    print(a,n);
                    break;
            }

        }
        while(ch!=6);
    }
    
   public static void BubbleSort(int a[], int n) {
    long startTime = System.nanoTime(); 
    int temp;
    boolean swap;
    for (int i = 0; i < n - 1; i++) {
        swap = false;
        for (int j = 0; j < n - 1; j++) {
            if (a[j] > a[(j + 1)]) {
                temp = a[j];
                a[j] = a[(j + 1)];
                a[(j + 1)] = temp;
                swap = true;
            }
        }
        if (!swap) {
            break;
        }
    }
    long endTime = System.nanoTime(); 
    long duration = endTime - startTime; 

    System.out.println("Tempo de execução do BubbleSort: " + duration + " nanossegundos");
    print(a, n);
}

    public static void SelectionSort(int a[], int n) {
    long startTime = System.nanoTime(); 
    for (int i = 0; i < n - 1; i++) {
        int imin = i;
        int temp;
        for (int j = i + 1; j < n; j++) {
            if (a[j] < a[imin])
                imin = j;
        }
        temp = a[i];
        a[i] = a[imin];
        a[imin] = temp;
    }
    long endTime = System.nanoTime(); 
    long duration = endTime - startTime; 

    System.out.println("Tempo de execução do SelectionSort: " + duration + " nanossegundos");
    print(a, n);
}

    public static void InsertionSort(int a[], int n) {
    long startTime = System.nanoTime(); 
    for (int i = 1; i < n; i++) {
        int val = a[i];
        int hole = i;
        while (hole > 0 && a[hole - 1] > val) {
            a[hole] = a[hole - 1];
            hole = hole - 1;
        }
        a[hole] = val;
    }
    long endTime = System.nanoTime(); 
    long duration = endTime - startTime; 

    System.out.println("Tempo de execução do InsertionSort: " + duration + " nanossegundos");
    print(a, n);
}

  public static void MergeSort(int a[], int n) {
    // Somente meça o tempo na primeira chamada
    if (n <= 1) {
        return;
    }

    if (n == a.length) {
        long startTime = System.nanoTime();
        MergeSort(a, n, startTime);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Tempo de execução do MergeSort: " + executionTime + " nanossegundos");
    } else {
        MergeSort(a, n, 0); 
    }
}

private static void MergeSort(int a[], int n, long startTime) {
    if (n <= 1)
        return;
    int mid = n / 2;
    int left[] = new int[mid];
    int right[] = new int[n - mid];
    for (int i = 0; i < mid; i++)
        left[i] = a[i];
    for (int i = mid; i < n; i++)
        right[i - mid] = a[i]; 
    MergeSort(left, mid, startTime);
    MergeSort(right, n - mid, startTime);

    
}



   
    
    
    public static void print(int a[],int n)
    {
        System.out.println();
        for(int i=0;i<n;i++)
            System.out.print(a[i]+"\t");
    }
}