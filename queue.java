package Queue;

// Queue.java
////////////////////////////////////////////////////////////////

 
class Queue
{
    protected int maxSize;
    protected long[] queArray;
    protected int front;
    protected int rear;
    protected int nItems;
//--------------------------------------------------------------
    public Queue(int s)       
    {
        maxSize = s;
        queArray = new long[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }
//--------------------------------------------------------------
    public void insert(long j)   
    {
        if(rear == maxSize-1)         
            rear = -1;
        queArray[++rear] = j;         
        nItems++;                     
    }
//--------------------------------------------------------------
    public long remove()         
    {
        long temp = queArray[front++]; 
        if(front == maxSize)           
            front = 0;
        nItems--;  
        return temp;
    }
//--------------------------------------------------------------
    public long peekFront()      
    {
        return queArray[front];
    }
//--------------------------------------------------------------
    public boolean isEmpty()   
    {
        return (nItems==0);
    }
//--------------------------------------------------------------
    public boolean isFull()  
    {
        return (nItems==maxSize);
    }
//--------------------------------------------------------------
    public int size()
    {
        return nItems;
    }
    
    /*********** Programming Projects: 4.1 *******************/
    public void displayQueue()
    {
        if(!this.isEmpty())
        {
            int disp = front;
            if(front > rear)
            {
                while(disp < maxSize)
                    System.out.print("[" + this.queArray[disp++] + "]");
                disp = 0;
                while(disp <= rear)
                    System.out.print("[" + this.queArray[disp++] + "]");
            }
            else
                while(disp <= rear)
                    System.out.print("[" + this.queArray[disp++] + "]");
        }
        else
            System.out.println("Empty queue");
        System.out.println("");
    }
    /********************************************************************/

    /*********** Programming Projects: 4.2 ******************************/
    public class DeQueue extends Queue
    {
    
        public DeQueue(int s)  
        {
            super(s);    
        }

        public void insertRight(long j)
        {
            if(rear == maxSize-1) 
                rear = -1;
            super.queArray[++rear] = j;
            nItems++;
        }
        
        //  These methods would be necesary if we used privete members in the partent class (Queue)
        /*public void getSuperValues()
        {
            front = super.front;
            rear = super.rear;
        }

        public void setSuperValues()
        {
            super.front = front;
            super.rear = rear;
            super.nItems = nItems;
        }*/
        
    public void insertLeft(long x)
    {
        //this.getSuperValues();
        
        if(front == 0 && rear < maxSize -1)
        {         
           front = maxSize - 1;
           rear = maxSize - 1;
        }
        else if(front > 0)
            front--;
        super.queArray[front] = x;
        nItems++;
        
        //this.setSuperValues();
    }

    public long removeLeft()
    {
        //this.getSuperValues();
        
        long temp = super.queArray[front++]; 
        if(front > maxSize - 1)     
            front = 0;
        nItems--;          
        //this.setSuperValues();
        
        return temp;
    }
    
    public long removeRight()        
    {
        //this.getSuperValues();
        
        rear--;  
        if(rear <= -1)    
            rear = maxSize - 1;
        long temp = super.queArray[rear];
        nItems--;
        
        //this.setSuperValues();
        return temp;
    }
/*******************************************************************/
    
}//end class DeQueue
    
}  // end class Queue

/*********** Programming Projects: 4.3 *******************/

class DeQueueStack
    {
        Queue.DeQueue UserDeQueue;
        public DeQueueStack(int s) 
        {    
            UserDeQueue = new Queue(s).new DeQueue(s);   
        }
        
        public void push(long x)
        {
            this.UserDeQueue.insertLeft(x);
        }
        
        public long pop()
        {
            return this.UserDeQueue.removeLeft();
        }
        
