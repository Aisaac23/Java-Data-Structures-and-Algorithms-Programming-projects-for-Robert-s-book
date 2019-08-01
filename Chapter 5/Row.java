//This is a solution or part of a solution proposed by: 
//33ED4C419BD9178A7EDB80708518BF447F43F3980971CE6CFB7D86C1CBC75ACE8CA0417ABF1ADEFCE44826BD725CD1382DA0C0B3AE577DA326EC8817DB336E11
///////////////////////////////////////////////////////////////

package LinkedLists;

import Links.DoubleLink;

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
