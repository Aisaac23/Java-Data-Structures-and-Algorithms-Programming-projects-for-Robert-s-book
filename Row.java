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
    
    public Row(long id, long col) {
        super(id);
        this.rowLst = new DoublyLinkedList();
        
    }

    public void displayRow()
    {
        Cell current = (Cell)this.rowLst.getFirst();
        System.out.print("|" + current.getiData() + "| ");
        while(current != null)
        {
            current.displayLink();
            current = (Cell)current.getNext();
        }
        System.out.println("");
    }

    public DoublyLinkedList getRowLst() {
        return rowLst;
    }

    public void setRowLst(DoublyLinkedList rowLst) {
        this.rowLst = rowLst;
    }
    
}