        public long peek()
        {
            return this.UserDeQueue.peekFront();
        }
    }
/******************************************************************/

class QueueApp
{
    public static void main(String[] args)
    {
        Queue UserQueue;
        int maxSize = 20;
        int rem = 5;
        /*********** Testing: Programming Projects: 4.1 *******************/
        System.out.println("Filling completely the Queue");
        UserQueue =  new Queue(maxSize);
        for (int i = 0; i < maxSize; i++)
            UserQueue.insert((long)(Math.random()*maxSize));
        UserQueue.displayQueue();
        
        System.out.println("Full Queue");
        System.out.println("Removing items...");
        for (int i = 0; i < rem; i++) 
            UserQueue.remove();
        UserQueue.displayQueue();
        
        System.out.println("");
        System.out.println("Inserting items (breaking the sequence)...");
        for (int i = 0; i < rem/2; i++) 
            UserQueue.insert((long)(Math.random()*maxSize));
        UserQueue.displayQueue();
        
        System.out.println("Leaving only three items...");
        for (int i = 0; i < rem*3 -1 ; i++) 
            UserQueue.remove();
        UserQueue.displayQueue();
        
        System.out.println("Inserting items (On new rear position)...");
        UserQueue.insert((long)(Math.random()*maxSize));
        UserQueue.insert((long)(Math.random()*maxSize));
        UserQueue.displayQueue();
      /**********************************************************************/

        
      /************ Testing: Programming Projects: 4.2 **********************/
        Queue.DeQueue UserDeQueue;
        System.out.println("DEQUEUE..........................................");
        System.out.println("Filling from the left side (oposite direction than a normal Queue)");
        UserDeQueue = new Queue(maxSize).new DeQueue(maxSize);
        for (int i = 0; i < maxSize; i++)
            if(!UserDeQueue.isFull())
                UserDeQueue.insertLeft((long)(Math.random()*maxSize));
        UserDeQueue.displayQueue();
        
        System.out.println("Full Queue");
        System.out.println("Removing items from the left...");
        for (int i = 0; i < rem; i++) 
            UserDeQueue.removeLeft();
        UserDeQueue.displayQueue();
        
        System.out.println("");
        System.out.println("Inserting items from the left...");
        for (int i = 0; i < rem/2; i++) 
            UserDeQueue.insertLeft((long)(Math.random()*maxSize));
        UserDeQueue.displayQueue();
        
        System.out.println("Leaving only three items, from the right (opposite than normal)...");
        for (int i = 0; i < rem*3 -1 ; i++) 
            UserDeQueue.removeRight();
        UserDeQueue.displayQueue();
        
        System.out.println("Inserting items one left and one right...");
        UserDeQueue.insertLeft((long)(Math.random()*maxSize));
        UserDeQueue.insertRight((long)(Math.random()*maxSize));
        UserDeQueue.displayQueue();
        
        System.out.println("Leaving only one item... ");
        UserDeQueue.removeRight();
        UserDeQueue.removeLeft();
        UserDeQueue.displayQueue();
        System.out.println("............");
        UserDeQueue.removeRight();
        UserDeQueue.removeLeft();
        UserDeQueue.displayQueue();
        System.out.println("Zero items...");
        UserDeQueue.removeRight();
        UserDeQueue.displayQueue();
        
    /**********************************************************************/
        
    /*********** Testing: Programming Projects: 4.3 ***********************/
      
        DeQueueStack stackX = new DeQueueStack(maxSize);
        System.out.println("Pushing into the implemented Stack...");
        for (int i = 0; i < maxSize; i++)
        {
            long item = (long)(Math.random()*maxSize);
            stackX.push(item);
            System.out.println("Pushed: " + item);
        }
        System.out.println("Poping from the implemented Stack...");
        for (int i = 0; i < maxSize; i++)
            System.out.println("Poped: " + stackX.pop());
    /**********************************************************************/
    
    /*********** Testing: Programming Projects: 4.4 ***********************/
    PriorityQ pQ1 = new PriorityQ(maxSize);
    System.out.println("Filling the priority Q");
    for (int i = 0; i < maxSize; i++)
        pQ1.insert( (long)(Math.random()*maxSize) );
    
    System.out.println("Displaying full priorityQ");
    pQ1.displayQueue();
    
    System.out.println("Deleting half of the items");
    for (int i = 0; i < maxSize/2; i++)
        pQ1.remove();
    pQ1.displayQueue();
    
    System.out.println("Inserting some more items");
    for (int i = 0; i < 3; i++)
        pQ1.insert( (long)(Math.random()*maxSize) );
    pQ1.displayQueue();
    
    System.out.println("Deleting more items");
    for (int i = 0; i < 3; i++)
        pQ1.remove();
    pQ1.displayQueue();
    /**********************************************************************/
    
    /*********** Testing: Programming Projects: 4.5 ***********************/
    System.out.println("");
    System.out.println("SUPER MARKET SIMULATOR:");
    SuperMarket supermarket = new SuperMarket("SuperMarket_1");
    supermarket.start();
    /**********************************************************************/
    
    }
   
}
