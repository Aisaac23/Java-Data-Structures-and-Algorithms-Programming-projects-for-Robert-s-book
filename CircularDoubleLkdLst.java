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
    
    private CustomDoubleLink current;
    public CircularDoubleLkdLst()
    {
        this.current = null;
    }

    public CustomDoubleLink getCurrent() {
        return current;
    }

    public void setCurrent(CustomDoubleLink current) {
        this.current = current;
    }
    
    
    
    public boolean isEmpty()
    {
        return this.current == null;
    }
   
    /****************** Programming projects: 5.3 ***********************/
    public void insert(long id, double dd)
    {
        CustomDoubleLink item = new CustomDoubleLink(id, dd);
        if( this.isEmpty() )
        {
            current = item;
            current.setNext(current);
            current.setPrevious(current);
        }
        else
        {
            //Making head pointing to tails and tails pointing to tails
            item.setPrevious( current.getPrevious() );
            item.getPrevious().setNext( item );
            
            //Connecting current and new item
            item.setNext( current );
            current.setPrevious(item);
            
            current = item;
        }
    }
    
    public CustomDoubleLink find( double dd )
    {
        if( !this.isEmpty() )
        {
            CustomDoubleLink toMove = current;
            if( toMove.getdData() == dd )
                return toMove;
            else
            {
                long ref = toMove.getiData();
                toMove = (CustomDoubleLink) toMove.getNext();
                
                while( toMove.getdData()!=dd && toMove.getiData()!=ref )
                    toMove = (CustomDoubleLink) toMove.getNext();
                
                return ( toMove.getdData()==dd ) ? toMove : null;
            }
        }
        return null;
    }
    
    public void displayForwards()
    {
        if(!this.isEmpty())
        {
            CustomDoubleLink temp = current;
            temp.displayLink();
            long ref = temp.getiData();
            temp = (CustomDoubleLink) temp.getNext();
            while(temp.getiData() != ref)
            {
                temp.displayLink();
                temp = (CustomDoubleLink) temp.getNext();
            }
            
            System.out.println("");
        }
        else
            System.out.println("Empty list.");
    }
    
    public void displayBackwards()
    {
        if(!this.isEmpty())
        {
            CustomDoubleLink temp = current;
            long ref = temp.getiData();
            temp = (CustomDoubleLink) temp.getPrevious();
            while(temp.getiData() != ref)
            {
                temp.displayLink();
                temp = (CustomDoubleLink) temp.getPrevious();
            }
            temp.displayLink();
            System.out.println("");
        }
        else
            System.out.println("Empty list.");
    }
    
    public CustomDoubleLink delete(double dd)
    {
        if( !this.isEmpty() )
        {
            CustomDoubleLink toDelete, temp, prev;
            toDelete = this.find(dd);
            if( toDelete != null)
            {
                toDelete.getPrevious().setNext( toDelete.getNext() );
                toDelete.getNext().setNext( toDelete.getPrevious() );
                if(toDelete == current)
                    current = (CustomDoubleLink)current.getNext();
                return toDelete;
            }
        }
        return null;
    }
    
    public CustomDoubleLink deleteFirst()
    {
        if( current.getNext() == current && current.getPrevious() == current )
        {
            CustomDoubleLink temp = current;
            current = null;
            return temp;
        }
        
        if( !this.isEmpty() )
        {
            CustomDoubleLink prev, toDelete = current;
            prev = (CustomDoubleLink) current.getNext();
            prev.setPrevious( current.getPrevious() );
            current.getPrevious().setNext(current.getNext());
            current = (CustomDoubleLink) current.getNext();
            return toDelete;
        }
        return null;
    }
    
    public CustomDoubleLink deleteLast()
    {       
        if( !this.isEmpty() )
        {
            CustomDoubleLink prev = (CustomDoubleLink)current.getPrevious();
            current.setPrevious( current.getPrevious().getPrevious() );
            current.getPrevious().getPrevious().setNext( current );
            return prev;
        }
        return null;
    }
    
    
}
