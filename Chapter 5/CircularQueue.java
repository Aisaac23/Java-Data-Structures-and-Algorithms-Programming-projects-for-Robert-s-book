//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

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
