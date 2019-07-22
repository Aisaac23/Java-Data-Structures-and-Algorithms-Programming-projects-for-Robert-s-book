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