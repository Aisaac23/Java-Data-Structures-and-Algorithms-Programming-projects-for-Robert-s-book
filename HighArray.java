package higharray;

// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArray
////////////////////////////////////////////////////////////////
class HighArray
{
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }
   //-----------------------------------------------------------
    public boolean find(long searchKey)
    {                              // find specified value
        int j;
        for(j=0; j<nElems; j++)            // for each element,
            if(a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if(j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()
   //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }
   //-----------------------------------------------------------
    public boolean delete(long value)
    {
        int j;
        for(j = 0; j < nElems; j++)        // look for it
            if(value == a[j])
                break;
        if(j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for(int k = j; k < nElems-1; k++) // move higher ones down
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
   public long getMax()//Programming projects 2.1      
    {
        long value = -1;
        for(int j=0; j<nElems; j++)        // look for it
           if( a[j] > value )
               value = a[j];
        return value; 
    }  // end getMax()
   //-----------------------------------------------------------
  public long deleteMax()
  {
    long value = -1;
    int pm = 0, fm;//fm = finding max
    if(nElems > 0)                          
    {
        for(fm = 0; fm < nElems; fm++)        // look for it, pm = position of max
            if(a[fm] > value)
            {
                value = a[fm];
                pm = fm;
            }
        
        for(int k = pm; k < nElems-1; k++) // move higher ones down
            a[k] = a[k+1];
        nElems--;
        return value;
    }
    else
        return -1;
   
   }  // end delete()
   
   //-----------------------------------------------------------
  
    public int noDups()
    {
    int dups = 0;

    for (int i = 0; i < nElems; i++) 
        for (int j = 0; j < nElems; j++) 
            if(this.a[i] == a[j] && j != i && a[i] != -1)
            {
                a[j] = -1;
                dups++;
            }

    for (int i = 0; i < nElems; i++)
        this.delete(-1);
    return dups;
  }
          
  //-----------------------------------------------------------
   }  // end class HighArray

 //-----------------------------------------------------------
   
////////////////////////////////////////////////////////////////
class HighArrayApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

        arr.insert(65);               // insert items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(8);
        arr.insert(11);
        arr.insert(00);
        arr.insert(77);
        arr.insert(33);
        arr.insert(9);

        /***** You can alternatively use the following code to generate random arrays
            int maxSize = (int)(Math.random()*100);            // array size
            HighArray arr;                // reference to array
            arr = new HighArray(maxSize); // create the array

            for (int i = 0; i < maxSize; i++)
                arr.insert((long)(Math.random()*maxSize));
         */
        
        /******************Testing: Programming projects 2.1 & 2.2 ************************/
        for (int i = 0; i < 11; i++) 
        {
            arr.display();                
            System.out.println("getMax: " + arr.getMax());
            System.out.println("deleteMax: " + arr.deleteMax());
            System.out.print("Array after deleteMax: ");
            arr.display();
        }

        /**********************************************************************************/
        
        /******************Testing: Programming projects 2.3 ******************************/
        for (int i = 0; i < maxSize; i++)
                arr.insert((long)(Math.random()*maxSize));
        
        System.out.println("");
        System.out.println("Unsorted array: ");
        arr.display();

        long max = 0;
        System.out.println("Sorted array: ");
        System.out.print("[");
        while((max = arr.deleteMax())!=-1)
              System.out.print(max + ", ");
        System.out.println("]");
        System.out.println("");
        /***********************Testing: Programming projects 2.6****************************/
        for (int i = 0; i < 20; i++)
                arr.insert((long)(Math.random()*20));
        
        System.out.println("Arrray with duplicates: ");
        arr.display();
        System.out.println("dups: "+ arr.noDups());
        System.out.println("Arrray with N0 duplicates: ");
        arr.display();
    
      }  // end main()
   }  // end class HighArray
