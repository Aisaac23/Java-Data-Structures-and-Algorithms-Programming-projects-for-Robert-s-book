/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circularlist;

import java.util.logging.Level;
import java.util.logging.Logger;

class Link
{
    public int iData;
    public double dData;
    public Link next;

    public Link(int iData, double dData) {
        this.iData = iData;
        this.dData = dData;
    }
    
    public void displayLink()
    {
        System.out.print("{" + this.dData + ", " + this.iData + "}");
    }
}


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
    
    public void insert(int id, double dd)
    {
        Link newLink = new Link(id, dd);
        if(first == null)
        {
            newLink.next = first;
            first = newLink;
        }
        else
        {
            Link temp = first;
            while(temp.next != null)
                temp = temp.next;
            temp.next = newLink;
            newLink.next = null;
        }
    }
    public void displayList()
    {
        Link temp = first;
        while(temp != null)
        {
            temp.displayLink();
            temp = temp.next;
        }
        System.out.println("");
    }
}

public class CircularList {

    
    private Link current;
    public CircularList()
    {
        this.current = null;
    }
    
    public boolean isEmpty()
    {
        return this.current == null;
    }
    
    public LinkList JosephusProblem(int cOff)
    {
        int killer = cOff;
        LinkList eliminated = new LinkList();
        current = current.next;//go to the first element
        
        while(current.next != current)
        {
            Link temp = this.deleteSpin(killer);
            eliminated.insert(temp.iData, temp.dData);
            
        }
        return eliminated;
    }
    
    /****************** Programming projects: 5.3 ***********************/    
    public Link deleteSpin(int cOff)
    {
        if(current.next == current)
            return null;
        else
        {
            Link prev = current;
            for (int a = 0; a < cOff; a++) {
                prev = current;
                current = current.next;
            }
            Link temp = current;
            prev.next = current.next;
           current = prev.next;
            return temp;
        }
    }
    /*********************************************************************/
    
    /****************** Programming projects: 5.3 ***********************/
    public void insert(int id, double dd)
    {
        if(current == null)
        {
            current = new Link(id, dd);
            current.next = current;
        }
        else
        {
            Link item = new Link(id, dd);
            item.next = current.next;
            current.next = item;
            current = item;
        }
    }
    /*********************************************************************/
    
    public void display()
    {
        if(!this.isEmpty())
        {
            int ref = current.iData;
            while(current.next.iData != ref)
            {
                System.out.print("["+current.dData+"]->");
                current = step();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CircularList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.print("["+current.dData+"]->");
        }
        else
            System.out.println("Empty list.");
    }
    
    public Link delete(double dd)
    {
        if(current.next == current)
        {
            Link temp = current;
            current = null;
            return temp;
        }

        Link prev = current;
        current = step();
        int ref = current.iData;
        
        while(true)
        {
            if(current.iData == dd)
            {
                Link temp = current;
                prev.next = current.next;
                current = prev.next;
                return temp;
            }
            else
            {
                prev = current;
                current = step();
            }
            if(current.iData == ref)
                break;
        }
        return null;
    }
    public Link step()
    {
        return current.next;
    }
    
    public static void main(String[] args) {
        CircularList obj = new CircularList();
        for (int i = 0; i < 10; i++) {
            obj.insert(i, i*Math.PI);
        }
        obj.display();
        System.out.println("");
        for (int i = 0; i < 9; i++)
           obj.delete(i).displayLink();
        obj.display();
        obj.delete(9);
        System.out.println("");
        obj.display();
        
        CircularList listC = new CircularList();
        for (int i = 1; i < 4; i++) {
            listC.insert(i, i*100);
        }
        //listC.display();
        LinkList elim;
        elim = listC.JosephusProblem(3);
        elim.displayList();
        listC.display();
    }
    
}
