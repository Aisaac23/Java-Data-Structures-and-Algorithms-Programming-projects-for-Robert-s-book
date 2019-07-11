/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

public class CircularList {

    
    private CustomLink current;
    public CircularList()
    {
        this.current = null;
    }

    public CustomLink getCurrent() {
        return current;
    }

    public void setCurrent(CustomLink current) {
        this.current = current;
    }
    
    
    
    public boolean isEmpty()
    {
        return this.current == null;
    }
   
    /****************** Programming projects: 5.3 ***********************/
    public void insert(long id, double dd)
    {
        CustomLink item = new CustomLink(id, dd);
        if( this.isEmpty() )
        {
            current = item;
            current.setNext(current);
        }
        else
        {
            item.setNext(current.getNext());
            current.setNext(item);
            current = item;
        }
    }
    
    public CustomLink find( double dd )
    {
        if( !this.isEmpty() )
        {
            CustomLink toMove = current;
            if( toMove.getdData() == dd )
                return toMove;
            else
            {
                long ref = toMove.getiData();
                toMove = (CustomLink) toMove.getNext();
                
                while( toMove.getdData()!=dd && toMove.getiData()!=ref )
                    toMove = (CustomLink) toMove.getNext();
                
                return ( toMove.getdData()==dd ) ? toMove : null;
            }
        }
        return null;
    }
    
    public void display()
    {
        if(!this.isEmpty())
        {
            CustomLink temp = current;
            long ref = temp.getiData();
            temp = (CustomLink) temp.getNext();
            while(temp.getiData() != ref)
            {
                temp.displayLink();
                temp = (CustomLink) temp.getNext();
            }
            temp.displayLink();
            System.out.println("");
        }
        else
            System.out.println("Empty list.");
    }
    
    public CustomLink delete(double dd)
    {
        if( !this.isEmpty() )
        {
            CustomLink toDelete, temp, prev;
            toDelete = this.find(dd);
            if( toDelete != null)
            {
                prev = current;
                temp = (CustomLink) current.getNext();
                while( temp.getiData() != toDelete.getiData() )
                {
                    prev = temp;
                    temp = (CustomLink) temp.getNext();
                }
                prev.setNext(toDelete.getNext());
                current = prev;
                return toDelete;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        int maxSize = 100;
        CircularList Clist = new CircularList(); 
        for (int i = 0; i < maxSize/2; i++)
            Clist.insert(i, (long)(Math.random()*maxSize));
        Clist.display();
        
        for (int i = 0; i < maxSize; i++)
        {
            long toFind = (long)(Math.random()*maxSize);
            CustomLink found = Clist.find(toFind);
            if(found != null)
                System.out.println("[" + toFind + "] found at the key: " + found.getiData() );
            else
                System.out.println("[" + toFind + "] Not found");
        }
        System.out.println("");
        System.out.println("Deleting");
        for (int i = 0; i < maxSize; i++)
        {
            long toFind = (long)(Math.random()*maxSize);
            CustomLink found = Clist.delete(toFind);
            if(found != null)
                System.out.println("[" + toFind + "] deleted at the key: " + found.getiData() );
            else
                System.out.println("[" + toFind + "] Not found");
        }
        System.out.println("");
        Clist.display();
        
        System.out.println("Circular Stack: ");
        
        CircularStack cStack = new CircularStack();
        System.out.println("Inserting....");
        for (int i = 0; i < maxSize; i++)
            cStack.insert(i, (long)(Math.random()*maxSize));   
        cStack.display();
        System.out.println("");
        System.out.println("Deleting....");
        for (int i = 0; i < maxSize; i++)
        {
            System.out.print("Peek first: ");
            cStack.peekCurrent().displayLink();
            System.out.print("Deleted:");
            cStack.Pop().displayLink();
            System.out.println("");
        }
        cStack.display();
        
        System.out.println("Circular Queue: ");
        
        CircularQueue CQueue = new CircularQueue();
        
        System.out.println("Inserting....");
        for (int i = 0; i < maxSize; i++)
            CQueue.insert(i, (long)(Math.random()*maxSize));
        CQueue.display();
        
        System.out.print("Peek front:");
        CQueue.peekFront().displayLink();
        System.out.println("");
        System.out.println("Peek Rear");
        CQueue.peekRear().displayLink();
        
        System.out.println("");
        System.out.println("Removing: ");
        for (int i = 0; i < maxSize; i++)
        {
            System.out.print("Peek front: ");
            CQueue.peekFront().displayLink();
            System.out.print("Deleted:");
            CQueue.Remove().displayLink();
            System.out.println("");
        }
        CQueue.display();
        
        System.out.println("CIRCULAR DOUBLE LINKED LIST: ");
        CircularDoubleLkdLst CDlist = new CircularDoubleLkdLst(); 
        for (int i = 0; i < maxSize/2; i++)
            CDlist.insert(i, (long)(Math.random()*maxSize));
        System.out.println("Backwards:");
        CDlist.displayBackwards();
        System.out.println("Forwards:");
        CDlist.displayForwards();
        
        
        System.out.println("");
        System.out.println("Deleting");
        /*for (int i = 0; i < maxSize/2; i++)
        {
            long toFind = (long)(Math.random()*maxSize);
            CustomDoubleLink found = CDlist.delete(toFind);
            if(found != null)
                System.out.println("[" + toFind + "] deleted at the key: " + found.getiData() );
            else
                System.out.println("[" + toFind + "] Not found");
        }*/
        boolean swt = false;
        for (int i = 0; i < maxSize/2; i++)
        {
            long toFind = (long)(Math.random()*maxSize);
            CustomDoubleLink found;
            if(swt)
                found = CDlist.deleteLast();
            else
                found = CDlist.deleteFirst();
            if(found != null)
                System.out.println("[" + toFind + "] deleted at the key: " + found.getiData() );
            else
                System.out.println("[" + toFind + "] Not found");
            swt = !swt;
        }
        
        System.out.println("");
        CDlist.displayForwards();
        
    }
    
}
