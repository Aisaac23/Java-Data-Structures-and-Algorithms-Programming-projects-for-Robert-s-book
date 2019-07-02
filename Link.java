package Links;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author isaac.huerta
 */
public class Link {
    
    private long dData;                  
    private Link next;                   
   
    public Link(long dd)                
    { dData = dd; }
   
    public void displayLink()           
    { System.out.print("{" + dData + "}"); }

    public long getdData() { return dData; }

    public Link getNext() { return next; }

    public void setdData(long dData) { this.dData = dData; }

    public void setNext(Link next) { this.next = next; }
}
