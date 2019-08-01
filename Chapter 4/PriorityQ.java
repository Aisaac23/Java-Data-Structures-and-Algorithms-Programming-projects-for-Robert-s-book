//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package Queue;

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
