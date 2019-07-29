/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

/**
 *
 * @author Isaac
 */

/*********** Programming Projects: 4.4 ***********************/
public class PriorityQ extends Queue{

    public PriorityQ(int s) {
        super(s);
    }
    
    @Override
    public void insert(long item)
    {
        queArray[nItems++] = item;
    }

    @Override
    public long remove()
    {    
        this.insertionSort();
        return queArray[--nItems]; 
    }
   
   
    private void insertionSort()
    {
        int in, out;
        for ( out = 1; out < nItems; out++ )
        {
            long temp = queArray[out];
            in = out;
            while(in > 0 && queArray[in - 1] <= temp)
            {
                queArray[in] = queArray[in - 1];
                --in;
            }
            queArray[in] = temp;
        }
    }
    public long peekMin()
    { 
        return queArray[nItems-1]; 
    }
    
    @Override
    public void displayQueue()
    {
        rear = nItems-1;
        front = 0;
        super.displayQueue();
    }
/*******************************************************************/  
}
