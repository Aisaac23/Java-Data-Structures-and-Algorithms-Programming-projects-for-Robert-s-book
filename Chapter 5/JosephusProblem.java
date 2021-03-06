//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.Link;

public class JosephusProblem {
    
    CircularList JosephusCircle = new CircularList();
    int people;

    public JosephusProblem(int people) {
        this.people = people;
        for (int i = 1; i <= this.people; i++)
            JosephusCircle.insert(i, i);
    }

    public CircularList getJosephusCircle() {
        return JosephusCircle;
    }
    
    
    public LinkList JosephusProblem(int cOff, int starts)
    {
        int killer = cOff;
        LinkList eliminated = new LinkList();
        this.JosephusCircle.setCurrent( (CustomLink) this.JosephusCircle.find(starts) );
        
        while(this.JosephusCircle.getCurrent().getNext() != this.JosephusCircle.getCurrent())
        {
            Link temp =  (CustomLink) this.deleteSpin(killer);
            eliminated.insertFirst(temp);
            System.out.print("Eliminated: ");
            temp.displayLink();
            System.out.println("");
        }
        return eliminated;
    }
    
    public Link deleteSpin(int cOff)
    {
        if( this.JosephusCircle.getCurrent().getNext() == this.JosephusCircle.getCurrent() )
            return null;
        else
        {
            Link prev = this.JosephusCircle.getCurrent();
            for (int a = 0; a < cOff; a++) {
                prev = this.JosephusCircle.getCurrent();
                this.JosephusCircle.setCurrent( (CustomLink) this.JosephusCircle.getCurrent().getNext() );
            }
            Link temp = this.JosephusCircle.getCurrent();
            prev.setNext( this.JosephusCircle.getCurrent().getNext() ); 
            this.JosephusCircle.setCurrent( (CustomLink)prev.getNext() );
            return temp;
        }
    }
    
    
    public static void main(String[] args)
    {
        JosephusProblem prob = new JosephusProblem(10);
        
        prob.JosephusProblem(5, 1).displayList();
        
        prob.getJosephusCircle().display();
    }
}
