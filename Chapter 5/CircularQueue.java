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
public class CircularQueue extends CircularList{
    
    public CustomLink peekFront()
    {
        return this.getCurrent();
    }
    
    public CustomLink peekRear()
    {
        return (CustomLink) this.getCurrent().getNext();
    }

    public CustomLink Remove() {
        if( !this.isEmpty() )
        {
            CustomLink toDelete, temp, prev;
            if( this.getCurrent().getNext() == this.getCurrent() )
            {
                temp = this.getCurrent();
                this.setCurrent(null);
                return temp;
            }
            
            toDelete = this.getCurrent();
            prev = this.getCurrent();
            temp = (CustomLink) this.getCurrent().getNext();
            
            while( temp != toDelete )
            {
                prev = temp;
                temp = (CustomLink) temp.getNext();
            }
            prev.setNext( toDelete.getNext() );
            this.setCurrent( prev );
            return toDelete;
        }
        
        return null;
    }

    @Override
    public void insert(long id, double dd) {
        CustomLink newLink = new CustomLink(id, dd);
        
        if( this.isEmpty() )
        {
            this.setCurrent( newLink );
            this.getCurrent().setNext( this.getCurrent() );
        }
        else
        {
            newLink.setNext( this.getCurrent().getNext() );
            this.getCurrent().setNext( newLink );
        }
    }

    @Override
    public CustomLink delete(double dd) {
        System.out.println("Method not available");
        return null;
    }
    
    
    
}
