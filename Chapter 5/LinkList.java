//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.Link;

class LinkList
{
    private Link first;
    public LinkList()
    {
        first = null;
    }
    
    public boolean isEmpty()
    {
        return (first == null);
    }
    
    public void insertFirst(Link newLink)
    {
        newLink.setNext(first);
        first = newLink;
    }
    
    public Link delteFirst()
    {
        Link temp = first;
        first = first.getNext();
        return temp;
    }
    
    public void displayList()
    {
        Link temp = first;
        while(temp != null)
        {
            temp.displayLink();
            temp = temp.getNext();
        }
        System.out.println("");
    }
}
