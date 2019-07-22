package LinkedLists;

import Links.*;
// doublyLinked.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class DoublyLinkedList
{
    private DoubleLink first;
    private DoubleLink last;
    
    public DoublyLinkedList()
    {
        first = null;
        last = null;
    }

    public boolean isEmpty()
    { return first==null; }
    
    
    
    public void insertFirst(DoubleLink newLink)
    {
        if( isEmpty() )
            last = newLink;
        else
            first.setPrevious(newLink);
        newLink.setNext(first);
        first = newLink;
    }
    
    public void insertLast(DoubleLink newLink)
    {
        if( isEmpty() )
            first = newLink;
        else
        {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
    }

    public DoubleLink deleteFirst()         
    {                             
        DoubleLink temp = first;
        if(first.getNext() == null)
            last = null;
        else
        {
            DoubleLink toDelete = (DoubleLink)first.getNext();
            toDelete.setPrevious(null);
        }
        first = (DoubleLink)first.getNext();
        return temp;
    }

    public DoubleLink deleteLast()
    {
        DoubleLink temp = last;
        if(first.getNext() == null)        
            first = null; 
        else
            last.getPrevious().setNext(null);
        last = last.getPrevious();
        return temp;
    }
     //Eliminating bellow methods since they shouldn't be accessible for subclass: LinkedDeQueue
    public boolean insertAfter(DoubleLink newLink, long key)
    {                             
        DoubleLink current = first;
        while(current.getiData() != key)
        {
            current = (DoubleLink) current.getNext(); 
            if(current == null)
                return false; 
        } 
        if( current == last ) 
        {
            newLink.setNext(null);
            last = newLink; 
        }
        else     
        {
            newLink.setNext(current.getNext());
            DoubleLink temp = (DoubleLink) current.getNext();
            temp.setPrevious(newLink);
        }
        
        newLink.setPrevious(current);    
        current.setNext(newLink);  
        return true;  
    }
    
    public Link deleteKey(long key)
    {                             
        DoubleLink current = first; 
        while(current.getiData() != key)
        {
            current = (DoubleLink)current.getNext();
            if(current == null)
                return null;
        }
        if(current==first)
            first = (DoubleLink)current.getNext();
        else
            current.getPrevious().setNext( current.getNext() );

        if(current==last)
            last = current.getPrevious();
        else
        {
            DoubleLink temp = (DoubleLink) current.getNext();
            temp.setPrevious( current.getPrevious() );
        }
        
        return current;
    }
    public void displayBackward()
    {
        System.out.print("List (last-->first): ");
        DoubleLink current = last;           
        while(current != null)         
        {
            current.displayLink(); 
            current = (DoubleLink) current.getPrevious(); 
        }
        System.out.println("NULL");
    }

    public void displayForward()
    {
        System.out.print("List (first-->last): ");
        DoubleLink current = first;
        while(current != null)
        {
            current.displayLink();
            current = (DoubleLink)current.getNext();
            System.out.print("<->");
        }
        System.out.println("NULL");
    }

    public DoubleLink getFirst() {
        return first;
    }

    public DoubleLink getLast() {
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
        DoubleLink current = this.getFirst();
        long size = 0;
        while(current != null)
        {
            current = (DoubleLink)current.getNext();
            size++;
        }
        return size;
    }
}

class DoublyLinkedApp
{
    public static void main(String[] args)
    {
        System.out.println("Doubly Linked DeQueue:");
        long maxSize = 100;
        int queueSize = 20;
        LinkedDeQueue theList = new LinkedDeQueue();

        System.out.println("Inserting on the right-side: ");
        for (int i = 0; i < queueSize; i++)
            theList.insertFirst( new DoubleLink ((long)(Math.random()*maxSize)) );
        theList.displayForward();
        
        System.out.println("Inserting on the left-side: ");
        for (int i = 0; i < queueSize; i++)
            theList.insertLast( new DoubleLink ((long)(Math.random()*maxSize)) );
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
