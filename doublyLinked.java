package doublyLinked;

// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link
{
    private long dData;
    private Link next;
    private Link previous;

    public Link(long d)
    { dData = d; }
    
    public void displayLink()
    { System.out.print("{" + dData + "}"); }

    public long getdData() {
        return dData;
    }

    public void setdData(long dData) {
        this.dData = dData;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }

}

class DoublyLinkedList
{
    private Link first;
    private Link last;
    
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    { return first==null; }
    
    public void insertFirst(long dd)
    {
        Link newLink = new Link(dd);

        if( isEmpty() )
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }
    
    public void insertLast(long dd)
    {
        Link newLink = new Link(dd);
        if( isEmpty() )
            first = newLink;
        else
        {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public Link deleteFirst()         
    {                             
        Link temp = first;
        if(first.getNext() == null)
            last = null;
        else
            first.getNext().setPrevious(null);
        first = first.getNext();
        return temp;
    }

    public Link deleteLast()
    {
        Link temp = last;
        if(first.getNext() == null)        
            first = null; 
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    }
    /* Eliminating bellow methods since they shouldn't be accessible for subclass: LinkedDeQueue
    public boolean insertAfter(long key, long dd)
    {                             
        Link current = first;
        while(current.dData != key)
        {
            current = current.next; 
            if(current == null)
                return false; 
        }
        Link newLink = new Link(dd); 

        if(current==last) 
        {
            newLink.next = null; 
            last = newLink; 
        }
        else     
        {
            newLink.next = current.next; 
            current.next.previous = newLink;
        }
        newLink.previous = current;    
        current.next = newLink;  
        return true;  
    }

    public Link deleteKey(long key)
    {                             
        Link current = first; 
        while(current.dData != key)
        {
            current = current.next;
            if(current == null)
                return null;
        }
        if(current==first)
            first = current.next;
        else
            current.previous.next = current.next;
        if(current==last)
            last = current.previous;
        else
            current.next.previous = current.previous;
        return current;
    }

    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        Link current = last;           
        while(current != null)         
        {
            current.displayLink(); 
            current = current.previous; 
        }
        System.out.println("");
    }
*/
    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        Link current = first;
        while(current != null)
        {
            current.displayLink();
            current = current.getNext();
            System.out.print("<->");
        }
        System.out.println("NULL");
    }

    public Link getFirst() {
        return first;
    }

    public Link getLast() {
        return last;
    }
    
    
    
   }  // end class DoublyLinkedList

class LinkedDeQueue extends DoublyLinkedList
{
    public void peekRight()
    {this.getFirst().displayLink();}
    
    public void peekLeft()
    {this.getLast().displayLink();}
    
    public long size()
    {
        Link current = this.getFirst();
        long size = 0;
        while(current != null)
        {
            current = current.getNext();
            size++;
        }
        return size;
    }
}

class DoublyLinkedApp
{
    public static void main(String[] args)
    {      
        long maxSize = 100;
        int queueSize = 20;
        LinkedDeQueue theList = new LinkedDeQueue();

        System.out.println("Inserting on the right-side: ");
        for (int i = 0; i < queueSize; i++)
            theList.insertFirst( (long)(Math.random()*maxSize) );
        theList.displayForward();
        
        System.out.println("Inserting on the left-side: ");
        for (int i = 0; i < queueSize; i++)
            theList.insertLast( (long)(Math.random()*maxSize) );
        theList.displayForward();
        
        System.out.println("Deleting from the right-side: ");
        for (int i = 0; i < queueSize/2; i++)
        {
            theList.deleteFirst().displayLink();
            System.out.println("");
        }
        
        System.out.println("Deleting from the left-side: ");
        for (int i = 0; i < queueSize/2; i++)
        {
            theList.deleteLast().displayLink();
            System.out.println("");
        }
        
        theList.displayForward();
        System.out.println("Size: " + theList.size());
        System.out.print("Front: ");
        theList.peekRight();
        System.out.print("Right: ");
        theList.peekLeft();
      }  // end main()
   }  // end class DoublyLinkedApp
////////////////////////////////////////////////////////////////
