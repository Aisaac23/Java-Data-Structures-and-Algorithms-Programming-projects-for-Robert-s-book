// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub
   {
   private long[] a;                
   private int nElems;              
   
   public ArrayBub(int max)         
   {
      a = new long[max];                
      nElems = 0;                       
   }
   
   public void insert(long value)    
   {
      a[nElems] = value;            
      nElems++;                     
   }

   public void display()             
   {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
   }
   
   public void bubbleSort()
   {
      int out, in;

      for(out=nElems-1; out>1; out--)   // outer loop (backward)
         for(in=0; in<out; in++)        // inner loop (forward)
            if( a[in] > a[in+1] )       // out of order?
               swap(in, in+1);          // swap them
   } 

   

//************************* Programming Projects: 3.1 *****************   
   public void bubbleSortBidirectional()
   {
      int out, in, outBackw, nst = 0;

      for(out=nElems-1; out>1; out--)
      {
          //System.out.print(out+".. ");this.display();
         for(in=nst; in<out; in++)
             //System.out.print(in + "........... ");this.display();
            if( a[in] > a[in+1] )       // out of order?
               swap(in, in+1);
         for (outBackw = in-1; outBackw >nst; outBackw--)
             //System.out.print(in+"********************* ");this.display();
             if( a[outBackw] < a[in-1] )       // out of order?
               swap(outBackw, outBackw-1)
          nst++;
      }
   } 
//************************************************************************

//************************* Programming Projects: 3.4 *****************   
public void oddEvenSort()
{       
    for (int k = 1; k <= nElems; k++)
    {
        System.out.println("pass #"+k);
        int m;
        if(k % 2 == 0)
            m = 0;
        else
            m = 1;
        
        while(m+1 < nElems) 
        {
            System.out.println("Comparing: [" + a[m] + "] & [" + a[m+1] +"]");
            if(a[m] > a[m+1])
               swap(m, m+1);
            m+=2;
        }
        
    }
}   
//****************************************************************************   

   private void swap(int one, int two)
      {
      long temp = a[one];
      a[one] = a[two];
      a[two] = temp;
      }

   }  // end class ArrayBub

class BubbleSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            
      ArrayBub arr, arr2;                
      arr = new ArrayBub(maxSize);  
      arr2 =  new ArrayBub(maxSize);
      
      arr.insert(77);               
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);
      for (int i = 0; i < maxSize-10; i++)
            arr.insert((long)(Math.random()*maxSize));
      for (int i = 0; i < maxSize; i++)
            arr2.insert((long)(Math.random()*maxSize));
      /*********** Testing: Programming Projects: 3.1 *******************/
      System.out.println("Unsorted array:");
      arr.display();
      arr.bubbleSortBidirectional();
      System.out.println("Sorted array:");
      arr.display(); 
      /********************************************************/
      
      /*********** Testing: Programming Projects: 3.4 *******************/
      
      System.out.println("Unsorted array:");
      arr2.display();
      arr2.oddEvenSort();
      System.out.println("Sorted array with odd-even sort:");
      arr2.display(); 
      /********************************************************/
      
      
      }  // end main()
   }  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
