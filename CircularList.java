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
        
    }
    
}
