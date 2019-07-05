/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlist;

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
    
    public void step(CustomLink move)
    {
        move = (CustomLink) move.getNext();
    }
    
    public long find( double dd )
    {
        long steps = -1;
        if( !this.isEmpty() )
        {
            CustomLink toMove = current;
            if( toMove.getdData() == dd )
                return 0;
            else
            {
                long ref = toMove.getiData();
                toMove = (CustomLink) toMove.getNext();//this.step(toMove);
                steps++;
                
                while( toMove.getdData()!=dd && toMove.getiData()!=ref )
                {
                    steps++;
                    toMove = (CustomLink) toMove.getNext();//this.step(toMove);
                }
                
                return ( toMove.getdData()==dd ) ? steps : -1;
            }
        }
        return steps;
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
    
    public static void main(String[] args) {
        int maxSize = 100;
        CircularList Clist = new CircularList(); 
        for (int i = 0; i < maxSize/2; i++)
            Clist.insert(i, (long)(Math.random()*maxSize));
        Clist.display();
        
    }
    
}
