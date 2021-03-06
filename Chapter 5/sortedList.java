//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package sortedList;

import Links.Link;

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
        
        System.out.println("");
        System.out.println("Size:" + linkedQueue.size());
    } 
}
