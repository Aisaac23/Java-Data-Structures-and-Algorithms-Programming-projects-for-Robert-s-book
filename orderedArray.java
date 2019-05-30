package orderedarray;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray
{
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public OrdArray(int max)          // constructor
      {
      a = new long[max];             // create array
      nElems = 0;
      }
   //-----------------------------------------------------------
   public int size()
      { return nElems; }
   //-----------------------------------------------------------

    public long[] getArray() 
    {
        long[] nArray = new long[nElems];
        System.arraycopy(a, 0, nArray, 0, nElems);
                 
        return nArray;
    }
   //*******************************************************************
    public long[] merge(long[] arr1, long[] arr2)// Programming project 2.4
    {
        int topMin, topMax;
        if(arr1.length <= arr2.length)
        {
            topMin = arr1.length;
            topMax = arr2.length;
        }
        else
        {
            topMin = arr2.length;
            topMax = arr1.length;
        }
        
        OrdArray mrg = new OrdArray(topMax+topMin);
        
        for (int i = 0; i < topMin; i++)
        {
            mrg.insert(arr1[i]);
            mrg.insert(arr2[i]);
        }
        
        if(arr1.length == topMax)
            for (int i = topMin; i < topMax; i++) 
                mrg.insert(arr1[i]);
        else
            for (int i = topMin; i < topMax; i++) 
                mrg.insert(arr2[i]);
                
        return mrg.getArray();
    }
    //*******************************************************************
   
    //*******************************************************************
    public int insertWithBinarySearch(long searchKey)// Programming project 2.4
    {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;

            if(a[curIn]==searchKey)
                return curIn;              // found it
            else if(lowerBound > upperBound)
                return nElems;             // can't find it
            else if(curIn + 1 <= nElems)
                    if(a[curIn] > searchKey)
                        if(a[curIn + 1] < searchKey)
                            return curIn + 1;
                        else
                            lowerBound = curIn + 1;
                    else if(curIn >0)
                        if(a[curIn - 1] > searchKey)
                            return curIn;
                        else
                            upperBound = curIn - 1;
                    else 
                        return curIn;
            else 
                    return nElems;
        }  // end while
    }  // end find()
   //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
      int j = this.insertWithBinarySearch(value);
      
        for(int k=nElems; k>j; k--)    // move bigger ones up
           a[k] = a[k-1];
      
      a[j] = value;                  // insert it
      nElems++;                      // increment size
    }  // end insert()
   
   //*******************************************************************
    public int findWithBinarySearch(long searchKey) // Programming project 2.4
    {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;

            if(a[curIn]==searchKey)
                return curIn;              // found it
            else if(lowerBound > upperBound)
                return nElems;             // can't find it
            else if(a[curIn] > searchKey)
                lowerBound = curIn + 1;        
            else
                upperBound = curIn - 1;
        }  // end while
    }  // end find()
    
    /**********************************************************************************/
   
    public boolean delete(long value)
      {
      int j = this.findWithBinarySearch(value);
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems-1; k++) // move bigger ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //-----------------------------------------------------------
    
   
   //-----------------------------------------------------------
   
   }  // end class OrdArray


////////////////////////////////////////////////////////////////
class OrderedApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;             // array size
        OrdArray arr, arr2;                  // reference to array
        arr = new OrdArray(maxSize);
        /***************Programming project 2.4***********************/
        for (int i = 0; i < maxSize; i++)
            arr.insert((long)(Math.random()*maxSize));
        
        System.out.println("After inserting with Binary Search:");
        arr.display();
        
        for (int i = 0; i < 50; i++) 
            arr.delete(i);
        System.out.println("After deleting with Binary Search:");
        arr.display();
            
        for (int i = 0; i < 10; i++) 
            if(arr.findWithBinarySearch(i) != arr.size())
                System.out.println("Found " + i);
            else
                System.out.println("Can't find " + i);
                
        System.out.println("");
        
        arr2 = new OrdArray(maxSize/2);
      
        for (int i = 0; i < maxSize/2; i++)
            arr2.insert((long)(Math.random()*maxSize));
        /*****************************************************/
        
        /*************** Programming project 2.5 ***************/
        System.out.println("Both arrays before merged:");
        arr.display();
        arr2.display();
      
        System.out.println("Merged array:");
        long[] mergedArray = arr.merge(arr.getArray(), arr2.getArray());
            for (int i = 0; i < mergedArray.length; i++)
                System.out.print("["+mergedArray[i]+"],");   
        /*****************************************************/
      }  // end main()
   }  // end class OrderedApp
