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
    
    private long iData;                  
    private Link next;                   
   
    public Link(long id)                
    { iData = id; }
   
    public void displayLink()           
    { System.out.print("{" + iData + "}"); }

    public long getiData() { return iData; }

    public Link getNext() { return next; }

    public void setiData(long dData) { this.iData = dData; }

    public void setNext(Link next) { this.next = next; }
}