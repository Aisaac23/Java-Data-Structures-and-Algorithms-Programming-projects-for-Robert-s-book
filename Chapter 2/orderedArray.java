package orderedarray;

//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////
class OrdArray
{
      private long[] a;                 
      private int nElems;              
   
      public OrdArray(int max) 
      {
         a = new long[max];            
         nElems = 0;
      }
   
      public int size()
      { return nElems; }
   
      public long[] getArray() 
      {
         long[] nArray = new long[nElems];
         System.arraycopy(a, 0, nArray, 0, nElems);      
         return nArray;
      }
    
      public long[] merge(long[] arr1, long[] arr2)// Programming project 2.5
      {
         int topMin, topMax;
         
         topMin = (arr1.length <= arr2.length) ? arr1.length : arr2.length;
         topMax = (arr1.length <= arr2.length) ? arr2.length : arr1.length;
            
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
   
      public int insertWithBinarySearch(long searchKey)// Programming project 2.4
      {
         int lowerBound = 0;
         int upperBound = nElems-1;
         int curIn;

           while(true)
           {
               curIn = (lowerBound + upperBound ) / 2;

               if(a[curIn]==searchKey)
                   return curIn;              
               else if(lowerBound > upperBound)
                   return nElems; 
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

   public void insert(long value)
   {
      int j = this.insertWithBinarySearch(value);
      for(int k=nElems; k>j; k--) 
         a[k] = a[k-1];
      a[j] = value;
      nElems++;
   }  // end insert()
   
   public int findWithBinarySearch(long searchKey) // Programming project 2.4
   {
      int lowerBound = 0;
      int upperBound = nElems-1;
      int curIn;
      
      while(true)
      {
         curIn = (lowerBound + upperBound ) / 2;

         if(a[curIn]==searchKey)
             return curIn;              
         else if(lowerBound > upperBound)
             return nElems;       
         else if(a[curIn] > searchKey)
             lowerBound = curIn + 1;        
         else
             upperBound = curIn - 1;
      }  
   }  
   
   public boolean delete(long value)
   {
      int j = this.findWithBinarySearch(value);
      if(j==nElems)            
         return false;
      else
      {
         for(int k=j; k<nElems-1; k++)
            a[k] = a[k+1];
         nElems--;                
         return true;
      }
   }

   public void display()             
   {
      for(int j=0; j<nElems; j++)       
         System.out.print(a[j] + " "); 
      System.out.println("");
   }
}  // end class OrdArray

class OrderedApp
{
    public static void main(String[] args)
    {
        int maxSize = 100;
        OrdArray arr, arr2; 
        arr = new OrdArray(maxSize);
       
        /***************Testing Programming project 2.4***********************/
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
        /************************************************************************/
        
        /******************** Testing Programming project 2.5 *******************/
        System.out.println("Both arrays before merged:");
        arr.display();
        arr2.display();
      
        System.out.println("Merged array:");
        long[] mergedArray = arr.merge(arr.getArray(), arr2.getArray());
            for (int i = 0; i < mergedArray.length; i++)
                System.out.print("["+mergedArray[i]+"],");   
        /************************************************************************/
      }  // end main()
   }  // end class OrderedApp
