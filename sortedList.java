package sortedList;

// sortedList.java
// demonstrates sorted list
// to run this program: C>java SortedListApp
////////////////////////////////////////////////////////////////
class Link
{
    private long dData;                  
    private Link next;                   
   
    public Link(long dd)                
    { dData = dd; }
   
    public void displayLink()           
    { System.out.print("{" + dData + "}"); }

    public long getdData() { return dData; }

    public Link getNext() { return next; }

    public void setdData(long dData) { this.dData = dData; }

    public void setNext(Link next) { this.next = next; }
      
}

class SortedList
{
    private Link first;
    public SortedList(){ first = null; }
    
    public boolean isEmpty(){ return (first==null); }
    
    public void insert(long key)        
    {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;
        
        while(current != null && key > current.getdData())
        {
            previous = current;
            current = current.getNext();
        }
        if(previous==null)
            first = newLink;
        else
            previous.setNext(newLink);
        newLink.setNext(current);
    }

    public Link remove()
    {                          
      Link temp = first;
      first = first.getNext();
      return temp;
    }
    
    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            System.out.print("->");
            current = current.getNext();
        }
        System.out.println("NULL");
    }

    public Link getFirst() {
        return first;
    }
    
}

class PriorityLinkedList extends SortedList
{
    
    public void peekMin()
    {this.getFirst().displayLink();}
    
}

class SortedListApp
{
    public static void main(String[] args)
    {                            
        PriorityLinkedList linkedQueue = new PriorityLinkedList();
        int maxSize = 20;
        for (int i = 0; i < maxSize; i++)
            linkedQueue.insert( (long)(Math.random()*maxSize) );
        
        System.out.println("Linked Queue: ");
        linkedQueue.displayList();
        System.out.println("");
        for (int i = 0; i < maxSize/2; i++)
        {
            System.out.print("Removed: ");
            linkedQueue.remove().displayLink();
            System.out.println("");
        }
        
        System.out.println("After deleting some: ");
        linkedQueue.displayList();
        
        System.out.print("@Top: ");
        linkedQueue.peekMin();
    } 
}
