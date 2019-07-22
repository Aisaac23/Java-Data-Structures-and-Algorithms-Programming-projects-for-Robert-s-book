/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedLists;

/**
 *
 * @author Isaac
 */
public class Matrix extends DoublyLinkedList{
    
    Cell current;
    long rows;
    long columns;

    public Matrix(long rows, long columns) {
        this.rows = rows;
        this.columns = columns;
        
        for (int i = 0; i < rows; i++)
            this.insertLast(new Row (i+1, 1) );
        
        Row inserting = (Row) this.getFirst();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 1; j <= columns; j++)
                inserting.getRowLst().insertLast( new Cell (i+1, j+1));
            inserting = (Row) inserting.getNext();
        }
        
    }
    
    public void displayMatrix()
    {
        
        Row current = (Row)this.getFirst();
        while(current != null)
        {
            current.displayRow();
            current = (Row)current.getNext();
            System.out.println("");
        }
        
    }
    
    
    public Cell navigate(long row, long col)
    {
        if( !this.isEmpty() )
        {
            Row rowlst = (Row) this.getFirst();
            if(current == null)
                current = (Cell) rowlst.getRowLst().getFirst();
            
            while(current.getiData() != row)
                if(current.getiData() < row)
                {
                    Row temp = (Row) rowlst.getNext();
                    current = (Cell) temp.getRowLst().getFirst();
                }
                else
                {
                    Row temp = (Row) rowlst.getPrevious();
                    current = (Cell) temp.getRowLst().getFirst();
                }
            while( current.getColumn() == col)
                current = (Cell) current.getNext();
            
            Cell temp = current;
            return temp;
        }    
        
        return null;
    }
    
    public static void main(String[] args)
    {
        System.out.println("Matrix");
        long maxSize = 100;
        int random = 20;
        Matrix matrixInstance = new Matrix(maxSize, maxSize);

        System.out.println("Inserting only 100 rows: ");
        for (int i = 0; i < maxSize; i++)
            matrixInstance.insertLast(new Row (i+1, 1) );
        
        matrixInstance.displayMatrix();
       
        
        
    }
}
