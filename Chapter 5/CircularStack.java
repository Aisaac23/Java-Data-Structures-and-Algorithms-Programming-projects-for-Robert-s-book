//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

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
