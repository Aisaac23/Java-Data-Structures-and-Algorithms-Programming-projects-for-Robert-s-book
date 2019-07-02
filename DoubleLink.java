/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Links;

/**
 *
 * @author isaac.huerta
 */
public class DoubleLink 
{
    private DoubleLink previous;
    private DoubleLink next;    
    private long dData;  

    public DoubleLink(long dData) {
        this.dData = dData;
    }
    
    public void displayLink()
    { System.out.print("{" + dData + "}"); }

    public DoubleLink getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleLink previous) {
        this.previous = previous;
    }

    public DoubleLink getNext() {
        return next;
    }

    public void setNext(DoubleLink next) {
        this.next = next;
    }
    
    
}
