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
public class CircularStack extends CircularList{
    
    public CustomLink peekCurrent()
    {   
        return this.getCurrent();
    }
    
    public CustomLink Pop()
    {
        if( !this.isEmpty() )
        {
            CustomLink toDelete, temp, prev;
            if(this.getCurrent().getNext() == this.getCurrent() )
            {
                temp = this.getCurrent();
                this.setCurrent(null);
                return temp;
            }
            toDelete = this.getCurrent();
            prev = this.getCurrent();
            temp = (CustomLink) this.getCurrent().getNext();
            while( temp.getiData() != toDelete.getiData() )
            {
                prev = temp;
                temp = (CustomLink) temp.getNext();
            }
            prev.setNext(toDelete.getNext());
            this.setCurrent(prev);
            return toDelete;
        }
        return null;
    }
}
