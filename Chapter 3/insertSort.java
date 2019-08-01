//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

class ArrayIns
   {
   private long[] a;                
   private int nElems;
//--------------------------------------------------------------
   public ArrayIns(int max)          
      {
      a = new long[max];                
      nElems = 0;   
      }
//--------------------------------------------------------------
   public void insert(long value)  
      {
      a[nElems] = value; 
      nElems++;    
      }
//--------------------------------------------------------------
   
//************************* Programming Projects: 3.2 *****************
public long median()    
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

   public void display()             
      {
      for(int j=0; j<nElems; j++)       
         System.out.print("["+a[j] + "]"); 
      System.out.println("");
      }
//************************* Programming Projects: 3.6 *****************
public void noDupsInsertSort()             
{
    int in, out;

    for(out=1; out<nElems; out++)
    {
        long temp = a[out];    
        in = out;                      
        while(in>0 && a[in-1] >= temp) 
        {
            if(a[in-1] == temp)
                temp = -1;
            a[in] = a[in-1];  
            --in;            
        }
        a[in] = temp;
    } 
    
    System.out.println("Replaced  with -1: ");
    this.display();
    
    int B = 0, C = 0, dups = 0;
    for (int i = 0; i < nElems; i++)
    {
        while(C < nElems)
        {
            if(a[C] == -1)
            {
                C++;
                dups++;
            }
            else
            {
                a[i] = a[C];
                i++;
                C++; 
            }
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

    for(out=1; out<nElems; out++)     
    {
        long temp = a[out];           
        in = out;                     
        while(in > 0 && a[in-1] >= temp) 
        {
                a[in] = a[in-1];            
                --in;
        }
        a[in] = temp;
    }  
}  

   
   }  // end class ArrayIns

class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;           
      ArrayIns arr, arr2;                
      arr = new ArrayIns(maxSize);  
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
