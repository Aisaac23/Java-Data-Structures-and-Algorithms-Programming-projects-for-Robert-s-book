// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   
//************************* Programming Projects: 3.2 *****************
public long median()    // returns the median
{
    long[] backup = new long[this.nElems]; // we make a copy so we don't affect the array we're working with
    long med;
    System.arraycopy(this.a, 0, backup, 0, this.nElems);
    this.insertionSort();
    if(this.nElems % 2 == 0)
        med = (this.a[(nElems-1)/2] + this.a[(nElems-1)/2 +1])/2;
    else
        med = this.a[(nElems-1)/2];
    System.arraycopy(backup, 0, this.a, 0, this.nElems);
    return med;
}

public long[] getArray()
{
    return this.a;
}
//************************************************************************

//************************* Programming Projects: 3.3 *****************
public void noDups()
{
    int dups = 0;
    for(int out = 0; out < nElems - 1; out++)
    {
        int B = out, C = out + 1;
        if(a[B] == a[C])
        {
            while(C < nElems)
            {
                if(a[B] != a[C])
                {
                    B++;
                    a[B] = a[C];
                    if(C < nElems - 1)
                        if(a[C] == a[C+1])
                        {
                            C++;
                            dups++;
                        }
                    C++;
                }
                else
                {
                    C++;
                    dups++;
                }
            }
            out = C;
        }
     }
    this.nElems = this.nElems - dups;
}
//************************************************************************

   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print("["+a[j] + "]");  // display it
      System.out.println("");
      }
//************************* Programming Projects: 3.6 *****************
public void noDupsInsertSort()             
{
    int dups = 0;
    for(int out=0; out<nElems-1; out++)
    {

        int B = out, C = out + 1;
        while(a[out] == a[C])
        {
            C++;
            dups++;
        }
        int D = B;
        while(B + 1 < C  && C < nElems)
        {
            B++;
            a[B] = a[C];
            if(C < nElems - 1)
                if(a[C] == a[C+1])
                {
                    C++;
                    dups++;
                }
            C++;
        }
    }
    nElems = nElems - dups;
}
//************************* Programming Projects: 3.3 *****************

    
//************************* Programming Projects: 3.5 *****************
public void insertionSortWithResults()
{//This sort algorithm is in the oposite direction than the one without results to show the O(N^2) efficiency 
    int in, out, comps = 0, iter = 0, copies = 0;

    for(out=1; out<nElems; out++)     
    {
        long temp = a[out];
        copies++;
        in = out;                      
        while(in>0 && a[in-1] <= temp) 
        {
            a[in] = a[in-1];            
            --in;
            comps+=2;
            iter++;
            copies++;
        }
        comps+=2; //once it finishes counts two more because -while- compared to finish
        a[in] = temp;
        copies++;
        iter++;
    }  
    System.out.println("Comparisons: " + comps);
    System.out.print(", Iterations: " + iter);
    System.out.print(", Copies: " + copies);
    System.out.println("");
}
//*************************************************************************


public void insertionSort()
{
    int in, out;

    for(out=1; out<nElems; out++)     // out is dividing line
    {
        long temp = a[out];            // remove marked item
        in = out;                      // start shifts at out
        while(in > 0 && a[in-1] >= temp) // until one is smaller,
        {
                a[in] = a[in-1];            // shift item to right
                --in;
        }
        a[in] = temp;
    }  
}  // end insertionSort()
//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr, arr2;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array
      arr2 = new ArrayIns(maxSize);
      for (int i = 0; i < maxSize-10; i++)
            arr.insert((long)(Math.random()*maxSize));
      for (int i = 0; i < maxSize; i++)
            arr2.insert((long)(Math.random()*maxSize));
    //************************* Testing Programming Projects: 3.1, 3.2, 3.3 & 3.5 *****************
    System.out.println("Unsorted array:");
    arr.display();
    System.out.println("Median: " + arr.median());
    System.out.println("Sorted array:");
    arr.insertionSort();
    arr.display(); 

    System.out.println("Inversely Sorted array:");
    arr.insertionSortWithResults();
    arr.display();
    
    System.out.println("Without duplicates:");
    arr.noDups();
    arr.display();
    
    System.out.println("Inserting a few items...");
    System.out.println("");
    arr.insert(10);
    arr.insert(11);
    arr.insert(3);
    
    System.out.println("Sorted only a few items out of place:");
    arr.insertionSortWithResults();
    arr.display();
    //****************************************************************************

    //************************* Testing Programming Projects: 3.6 *****************
    System.out.println("");
    System.out.println("Unsorted array:");
    arr2.display();
    System.out.println("Sorted array (removing duplicates simultaneously):");
    arr.noDupsInsertSort();
    arr.display(); 
    }  // end main()
      
   }  // end class InsertSortApp