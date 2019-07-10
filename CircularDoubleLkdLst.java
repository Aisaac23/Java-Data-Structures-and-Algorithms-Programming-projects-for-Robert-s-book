/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

/**
 *
 * @author Isaac
 */
public class CircularDoubleLkdLst {
    
    private CustomLink current;
    public CircularDoubleLkdLst()
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
    
}
