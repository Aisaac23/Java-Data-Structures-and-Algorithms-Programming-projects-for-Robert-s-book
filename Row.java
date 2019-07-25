/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

import Links.DoubleLink;


/**
 *
 * @author Isaac
 */
public class Row extends DoubleLink{

    private DoublyLinkedList rowLst;
    
    public Row(long id, long cols) {
        super(id);
        this.rowLst = new DoublyLinkedList();
        for (int a = 0; a < cols; a++)
            this.rowLst.insertLast( new Cell (id , a+1));
    }

    public void incrementRow()
    {
        this.setiData(this.getiData()+1);
    }
    public void displayRow()
    {
        Cell current = (Cell)this.rowLst.getFirst();
        
        while(current != null)
        {
            current.displayLink();
            current = (Cell)current.getNext();
        }
    }

    public void displayCells()
    {
        Cell current = (Cell)this.rowLst.getFirst();
        
        while(current != null)
        {
            current.displayCell();
            current = (Cell)current.getNext();
        }
    }
    
    public DoublyLinkedList getRowLst() {
        return rowLst;
    }

    public void setRowLst(DoublyLinkedList rowLst) {
        this.rowLst = rowLst;
    }
    
}
